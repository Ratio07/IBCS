## ✅ **IB Computer Science – Paper 2 Style Exam Question**
### **Topic: OOP, Linked Lists, Stacks, and Data Structure Selection**

---
### Part A
### **Question 1 – Customer Discount Correction System**
**[Total: 17 marks]**

A retail store uses a transaction system to record each customer's purchase at checkout. Each customer has a name, purchase amount, loyalty tier, and the hour of purchase (in 24-hour format). The store operates from 9:00 AM to 9:00 PM (21:00).

Due to a software bug, a **flat 5% discount** was mistakenly applied to all customers during the **last hour of operation (20:00–21:00)**. The correct discount policy is based on loyalty:

- **Bronze**: 5%
- **Silver**: 10%
- **Gold**: 25%

The system currently stores customers in a **singly linked list** in the order they checked out.

---

### **Given Classes:**

```java
class Customer {
    private String name;
    private double lastPurchase;  // already reduced by 5% due to bug
    private String loyaltyTier;   // "Bronze", "Silver", "Gold"
    private int hour;             // 9 to 21 (24-hour format)

    public Customer(String name, double lastPurchase, String loyaltyTier, int hour) {
        this.name = name;
        this.lastPurchase = lastPurchase;
        this.loyaltyTier = loyaltyTier;
        this.hour = hour;
    }

    // Getters
    public String getName() { return name; }
    public double getLastPurchase() { return lastPurchase; }
    public String getLoyaltyTier() { return loyaltyTier; }
    public int getHour() { return hour; }

    // Setter
    public void setLastPurchase(double amount) { this.lastPurchase = amount; }

    // Returns correct discount rate
    public double getCorrectDiscountRate() {
        switch(loyaltyTier) {
            case "Gold": return 0.25;
            case "Silver": return 0.10;
            case "Bronze": return 0.05;
            default: return 0.05;
        }
    }
}
```

```java
class TransactionLog {
    private Node head;

    private class Node {
        Customer customer;
        Node next;

        public Node(Customer customer) {
            this.customer = customer;
            this.next = null;
        }
    }

    public TransactionLog() {
        head = null;
    }

    // Adds customer to the end of the list (chronological order)
    public void addCustomer(Customer customer) {
        Node newNode = new Node(customer);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}
```

---

### **(a)**
Write a method in the `TransactionLog` class called:
```java
public void correctLastHourDiscounts()
```
This method must:
- Traverse the **entire linked list**
- Identify customers who checked out between **20:00 and 21:00 (inclusive)**
- For each such customer:
    - **Reverse the incorrect 5% discount**
    - Apply the **correct discount** based on loyalty tier
    - Update the `lastPurchase` with the corrected value


**[8 marks]**
```java
public void correctLastHourDiscounts(){
    Node currentNode = head;
    while(currentNode.next != null){
        if(currentNode.getHour() >= 20 && currentNode.getHour() <= 21){
            currentNode.setLastPurchase(currentNode.getLastPurchase * 20 / 19);
            currentNode.setLastPurchase(currentNode.getLastPurchase * (1 - currentNode.getCorrectDiscountRate()));
        }
    }
}
```
---

### **(b)**
Explain why using a **singly linked list** is **inefficient** for this type of operation — especially if the store needs to **frequently correct the most recent transactions**.

Suggest a **better data structure** for storing transactions when **recent entries need to be accessed or modified quickly**, and justify your choice.

**[4 marks]**

A singly linked list is inefficient in that requires correct transactions to be checked for error. If a store require frequent transaction corrections, it may lead servers to spend exorbitant amount of computations each time an error occurs. Instead, a better data structure the store can use are stacks. They can allow for modifications of the most recent transactions, thus allowing all of the errors to be fixed immediately rather than needing to find errors beforehand, thus saving computational power.

---

### **(c)**
Describe how the **stack** data structure follows the **LIFO principle**, and explain why this makes it **particularly suitable** for modeling **transaction undo systems** or **rollback operations** in point-of-sale software.

**[3 marks]**

the stack data structure will push the most recently stored data. In this way, it will be suitable for undo system because it can just push the recently stored data and the data follows if the redo continues.

---

### **(d)**
State **one disadvantage** of using a stack for this transaction system if the store also needs to **generate daily reports sorted by time** or **search for a customer by name**.


**[2 marks]**

It take more take for the stack to generated time sorted reports or customer by name because it needs to push all of the data, sort the data then put them back to the stack again, which is inefficient.

---



### **Task 1 (c): Binary Search Application**

The store now wants to **quickly find a customer by name** in a **separate sorted array** of customers (not the linked list). The array is sorted alphabetically by name.

Write a **binary search method** (not in the list class) that searches for a customer by name and returns the index, or -1 if not found.

Assume you are given:
```java
Customer[] sortedCustomers; // sorted by name
```

Write the method:
```java
public int binarySearchCustomer(Customer[] arr, String targetName)
```

You may assume `Customer` has a `getName()` method.

**[6 marks]**

```java
public int binarySearchCustomer(Customer[] arr, String targetName){
    low =0;
    high = arr.length-1;
    while(arr[low].compareTo(arr[high])<=0){
        mid = (low+high)/2
        if(arr[mid].equals(targetName)){
            return mid;
        }
        else if(arr[mid].compareTo(targetName)<0){
            low = mid + 1;
        }
        else{
            high = mid - 1;
        }
    }
}
```

> 🔎 *Note: This tests understanding of binary search preconditions (sorted data) and implementation.*

---

## **Question 2: Stack Applications**

### **Standard Stack Operation**

You are given a **stack of integers**. Write a method that **reverses the stack** using **only one queue** as auxiliary storage.

You may only use standard stack and queue operations (`push`, `pop`, `peek`, `enqueue`, `dequeue`, `isEmpty`).

Write the method:
```java
public void reverseStack(Stack<Integer> stack)
```

**[6 marks]**

> 💡 *Hint: Use the queue to temporarily store elements, then re-push them back.*

```java
public void reverseStack(Stack<Integer> stack){
    while (!stack.isEmpty()){
        queue.enqueue(stack.pop());
    }
    while(!queue.isEmpty()){
        stack.push(queue.dequeue());
    }
}
```

---