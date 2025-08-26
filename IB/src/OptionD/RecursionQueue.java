package OptionD;

import java.util.Queue;

public class RecursionQueue {


    public void reverseQueue(Queue<Integer> q) {
        if (!q.isEmpty()) {
            int temp = q.poll();
            reverseQueue(q);
            q.add(temp);
        }
    }
}
