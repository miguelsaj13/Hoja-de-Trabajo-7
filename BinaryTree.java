public class BinaryTree<E>{
    protected E val;
    protected BinaryTree<E> left, right, parent; // children of node
    public BinaryTree()
    {
        val = null;
        parent = null; 
        left = null;
        right = null;
    }
    public BinaryTree(E value)
    {
        val = value;
        right = new BinaryTree<E>();
        left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
    {
        val = value;
        if (left == null) { left = new BinaryTree<E>(); }
        setLeft(left);
        if (right == null) { right = new BinaryTree<E>(); }
        setRight(right);
    }
    public BinaryTree<E> left()
    {
        return left;
    }
    public BinaryTree<E> right()
    {
        return right;
    }
    public BinaryTree<E> parent()
    {
        return parent;
    }
    public void setLeft(BinaryTree<E> newLeft)
    {
        if (isEmpty()) return;
        if (left != null && left.parent() == this) left.setParent(null);
        left = newLeft;
        if(left != null) left.setParent(this);
    }
    public void setRight(BinaryTree<E> newRight)
    {
        if (isEmpty()) return;
        if (right != null && right.parent() == this) right.setParent(null);
        right = newRight;
        if(right != null) right.setParent(this);
    }
    protected void setParent(BinaryTree<E> newParent)
    {
        if (!isEmpty()) {
            parent = newParent;
        }
    }
    public E value()
    {
        return val;
    }
    public void setValue(E value)
    {
        val = value;
    }
    public boolean isEmpty()
    {
        return val == null;
    }
}