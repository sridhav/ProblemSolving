class LinkedList<T>{

	Node<T> start = null;
	int size = 0;
	/**
	 * This method appends to the end of the linked list
	 * @param item object that needs to be appended
	 */
	void add(T item){
		Node<T> temp =  new Node<T>(item);
		if(start==null){
			start = temp;
		} else{
			Node travel = start;
			while(travel.link!=null){
				travel=travel.link;
			}
			travel.link= temp;
		}
		size++;
	}
	/**
	 * This method adds item to the linked list at a particular index
	 * @param item object to be added
	 * @param index the location where the object needs to be added
	 */
	void addAt(T item, int index){
		if(index == size){
			add(item);
			return;
		}

		if(index<0 || index>size){
			System.out.println("Invalid Index");
			return;
		}
		
		Node<T> temp = new Node<T>(item);
		int count = 0;
		Node travel = start;
		while(travel.link!=null){
			if(count == index-1){
				temp.link = travel.link;
				travel.link = temp;
				size++;
				return;
			} 
			travel = travel.link;
			count++;
		}
	}

	/**
	 * This method removes the item from linked list and returns the item that is removed
	 * @param index the index where the item needs to be removed
	 * @return object that is removed at the index
	 */

	T remove(int index){
		if(index < 0 || index >= size){
			System.out.println("INVALID INDEX");
			return null;
		}
		int count = 0;
		Node<T> travel = start;
		while(travel.link != null){
			if(count == index-1){
					travel.link = travel.link.link;
				size--;
				return travel.data;
			}
			travel= travel.link;
			count++;
		}
		return null;
	}
	/**
	 * This method retrieves the object from the linked list at a given index
	 * @param index the index to be retrieved
	 * @return the object at a given index
	 */
	T get(int index){
		if(index < 0 || index >= size){
			System.out.println("INVALID INDEX");
			return null;
		}
		int count = 0;
		Node<T> travel = start;
		while(travel != null){
			if(count == index){
				return travel.data;
			}
			travel= travel.link;
			count++;
		}
		return null;	
	}
	/**
	 * This method displays the content of the linked list
	 */
	void display(){
		if(start==null){
			System.out.println("Empty linked list");
			return;
		}
		System.out.println("Linked List");
		Node<T> travel = start;
		while(travel!=null){
			System.out.print(travel.data+"->");
			travel=travel.link;
		}
		System.out.println();
	}


	class Node<T> {
		T data;
		Node link;
		Node(T item){
			this.data = item;
			this.link = null;
		}
	}

	public static void main(String args[]){
		LinkedList<Integer> al =new LinkedList<Integer>();
		al.add(1);
		al.add(2);
		al.addAt(5,1);
		al.display();
		System.out.println("GET 1: "+al.get(1));
		al.remove(1);
		al.display();
		al.addAt(5,1);
		al.display();
		System.out.println("GET 1: "+al.get(1));
		al.remove(1);
		al.display();
		al.remove(5);
	}

}