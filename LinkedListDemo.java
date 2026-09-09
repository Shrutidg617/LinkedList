
public class LinkedListDemo {

    // Node represents one element of the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Insert a node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    // Insert a node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Delete the first node containing the given value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If the head itself contains the value
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println(data + " not found.");
        } else {
            current.next = current.next.next;
        }
    }

    // Search for a value
    public boolean search(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display the linked list
    public void display() {
        Node current = head;

        if (current == null) {
            System.out.println("List is empty.");
            return;
        }

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListDemo list = new LinkedListDemo();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("Original list:");
        list.display();

        list.insertAtBeginning(5);

        System.out.println("After inserting 5 at beginning:");
        list.display();

        list.delete(20);

        System.out.println("After deleting 20:");
        list.display();

        System.out.println("Is 30 present? " + list.search(30));
        System.out.println("Is 100 present? " + list.search(100));
    }
}
```
