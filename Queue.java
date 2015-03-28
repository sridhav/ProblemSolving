class Queue<T>{
	
	Node<T> first = null;
	Node<T> last = null;

	void enqueue(T val){
		Node item = new Node(val);
		if(first == null){
			first = item;
			last = item;
		} else {
			last.link = item;
			last = last.link;
		}
	}
	
	Node<T> dequeue(){
		Node<T> temp;
		if(first == null){
			System.out.println("Queue Empty");
			return null;
		}

		if(first == last){
			temp = first;
			first = null;
			last = null;
		} else {
			temp = first;
			first = first.link;
		}
		return temp;
	}

	void display(){
		Node<T> travel = first;

		System.out.println("Queue");
		
		while(travel !=null){
			System.out.print(travel.data+"-->");
			travel = travel.link;
		}
		System.out.println();
	}

	class Node<T> {
		T data;
		Node link;
		Node(T val){
			this.data=val;
			link = null;
		}
	}

	public static void main(String args[]){
		Queue<String> aqueue = new Queue<String>();
		aqueue.enqueue("100");
		aqueue.display();
		aqueue.enqueue("212");
		aqueue.display();
		aqueue.enqueue("313");
		aqueue.display();
		aqueue.dequeue();
		aqueue.display();
		aqueue.dequeue();
		aqueue.display();
		aqueue.dequeue();
		aqueue.display();
		aqueue.dequeue();
		aqueue.display();
	}
}
