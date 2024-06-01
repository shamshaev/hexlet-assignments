package exercise.dto.articles;

import io.javalin.validation.ValidationError;
import java.util.Map;
import java.util.List;

// BEGIN
public class BuildArticlePage {
    private String title;
    private String content;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildArticlePage() {
    }

    public BuildArticlePage(String title, String content, Map<String, List<ValidationError<Object>>> errors) {
        this.title = title;
        this.content = content;
        this.errors = errors;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }
}

// END
