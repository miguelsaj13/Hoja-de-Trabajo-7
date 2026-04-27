/**
 * Clase que implementa un árbol binario de búsqueda.
 * Permite insertar elementos, buscarlos y recorrerlos en orden.
 * 
 * @param <E> tipo de dato que debe ser comparable
 */
public class BST<E extends Comparable<E>> {
    private BinaryTree<E> root;

    /**
     * Constructor que inicializa el árbol vacío.
     */
    public BST()
    {
        root = new BinaryTree<E>();
    }

    /**
     * Método recursivo para insertar un valor en el árbol.
     * 
     * @param value valor a insertar
     * @param root nodo actual
     * @throws Exception en caso de error
     */
    private void insert(E value, BinaryTree<E> root) throws Exception
    {
        if (root.isEmpty()) {
            root.setValue(value);
            return;
        }

        if (value.compareTo(root.value()) < 0) {
            if (root.left() == null)
                root.setLeft(new BinaryTree<E>());
            insert(value, root.left());
        }
        else if (value.compareTo(root.value()) > 0) {
            if (root.right() == null)
                root.setRight(new BinaryTree<E>());
            insert(value, root.right());
        }
        else {
            return;
        }
    }

    /**
     * Método público para insertar un valor.
     * 
     * @param value valor a insertar
     */
    public void insert(E value)
    {
        try {
            insert(value, root);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    /**
     * Método recursivo para buscar un elemento en el árbol.
     * 
     * @param key valor a buscar
     * @param actual nodo actual
     * @return nodo donde se encuentra el valor o null si no existe
     */
    private BinaryTree<E> search(E key, BinaryTree<E> actual)
    {
        if(actual == null || actual.isEmpty())
        {
            return null;
        }
        if(actual.value().compareTo(key)==0)
        {
            return actual;
        }
        if(key.compareTo(actual.value())<0)
        {
            return search(key, actual.left());
        }
        else{
            return search(key, actual.right());
        }
    }

    /**
     * Método recursivo para recorrer el árbol en in-order.
     * Imprime los valores en orden.
     * 
     * @param root nodo actual
     */
    private void inOrder(BinaryTree<E> root)
    {
        if(root == null || root.isEmpty())
        {
            return;
        }
        inOrder(root.left());
        System.out.println(root.value());
        inOrder(root.right());
    }

    /**
     * Método público para recorrer el árbol en in-order.
     */
    public void inOrder()
    {
        inOrder(root);
    }

    /**
     * Método público para buscar un elemento en el árbol.
     * 
     * @param key valor a buscar
     * @return nodo donde se encuentra el valor o null si no existe
     */
    public BinaryTree<E> search(E key)
    {
        return search(key, root);
    }
}