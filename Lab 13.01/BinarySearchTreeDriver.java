import java.util.*;
import java.io.*;

public class BinarySearchTreeDriver {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Sample.in"));
        int n = sc.nextInt();
        BinarySearchTree BST = new BinarySearchTree();
        for (int i = 0; i < n; i++) {
            Scanner tmp = new Scanner(sc.nextLine());
            while (tmp.hasNext()) {
                BST.add(tmp.next());
            }
        }
        BST.printLevels();
        System.out.println(BST.levelorder());
    }
}
