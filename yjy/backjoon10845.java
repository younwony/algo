package backjoon;
/**
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class backjoon10845 {
	
	public static void main(String[] args)throws Exception{
		Stack stk = new Stack();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iNum = Integer.parseInt(br.readLine());
		for(int x=0;x<iNum;x++){
			String str = br.readLine();
			str = str.toLowerCase();
			String[] arr  = str.split(" ");
			int top = stk.size();
			switch(arr[0]){
				case "push": 
					stk.push(arr[1]);
					break;
				case "pop":
					if(stk.isEmpty()){
						System.out.println("-1");
					}else{
						System.out.println(stk.get(top-1));
						stk.pop();
					}
					break;
				case "top":
					
					System.out.println(stk.isEmpty()?-1:stk.peek());
					break;
				case "size":
					System.out.println(stk.size());
					break;
				case "empty":
					if(stk.isEmpty()){
						System.out.println("1");
					}else{
						System.out.println("0");
					}
					break;
				default:
					break;
			};
		}
	
	}
}
