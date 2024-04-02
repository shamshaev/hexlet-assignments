package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    protected String name;
    private Map<String, String> attributes;

    public Tag(String type, Map<String, String> attributes) {
        this.name = type;
        this.attributes = attributes;
    }

    public String tagToString() {
        var str = attributes.entrySet().stream()
                .map(entry -> " " + entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining());
        return "<" + name + str + ">";
    }
}
// END
