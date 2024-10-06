/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package ComposerApp;

import java.util.List;

/*
 * Interface for GenericDAO, with type parameters for entity and key
 */
public interface GenericDAO<E, K> {
    List<E> findAll();
    E findBy(K key);
    void insert(E entity);
}
