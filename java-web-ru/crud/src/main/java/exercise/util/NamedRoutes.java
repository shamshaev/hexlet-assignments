package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }

    public static String postsPathWithPage(Integer page) {
        return postsPathWithPage(String.valueOf(page));
    }

    public static String postsPathWithPage(String page) {
        return "/posts?page=" + page;
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }
    // END
}
