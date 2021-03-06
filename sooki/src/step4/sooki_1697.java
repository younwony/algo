package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1697번 숨바꼭질
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * 수빈이는 걷거나 순간이동을 할 수 있다.
 * 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 *  
 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수
 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력  
 * @author sooki
 *
 */
public class sooki_1697 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer nk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nk.nextToken());
        int k = Integer.parseInt(nk.nextToken());
        
        // 수빈이가 동생보다 큰 경우 무조건 -1로 이동해야함
        if (n >= k) 
        	System.out.println(n-k);
        else
        	System.out.println(bfs(n,k));
        

	}
	
	private static int bfs(int n, int k)
	{
		int[] visited = new int[100001];
        int queue[] = new int[100001];
        // 앞라인 숫자, 어디까지갔는지
        int front = 0, rear = 0;
        // 처음꺼 넣음
        queue[rear++] = n;
        // 방문 처리
        visited[n] = 1;
        int temp;
        while (front <= rear)
        {
        	// 기준 숫자
            temp = queue[front++];
            
            for (int i = 0; i < 3; i++) {
				int nx;
				
				if (i==0)
					nx = temp -1;
				else if (i==1)
					nx = temp +1;
				else 
					nx = temp *2;
				
				if (nx == k)
					return visited[temp];
				else if (nx >= 0 && nx <= 100000)
				{
					if (visited[nx] == 0)
					{
						queue[rear++] = nx;
						visited[nx] = visited[temp]+1;
					}
				}
				
            }
            	
        }

        return 0;
    }

}
