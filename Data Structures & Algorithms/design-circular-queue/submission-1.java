class Node{
    int val ;
    Node next;
    Node(int v ){
        this.val = v;
        this.next = null;
    }

    Node(int v , Node n){
        this.val = v;
        this.next = n;
    }
}
class MyCircularQueue {
    int capacity ;
    int size;
    Node front ;
    Node rear;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        this.front = null;
        this.rear = null;

    }
    
    public boolean enQueue(int value) {
        if(this.isFull())return false;
        if(this.isEmpty()){
            this.front = new Node(value);
            this.rear = this.front;
            this.size++;
            return true;


        }
       
        this.rear.next = new Node(value);
        this.rear = this.rear.next;
        this.size++;
        return true;
    }
    
    public boolean deQueue() {
        if(this.isEmpty())return false;
        if(this.size == 1){
            this.size = 0;
            this.front = null;
            this.rear = null;
            return true;
        }
        this.size--;
        this.front = this.front.next;
        return true;

    }
    
    public int Front() {
        if(this.front == null)return -1;
        return this.front.val;
    }
    
    public int Rear() {
        if(this.rear == null)return -1;
        return this.rear.val;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */