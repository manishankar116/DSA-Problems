import java.util.*;
class queueUsingStacks{
    Stack main = new Stack();
	Stack helper = new Stack();
	int capacity = 0;
	queueUsingStacks (int capacity) {
		this.capacity  = capacity;
	}

	boolean isEmpty() {
		return main.isEmpty();
	}
	
	int size() {
		return main.size();
	}
	
	int front() {
		if(isEmpty()) return -1;
		
		while(!isEmpty()){
			helper.push(main.peek());
			main.pop();
		}
		int frontElement = (int) helper.peek();
		while(!helper.isEmpty()){
			main.push(helper.peek());
			helper.pop();
		}
		
		return frontElement;
	}
	
	int back() {
		if(isEmpty()){
			return -1;
		}
		return main.peek();
	}
	
	void push(int element) {
		if(main.size() == capacity) {
			return;
		};
		main.push(element);
	}
	
	void pop() {
		if(isEmpty()) return;
		
		while(!isEmpty()){
			helper.push(main.peek());
			main.pop();
		}
		helper.pop();
		while(!helper.isEmpty()){
			main.push(helper.peek());
			helper.pop();
		}
	}
}