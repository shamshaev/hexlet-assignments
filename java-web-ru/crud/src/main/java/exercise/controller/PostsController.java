package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        page = Math.max(1, page);
        var entitiesSize = PostRepository.getEntities().size();
        var fromIndex = (page - 1) * 5;
        var toIndex = Math.min(fromIndex + 5, entitiesSize);
        var posts = PostRepository.getEntities().subList(fromIndex, toIndex);
        var postsPage = new PostsPage(posts, page);
        ctx.render("posts/index.jte", model("postsPage", postsPage));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
    // END
}
