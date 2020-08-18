package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� 1260�� DFS�� BFS
 * �׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�.
 * ���� ��ȣ�� 1������ N�������̴�.
 * 
 * ù° �ٿ� ������ ���� N(1 �� N �� 1,000), ������ ���� M(1 �� M �� 10,000), Ž���� ������ ������ ��ȣ V�� �־�����.
 * ���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����.
 * � �� ���� ���̿� ���� ���� ������ ���� �� �ִ�.
 * �Է����� �־����� ������ ������̴�.
 * @author sooki
 *
 */
public class sooki_1260 {
	private static int n;					// ���� ��
	private static int m;					// ���� ��
	private static int v;					// ������(vertex)
	private static int[][] vertexList;		// ��������
	private static int[] visited;			// �湮����
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
		// �̹� �湮������ skip
		if (visited[v] == 1) return;
		
		// �湮ó��
		visited[v] = 1;
        sb.append(v + " ");
		
		for (int i = 1; i <= n; i++) {
			// ������ ������ dfs
			if (vertexList[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int v)
	{
        int queue[] = new int[n+1];
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
            for (int j = 1; j <=n; j++)
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
            sb.append(queue[j]+" ");
    }

}
