package Heap;

// creating a minimum heap tree

import java.util.ArrayList;

public class heapImplementation {
    ArrayList<Integer> list = new ArrayList<>();

    public void insert(int value){
        list.add(value);
        unheap(list.size()-1);
    }
    // just make a minimum-heap tree, i.e parent has samller value than their child

    public void unheap(int index){
        if(index==0){
            return;
        }
        int p= parentIndex(index);
        if(list.get(p)>list.get(index)){
            swap(p,index);
            unheap(p);
        }
    }
    public void swap(int p, int index){
        int temp = list.get(p);
        list.set(p,list.get(index));
        list.set(index,temp);
    }

    // remove
    public int remove()throws Exception{
        if(list.isEmpty()){
            throw new Exception("Khaali hai !..");
        }
        int temp = list.get(0);
        int last = list.remove(list.size()-1);
        if(!list.isEmpty()) {
            list.set(0,last);
            downheap(0);
        }
        return temp;
    }

    public void downheap(int index){
        int min = index;
        int left = leftChildIndex(index);
        int right = rightChildIndex(index);
        if(left<list.size() && list.get(min)>list.get(left)){
            min=left;
        }
        if(right<list.size() && list.get(min)>list.get(right)){
            min = right;
        }
        if(min!=index){
            swap(min,index);
        }
    }
    // finding indecises of child and parent
    public int parentIndex(int index){
        return (index-1)/2;
    }
    public int leftChildIndex(int index){
        return  (index*2)+1;
    }
    public int rightChildIndex(int index){
        return (index*2)+2;
    }

    //dispaly the heap;
    public void display(){
        System.out.println(list);
    }
    public static void main(String[] args) throws Exception {
    heapImplementation heap = new heapImplementation();
    heap.insert(3);
    heap.insert(1);
    heap.insert(7);
    heap.insert(0);
    heap.insert(5);
//
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        for (int i = 0; i <5; i++) {
//            System.out.println(heap.remove());
//        }
        heap.display();

    }
}
