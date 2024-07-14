package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Comment show(@PathVariable String id) {
        return commentRepository.findById(Long.parseLong(id)).
                orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    @PutMapping(path = "/{id}")
    public Comment update(@PathVariable String id, @RequestBody Comment commentData) {
        var post = commentRepository.findById(Long.parseLong(id)).
                orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        post.setPostId(commentData.getPostId());
        post.setBody(commentData.getBody());
        return commentData;
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable String id) {
        commentRepository.deleteById(Long.parseLong(id));
    }
}
// END
