//aqui poner lo de insertar ordenadamente, busqueda, y recorrido ¿in-order?

public class BST<E extends Comparable<E>> {
    private BinaryTree<E> root;

    public BST()
    {
        root = new BinaryTree<E>();
    }

    private void insert(E value, BinaryTree<E> root) throws Exception
    {
        if(root.isEmpty())
        {
            root.setValue(value);
            return;
        }
        if(value.compareTo(root.value()) < 0)
        {
            if(root.left().isEmpty())
            {
                root.setLeft(new BinaryTree<E>(value));
            }
            else{
                insert(value, root.left());
            }
        }
        else if(value.compareTo(root.value()) > 0)
        {
            if(root.right().isEmpty())
                {
                    root.setRight(new BinaryTree<E>(value));
                }
            else{
                insert(value, root.right());
            }
        }
        else{
            throw new Exception();
        }
    }
    public void insert(E value) throws Exception
    {
        insert(value, root);
    }
    private BinaryTree<E> search(E key, BinaryTree<E> actual)
    {
        if(actual.isEmpty())
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
    private void inOrder(BinaryTree<E> root)
    {
        if(root.isEmpty())
        {
            return;
        }
        inOrder(root.left());
        System.out.println(root.value());
        inOrder(root.right());
    }
    public void inOrder()
    {
        inOrder(root);
    }
    public BinaryTree<E> search(E key)
    {
        return search(key, root);
    }
}