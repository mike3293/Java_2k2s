
public class User {
    String name;
    String password;
    String role;

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return role + ' ' + name;
    }
}
