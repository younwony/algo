package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� 2606 ���̷���
 * 1�� ��ǻ�͸� ���� �����̷��� �ɸ��� ��ǻ�� ��
 * @author sooki
 *
 */
public class sooki_2606 {
	private static int com;					// ���� ��
	private static int node;				// ���� ��
	private static int[][] vertexList;		// ��������
	private static int[] visited;			// �湮����
	

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
        // �ն��� ����, ������������
        int front = 0, rear = 0;
        // ó���� ����
        queue[rear++] = v;
        // �湮 ó��
        visited[v] = 1;
        int temp;
        while (front <= rear)
        {
        	// ���� ����
            temp = queue[front++];
            for (int j = 1; j <=com; j++)
            {
            	// �湮�������� ������ ������ ����
                if (vertexList[temp][j] == 1 && visited[j] == 0)
                {
                    queue[rear++]=j;
                    // �湮 ó��
                    visited[j]=1;
                }
            }
        }

        for (int j=0; j<rear;j++)
        	result++;
        
        return result;
    }

}
