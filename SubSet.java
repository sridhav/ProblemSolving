import java.util.*;
class SubSet{
	//recursion

	static String myString="SRIDHAV";
	static LinkedList<String> temp = new LinkedList<String>();

	public static void main(String args[]){
		getSubset(myString.length()-1);
		for(int i=0;i<temp.size();i++){
			System.out.println((String)temp.get(i));
		}
	}

	static void getSubset(int n){
		if(n==0){
			temp.add(""+myString.charAt(n));
		}else{
			getSubset(n-1);	
			List<String> appended = new LinkedList<String>();
			appended.add(""+myString.charAt(n));
			for(int i=0;i<temp.size();i++){
				String strFromList = temp.get(i);
				strFromList=strFromList+""+myString.charAt(n);
				appended.add(strFromList);
			//	System.out.println(temp.size());
			}
			for(int i=0;i<appended.size();i++){
				temp.add(appended.get(i));
			}
		}
	}
}