import java.util.*;
class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
        next = null;
    }
}
public class linkedlt {
    public static Node<Integer> insert(Node<Integer> head,int data,int pos){
        Node<Integer> newnode = new Node<Integer>(data);
        if(pos == 0){
            newnode.next = head;
            return newnode;
        }
        int i = 0;
        Node<Integer> temp = head;
        while(i<pos-1){
            temp = temp.next;
            i++;
        }
        newnode.next = temp.next;
        temp.next = newnode;
        return head;
    }
    
    public static Node<Integer> takeinput(){
        Node<Integer> head = null,tail = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        while(data!=-1){
            Node<Integer> newnode = new Node<Integer>(data);
            if(head == null){
                head = newnode;
                tail = newnode;
            }
            else{
                // Node<Integer> temp = head;
                // while(temp.next!=null){
                //     temp = temp.next;
                // }
                // temp.next = newnode;
                tail.next = newnode;
                tail = newnode;
            }
            data = sc.nextInt();
        }
        return head;
    }
    public static void print(Node<Integer> head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static int middle(Node<Integer> head){
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    public static Node<Integer> delete(Node<Integer> head,int pos){
        if(pos==0){
            head = head.next;
            return head;
        }
        int i = 0;
        Node<Integer> temp = head;
        while(i<pos-1){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static Node<Integer> insertR(Node<Integer> head,int elm,int p){
        if(head == null && p>0){
            return head;
        }
        if(p == 0){
            Node<Integer> temp = new Node<>(elm);
            temp.next = head;
            return temp;
        }
        else{
            head.next = insertR(head.next,elm,p-1);
            return head;
        }
    }
    public static void printr(Node<Integer> head){
        if(head == null){
            return;
        }
        System.out.print(head.data+" ");
        printr(head.next);
    }
    public static Node<Integer> deleter(Node<Integer> head,int p){
        if(head == null && p>0){
            return head;
        }
        if(p==0){
            return head.next;
        }
        else{
            head.next = deleter(head.next,p-1);
            return head;
        }
    }
    public static void main(String[] args) {
        // Node<Integer> node1 = new Node<>(10);
        // Node<Integer> node2 = new Node<>(20);
        // Node<Integer> node3 = new Node<>(30);
        // node1.next = node2;
        // node2.next = node3;
        // Node<Integer> head = node1;
        Node<Integer> head = takeinput();
        // head = insert(head,80,3);
        // System.out.println("After insertation");
        // print(head);
        // head = delete(head,0);
        // System.out.println("Middle node");
        // System.out.println(middle(head));
        // head = insertR(head,30,0);
        head = deleter(head,0);
        printr(head);
        
    }
}
