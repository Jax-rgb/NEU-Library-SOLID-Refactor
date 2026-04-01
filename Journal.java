public class Journal implements LibraryResource {
    private final String title;
    private boolean available = true;

    public Journal(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrow(Student student) {
        if (available) {
            available = false;
            System.out.println(student.getName() + " borrowed the journal: " + title);
        } else {
            System.out.println("Journal '" + title + "' is not available.");
        }
    }

    @Override
    public void returnResource() {
        available = true;
        System.out.println("Journal '" + title + "' has been returned.");
    }
}
