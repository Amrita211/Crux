package Binarytree;

import java.util.Scanner;

public class Binary {
    Node root ;
    public class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
//            this.left=null;
//            this.right=null;
        }
    }

    // insertion
    private void insertion(Scanner s){
        this.root = insertion(s,root);
    }

    private Node insertion(Scanner s, Node node) {
        if(node==null){
            System.out.println("Enter the value:-");
            int val = Integer.parseInt(s.nextLine());
            return new Node(val);
        }
        System.out.println("Enter the direction left or right ??");
        String dir = s.nextLine();
        if(dir.equals("left")){
            node.left=insertion(s,node.left);
        }
        else{
            node.right=insertion(s,node.right);
        }
        return node;
    }
// displaying
private void display(){
        display(root, "");
}
private void display(Node node, String indent){
        if(node==null){
            return;
        }
    System.out.println(indent+node.value);
    display(node.left, indent+"\t");
    //System.out.println(indent+node.value); // for inorder traversal
    display(node.right,indent+"\t");
    //System.out.println(indent+node.value); // for postorder traversal
}

//height of the tree [considering root height as 1 or otherwise we can return -1 instead of 0 in base condition for root hefight as 0]
    private int height(){
        return height(root);
    }
    private int height(Node node){
        if(node==null){
            return 0;
        }
        return Math.max(height(node.left), height(node.right))+1;
    }

    // check a node is present in tree or not
    public boolean checkNodePresence(int value){
        return checkNodePresence(value, root);
    }

    private boolean checkNodePresence(int value, Node node) {
        if(node==null){
            return false;
        }
        if(node.value==value){
            return true;
        }
        return checkNodePresence(value,node.left) || checkNodePresence(value, node.right);
    }

    // find nodes at A specific level
    private void atlevel(int k){
        atLevel(root,k);
    }
    private void atLevel(Node node, int k){
        if(node==null){
            return;
        }
        if(k==0){
            System.out.println(node.value);
//            return;
        }
        atLevel(node.left, k-1);
        atLevel(node.right, k-1);
    }

    //diameter (consider two node and then stretch these two node and count the node including in these two nodes, will be diameter)
    private int diameter(){
        return diameter(root);
    }
    private int diameter(Node node) {
        if(node==null){
            return 0;
        }
        int curr= 1+height(node.left)+height(node.right);
        int max = Math.max(diameter(node.left) , diameter(node.right));
        return Math.max(max, curr);
    }

    // mirroring of binary tree
    private void mirror(){
        mirror(root);
    }
    private void mirror(Node node){
        if(node==null){
            return;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right=temp;

        mirror(node.left);
        mirror(node.right);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
    Binary bin = new Binary();
        bin.insertion(s);
        bin.insertion(s);
        bin.insertion(s);
        bin.insertion(s);
        bin.insertion(s);

        System.out.println();
        bin.display();

        System.out.println("height of the tree");
        System.out.println(bin.height());

        System.out.println("element is present or not ??");
        System.out.println(bin.checkNodePresence(3));

        System.out.println("nodes at level at k :-");
        bin.atlevel(1);

        System.out.println("diameter is :-");
        System.out.println(bin.diameter());

        System.out.println("morririrng :-");
        bin.mirror();
        bin.display();
    }
}
