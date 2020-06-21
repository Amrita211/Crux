package BinarySearchTree;

public class AVLTree {

    private Node root;
    public class Node{
        int value ;
        int height;
         Node left;
          Node right;
          public Node(int value){
              this.value=value;
              this.height=1;
          }
    }

    // insertion
    public void insertion(int key){
        this.root=insertion(root , key);
    }

    private Node insertion(Node node, int key) {
        if(node==null){
            return new Node(key);
        }
        if(node.value>key){
            node.left=insertion(node.left, key);
        }
        else{
            node.right=insertion(node.right,key);
        }
        node.height = Math.max(height(node.left) ,height(node.right))+1;
        node = balancing(node);
        return node;
    }

    private Node balancing(Node node) {
        if(height(node.left)-height(node.right)>1){
            if(height(node.left.left)-height(node.left.right)<0){
                node.left=leftRotation(node.left);
            }
            return rightRotation(node);
        }
        if(height(node.left)-height(node.right)<-1){
            if(height(node.right.left)-height(node.right.right)>0){
                node.right=rightRotation(node.right);
            }
            return leftRotation(node);
        }
        return node;
    }

    private Node rightRotation(Node x) {
        Node y = x.left;
        Node temp = y.right;
        y.right=x;
        x.left=temp;

        x.height=Math.max(height(x.left),height(x.right))+1;
        y.height=Math.max(height(y.left),height(y.right))+1;
        return y;

    }

    private Node leftRotation(Node y) {
    Node x = y.right;
    Node temp = x.left;

    x.left=y;
    y.right=temp;

    x.height=Math.max(height(x.left), height(x.right))+1;
    y.height=Math.max(height(y.left),height(y.right))+1;

    return x;
    }

    public int height(Node node){
        if(node==null){
            return 0;
        }
        return node.height;
    }
    // display [preorder display]
    public void display(){
        display(root," ");
    }
    public void display(Node node, String indent){
        if(node==null){
            return;
        }
        System.out.println(indent+node.value);
        display(node.left, indent+"\t");
        display(node.right,indent+"\t");
    }
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        avl.insertion(2);
        avl.insertion(5);
        avl.insertion(3);
        avl.insertion(9);

        avl.display();

    }
}
