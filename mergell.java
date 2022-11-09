import java.util.*;
class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
        this.next = null;
    }
}
public class mergell {
    public static Node<Integer> takeinput(){
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = null , tail = null;
        int data = sc.nextInt();
        while(data!=-1){
            Node<Integer> temp = new Node<Integer>(data);
            if(head == null){
                head = temp;
                tail = temp;
            }
            else{
                tail.next = temp;
                tail = temp;
            }
            data = sc.nextInt();
        }
        return head;
    }
    public static void printr(Node<Integer> head){
        if(head == null){
            return;
        }
        System.out.print(head.data+" ");
        printr(head.next);
        System.out.println();
    }
    public static Node<Integer> mergetwoll(Node<Integer> l1,Node<Integer> l2){
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        Node<Integer> head = new Node<Integer>(0);
        Node<Integer> tail = head;
        while(true){
            if(l1 == null){
                tail.next = l2;
                break;
            }
            if(l2 == null){
                tail.next = l1;
                break;
            }
            if(l1.data<=l2.data){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        return head.next;
    }
    public static void main(String[] args) {
        Node<Integer> l1 = takeinput();
        Node<Integer> l2 = takeinput();
        System.out.println("Given List");
        printr(l1);
        printr(l2);
        System.out.println("Merge list");
        mergetwoll(l1, l2);
        printr(l1);
        
    }
}
