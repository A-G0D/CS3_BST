import java.util.*;

@SuppressWarnings("rawtypes")
public class BinarySearchTree {
    private BinaryNode root;
    int size;
    public BinarySearchTree() {
        root = null;
    }
    public BinarySearchTree(BinaryNode x) {
        root = x;
    }
    public BinarySearchTree(Comparable x) {
        this(new BinaryNode(x));
    }
    public void add(BinaryNode s, BinaryNode x) {
        size++;
        if (s == null) s = x;
        else {
            if (s.compareTo(x)>0) {
                if (s.getLeft() == null) s.setLeft(x);
                else add(s.getLeft(), x);
            } else {
                if (s.getRight() == null) s.setRight(x);
                else add(s.getRight(), x);
            }
        }
    }
    public void add(BinaryNode s, Comparable x) {
        add(s, new BinaryNode(x));
    }
    public void add(BinaryNode x) {add(root, x);}
    public void add(Comparable x) {add(root, new BinaryNode(x));}
    public void swap(BinaryNode a, BinaryNode b) {
        Comparable tmp = a.getValue();
        a.setValue(b.getValue());
        b.setValue(tmp);
    }
    
}
