/**
 * Clase que representa un árbol binario genérico.
 * 
 * @param <E> tipo de dato que se guarda en el nodo
 */
public class BinaryTree<E>{
    protected E val;
    protected BinaryTree<E> left, right, parent; // children of node

    /**
     * Constructor por defecto. Crea un nodo vacío.
     */
    public BinaryTree()
    {
        val = null;
        parent = null; 
        left = null;
        right = null;
    }

    /**
     * Constructor que crea un nodo con un valor y dos hijos vacíos.
     * 
     * @param value valor que se guarda en el nodo
     */
    public BinaryTree(E value)
    {
        val = value;
        right = new BinaryTree<E>();
        left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }

    /**
     * Constructor que crea un nodo con valor y subárboles dados.
     * 
     * @param value valor del nodo
     * @param left subárbol izquierdo
     * @param right subárbol derecho
     */
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
    {
        val = value;
        if (left == null) { left = new BinaryTree<E>(); }
        setLeft(left);
        if (right == null) { right = new BinaryTree<E>(); }
        setRight(right);
    }

    /**
     * Obtiene el hijo izquierdo del nodo.
     * 
     * @return subárbol izquierdo
     */
    public BinaryTree<E> left()
    {
        return left;
    }

    /**
     * Obtiene el hijo derecho del nodo.
     * 
     * @return subárbol derecho
     */
    public BinaryTree<E> right()
    {
        return right;
    }

    /**
     * Obtiene el nodo padre.
     * 
     * @return nodo padre
     */
    public BinaryTree<E> parent()
    {
        return parent;
    }

    /**
     * Asigna un nuevo hijo izquierdo al nodo.
     * 
     * @param newLeft nuevo subárbol izquierdo
     */
    public void setLeft(BinaryTree<E> newLeft)
    {
        if (isEmpty()) return;
        if (left != null && left.parent() == this) left.setParent(null);
        left = newLeft;
        if(left != null) left.setParent(this);
    }

    /**
     * Asigna un nuevo hijo derecho al nodo.
     * 
     * @param newRight nuevo subárbol derecho
     */
    public void setRight(BinaryTree<E> newRight)
    {
        if (isEmpty()) return;
        if (right != null && right.parent() == this) right.setParent(null);
        right = newRight;
        if(right != null) right.setParent(this);
    }

    /**
     * Asigna el nodo padre.
     * 
     * @param newParent nuevo nodo padre
     */
    protected void setParent(BinaryTree<E> newParent)
    {
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     * 
     * @return valor del nodo
     */
    public E value()
    {
        return val;
    }

    /**
     * Cambia el valor del nodo.
     * 
     * @param value nuevo valor
     */
    public void setValue(E value)
    {
        val = value;
    }

    /**
     * Indica si el nodo está vacío.
     * 
     * @return true si no tiene valor, false en caso contrario
     */
    public boolean isEmpty()
    {
        return val == null;
    }
}