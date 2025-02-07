import java.util.*;
import java.io.*;

public class BinarySearchTreeDriver {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/workspaces/CS3_BST/Lab 13.01/Sample.in"));
        int n = sc.nextInt();
        BinarySearchTree BST = new BinarySearchTree();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            Scanner tmp = new Scanner(sc.nextLine());
            while (tmp.hasNext()) {
                BST.add(tmp.next());
            }
        }
        BST.printLevels();
        System.out.println(BST.levelorder());
        BST.printOrders();
        System.out.print("Number of leaves: ");
        System.out.println(BST.leaves());
        System.out.println("Number of levels: " + BST.levels());
        System.out.println("The Tree width: " + BST.width());
        System.out.println("The Tree height: " + BST.height(BST.root));
        System.out.println("The Tree diameter: " + BST.diameter());
        System.out.println("Number of nodes: " + BST.size);
        for (int width = 0; width < BST.levels(); width++) {
            System.out.println("width at level " + width + " " + BST.levelWidth(width));
        }
        if (BST.isFull()) System.out.println("Tree is full.");
        else System.out.println("Tree is not full.");
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            if (BST.contains(s)) System.out.print("Tree contains ");
            else System.out.print("Tree does not contain ");
            System.out.println(s);
        }
    }
}
