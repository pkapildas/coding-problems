package LList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.module.FindException;

public class LListProblems {


     private LNode head;

    public LListProblems(   ) {
        this.head = null;
    }
    private LListProblems lListProblems = null;


    public  void insertInHead(int data){
        LNode temp = new LNode(data, null);
        if(head==null){
             head = temp;
         } else {
            temp.next= head;
            head = temp;

        }
    }

    public  void insertInTail(int data){
        LNode dNode = new LNode(data, null);
        if(head==null){
            head = dNode;
            return;
        }
        LNode temp = head;
        while (temp.next !=null)
            temp = temp.next;

        temp.next= dNode;
    }

    public  void insertAtIndex(int data, int index){
        if(index ==1){
            insertInHead(data);
            return;
        }
        int count = 1;

        LNode temp = head;
        while (temp !=null && count< index-1){

            temp = temp.next;
            ++count;
        }
        if(temp == null){
            System.out.println(" Index Not Found");
        }else {
            LNode newNode = new LNode(data, null);
            temp.next  = temp.next;
            temp.next = newNode;
        }


    }


    public void deleteNode_head(){
        if(head == null && (head.next == null)){
            return;
        }

        head = head.next;
    }
    public void deleteNode_Tail(){
        if(head == null){
            return;
        }

        LNode temp = head;
        while(temp.next.next !=null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public  void delete_AtIndex( int index){
        if(head == null || head.next ==null){
            head =null;
            return;
        }
        LNode temp = head;
        if(index ==0){
           temp = temp.next;
           head=temp;
           return;
        }
        int count = 1;

         while (temp !=null && count< index-1){

            temp = temp.next;
            ++count;
        }
        if(temp == null || temp.next ==null){
            return;
         }else {
              LNode next = temp.next.next;

            temp.next = next;
        }


    }

    public LNode getMidNode(){
        if(null == head){
            return null;
        }
        LNode slow = head, fast =head;
        while(fast.next!=null && fast.next.next!=null){
            fast= fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean detect_cycle() {
        if (null == head) {
            return false;
        }
        LNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
       return false;
    }
    public int lengthOfcycle() {
  return 0;
    }

    public void reverseLinkedList(){
        LNode curr = null, prev = null, temp ;
        temp= head;
        while(temp!= null){
            curr = temp.next;
            temp.next =prev;
            prev = temp;
            temp =curr;
        }
        head = prev;

    }

    private int getLength(LNode head){
        int count =0;
        LNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return  count
    }
    public LNode getMergedNode(LNode l1, LNode l2){

        if(l1 ==null || l2 ==null) {
            return null;
        }

        int lengthl1 = getLength(l1);
        int lengthl2= getLength(l2);
        LNode head1 = l1;
        LNode head2 = l2;

        while(lengthl1 > lengthl2){
            head1 = head1.next;
            lengthl1--;
        }

        while(lengthl2 > lengthl1){
            head2 = head2.next;
            lengthl2--;
        }


        while(head1 !=head2){

            head1 = head1==null ? head2: head1.next;
            head2 = head2 ==null ? head1 :head2.next;


        }
        return head1;
    }

    @BeforeEach
    public  void before (){
        lListProblems = new LListProblems();
    }

    public void  printList(){
        System.out.println();
        LNode temp = head;
        while(temp!= null){
            System.out.print( " "+temp.data);
            temp = temp.next;
            System.out.print( " ->");

        }
    }



    @Test
    public void test_insertHead(){
        lListProblems.insertInHead(1);
        lListProblems.insertInHead(2);
        lListProblems.insertInHead(3);
        lListProblems. printList();

    }

    @Test
    public void test_insert_Tail(){
        lListProblems.insertInTail(1);
        lListProblems.insertInTail(2);
        lListProblems.insertInTail(3);
        lListProblems. printList();

    }

    @Test
    public void test_tail_delete(){

        lListProblems.insertInHead(1);
        lListProblems.insertInTail(2);
        lListProblems.insertInHead(3);
        lListProblems.insertInHead(13);
        lListProblems.insertInHead(32);
        lListProblems. printList();

        System.out.println("Delete tail");
        lListProblems.deleteNode_Tail();
        lListProblems.printList();
        lListProblems.deleteNode_head();
        System.out.println("Deleting at head");
        lListProblems.printList();
        lListProblems.insertInHead(32);
        System.out.println("inserted 32 at head");
        lListProblems.printList();
        System.out.println("Delete At Index 2");
        lListProblems.delete_AtIndex(2);
        lListProblems.printList();

        lListProblems.delete_AtIndex(2);
    }

    @Test
    public  void test_mid_Node(){

        lListProblems.insertInHead(1);
        lListProblems.insertInTail(2);
        lListProblems.insertInHead(3);
        lListProblems.insertInHead(13);
        lListProblems.insertInHead(32);
        lListProblems. printList();
        System.out.println( "Mid " + lListProblems.getMidNode().data);
        System.out.println("Delete tail");
        lListProblems.deleteNode_Tail();
        lListProblems.printList();
        System.out.println( "Mid " + lListProblems.getMidNode().data);

        lListProblems.deleteNode_head();
        System.out.println("Deleting at head");
        lListProblems.printList();
        System.out.println( "Mid " + lListProblems.getMidNode().data);


    }

}
