public class Student {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Refactored method – depends only on the abstraction (DIP)
    public void borrowResource(LibraryResource resource) {
        if (resource != null) {
            resource.borrow(this);
        }
    }

    public void returnResource(LibraryResource resource) {
        if (resource != null) {
            resource.returnResource();
        }
    }
}
