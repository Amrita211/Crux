package LinkedLists;

import java.util.HashSet;

public class Linkedlistt {
    private Node head;
    private Node tail;
    private int size=0;

    // first insertion
    public void insertfirst(int elem){
        Node node = new Node(elem);
        node.next=head;  // ye bhi same result dega
        head=node;
        if(tail==null){
            tail=head;
        }
//        node.next=head;
//        head=node;
        size++;
    }

    // insert at last
    public void insertlast(int elem){
//        Node node = new Node(elem);
        if(size==0){
            insertfirst(elem);
            return;
        }
        Node node = new Node(elem);
        tail.next=node;
        tail=node;
        size++;
    }

    // deletefirst
    public int removefirst(){
        if(size==0){
            return -1;
        }
        int temp  = head.value;
        head=head.next;
        size--;
        return temp;
    }

    // remove last i.e tail.value
    public int removelast(){
        if(size==0){
            removefirst();
        }
        Node temp = head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        int last = temp.next.value;
        tail=temp;
        temp.next=null;
        size--;
        return last;
    }

    //get node for a specific node
    public Node getNode(int index){
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }

    // insert at specific index [insertInBetween]
    public void insertInBetween(int elem, int index){
        if(index==0){
            insertfirst(elem);
            return;
        }
        if(index==size-1){
            insertlast(elem);
            return;
        }
        Node prev = getNode(index-1);
        Node temp = new Node(elem);
        temp.next=prev.next;
        prev.next=temp;
        size++;
    }

    // delete node at specific index
    public int deleteAtIndex(int index){
        if(index==0){
            removefirst();
            return -1;
        }
        if(index==size-1){
            removelast();
            return -1;
        }
        Node prev = getNode(index-1);
        int temp =prev.next.value;
        prev.next=prev.next.next;
        size--;
        return temp;
    }

    // remove alternate duplicates
    public void removeDuplicate(){
        Node temp = head;
        while(temp.next!=null){
            if(temp.value==temp.next.value){
                temp.next=temp.next.next;
                size--;
            }
            else{
                temp=temp.next;
            }
        }
        tail=temp;
    }

    //find Node type index of an element
    public Node findVertex(int elem){
        Node temp =head;
        while(temp.next!=null){
            if(temp.value==elem){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }

    //reverse Linkedlist using recursion
    private void reverse(){
        reverse(head);
    }
    public void reverse(Node node){
        if(node==tail){
            head=tail;
            return;
        }
        reverse(node.next);
        tail.next=node;
//        node.next=null; // ye bhi kar sakte hai instead of tail.next=null, but it should be here not in last line.
        tail=node;
        tail.next=null;
    }

    // find element of a specific index from last
    public int elementFromLast(int index){
        if(index>=size){
            System.out.println("index is out of bound of size");
            return -1;
        }
        Node slow=head;
        Node fast=head;
        for(int i=0;i<index;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow.value;
    }
//********************************************* // output wrong aa raha hai :(
    // finding mid
//    public Node mid(){
//        Node slow = head;
//        Node fast=head;
//        while(fast.next!=null && fast.next.next!=null){
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        return slow;
//    }
    // merging
    public Linkedlistt merging(Linkedlistt first, Linkedlistt sec){
        Linkedlistt mix = new Linkedlistt();
        Node f = first.head;
        Node s = sec.head;
        while(f!=null && s!=null){
            if(f.value<s.value){
                mix.insertlast(f.value);
                f=f.next;
            }
            else{
                mix.insertlast(s.value);
                s=s.next;
            }
        }
        while(f!=null){
            mix.insertlast(f.value);
            f=f.next;
        }
        while(s!=null){
            mix.insertlast(s.value);
            s=s.next;
        }
        return mix;
    }
    // finding mid
    public Node mid(){
        Node slow = head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    // merge sort , dividing the linkedlist and the call merging to merge it
    public Linkedlistt mergesort(Linkedlistt list){
        if(list.size==1){
            return list;
        }
//        Linkedlistt first = new Linkedlistt();
//        Linkedlistt sec = new Linkedlistt();

        Node mid = list.mid();
        Linkedlistt first = new Linkedlistt();
        first.head=list.head;
        first.tail=mid;
        first.size=(list.size+1)/2;

        Linkedlistt sec = new Linkedlistt();
        sec.head=mid.next;
        sec.tail=list.tail;
        sec.size=list.size/2;
        mid.next=null;

        first=mergesort(first);
        sec=mergesort(sec);

        return merging(first,sec);
    }
    //*****************************

    // arranging in oddeven sequence
    public Linkedlistt oddeven(Linkedlistt list){
        Linkedlistt odd = new Linkedlistt();
        Linkedlistt even = new Linkedlistt();
        Node temp =list.head;

        while(temp!=null){
            if(temp.value%2==0){
                even.insertlast(temp.value);
            }
            else{
                odd.insertlast(temp.value);
            }
            temp=temp.next;
        }
        odd.tail.next=even.head;
        odd.tail=even.tail;
        return odd;
    }
    // display
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+"=>");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }
    }
    public static void main(String[] args) {
//    Linkedlistt list = new Linkedlistt();
//    list.insertfirst(2);
//    list.insertfirst(3);
//    list.insertfirst(3);

//    list.insertlast(7);
//    list.insertlast(8);
//    list.insertlast(8);
//    list.insertlast(8);

//        System.out.println();
//        list.display();

//        System.out.println();
//        System.out.println(list.removefirst());

//        System.out.println();
//        System.out.println(list.removelast());

//        System.out.println();
//        list.display();

//        System.out.println();
//        list.insertInBetween(33,3);
//        list.display();

//        System.out.println();
//        System.out.println(list.deleteAtIndex(4));
//        list.display();

//        System.out.println();
//        list.removeDuplicate();
//        list.display();

//        System.out.println();
//        list.reverse();
//        list.display();

//        System.out.println();
//        System.out.println(list.elementFromLast(7));

        Linkedlistt list1 = new Linkedlistt();

        list1.insertlast(3);
        list1.insertlast(5);
        list1.insertlast(10);
        list1.insertlast(14);
        list1.insertlast(11);
//
//        list1.display();
//        list1 = list1.mergesort(list1);

        System.out.println();
        list1=list1.oddeven(list1);
        list1.display();

    }
}
