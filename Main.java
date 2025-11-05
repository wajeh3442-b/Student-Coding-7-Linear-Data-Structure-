import java.util.*;

class ArrayOps {
    int[] arr;
    int size;

    void create(Scanner sc) {
        System.out.print("Enter size of array: ");
        size = sc.nextInt();
        arr = new int[size];
        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) arr[i] = sc.nextInt();
    }

    void traverse() {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void insert(Scanner sc) {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }
        System.out.print("Enter position (1-" + (size + 1) + "): ");
        int pos = sc.nextInt();
        System.out.print("Enter element: ");
        int ele = sc.nextInt();
        int[] newArr = new int[size + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == pos - 1) newArr[i] = ele;
            else newArr[i] = arr[j++];
        }
        arr = newArr;
        size++;
    }

    void delete(Scanner sc) {
        if (arr == null || size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        System.out.print("Enter position to delete (1-" + size + "): ");
        int pos = sc.nextInt();
        int[] newArr = new int[size - 1];
        for (int i = 0, j = 0; i < size; i++) {
            if (i != pos - 1) newArr[j++] = arr[i];
        }
        arr = newArr;
        size--;
    }

    void search(Scanner sc) {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at position " + (i + 1));
                return;
            }
        }
        System.out.println("Element not found!");
    }
}

class Node {
    int data;
    Node next;
    Node prev;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class SinglyLinkedList {
    Node head;
    void traverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtPosition(int data, int pos) {
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;
        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
    }

    void deleteFromPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null) {
            System.out.println("Invalid position!");
            return;
        }
        temp.next = temp.next.next;
    }

    void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
    }

    void search(int key) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element found at position: " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Element not found!");
    }
}

class DoublyLinkedList {
    Node head;
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        System.out.print("Doubly Linked List: NULL <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

class CircularLinkedList {
    Node head;
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        System.out.print("Circular Linked List: ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to head)");
    }
}

class StackChar {
    private int top;
    private char[] stackArray;
    private int maxSize;

    public StackChar(int size) {
        this.maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char c) {
        if (top == maxSize - 1)
            System.out.println("Stack Overflow!");
        else
            stackArray[++top] = c;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return '\0';
        } else
            return stackArray[top--];
    }

    public char peek() {
        if (isEmpty())
            return '\0';
        else
            return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack (top → bottom): ");
        for (int i = top; i >= 0; i--)
            System.out.print(stackArray[i] + " ");
        System.out.println();
    }
}

class ExpressionConverter {
    private int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        StackChar stack = new StackChar(exp.length());
        for (char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                result.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    result.append(stack.pop());
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            result.append(stack.pop());
        return result.toString();
    }

    public String infixToPrefix(String exp) {
        StringBuilder sb = new StringBuilder(exp).reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') sb.setCharAt(i, ')');
            else if (sb.charAt(i) == ')') sb.setCharAt(i, '(');
        }
        String postfix = infixToPostfix(sb.toString());
        return new StringBuilder(postfix).reverse().toString();
    }
}

class QueueArray {
    private int front, rear, count, size;
    private String[] queue;

    public QueueArray(int capacity) {
        size = capacity;
        queue = new String[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean isEmpty() { return count == 0; }

    public boolean isFull() { return count == size; }

    public void enqueue(String job) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add: " + job);
            return;
        }
        rear = (rear + 1) % size;
        queue[rear] = job;
        count++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Processing: " + queue[front]);
        front = (front + 1) % size;
        count--;
    }

