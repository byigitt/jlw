public class Main {
  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();

    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(7);
    tree.insert(12);
    tree.insert(18);

    System.out.println("Number 7 on the tree => " + tree.search(7));
    System.out.println("Number 21 on the tree => " + tree.search(21));
    System.out.println("Total number of nodes => " + tree.countNodes());
    System.out.println("Is the specified tree a Binary Search Tree? => " + BinarySearchTree.checkBST(tree));
  }

}
