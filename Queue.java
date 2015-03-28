class Queue {
	
	Node first = null;
	Node last = null;

	void enqueue(int val){
		Node item = new Node(val);
		if(first == null){
			first = item;
			last = item;
		} else {
			last.link = item;
			last = last->link;
		}
	}
	
	Node dequeue(){
		Node temp;
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
		Node travel = first;

		System.out.println("Queue");
		
		while(travel !=null){
			System.out.print(travel.data+"-->");
		}
		System.out.println();
	}

	class Node {
		int data;
		Node link;
		Node(int val){
			this.data=val;
			link = null;
		}
	}

	public static void main(String args[]){
		Queue aqueue = new Queue();
		aqueue.enqueue(1);
		aqueue.display();
		aqueue.enqueue(2);
		aqueue.display();
		aqueue.enqueue(3);
		aqueue.display();
		aqueue.dequeue();
		aqueue.display();
		aqueue.dequeue();
		aqueue.display();
		aqueue.dequeue();
		aqueue.display();
	}

}