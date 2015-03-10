class Permutation{

	//Recursion

	static String inp = "ABCDEFGHIJKLMNO";
	public static void main(String[] args){
		char[] arr = inp.toCharArray();
		permutate(arr,0,arr.length-1);

	}

	static void permutate(char[] arr,int i, int n){
		if (i==n){
			System.out.println(new String(arr));
		} else{
			for(int j=i;j<=n;j++){
				swap(arr,i,j);
				permutate(arr,i+1,n);
				swap(arr,i,j);
			}
		}
	}

	static void swap(char[] arr, int i, int j){
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j] = temp;
	}
}