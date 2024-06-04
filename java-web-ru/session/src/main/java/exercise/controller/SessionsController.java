package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void root(Context ctx) {
        var currentUser = ctx.sessionAttribute("currentUser");
        var page = new MainPage(currentUser);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = encrypt(ctx.formParam("password"));

        if (UsersRepository.existsByName(name)) {
            var user = UsersRepository.findByName(name);
            var passwordInRepo = user.getPassword();
            if (password.hashCode() == passwordInRepo.hashCode()) {
                ctx.sessionAttribute("currentUser", name);
                ctx.redirect("/");
            }
        }
        var page = new LoginPage(name, "Wrong username or password");
        ctx.render("build.jte", model("page", page));
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}
