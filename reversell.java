import java.util.*;
class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
        next = null;
    }
}
public class reversell {
    public static Node<Integer> reversel(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> newhead = reversel(head.next);
        Node<Integer> temp = newhead;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return newhead;
    }
    public static Node<Integer> takeinput(){
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = null;
        int data = sc.nextInt();
        while(data != -1){
            Node<Integer> newnode = new Node<Integer>(data);
            if(head == null){
                head = newnode;

            }
            else{
                Node<Integer> temp = head;
                while(temp.next!=null){
                    temp = temp.next;
                }
                temp.next = newnode;
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
    public static void main(String[] args){
        Node<Integer> head = takeinput();
        System.out.println("Original LinkedList");
        print(head);
        head = reversel(head);
        System.out.println("Reverse linkedlist");
        print(head);
    }
}
