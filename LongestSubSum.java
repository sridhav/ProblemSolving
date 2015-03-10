class LongestSubSum{

	//Dynamic Programming

	static int[] arr = {1,1,2,-1};

	public static void main(String[] args){
		int out[] = new int[arr.length];

		for(int i=0;i<arr.length;i++){
			if(i<=0){
				out[i] = arr[i];
			} else {
				int val = out[i-1]+arr[i];
				if(val>arr[i]){
					out[i] = val;
				} else{
					out[i] = arr[i];
				}
			}
		}
		for(int i=0;i<out.length;i++)
			System.out.println("i "+i+" val: "+out[i]);
	}

}