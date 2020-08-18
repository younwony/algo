package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2178번 미로탐색
 * @author sooki
 *
 */
public class sooki_2178 {
	private static int[][] vertexList;		// 간선관계
	private static int[][] visited;			// 방문여부
    private static int[] mx = { -1, 0, 1, 0 };
    private static int[] my = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());

        vertexList = new int[n][m];
        visited = new int[n][m];
        
        for (int i = 0; i < n; i++)
        {
        	String line = br.readLine();
        	for (int j = 0; j < line.length(); j++) {
        		vertexList[i][j] = line.charAt(j)-48;
			}
			
		}
        
        bfs(n-1,m-1);
        
    	System.out.println(vertexList[n-1][m-1]);
        

	}
	
	private static void bfs(int x, int y)
	{
		Queue<int[]> q = new LinkedList<int[]>();
		// 처음꺼 넣음
		q.add(new int[] {0,0});
		// 방문 처리
		visited[0][0] = 1;
		
		while (!q.isEmpty())
		{
			int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
            	// 다음 경로
            	int nx = temp[0] + mx[i];
            	int ny = temp[1] + my[i];
            	
                if (nx < 0 || ny < 0 || nx > x || ny > y) 
                    continue;
                
                
                if (visited[nx][ny] == 1 || vertexList[nx][ny] == 0) 
                    continue;
                
                q.add(new int[] {nx,ny});
                
                vertexList[nx][ny] = vertexList[temp[0]][temp[1]] + 1;
                visited[nx][ny] = 1;
				
            }
		}
		
    }

}
