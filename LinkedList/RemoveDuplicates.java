import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
        private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public RemoveDuplicates(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        length = 0;
    }
    
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }
    
    public void removeDuplicates(){
        Node curr = head;
        Node prev = null;
        HashSet<Integer> hs = new HashSet<>();
        
        while(curr != null){
            
            if(hs.contains(curr.value)){
                prev.next = curr.next;
                length--;
            }
            else{
                hs.add(curr.value);
                prev = curr;
                
            }
            
            curr = curr.next;
            
        }
        
    }

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(1);

        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(1);
        myLinkedList.append(4);
        myLinkedList.append(2);
        myLinkedList.append(5);


        myLinkedList.removeDuplicates();

        myLinkedList.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            1
            2
            3
            4
            5
            
        */
        
    }
    
}
