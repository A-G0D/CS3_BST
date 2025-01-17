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
    public int height(BinaryNode rt) {
       if(rt == null) return -1;
       return Math.max(height(rt.getRight())+1, height(rt.getLeft())+1);
    }
    public int width() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        int mxWidth = 0;
        while (!queue.isEmpty()) {
            int levelWidth = queue.size();
            mxWidth = Math.max(mxWidth, levelWidth);
            for (int i = 0; i < levelWidth; i++) {
                BinaryNode current = queue.poll();
                if (current.getLeft() != null) queue.add(current.getLeft());
                if (current.getRight() != null) queue.add(current.getRight());
            }
        }
    return mxWidth;
    }
    public void swap(BinaryNode a, BinaryNode b) {
        Comparable tmp = a.getValue();
        a.setValue(b.getValue());
        b.setValue(tmp);
    }
    public BinaryNode successor(BinaryNode x) {
        x = x.getRight();
        while (x.getLeft() != null) x = x.getLeft();
        return x;
    }
}
