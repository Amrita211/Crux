package BinarySearchTree;

import java.util.Arrays;

public class BinarySearch {
    private Node root;
    public class Node{
        int value;
        Node left;
         Node right;
         public Node(int value){
             this.value=value;
         }
    }

    // insertion
    public void insertion(int key){
        this.root=insertion(key,root);
    }
    public Node insertion(int key , Node node){
        if(node==null){
            return new Node(key);
        }
        if(key<node.value){
            node.left=insertion(key, node.left);
        }
        else{
            node.right= insertion(key, node.right);
        }
        return node;
    }

    // displaying the tree
    public void display(){
        display(root,"");
    }
    public void display(Node node, String indent){
        if(node==null){
            return;
        }
        System.out.println(indent+node.value);  // for preorder traversal
        display(node.left,indent+"\t");
        //System.out.println(indent+node.value); // for inorder [ or sorted bst ]traversal
        display(node.right,indent+"\t");
        //System.out.println(indent+node.value);   // for postorder traversal
    }

    // height of the tree
    public int height(){
        return height(root);
    }
    public int height(Node node){
     if(node==null){
         return 0;
     }
     return Math.max(height(node.left) , height(node.right)) +1;
    }

    //find successor of the value
    public int successor(int k){
        return successor(k, root);
    }
    public int successor(int k, Node node){
        if(node==null){
            return -1;
        }
        Node succ = null;
        Node curr = root;
        while(curr!=null){
            if(curr.value>k){
                if(succ==null || succ.value>curr.value){
                    succ=curr;
                }
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        return succ.value;

    }

    // find all nodes lying in a range of k1 and k2
    public void nodesInRange(int k1, int k2){
        nodesInRange(root, k1, k2);
    }

    private void nodesInRange(Node node, int k1, int k2) {
        if(node==null){
            return;
        }
        if(node.value>=k1 && node.value<=k2){
            System.out.print(node.value +" ");
        }
        if(node.value>k1){
            nodesInRange(node.left,k1,k2);
        }
        if(node.value<k2){
            nodesInRange(node.right, k1, k2);
        }
    }

    // make a bst from sorted tree
    public  void makeFromSorted(int[] ar, int start , int end){
    if (start>end){
        return;
    }
        int mid = (start+end)/2;
        insertion(ar[mid]);
        makeFromSorted(ar, start, mid-1);
        makeFromSorted(ar, mid+1, end);
    }

    // make a bst from the given preorder and inorder traversal
    public void makeFromInorderPreorder(int[] in, int[] pre){
        this.root=makeFromInorderPreorder(root, in,pre);
    }

    private Node makeFromInorderPreorder(Node node, int[] in, int[] pre) {
        if(in.length==0){
            return node;
        }
        int elem = pre[0];
        int index= find(elem, in);
        int[] in_left = Arrays.copyOfRange(in,0,index);
        int[] in_right = Arrays.copyOfRange(in,index+1, in.length);

        int[] pre_left = Arrays.copyOfRange(pre, 1, index+1);
        int[] pre_right = Arrays.copyOfRange(pre,index+1, pre.length);

        Node node1 = new Node(elem);
        node1.left=makeFromInorderPreorder(node1.left,in_left,pre_left);
        node1.right=makeFromInorderPreorder(node1.right, in_right,pre_right);

        return node1;
    }

    private int find(int elem, int[] in) {
        for(int i=0; i<in.length;i++){
            if(elem==in[i]){
                return i;
            }
        }
        return -1;
    } // make from preorder and inorder

    // check whether a bst is balanced or not
    public boolean isBalance(){
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if(node==null){
        return true;
        }
        int diff = Math.abs(height(node.left)-height(node.right));
        if(diff>1){
            return false;
        }
        boolean left = isBalance(node.left);
        boolean right = isBalance(node.right);
        return left&&right;
    }

    public static void main(String[] args) {
        BinarySearch bst = new BinarySearch();
        bst.insertion(2);
        bst.insertion(4);
        bst.insertion(8);
        bst.insertion(3);
        bst.insertion(6);

        System.out.println("preorder bst :-");
        bst.display();

        System.out.println("height of the tree :-");
        System.out.println(bst.height());

        System.out.println("successor is :-");
        System.out.println(bst.successor(4));

        System.out.println("nodes in a range of :-");
        bst.nodesInRange(2,7);

//        System.out.println("make from sorted tree");
//        int[] ar = {1,4,5,6,7};
//        bst.makeFromSorted(ar,  0, ar.length-1);
//        bst.display();

//        System.out.println("bst from inorder and preorder");
//        int[] in = {1,3,4,5,7};
//        int[] pre = {5,3,1,4,7};
//        bst.makeFromInorderPreorder(in, pre);
//        bst.display();

//        System.out.println();
//        bst.insertion(7);
//        bst.insertion(2);
//        bst.insertion(9);
//        bst.insertion(3);
//        bst.insertion(4);
//        System.out.println("isbalance ? ");
//        System.out.println(bst.isBalance());
    }
}
