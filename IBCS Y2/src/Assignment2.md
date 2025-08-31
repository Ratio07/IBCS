### **Part B: "Undo System for Text Editor"**

A simple text editor uses a **stack** to support **undo** operations. Every time the user types a word, it is pushed onto the `actionStack`. The editor also supports a **"redo"** feature, but only **immediately after an undo**, and only **once**.

You are to design a system using **two stacks**:
- `actionStack`: stores words typed (most recent on top)
- `redoStack`: stores words that were undone (only one level of redo allowed)

Implement a method:

```java
public String undoLastAction(){
    if(!redoStack.isEmpty()){
        redoStack.pop();
    }
    redoStack.push(actionStack.pop());
    return redoStack.peek();
}
```
- Pops the last word from `actionStack`
- Pushes it to `redoStack` (only if `redoStack` is empty — no multiple redos)
- Returns the undone word

Also implement:
```java
public String redoLastUndo(){
    if(!redoStack.isEmpty()){
        actionStack.push(redoStack.pop());
        return actionStack.peek();
    }
    return null;
}
```
- Only works if `redoStack` is not empty
- Moves the word back to `actionStack`
- Returns the word, or `null` if redo not possible


```java
import java.util.Stack;

public class TextEditor {
    private Stack<String> actionStack;
    private Stack<String> redoStack;

    public TextEditor() {
        actionStack = new Stack<>();
        redoStack = new Stack<>();
    }

    /**
     * Undo the last action: pop from actionStack, push to redoStack (if empty)
     * @return the undone word, or null if no action to undo
     */
    public String undoLastAction() {
        
    }

    /**
     * Redo the last undone action
     * @return the word restored, or null if redo not possible
     */
    public String redoLastUndo() {
        
    }
}
```

---

**[7 marks]**

> 🎯 *Tests understanding of stack use in real systems and constraints.*

---

## **Question 3: Binary Trees – Diagram-Based Operations**

### **Given**:
A **binary search tree (BST)** with the following nodes inserted in this order:  
**50, 30, 70, 20, 40, 60, 80**

---

### **Part A**:
Draw the **final structure** of the BST after all insertions. Label all nodes.

....50....   
..30.....70..  
20.40.60.80

**[3 marks]**



---

### **Part B**:
Now perform the following operations **in sequence**, drawing the tree **after each step**:

1. Insert **35**
2. Insert **75**
3. Delete **30** (use standard BST deletion: if two children, replace with **in-order predecessor**)
4. Delete **70**

Show the tree after **each** operation.

....50....   
..30.....70..  
20.35..60.80  
.......40


....50....   
..30.....75..  
20.35..70.80  
......40.60


....50....   
..35.....75..  
20.40..70.80  
.........60

....50....   
..35.....75..  
20.40..60.80

**[8 marks – 2 each]**

> 📌 *Ensure diagrams are clear, with left/right children correctly positioned.*

---

### **Part C**:
After the final tree, state:
- The **height** of the tree
- Whether it is **balanced**
- One advantage of a **balanced BST** over an unbalanced one

**[3 marks]**
height = 2   
It is balanced  
Balanced BST is useful for search
---

## **Question 4: Vocabulary & Diagram Quiz**

### **Part A: Definitions**
Define the following terms (1 mark each):

1. Node - a fundamental unit within a data structure
2. Singly linked list - a type of linked list that its node contains a data field and a pointer that points to the next node
3. Stack (LIFO) - a type of data structure which will first execute its last data that get pushed in the stack.
4. Binary search tree (BST) - A type of tree structure that each node's left subtree contains node that is smaller than the parent node,while the right subtree contains the bigger one. 
5. Balanced tree - a type of tree structure where the height difference between left and right subtrees ≤ 1 at every node
6. In-order traversal - A type of traversal in the tree with the order : left subtree -> root node -> right subtree
7. Overflow (in stack context) - The program uses more memory from the called stack that it is allocated for.  
8. Head (in linked list) - a specific pointer that points to the start of the list.

**[8 marks]**

---

### **Part B: Diagram Interpretation**

You are given the following **singly linked list diagram**:

```
[Anna] -> [Bob] -> [Cara] -> null
```

Each node contains a `Customer` object.

1. Label the **head node**. Anna
2. What is the **successor** of Bob? Cara
3. What happens if the reference from Bob to Cara is lost? Then the node Anna will point to null
4. Why can't you traverse from Cara to Bob? because the pointer is single-direction, so you can't traverse in that opposite direction

**[4 marks]**

---

### **Part C: Tree Type Identification**

Given three tree diagrams (describe them verbally or sketch in exam):

- **Tree A**: All leaves at same level, full at every level
- **Tree B**: Skewed heavily to the left, height = n-1
- **Tree C**: Height difference between left and right subtrees ≤ 1 at every node

Identify each as:
- Full binary tree **Tree A** 
- Skewed (unbalanced) tree **Tree B**
- Balanced BST **Tree C**

And state which would give **best search performance** and why.
Tree a because each search would eliminate most amount, which Tree B's node all needs to be searched, and tree C has efficiency of log of n

**[5 marks]**

---