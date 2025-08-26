package OptionD;

public class StringStack {
    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node top; // Reference to the top of the stack
    public StringStack() {
        top = null;
    }
    public void push(String value) {
        for(int i=0;i<value.length();i++) {
            Node newNode = new Node(value.substring(i,i+1));
            newNode.next = top;
            top = newNode;
        }
    }
    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        String value = top.data;
        top = top.next;
        return value;
    }

    // Peek at the top integer without removing it
    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display the stack contents (top to bottom)
    public void display() {
        Node current = top;
        System.out.print("Stack (top to bottom): ");
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StringStack test = new StringStack();
        test.push("hi");
        test.push("stupid");
        test.push("done");
        test.display();

        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.isEmpty());
        test.display();

        System.out.println(test.pop());
        System.out.println(test.isEmpty());
        test.display();

    }
}
