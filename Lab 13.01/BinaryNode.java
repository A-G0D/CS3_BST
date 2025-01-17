import java.util.*;

@SuppressWarnings("rawtypes")
public class BinaryNode {
    private Comparable value;
    private BinaryNode left, right;
    public BinaryNode() {
        value = null;
        left = null;
        right = null;
    }
    public BinaryNode(Comparable x) {
        value = x;
    }
    public int degree() {
        int deg = 2;
        if (left==null) deg--;
        if (right==null) deg--;
        return deg;
    }
    public boolean isLeaf() {
        return degree() == 0;
    }
    public Comparable getValue() {
        return value;
    }
    public void setValue(Comparable c) {
        value = c;
    }
    public BinaryNode getLeft() {
        return left;
    }
    public BinaryNode getRight() {
        return right;
    }
    public void setLeft(BinaryNode l) {
        left = l;
    }
    public void setRight(BinaryNode r) {
        right = r;
    }
    @SuppressWarnings("unchecked")
    public int compareTo(BinaryNode o) {
        return getValue().compareTo(o.getValue());
    }
}