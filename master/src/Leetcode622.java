/** 622. 设计循环队列 https://leetcode.cn/problems/design-circular-queue/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode622 {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(4);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
        myCircularQueue.deQueue();
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(5);
        myCircularQueue.Rear();
        myCircularQueue.enQueue(6);
        myCircularQueue.Rear();
        myCircularQueue.Front();
        myCircularQueue.isFull();
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(4);
        myCircularQueue.Front();
    }
}

/**
 * 核心：头指针指向当前头指针的元素，尾指针，指向下一个插入的位置
 */
class MyCircularQueue {
    private int front;
    private int rear;
    private int capacity;
    private int[] elements;

    public MyCircularQueue(int k) {
        capacity = k + 1;
        elements = new int[capacity];
        rear = front = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return ((rear + 1) % capacity) == front;
    }
}

