public class ArrayStack implements Stack {
	
	private Object [] arr;
	private int top;
	private int size;

	public ArrayStack() {
		arr = new Object[10];
		top = -1;
		size = 0;
	}

	@Override
	public void push (Object item) {
		if(size == arr.length) {
			grow_array();
		}
		top = top+1;
		arr[top] = item;
		
		size++;
	}

	@Override
	public Object pop() {
		if(empty()) {
			System.out.println("Empty Array");
		} 
			
		size--;
		return arr[top--];
	}


	@Override
	public Object peek() {
		if(empty()) {
			System.out.println("Empty Array");
		} 
		return arr[top];
	}

	@Override
	public boolean empty() {
		return top == -1;
	}

	private void grow_array() {
		Object [] newArr = new Object [arr.length * 2];
		for(int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

}