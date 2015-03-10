class RoboMove{
	
	//Recursion

	static int count = 0;
	public static void main(String[] args){
		int i=0;
		int j=0;
		int n=2;
		recurse(i,j,n);
		System.out.println(count);
	}

	static void recurse(int i, int j, int n){
		if(i==n && j==n){
			count++;		
		} 

		if((j+1)<=n){
			recurse(i,j+1,n);
		}
		if((i+1)<=n){
			recurse(i+1,j,n);
		}
	}

}