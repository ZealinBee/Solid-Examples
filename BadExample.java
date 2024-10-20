// Let's say we have a library application with users
class UserController {
    // !! violates dependency inversion
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(User user) {
        userService.createUser(user);
        // implementation
    }

    public void getUser(String id) {
        userService.getUser(id);
    }

    // !! violates single responsibility
    public void getBooks(String message) {
        userService.getBooks(message);
    }
}

class UserService implements IUserService {

    public void createUser(User user) {
        // some implementation
    }

    public void getUser(String id) {
        // !! if i would change the implementation now, i would violate open closed
        // principle
        // some implementation
    }

    public void getBooks(String message) {
        // some implementation
    }

    // !! violates interface segregation
    public void createBook(String name) {
        // some implementation
    }
}

// violates liskov substitution
class SomeOtherUserService extends UserService {
    @Override
    public void createUser(User user) {
        // some other implementation
    }

    @Override
    public void getUser(String id) {
        // some other implementation
    }

    @Override
    public void getBooks(String message) {
        // some other implementation
    }
}

interface IUserService {
    void createUser(User user);

    void getUser(String id);

    void getBooks(String message);

    void createBook(String name);
}

class User {
    public String id;
    public String name;
    public String password;
}