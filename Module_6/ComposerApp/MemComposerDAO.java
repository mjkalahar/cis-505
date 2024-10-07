/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package ComposerApp;

import java.util.ArrayList;
import java.util.List;

/*
 * Implementation of ComposerDAO using an in-memory list
 */
public class MemComposerDAO implements ComposerDAO {
    //List of composers
    private final List<Composer> composers = new ArrayList<>();

    /*
     * Constructor for MemComposerDAO
     * Initializes the list with some sample composers
     */
    public MemComposerDAO() {
        //Sample composers
        Composer composer1 = new Composer(1007, "Ludwig Van Beethoven", "Classical");
        Composer composer2 = new Composer(1008, "Johann Sebastian Bach", "Classical");
        Composer composer3 = new Composer(1009, "Wolfgang Amadeus Mozart", "Classical");
        Composer composer4 = new Composer(1010, "Johannes Brahms", "Classical");
        Composer composer5 = new Composer(1011, "Joseph Haydn", "Classical");
        //Add sample composers to list
        composers.add(composer1);
        composers.add(composer2);
        composers.add(composer3);
        composers.add(composer4);
        composers.add(composer5);
    }

    /*
     * Find all composers
     * @return List<Composer> The list of all composers
     */
    @Override
    public List<Composer> findAll() {
        return composers;
    }

    /*
     * Find a composer by id
     * @param Integer key The id of the composer to find
     * @return Composer The composer with the given id, or null if not found
     */
    @Override
    public Composer findBy(Integer key) {
        return composers.stream().filter(c -> c.getId() == key).findFirst().orElse(null);
    }

    /*
     * Insert a composer
     * @param Composer entity The composer to insert
     */
    @Override
    public void insert(Composer entity) {
        composers.add(entity);
    }
}
