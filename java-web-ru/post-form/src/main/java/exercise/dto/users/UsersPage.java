package exercise.dto.users;

import exercise.model.User;
import java.util.List;

// BEGIN
public class UsersPage {
    private List<User> users;

    public UsersPage(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
// END
