package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1158 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new LinkedList<Integer>();
		StringBuffer sb= new StringBuffer();
		if(n>=1&&n<=5000){
			for(int i=1;i<=n;i++){
				que.offer(i);
			}
			if(k>=1&&k<=n){
				while(n-->0){
					if(n!=0){
						for(int z=0;z<=(k-1);z++){
							int t = que.poll();
							if(z==(k-1)){
								sb.append(t+", ");
							}else{
								que.offer(t);
							}
						}
					}else{
						int t = que.poll();
						sb.append(t);
					}
				}
			}
			System.out.println("<"+sb.toString()+">");
		}
	}
	
}
