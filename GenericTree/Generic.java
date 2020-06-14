package GenericTree;

import java.util.*;

public class Generic {

    private Node root;
    // insertion
    public void insertion(Scanner s){
        System.out.println("Enter the root value");
        int value = s.nextInt();
        this.root=new Node(value);
        insertion(s, this.root);
    }

    private void insertion(Scanner s, Node node) {

        while(true){
            System.out.println("want more node of"+node.value);
            boolean yes = s.nextBoolean();
            if(yes){
                System.out.println("enter the valur for"+node.value);
                Node child = new Node(s.nextInt());
                root.children.add(child);
                insertion(s,child);
            }
            else{
                break;
            }
        }
    }

    // display
    public void display(){
        display(root,"");
    }

    private void display(Node node, String indent) {
        System.out.println(indent+node.value);
        for (int i=0; i<node.children.size();i++){
            display(node.children.get(i),indent+"\t");
        }
    }

    // count the no.of nodes in the tree
    public int count(){
       return count(root);
    }
    public int count(Node node){
        if(node==null){
            return 0;
        }
        int cnt =1;
        for(int i=0; i<node.children.size();i++){
            cnt+=count(node.children.get(i));
        }
        return cnt;
    }

    // level order
    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(Node node) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(node);
        while(!qu.isEmpty()){
            Node temp = qu.remove();
//            System.out.println(temp.value);  // just for testing purpose
            for(int i=0; i<temp.children.size();i++){
                qu.add(temp.children.get(i));
            }
        }
    }

    // find maximum value of tree
    public int maximum(){
        int max = root.value;
        return maximum(root,max);
    }

    private int maximum(Node node, int max) {
        if(node==null){
            return 0;
        }
        for(int i=0; i <node.children.size();i++){
            if(max<node.children.get(i).value){
                max=node.children.get(i).value;
            }
        }
        return max;
    }

    // find the nodes at a particular level [sahi output nhi aa raha]
    public void nodeAtLevel(int k){
        nodeAtLevel(root, k);
    }

    private void nodeAtLevel(Node node, int k) {
        if(k==0){
            System.out.println(node.value);
        }
        for(int i=0; i<node.children.size();i++){
            nodeAtLevel(node.children.get(i),k-1);
        }
    }

    public class Node{
        int value;
        ArrayList<Node> children;
        public Node(int value){
            this.value=value;
            this.children=new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Generic tree = new Generic();

        tree.insertion(s);

        tree.display();

        System.out.println();
        System.out.println(tree.count());

        System.out.println();
        tree.levelOrder();
        tree.display();

        System.out.println("maximum value of tree ");
        System.out.println(tree.maximum());

        System.out.println("nodes at level at k:-");
        tree.nodeAtLevel(2);
//        tree.display();

    }
}
