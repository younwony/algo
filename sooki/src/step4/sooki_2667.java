package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 2667번 단지번호붙이기
 * @author sooki
 *
 */
public class sooki_2667 {
	private static int n;					// 지도 크기
	private static int[][] vertexList;		// 간선관계
	private static int[][] visited;			// 방문여부
	private static int result;				// 단지수

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        vertexList = new int[n][n];
        visited = new int[n][n];
        
        for (int i = 0; i < n; i++)
        {
        	String line = br.readLine();
        	for (int j = 0; j < line.length(); j++) {
        		vertexList[i][j] = line.charAt(j)-48;
			}
			
		}
        int x = 0, y = 0;
        while (x<n && y<n)
        {
        	if (visited[x][y] == 0 && vertexList[x][y] == 1)
        	{
        		result++;
        		dfs(x,y);
			}
        	if (x == n-1)
        	{	
        		x = 0;
        		y++;
        	}
        	else
        		x++;
		}
        
        System.out.println(result);
        int[] resultArr = new int[result+1];
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] != 0)
					resultArr[visited[i][j]]++;
			}
		}
        
    	Arrays.sort(resultArr);
		for (int i = 1; i < resultArr.length; i++) {
			System.out.println(resultArr[i]);
		}
	}
	
	private static void dfs(int x, int y)
	{
		// 이미 방문했으면 skip
		if (visited[x][y] != 0) return;
		
		// 방문처리
		visited[x][y] = result;
		
		for (int i = 0; i < 4; i++)
		{
			// 왼쪽
			if (i == 0) 
			{
				if (x-1 >=0 && y >=0 && x-1<n && y < n ) {
					if (vertexList[x-1][y] == 1 && visited[x-1][y] == 0)
					{
						dfs(x-1,y);
					}
				}
			}
			// 오른쪽
			else if (i==1)
			{
				if (x+1 >=0 && y >=0 && x+1<n && y < n ) {
					if (vertexList[x+1][y] == 1 && visited[x+1][y] == 0)
					{
						dfs(x+1,y);
					}
				}
			}	
			// 위
			else if (i==2)
			{
				if (x>=0 && y-1 >=0 && x<n && y-1 < n ) {
					if (vertexList[x][y-1] == 1 && visited[x][y-1] == 0)
					{
						dfs(x,y-1);
					}
				}
			}
			// 아래
			else if (i==3)
			{
				if (x >=0 && y+1 >=0 && x<n && y+1 < n ) {
					if (vertexList[x][y+1] == 1 && visited[x][y+1] == 0)
					{
						dfs(x,y+1);
					}
				}
			}	
			
		}
		
	}
	

}
