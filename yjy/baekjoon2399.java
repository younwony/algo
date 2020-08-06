package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 
 *문제
수직선에 n개의 점이 찍혀 있다. 각각의 점의 x좌표가 주어졌을 때, n2개의 모든 쌍에 대해서 거리를 더한 값을 구하는 프로그램을 작성하시오.

즉, 모든 i, j에 대해서 |x[i] - x[j]|의 합을 구하는 것이다.

입력
첫째 줄에 n(1 ≤ n ≤ 10,000)이 주어진다. 다음 줄에는 x[1], x[2], x[3], …, x[n]이 주어진다. 각각은 0 이상 1,000,000,000 이하의 정수이다.

출력
첫째 줄에 답을 출력한다.

예제 입력 1 
5
1 5 3 2 4
예제 출력 1 
40
 *
 */
public class baekjoon2399 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[]=new int[n];
		String s= br.readLine();
		StringTokenizer st= new StringTokenizer(s," ");
		long hap=0;
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(st.nextToken());
		}
		for(int z=0;z<n;z++){
			for(int x=0;x<n;x++){
				hap+=Math.abs(a[z]-a[x]);
			}
		}
		System.out.println(hap);
	}
}
