import java.util.*;

class BinaryNode {
    private Comparable value;
    private BinaryNode left, right;
    private int size;
    public BinaryNode() {
        value = null;
        left = null;
        right = null;
        size = 0;
    }
    public BinaryNode (Comparable x) {
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
    public int getSize() {
        return size;
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
    public String toString() {
        String temp = "Value:"+getValue()+(!isLeaf()? 
        (", (Left: "+(left==null?null:left.toString())+
        ", Right: "+(right==null?null:right.toString())+
        ")"):("") );
        return temp;
    }
    public int compareTo(BinaryNode o) {
        return getValue().compareTo(o.getValue());
    }
    public void add(BinaryNode o) {
        size++;
        if (getValue() == null) {
            setValue(o.getValue());
        }
        else {
            if (compareTo(o)==1) {
                if (getLeft() == null) setLeft(o);
                else add(getLeft(), o);
            }
            else {
                if (getRight() == null) setRight(o);
                else add(getRight(), o);
            }
        }
    }
    public void add(BinaryNode n, BinaryNode o) {
        if (n.compareTo(o)==1) 
            if (n.getLeft() == null) n.setLeft(o);
            else n.add(n.getLeft(), o);
        else 
            if (n.getRight() == null) n.setRight(o);
            else n.add(n.getRight(), o);
    }
    public ArrayList<BinaryNode> preorderA() {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        ret.add(this);
        if (this.getLeft()!=null) ret.addAll(getLeft().preorderA());
        if (this.getRight()!=null) ret.addAll(getRight().preorderA());
        return ret;
    }
    public ArrayList<BinaryNode> postorderA() {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        if (this.getLeft()!=null) ret.addAll(getLeft().postorderA());
        if (this.getRight()!=null) ret.addAll(getRight().postorderA());
        ret.add(this);
        return ret;
    }
    public ArrayList<BinaryNode> inorderA() {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        if (this.getLeft()!=null) ret.addAll(getLeft().inorderA());
        ret.add(this);
        if (this.getRight()!=null) ret.addAll(getRight().inorderA());
        return ret;
    }
    public String preorder() {
        ArrayList<BinaryNode> al = preorderA();
        String s = "";
        for (BinaryNode bn : al) s += bn.getValue() + " ";
        return s.trim();
    }
    public String postorder() {
        ArrayList<BinaryNode> al = postorderA();
        String s = "";
        for (BinaryNode bn : al) s += bn.getValue() + " ";
        return s.trim();
    }
    public String inorder() {
        ArrayList<BinaryNode> al = inorderA();
        String s = "";
        for (BinaryNode bn : al) s += bn.getValue() + " ";
        return s.trim();
    }
    public BinaryNode preprev(BinaryNode o){
        ArrayList<BinaryNode> preorder = preorderA();
        int len = preorder.size();
        boolean found = false;
        int i = 0;
        for (i = 0; i < len; i++) {
            if (preorder.get(i).compareTo(o)==0) {
                found = true;
                break;
            }
        }
        if (found==false || i==0) return null;
        return preorder.get(i-1);
    }
    public BinaryNode prenext(BinaryNode o){
        ArrayList<BinaryNode> preorder = preorderA();
        int len = preorder.size();
        boolean found = false;
        int i = 0;
        for (i = 0; i < len; i++) {
            if (preorder.get(i).compareTo(o)==0) {
                found = true;
                break;
            }
        }
        if (found==false || i==len-1) return null;
        return preorder.get(i+1);
    }
    public BinaryNode postprev(BinaryNode o){
        ArrayList<BinaryNode> postorder = postorderA();
        int len = postorder.size();
        boolean found = false;
        int i = 0;
        for (i = 0; i < len; i++) {
            if (postorder.get(i).compareTo(o)==0) {
                found = true;
                break;
            }
        }
        if (found==false || i==0) return null;
        return postorder.get(i-1);
    }
    public BinaryNode postnext(BinaryNode o){
        ArrayList<BinaryNode> postorder = postorderA();
        int len = postorder.size();
        boolean found = false;
        int i = 0;
        for (i = 0; i < len; i++) {
            if (postorder.get(i).compareTo(o)==0) {
                found = true;
                break;
            }
        }
        if (found==false || i==len-1) return null;
        return postorder.get(i+1);
    }
    public BinaryNode inprev(BinaryNode o){
        ArrayList<BinaryNode> inorder = inorderA();
        int len = inorder.size();
        boolean found = false;
        int i = 0;
        for (i = 0; i < len; i++) {
            if (inorder.get(i).compareTo(o)==0) {
                found = true;
                break;
            }
        }
        if (found==false || i==0) return null;
        return inorder.get(i-1);
    }
    public BinaryNode innext(BinaryNode o){
        ArrayList<BinaryNode> inorder = inorderA();
        int len = inorder.size();
        boolean found = false;
        int i = 0;
        for (i = 0; i < len; i++) {
            if (inorder.get(i).compareTo(o)==0) {
                found = true;
                break;
            }
        }
        if (found==false || i==len-1) return null;
        return inorder.get(i+1);
    }
    public int height() {
        return Math.max(height(getLeft())+1, height(getRight())+1);
    }
    public int height(BinaryNode rt) {
       if(rt == null) return -1;
       return Math.max(height(rt.getRight())+1, height(rt.getLeft())+1);
    }
    public int width() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(this);
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
    public int depth(BinaryNode o) {
        if (this.compareTo(o)==0) return 0;
        if (degree()==0) return -1;
        if (degree()==1) {
            if (getLeft() != null) return 1+depth(getLeft(), o);
            else return 1+depth(getRight(), o);
        }
        if (degree()==2) return Math.min(1+depth(getLeft(), o), 1+depth(getRight(), o));
        return -1;
    }
    public int depth(BinaryNode c, BinaryNode o) {
        if (c.compareTo(o)==0) return 0;
        if (c.degree()==0) return (int) Math.pow(10, 9);
        if (c.degree()==1) {
            if (c.getLeft() != null) return 1+c.depth(c.getLeft(), o);
            else return 1+c.depth(c.getRight(), o);
        }
        if (c.degree()==2) return Math.min(1+c.depth(c.getLeft(), o), 1+c.depth(c.getRight(), o));
        return (int) Math.pow(10, 9);
    }
    public int diameter() {
        return getLeft().height() + 3 + getRight().height();
    }
}

public class Main {
    public static void main(String args[]) {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Collections.shuffle(l);
        print(l);
        
        BinaryNode b = new BinaryNode();
        
        for (int i : l) {
            BinaryNode t = new BinaryNode(i);
            b.add(t);
        }
        print(b);
        print(b.preorder());
        print(b.postorder());
        print(b.inorder());
        print(b.height());
        print(b.width());
        print(b.getSize());
        print(b.diameter());
    }
    public static void print(Object o) {
        System.out.println(o);
    }
    public static void prin(Object o) {
        System.out.print(o + " ");
    }
}
