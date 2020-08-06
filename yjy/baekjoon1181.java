package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class baekjoon1181 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<String>();
		StringBuffer sb= new StringBuffer();
		for(int i=0;i<n;i++){
			String temp = br.readLine();
			if(!arr.contains(temp)){
				arr.add(temp);
			}
		}
		Collections.sort(arr,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length()>o2.length()){
					return 1;
				}else if(o1.length()<o2.length()){
					return -1;
				}else{
					return o1.compareTo(o2);
				}
					
			}
		});
		for(String s:arr){
			sb.append(s+"\n");
		}
		System.out.println(sb.toString());
	}

}
