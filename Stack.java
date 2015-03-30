class Stack<T>{
	private Node top = null;

	void push(T item){
		Node<T> temp = new Node<T>(item);
		if(top==null){
			top = temp;
		} else{
			temp.link = top;
			top = temp;
		}
	}

	T pop(){
		Node<T> temp = null;
		if(top == null){
			System.out.println("Stack is Empty");
			return null;
		} else{
			temp = top;
			top = top.link;
			return temp.data;
		}
		
	}

	void display(){
		Node<T> temp =top;
	
		if(top == null){
			System.out.println("Stack is Empty");
			return;
		}
			System.out.println("STACK");
		while(temp!=null){
			System.out.println("|");
			System.out.println(temp.data);
			temp = temp.link;
		}
		System.out.println();
	}


	class Node<T>{
		T data;
		Node<T> link=null;
		Node(T item){
			this.data = item;
		}
	}

	public static void main(String args[]){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.display();
		stack.pop();
		stack.pop();
		stack.display();
		stack.pop();
		stack.pop();
		stack.display();
	}
}