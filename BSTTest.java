import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de pruebas unitarias para el árbol BST.
 * Verifica que los métodos de insertar y buscar funcionen bien.
 */
public class BSTTest {

    private BST<ComparableAssociation<String, String>> arbol;

    /**
     * Método que se ejecuta antes de cada prueba.
     * Inicializa un árbol vacío.
     */
    @Before
    public void setUp() {
        arbol = new BST<>();
    }

    /**
     * Prueba que verifica que se pueden insertar elementos
     * y luego encontrarlos correctamente en el árbol.
     */
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

    /**
     * Prueba que verifica que la búsqueda de un elemento que no existe
     * regresa null.
     */
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

    /**
     * Prueba que verifica que al insertar un duplicado,
     * el árbol no falla y mantiene el valor original.
     */
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

        assertEquals("perro", result.value().getValue());
    }
}