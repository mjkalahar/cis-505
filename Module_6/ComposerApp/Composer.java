/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package ComposerApp;

/*
 * Class to represent a composer with an id, name, and genre
 */
public class Composer {
    //The id of the composer
    private int id = 0;
    //The name of the composer
    private String name = "";
    //The genre of the composer
    private String genre = "";

    /* Default constructor
     * id = 0, name = "", genre = ""
     */
    public Composer() {}

    /* Constructor with id, name, and genre
     * @param int id The id of the composer
     * @param String name The name of the composer
     * @param String genre The genre of the composer
     */
    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    /*
     * Get id of composer
     * @return int Id of composer
     */
    public int getId() {
        return id;
    }

    /*
     * Set id of composer
     * @param int id The id of the composer
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * Get name of composer
     * @return String Name of composer
     */
    public String getName() {
        return name;
    }

    /*
     * Set name of composer
     * @param String name The name of the composer
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Get genre of composer
     * @return String Genre of composer
     */
    public String getGenre() {
        return genre;
    }

    /*
     * Set genre of composer
     * @param String genre The genre of the composer
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /*
     * Returns a formatted string representation of the composer
     * @return String Formatted string representation of the composer
     */
    @Override
    public String toString() {
        return "  Id: " + getId() +
                "\n  Name: " + getName() +
                "\n  Genre: " + getGenre();
    }
}
