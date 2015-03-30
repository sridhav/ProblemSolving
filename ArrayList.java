class ArrayList<T>{
	T arr[] = new T[1];
	int size = 0;
	/**
	 * Appends item at the end of an Array List
	 * @param item Object to be appended
	 */
	void add(T item){
		if(this.size == arr.length){
			T temp[] = arr;
			arr = new T[size];
			for(int i=0;i<temp.length;i++){
				arr[i] = temp[i];
			}
		}
		arr[size] = item;
		size++;
	}
	/**
	 * This method retrieves the Object from the ArrayList at given index.
	 * @param index the index from where the object needs to be retrieved
	 * @return  the generic object at given index 
	 */
	T get(int index){
		return arr[index];
	}
	/**
	 * Adds item to the array list at particular index
	 * @param item the Object to be added
	 * @param index the location where the object needs to added
	 */
	void addAt(T item, int index){
		if(index == this.size){
			add(item);
			return;
		}
		if(index > this.size || index<0){
			System.out.println("Invalid Index appending at last");
			add(item);
		}
		if(this.size == arr.length){
			T temp[] = arr;
			arr = new T[2*arr.length];
			for(int i=0;i<(temp.length+1);i++){
				arr[i] = temp[i];
				if(i==index){
					i++;
					arr[i] = item;
				}
			}
		} else{
			for(int j=size()-1;j==index;j--){
				if(j==index){
					arr[j]=item;
				} else{
					arr[j+1]=arr[j];
				}
			}
		}
		size++;
	}
	/**
	 * This method removes the item from ArrayList and returns the item that is removed
	 * @param index the index where the item needs to be removed 
	 * @return Object that is removed at the index
	 */
	T remove(int index){
		if(index<0 && index>size){
			System.out.println("Invalid Index");
			return null;
		}
		T item = arr[index];
		for(int i=index;i<this.size-1;i++){
			arr[i]=arr[i+1];
		}
		return item;
	}
	/**
	 * This method returns the ArrayList logical size
	 * @return the size of the ArrayList
	 */
	int size(){
		return size;
	}
	/**
	 * This method displays the contents of the arraylist
	 */

	void display(){
		System.out.println("ArrayList : Length "+arr.length+" : Size : "+this.size);
		for(int i=0;i<size;i++){
			System.out.print(arr[i]+"-");
		}
	}

	public static void main(String args[]){
		ArrayList<Integer> al =new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.addAt(5,1);
		System.out.println("GET 1: "+al.get(1));
		al.remove(1);
		al.display();
	}
}