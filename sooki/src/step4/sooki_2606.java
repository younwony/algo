package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2606 바이러스
 * 1번 컴퓨터를 통해 웜바이러스 걸리는 컴퓨터 수
 * @author sooki
 *
 */
public class sooki_2606 {
	private static int com;					// 정점 수
	private static int node;				// 간선 수
	private static int[][] vertexList;		// 간선관계
	private static int[] visited;			// 방문여부
	

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        com = Integer.parseInt(br.readLine());
        node = Integer.parseInt(br.readLine());
        
        vertexList = new int[com+1][com+1];
        visited = new int[com+1];
        for (int i = 0; i < node; i++) {
        	StringTokenizer xy = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(xy.nextToken());
        	int y = Integer.parseInt(xy.nextToken());
        	vertexList[x][y] = vertexList[y][x] = 1;
		}
        
        // bfs
        System.out.println(bfs(1));
	}
	
	
	private static int bfs(int v)
	{
		int result = -1;
        int queue[] = new int[com+1];
        // 앞라인 숫자, 어디까지갔는지
        int front = 0, rear = 0;
        // 처음꺼 넣음
        queue[rear++] = v;
        // 방문 처리
        visited[v] = 1;
        int temp;
        while (front <= rear)
        {
        	// 기준 숫자
            temp = queue[front++];
            for (int j = 1; j <=com; j++)
            {
            	// 방문한적없고 간선이 있으면 넣음
                if (vertexList[temp][j] == 1 && visited[j] == 0)
                {
                    queue[rear++]=j;
                    // 방문 처리
                    visited[j]=1;
                }
            }
        }

        for (int j=0; j<rear;j++)
        	result++;
        
        return result;
    }

}
