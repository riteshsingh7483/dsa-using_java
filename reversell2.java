import java .util.*;
class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
        next = null;
    }
}
class DoubleNode{
    Node<Integer> head = null;
    Node<Integer> tail = null;
}
public class reversell2 {
    public static DoubleNode reversel(Node<Integer> head){
        if(head == null || head.next == null){
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }
        DoubleNode ans = reversel(head.next);
        ans.tail.next = head;
        head.next = null;
        DoubleNode smallans = new DoubleNode();
        smallans.head = ans.head;
        smallans.tail = head;
        return smallans;
    }
    public static Node<Integer> takeinput(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;
        Node<Integer> tail = null;
        while(data!=-1){
            Node<Integer> newhead = new Node<Integer>(data);
            if(head == null){
                head = newhead;
                tail = newhead;
                
            }
            else{
                tail.next = newhead;
                tail = newhead;
            }
            data = sc.nextInt();

        }
        return head;
        
    }
    public static void print(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node<Integer> head = takeinput();
        System.out.println("Original List");
        print(head);
        DoubleNode newhead = reversel(head);
        System.out.println("Reverse list");
        print(newhead.head);
    }

    
}
