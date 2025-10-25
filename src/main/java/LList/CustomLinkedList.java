package LList;

public class  CustomLinkedList<E> {
    static  class Node<E> {
        Node<E> next;
        E value;

        public Node(E value) {
            this.value = value;
        }
    }
    
    Node<E> head = null;

    Node<E> tail = null;


    public  void  addFirst(E val) {
        Node<E> temp = new Node<>(val);
        temp.next =head;
        head = temp;
        if(tail ==null){
            tail = temp ;
        }
    }

    // 1->2->3-4
    public  void  addLast(E val) {

        if(tail ==null){
            addFirst(val);
            return;
        }
        Node<E> temp = new Node<>(val);
        tail.next =temp;
        tail = temp;
    }

    public void insert(E val, int index) {
        if( index <1){
            return;
        }
        if(index ==1){
            addFirst(val);
        }
        Node<E>  temp = head;
        Node<E> node  = new Node<>(val);
        int count =1;
        while (temp !=null && count <index-1 ){
            temp = temp.next;
            ++count;
        }
        if(temp == null){
            System.out.println("Index not found ");
        }else {
            node.next =  temp.next;
            temp.next = node;

        }

    }

    public  void print(){
        Node<E> temp = head;
        while (temp!=null){
            System.out.print( temp.value +" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public  void remove (E val) {
        if(head ==null && head.next ==null){
            return;
        }
        if(head.value.equals(val)){
            head = head.next;
        }
        if(head ==null){
            return;
        }
        Node<E> curr = head;
        Node<E> prev  = null;



        while (curr!=null && !curr.value.equals(val)){
            prev =curr;
            curr = curr.next;
        }
        if(curr !=null){
            prev.next =curr.next;
        }
        System.out.println(" Element Removed  "+val);
    }

    public  void reverse() {
        if(head ==null || head.next == null){
            return;
        }
        Node<E> prev = null;
        Node<E> curr = head;
        Node<E> next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

}