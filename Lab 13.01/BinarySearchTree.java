import java.util.*;

@SuppressWarnings("rawtypes")
public class BinarySearchTree {
    BinaryNode root;
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
        if (root == null) root = x;
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
    public int levels() {
        return height(root) + 1;
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
    public ArrayList<BinaryNode> preorder() {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        ret.add(root);
        if (root.getLeft()!=null) ret.addAll(preorderA(root.getLeft()));
        if (root.getRight()!=null) ret.addAll(preorderA(root.getRight()));
        return ret;
    }
    public ArrayList<BinaryNode> preorderA(BinaryNode x) {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        ret.add(x);
        if (x.getLeft()!=null) ret.addAll(preorderA(x.getLeft()));
        if (x.getRight()!=null) ret.addAll(preorderA(x.getRight()));
        return ret;
    }
    public ArrayList<BinaryNode> postorder() {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        if (root.getLeft()!=null) ret.addAll(postorderA(root.getLeft()));
        if (root.getRight()!=null) ret.addAll(postorderA(root.getRight()));
        ret.add(root);
        return ret;
    }
    public ArrayList<BinaryNode> postorderA(BinaryNode x) {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        if (x.getLeft()!=null) ret.addAll(postorderA(x.getLeft()));
        if (x.getRight()!=null) ret.addAll(postorderA(x.getRight()));
        ret.add(x);
        return ret;
    }
    public ArrayList<BinaryNode> inorder() {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        if (root.getLeft()!=null) ret.addAll(inorderA(root.getLeft()));
        ret.add(root);
        if (root.getRight()!=null) ret.addAll(inorderA(root.getRight()));
        return ret;
    }
    public ArrayList<BinaryNode> inorderA(BinaryNode x) {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        if (x.getLeft()!=null) ret.addAll(inorderA(x.getLeft()));
        ret.add(x);
        if (x.getRight()!=null) ret.addAll(inorderA(x.getRight()));
        return ret;
    }
    public ArrayList<BinaryNode> revorder() {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        if (root.getRight()!=null) ret.addAll(revorderA(root.getRight()));
        ret.add(root);
        if (root.getLeft()!=null) ret.addAll(revorderA(root.getLeft()));
        return ret;
    }
    public ArrayList<BinaryNode> revorderA(BinaryNode x) {
        ArrayList<BinaryNode> ret = new ArrayList<>();
        if (x.getRight()!=null) ret.addAll(revorderA(x.getRight()));
        ret.add(x);
        if (x.getLeft()!=null) ret.addAll(revorderA(x.getLeft()));
        return ret;
    }
    public ArrayList<Comparable> levelorder() {
        ArrayList<Comparable> ret = new ArrayList<>();
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelWidth = queue.size();
            for (int i = 0; i < levelWidth; i++) {
                BinaryNode current = queue.poll();
                if (current == null) continue;
                ret.add(current.getValue());
                if (current.getLeft() != null) queue.add(current.getLeft());
                if (current.getRight() != null) queue.add(current.getRight());
            }
        }
        return ret;
    }
    public int leaves() {
        int ret = 0;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelWidth = queue.size();
            for (int i = 0; i < levelWidth; i++) {
                BinaryNode current = queue.poll();
                boolean children = false;
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                    children = true;
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                    children = true;
                }
                if (!children) ret++;
            }
        }
        return ret;
    }
    public int diameter() {
        return root.getLeft().height() + root.getRight().height() + 1;
    }
    public int nodes() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        int nodes = 0;
        while (!queue.isEmpty()) {
            int levelWidth = queue.size();
            nodes += levelWidth;
            for (int i = 0; i < levelWidth; i++) {
                BinaryNode current = queue.poll();
                if (current.getLeft() != null) queue.add(current.getLeft());
                if (current.getRight() != null) queue.add(current.getRight());
            }
        }
        return nodes;
    }
    public int levelWidth(int level) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        int idx = 0;
        while (!queue.isEmpty()) {
            idx++;
            int levelWidth = queue.size();
            if (idx == level) return levelWidth;
            for (int i = 0; i < levelWidth; i++) {
                BinaryNode current = queue.poll();
                if (current.getLeft() != null) queue.add(current.getLeft());
                if (current.getRight() != null) queue.add(current.getRight());
            }
        }
        return -1;
    }
    public boolean isFull() {
        for (int lvl = 0; lvl <= height(root); lvl++) {
            if (levelWidth(lvl)!=(int)Math.pow(2, lvl)) return false;
        }
        return true;
    }
    public boolean contains(BinaryNode s, BinaryNode x) {
        if (s == null) return false;
        else {
            if (s.compareTo(x)>0) {
                if (s.getLeft() == null) return false;
                else return contains(s.getLeft(), x);
            } else if (s.compareTo(x)<0){
                if (s.getRight() == null) return false;
                else return contains(s.getRight(), x);
            } else {
                return true;
            }
        }
    }
    public boolean contains(BinaryNode x) {
        return contains(root, x);
    }
    public boolean contains(Comparable x) {
        return contains(new BinaryNode(x));
    }
    public Comparable getLargest() {
        BinaryNode tmp = root;
        while (tmp.getRight() != null) tmp = tmp.getRight();
        return tmp.getValue();
    }
    public Comparable getSmallest() {
        BinaryNode tmp = root;
        while (tmp.getLeft() != null) tmp = tmp.getLeft();
        return tmp.getValue();
    }
    public void printLevels() {
        Queue<BinaryNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            if (depth > 5) break;
            depth++;
            int levelWidth = queue.size();
            for (BinaryNode c : queue) {
                if (c == null) System.out.print("--|");
                else System.out.print(c.getValue() + "|");
            }
            System.out.println();
            for (int i = 0; i < levelWidth; i++) {
                BinaryNode current = queue.poll();
                if (current == null) {
                    queue.add(null);
                    queue.add(null);
                }else {
                    queue.add(current.getLeft());
                    queue.add(current.getRight());
                }
            }
        }
    }
    private BinaryNode search(BinaryNode parent, Comparable target) {
        if(parent == null) return null;
        if(parent.getLeft()!=null && parent.getLeft().getValue().equals(target) || 
            parent.getRight()!=null && parent.getRight().getValue().equals(target))
            return parent;
        else if(target.compareTo(parent.getValue()) < 0) return search(parent.getLeft(),target);
        else return search(parent.getRight(),target);
    }
    public BinaryNode remove(BinaryNode start, Comparable target) {
        if(start == null) return null;
        BinaryNode temp = start;
        BinaryNode inorderSuccessor;
        if(start.getValue().equals(target)) {
            if(start.getLeft() == null && start.getRight() == null) {
                start = null;
                return temp;
            } else if(start.getLeft() == null) { 
                start = start.getRight();
                temp.setRight(null);
                return temp;
            } else if(start.getRight() == null) {
                start = start.getLeft();
                temp.setLeft(null);
                return temp;
            } else {
                inorderSuccessor = successor(start);
                swap(start,inorderSuccessor);
                if(start.getRight()==inorderSuccessor) {
                    start.setRight(inorderSuccessor.getRight());
                    inorderSuccessor.setRight(null);
                    return inorderSuccessor;
                }
                return remove(start.getRight(),target);
            }
        }
        return remove(root,target);
    }
}