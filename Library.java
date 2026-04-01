import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<LibraryResource> resources = new ArrayList<>();

    public void addResource(LibraryResource resource) {
        resources.add(resource);
    }

    public LibraryResource findByTitle(String title) {
        for (LibraryResource r : resources) {
            if (r.getTitle().equalsIgnoreCase(title)) {
                return r;
            }
        }
        return null;
    }

    public void listAvailableResources() {
        System.out.println("\nAvailable resources in the library:");
        for (LibraryResource r : resources) {
            if (r.isAvailable()) {
                System.out.println(" - " + r.getTitle() + " (" + r.getClass().getSimpleName() + ")");
            }
        }
    }
}
