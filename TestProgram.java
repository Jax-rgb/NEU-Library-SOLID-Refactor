public class TestProgram {
    public static void main(String[] args) {
        Library library = new Library();

        // Original resource types
        Book book = new Book("Design Patterns");
        Journal journal = new Journal("Nature Journal");

        library.addResource(book);
        library.addResource(journal);

        Student student = new Student("Alice");

        System.out.println("=== Testing borrowing specific resources ===");
        LibraryResource res1 = library.findByTitle("Design Patterns");
        student.borrowResource(res1);

        LibraryResource res2 = library.findByTitle("Nature Journal");
        student.borrowResource(res2);

        // Demonstrate future-proofing (new resource type without changing Student or Library)
        System.out.println("\n=== Adding a new resource type (EJournal) – no code changes needed ===");
        LibraryResource eJournal = new LibraryResource() {
            private final String title = "E-Journal of AI";
            private boolean available = true;

            @Override
            public String getTitle() { return title; }
            @Override
            public boolean isAvailable() { return available; }
            @Override
            public void borrow(Student s) {
                if (available) {
                    available = false;
                    System.out.println(s.getName() + " borrowed e-journal: " + title);
                }
            }
            @Override
            public void returnResource() {
                available = true;
                System.out.println("E-journal has been returned.");
            }
        };
        library.addResource(eJournal);

        LibraryResource res3 = library.findByTitle("E-Journal of AI");
        student.borrowResource(res3);

        library.listAvailableResources();
        System.out.println("\nTest completed successfully – system is flexible for any new resource type!");
    }
}