    public void peek() {
        if (isEmpty())
            System.out.println("Queue is empty!");
        else
            System.out.println("Next job: " + queue[front]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue: []");
            return;
        }
        System.out.print("Queue: [ ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % size;
            System.out.print(queue[index] + " ");
        }
        System.out.println("]");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpressionConverter converter = new ExpressionConverter();

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Array Operations");
            System.out.println("2. Linked List Operations");
            System.out.println("3. Stack/Queue Operations");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int mainChoice = sc.nextInt();

            switch (mainChoice) {
                case 1 -> arrayMenu(sc);
                case 2 -> linkedListMenu(sc);
                case 3 -> stackQueueMenu(sc, converter);
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void arrayMenu(Scanner sc) {
        ArrayOps a = new ArrayOps();
        a.create(sc);
        while (true) {
            System.out.println("\n--- ARRAY MENU ---");
            System.out.println("1. Traverse\n2. Insert\n3. Delete\n4. Search\n5. Back");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> a.traverse();
                case 2 -> a.insert(sc);
                case 3 -> a.delete(sc);
                case 4 -> a.search(sc);
                case 5 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void linkedListMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- LINKED LIST MENU ---");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Circular Linked List");
            System.out.println("4. Back");
            int type = sc.nextInt();
            switch (type) {
                case 1 -> singlyLinkedListMenu(sc);
                case 2 -> doublyLinkedListMenu(sc);
                case 3 -> circularLinkedListMenu(sc);
                case 4 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void singlyLinkedListMenu(Scanner sc) {
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.print("Enter number of nodes: ");
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            list.insertAtEnd(sc.nextInt());
        }
        while (true) {
            System.out.println("\n--- SINGLY LINKED LIST MENU ---");
            System.out.println("1. Traverse\n2. Insert\n3. Delete\n4. Search\n5. Back");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> list.traverse();
                case 2 -> {
                    System.out.println("1. At Beginning\n2. At Position\n3. At End");
                    int ins = sc.nextInt();
                    System.out.print("Enter element: ");
                    int data = sc.nextInt();
                    if (ins == 1) list.insertAtBeginning(data);
                    else if (ins == 2) {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        list.insertAtPosition(data, pos);
                    } else list.insertAtEnd(data);
                }
                case 3 -> {
                    System.out.println("1. From Beginning\n2. From Position\n3. From End");
                    int del = sc.nextInt();
                    if (del == 1) list.deleteFromBeginning();
                    else if (del == 2) {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        list.deleteFromPosition(pos);
                    } else list.deleteFromEnd();
                }
                case 4 -> {
                    System.out.print("Enter element to search: ");
                    list.search(sc.nextInt());
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void doublyLinkedListMenu(Scanner sc) {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.print("Enter total nodes: ");
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            list.insertEnd(sc.nextInt());
        }
        list.traverse();
    }

    static void circularLinkedListMenu(Scanner sc) {
        CircularLinkedList list = new CircularLinkedList();
        System.out.print("Enter total nodes: ");
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            list.insertEnd(sc.nextInt());
        }
        list.traverse();
    }

    static void stackQueueMenu(Scanner sc, ExpressionConverter converter) {
        System.out.print("Enter stack size: ");
        int stackSize = sc.nextInt();
        StackChar stack = new StackChar(stackSize);
        System.out.print("Enter queue size: ");
        int queueSize = sc.nextInt();
        QueueArray queue = new QueueArray(queueSize);

        while (true) {
            System.out.println("\n--- STACK/QUEUE MENU ---");
            System.out.println("1. Stack Operations");
            System.out.println("2. Queue Operations");
            System.out.println("3. Back");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> stackMenu(sc, converter, stack);
                case 2 -> queueMenu(sc, queue);
                case 3 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void stackMenu(Scanner sc, ExpressionConverter converter, StackChar stack) {
        sc.nextLine();
        while (true) {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push Characters\n2. Pop\n3. Peek\n4. Display\n5. Infix→Postfix\n6. Infix→Prefix\n7. Back");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter characters: ");
                    String input = sc.nextLine().replaceAll("\\s+", "");
                    for (char c : input.toCharArray()) stack.push(c);
                }
                case 2 -> System.out.println("Popped: " + stack.pop());
                case 3 -> System.out.println("Top: " + stack.peek());
                case 4 -> stack.display();
                case 5 -> {
                    System.out.print("Enter infix: ");
                    String exp = sc.nextLine();
                    System.out.println("Postfix: " + converter.infixToPostfix(exp));
                }
                case 6 -> {
                    System.out.print("Enter infix: ");
                    String exp2 = sc.nextLine();
                    System.out.println("Prefix: " + converter.infixToPrefix(exp2));
                }
                case 7 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void queueMenu(Scanner sc, QueueArray queue) {
        sc.nextLine();
        while (true) {
            System.out.println("\n--- QUEUE MENU ---");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek\n4. Display\n5. Back");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter job: ");
                    queue.enqueue(sc.nextLine());
                }
                case 2 -> queue.dequeue();
                case 3 -> queue.peek();
                case 4 -> queue.display();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
