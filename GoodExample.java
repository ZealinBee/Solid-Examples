// Now follows Dependency Inversion and Single Responsibility Principles
class UserController {

    private final IUserService userService;

    // Constructor-based dependency injection of IUserService (abstraction)
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    public void createUser(User user) {
        userService.createUser(user);
    }

    public void getUser(String id) {
        userService.getUser(id);
    }
}

// Follows Dependency Inversion and Single Responsibility Principles
class BookController {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    public void getBooks(String message) {
        bookService.getBooks(message);
    }

    public void createBook(String name) {
        bookService.createBook(name);
    }
}

// Follows Open/Closed and Liskov Substitution Principles
class UserService implements IUserService {

    @Override
    public void createUser(User user) {
        // User creation logic
    }

    @Override
    public void getUser(String id) {
        // Fetch user logic
    }
}

// New service implementation, can be used as a substitute without breaking LSP
class ReadOnlyUserService implements IUserService {

    @Override
    public void createUser(User user) {
        throw new UnsupportedOperationException("Read-only users cannot be created");
    }

    @Override
    public void getUser(String id) {
        // Fetch user logic for read-only access
    }
}

// Follows Interface Segregation Principle by separating book-related
// responsibilities
class BookService implements IBookService {

    @Override
    public void getBooks(String message) {
        // Fetch book logic
    }

    @Override
    public void createBook(String name) {
        // Book creation logic
    }
}

// Separate interfaces for user and book services to follow Interface
// Segregation Principle
interface IUserService {
    void createUser(User user);

    void getUser(String id);
}

interface IBookService {
    void getBooks(String message);

    void createBook(String name);
}

// Represents the User entity
class User {
    public String id;
    public String name;
    public String password;
}
