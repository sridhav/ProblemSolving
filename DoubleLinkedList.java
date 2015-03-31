class DoubleLinkedList<T>{
	
	Node<T> start=null;
	Node<T> end = null;
	int size = 0;
	/**
	 * This method appends an object at the end of the double linked list
	 * @param item object that needs to be appended
	 */
	void add(T item){
		Node<T> temp = new Node<T>(item);
		if(start == null && end == null){
			start = temp;
			end = temp;
		} else{
			temp.prev=end;
			end.next=temp;
			end = temp;
		}
		size++;
	}
	/**
	 * This method adds item to the double linked list at given index.
	 * @param item the object that needs to be added
	 * @param index the index where it needs to be added
	 */
	void addAt(T item, int index){
		Node<T> temp = new Node<T>(item);
		if(index == size){
			add(item);
			return;
		}
		if(index==0){
			temp.next=start;
			start.prev=temp;
			start=temp;
			size++;
			return;
		}

		if(index < 0 && index >size){
			System.out.println("Invalid Index");
			return;
		}

		if(index>(size/2)){
			Node travel = end;
			int count = size-1;
			while(travel.prev != null){
				if(index == count){
					temp.prev = travel.prev;
					temp.next = travel;
					travel.prev = temp;
					size++;
					break;
				}
				travel = travel.prev;
				count--;
			}
		} else{
			Node travel = start;
			int count = 0;
			while(travel.next != null){
				if(count == index-1){
					temp.prev = travel;
					temp.next = travel.next;
					travel.next.prev = temp;
					travel.next = temp;
					size++;
					break;
				}
				travel = travel.next;
				count++;
			}
		}
	}

	/**
	 * This method retrives the object at given index
	 * @param index the index to retrieve the object
	 * @return  return the object at the given index
	 */

	T get(int index){
		if(index < 0 || index >= size){
			System.out.println("Invalid Index");
			return null;
		}
		if(index==0){
			return start.data;
		}

		if(index==size-1){
			return end.data;
		}
		if(index > (size/2)){
			Node<T> travel = end;
			int count = size-1;
			while(travel.prev!=null){
				if(index==count){
					return travel.data;
				}
				travel = travel.prev;
				count--;
			}
		} else{
			Node<T> travel = start;
			int count =0;
			while(travel.next!=null){
				if(count == index){
					return travel.data;
				}
				travel = travel.next;
				count++;

			}
		}
		return null;
	}

	/**
	 * This method removes the object at given index
	 * @param index index where the object is to be removed
	 * @return object that is removed
	 */

	T remove(int index){
		if(index<0 || index >= size){
			System.out.println("Invalid Index");
			return null;
		}
		Node<T> temp=null;
		if(index == 0){
			temp = start;
			start.prev=null;
			start=start.next;
			size--;
			return temp.data;
		}

		if(index == size-1){
			temp = end;
			end = end.prev;
			end.next = null;
			size--;
			return temp.data;
		}

		if(index > (size/2)){
			Node travel = end;
			int count = size-1;
			while(travel.prev!=null){
				if(index==count){
					temp = travel;
					travel.next.prev = travel.prev;
					travel.prev.next = travel.next;
					size--;
					return temp.data;
				}
				travel = travel.prev;
				count --;
			}
		} else{
			Node travel =start;
			int count = 0;
			while(travel.next!=null){
				if(index==count){
					temp = travel;
					travel.next.prev = travel.prev;
					travel.prev.next = travel.next;
					size--;
					return temp.data;
				}
				travel = travel.next;
				count++;
			}
		}
		return null;
	}
	/**
	 * This method displays the linked list in forwards and backwards
	 */
	void display(){
		Node travel = start;
		if(start == null){
			System.out.println("Empty");
			return;
		}
		System.out.println("Forward List");
		while(travel!=null){
			System.out.print(travel.data+"-");
			travel = travel.next;
		}
		System.out.println();
		travel = end;
		if(end == null){
			System.out.println("Empty");
		}
		System.out.println("Backward List");

		while(travel!=null){
			System.out.print("-"+travel.data);
			travel = travel.prev;
		}
		System.out.println();
	}


	class Node<T>{
		T data;
		Node prev;
		Node next;

		Node(T item){
			this.data=item;
			prev=null;
			next=null;
		}

	}


	public static void main(String args[]){
		DoubleLinkedList<Integer> al =new DoubleLinkedList<Integer>();
		al.add(1);
		al.display();
		al.add(2);
		al.display();
		al.addAt(5,1);
		al.display();
		System.out.println("GET 1: "+al.get(1));
		al.remove(1);
		al.display();
		al.addAt(5,1);
		al.remove(2);
		al.display();
		System.out.println("GET 1: "+al.get(1));
		al.remove(1);
		al.display();
		al.remove(5);
	}
}