public interface LibraryResource {
    String getTitle();
    boolean isAvailable();
    void borrow(Student student);
    void returnResource();
}
