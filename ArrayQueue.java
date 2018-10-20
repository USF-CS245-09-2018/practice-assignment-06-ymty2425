public class ArrayQueue implements Queue{

    private Object[] arr; 
    private int head; 
    private int tail; 
    
    public ArrayQueue() {
        arr = new Object[10]; 
        head = 0; 
        tail = 0; 
    }
    
    @Override
    public Object dequeue() {
            Object obj = arr[head]; 
            head++; 
            head = head % arr.length; 
            return obj; 
    }

    @Override
    public void enqueue(Object obj) {
        
        if ((tail + 1) % arr.length == head) {
            grow_array(); 
        }
        arr[tail++] = obj; 
        tail = tail % arr.length; 
        
    }

    @Override
    public boolean empty() {
        return head == tail; 
    }

    private void grow_array() {
        Object[] newArr = new Object[arr.length * 2]; 
        tail = 0; 
        for (int i = head; i < arr.length + head; i++) {
            newArr[tail++] = arr[i % arr.length]; 
        }
        tail -= 1; 
        head = 0; 
        arr = newArr; 
    }
    
}