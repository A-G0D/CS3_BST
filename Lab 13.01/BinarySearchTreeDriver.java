import java.util.Scanner;

public class BinarySearchTreeDriver {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        BinarySearchTree BST = new BinarySearchTree();
        Scanner tmp = new Scanner("us and them after all we're only ordinary men me you god knows it's not what");
        System.out.println(BST.size);
        while (tmp.hasNext()) {
            String s = tmp.next();
            BST.add(s);
            System.out.println(s);
        }
        System.out.println(BST.levelorder());
    }
}
