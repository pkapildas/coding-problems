package LList;

public class LNode {
    int data ;
    public LNode next;

    public LNode(int data, LNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LNode getNext() {
        return next;
    }

    public void setNext(LNode next) {
        this.next = next;
    }
}
