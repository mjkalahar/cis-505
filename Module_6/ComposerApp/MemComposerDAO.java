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
        Composer composer1 = new Composer();
        Composer composer2 = new Composer();
        Composer composer3 = new Composer();
        Composer composer4 = new Composer();
        Composer composer5 = new Composer();
        //Add sample composers to list
        composer1.setId(1007);
        composer1.setName("Ludwig Van Beethoven");
        composer1.setGenre("Classical");
        composers.add(composer1);
        composer2.setId(1008);
        composer2.setName("Johann Sebastian Bach");
        composer2.setGenre("Classical");
        composers.add(composer2);
        composer3.setId(1009);
        composer3.setName("Wolfgang Amadeus Mozart");
        composer3.setGenre("Classical");
        composers.add(composer3);
        composer4.setId(1010);
        composer4.setName("Johannes Brahms");
        composer4.setGenre("Classical");
        composers.add(composer4);
        composer5.setId(1011);
        composer5.setName("Joseph Haydn");
        composer5.setGenre("Classical");
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
