class LongestSubSeq{
	
	//Dynamic Programming

	static String input = "ABCDEAFGHIJKLMNOPQRSTUVWXYA";

	public static void main(String args[]){
		int out[] = new int[input.length()];
		char arr[] = input.toCharArray();
		int max=0;
		for (int i=0;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[j]<=arr[i]){
					out[i]=out[j]+1;
				}
				if(max<out[i]){
					max=out[i];
				}
			}
		}
		//for(int i=0;i<)
		max=max+1;
		System.out.println(""+max);

	}
}