package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 
 * 문제
옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.

길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.

S = A[0]*B[0] + ... + A[N-1]*B[N-1]

S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.

S의 최솟값을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고,
 셋째 줄에는 B에 있는 수가 순서대로 주어진다. N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.

출력
첫째 줄에 S의 최솟값을 출력한다.

예제 입력 1 
5
1 1 1 6 0
2 7 8 3 1
예제 출력 1 
18
힌트
A를 {1, 1, 0, 1, 6}과 같이 재배열하면 된다.
 *
 */
public class baekjoon1026_1 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		ArrayList<Integer> C = new ArrayList<Integer>();
		ArrayList<Integer> D = new ArrayList<Integer>();
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int x=0;
		while(st.hasMoreTokens()){
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		s= br.readLine();
		st = new StringTokenizer(s, " ");
		while(st.hasMoreTokens()){
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		C=(ArrayList<Integer>) B.clone();
		D=(ArrayList<Integer>) B.clone();
		Collections.sort(A);
		Collections.sort(C);
		
		for(int z=B.size()-1;z>=0; z--){
			for(int y=0;y<B.size();y++){
				if(C.get(z)==B.get(y)){
					D.set(y, A.get(x));
					x++;
				}
			}
		}
		int sum = 0;
		for(int i=0;i<n;i++){
			sum += D.get(i)*B.get(i);
		}
		System.out.print(sum);
	}
}
