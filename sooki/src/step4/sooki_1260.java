package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1260번 DFS와 BFS
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 * 정점 번호는 1번부터 N번까지이다.
 * 
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
 * 입력으로 주어지는 간선은 양방향이다.
 * @author sooki
 *
 */
public class sooki_1260 {
	private static int n;					// 정점 수
	private static int m;					// 간선 수
	private static int v;					// 시작점(vertex)
	private static int[][] vertexList;		// 간선관계
	private static int[] visited;			// 방문여부
    private static StringBuffer sb = new StringBuffer();
	

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer nmv = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nmv.nextToken());
        m = Integer.parseInt(nmv.nextToken());
        v = Integer.parseInt(nmv.nextToken());
        
        vertexList = new int[n+1][n+1];
        visited = new int[n+1];
        
        for (int i = 0; i < m; i++)
        {
        	StringTokenizer ab = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(ab.nextToken());
        	int b = Integer.parseInt(ab.nextToken());
        	vertexList[a][b] = vertexList[b][a] = 1;
		}

        // dfs
        dfs(v);
        
        sb.append("\n");
        visited = new int[n+1];
        
        // bfs
        bfs(v);

        System.out.println(sb.toString());
	}
	
	private static void dfs(int v)
	{
		// 이미 방문했으면 skip
		if (visited[v] == 1) return;
		
		// 방문처리
		visited[v] = 1;
        sb.append(v + " ");
		
		for (int i = 1; i <= n; i++) {
			// 간선이 있으면 dfs
			if (vertexList[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int v)
	{
        int queue[] = new int[n+1];
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
            for (int j = 1; j <=n; j++)
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
            sb.append(queue[j]+" ");
    }

}
