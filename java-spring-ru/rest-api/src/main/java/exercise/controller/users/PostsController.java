package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> indexByUserId(@PathVariable String id) {
        return posts.stream()
                .filter(post -> String.valueOf(post.getUserId()).equals(id))
                .toList();
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createByUserId(@PathVariable String id, @RequestBody Post data) {
        var post = new Post();
        post.setUserId(Integer.parseInt(id));
        post.setSlug(data.getSlug());
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
        posts.add(post);
        return post;
    }
}
// END
