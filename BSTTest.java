import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BSTTest {

    private BST<ComparableAssociation<String, String>> arbol;

    @Before
    public void setUp() {
        arbol = new BST<>();
    }

    @Test
    public void testInsertAndSearch() {
        ComparableAssociation<String, String> a1 =
            new ComparableAssociation<>("dog", "perro");

        ComparableAssociation<String, String> a2 =
            new ComparableAssociation<>("cat", "gato");

        ComparableAssociation<String, String> a3 =
            new ComparableAssociation<>("house", "casa");

        try {
            arbol.insert(a1);
            arbol.insert(a2);
            arbol.insert(a3);
        } catch (Exception e) {
            fail("No debería lanzar excepción al insertar");
        }

        ComparableAssociation<String, String> key =
            new ComparableAssociation<>("dog", null);

        BinaryTree<ComparableAssociation<String, String>> result =
            arbol.search(key);

        assertNotNull(result);
        assertEquals("perro", result.value().getValue());
    }

    @Test
    public void testSearchNotFound() {
        ComparableAssociation<String, String> a1 =
            new ComparableAssociation<>("dog", "perro");

        try {
            arbol.insert(a1);
        } catch (Exception e) {
            fail("No debería lanzar excepción al insertar");
        }

        ComparableAssociation<String, String> key =
            new ComparableAssociation<>("cat", null);

        BinaryTree<ComparableAssociation<String, String>> result =
            arbol.search(key);

        assertNull(result);
    }

    @Test
    public void testInsertDuplicateIgnored() {
        ComparableAssociation<String, String> a1 =
            new ComparableAssociation<>("dog", "perro");

        ComparableAssociation<String, String> a2 =
            new ComparableAssociation<>("dog", "canino");

        try {
            arbol.insert(a1);
            arbol.insert(a2);
        } catch (Exception e) {
            fail("No debería lanzar excepción con duplicados");
        }

        ComparableAssociation<String, String> key =
            new ComparableAssociation<>("dog", null);

        BinaryTree<ComparableAssociation<String, String>> result =
            arbol.search(key);

        // Debe mantener el primer valor insertado
        assertEquals("perro", result.value().getValue());
    }
}