package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/**
 * 
 *문제
평면상에 n개의 점이 있다. 이 점들 중에 서로 다른 두 점을 선택하면 하나의 직선이 만들어진다. 이와 같이 직선을 만들었을 때, x축 또는 y축에 평행한 직선이 몇 개나 되는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 n(1≤n≤100,000)이 주어진다. 다음 n개의 줄에는 각 점의 좌표가 int 범위에서 주어진다. 만약 입력에 서로 같은 두 점이 주어지면, 그 두 점을 이용하여 직선을 만들 수 있다.

출력
첫째 줄에 답을 출력한다.

예제 입력 1 
4
0 0
10 10
0 10
10 0
예제 출력 1 
4
 *
 */
public class baekjoon2358 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> a=new ArrayList<Integer>();
		ArrayList<Integer> b=new ArrayList<Integer>();
		int hap=0;
		for(int i=0;i<n;i++){
			String s= br.readLine();
			StringTokenizer st= new StringTokenizer(s," ");		
			a.add(Integer.parseInt(st.nextToken()));
			b.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(a);
		Collections.sort(b);
		boolean f1=true;
		boolean f2=true;
		for(int z=1;z<n;z++){
			
			if(a.get(z)==a.get(z-1)){
				if(f1){
					hap++;
					f1=false;
				}
			}else{
				f1=true;
			}
			
			if(b.get(z)==b.get(z-1)){
				if(f2){
					hap++;
					f2=false;
				}
			}else{
				f2=true;
			}
		}
		
		System.out.print(hap);
	}
}
