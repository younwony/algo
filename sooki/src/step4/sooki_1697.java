package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� 1697�� ���ٲ���
 * �����̴� ���� �� N(0 �� N �� 100,000)�� �ְ�, ������ �� K(0 �� K �� 100,000)�� �ִ�.
 * �����̴� �Ȱų� �����̵��� �� �� �ִ�.
 * �������� ��ġ�� X�� �� �ȴ´ٸ� 1�� �Ŀ� X-1 �Ǵ� X+1�� �̵�
 * �����̵��� �ϴ� ��쿡�� 1�� �Ŀ� 2*X�� ��ġ�� �̵�
 * �����̿� ������ ��ġ�� �־����� ��, �����̰� ������ ã�� �� �ִ� ���� ���� �ð��� �� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 *  
 * ù ��° �ٿ� �����̰� �ִ� ��ġ N�� ������ �ִ� ��ġ K�� �־�����. N�� K�� ����
 * �����̰� ������ ã�� ���� ���� �ð��� ���  
 * @author sooki
 *
 */
public class sooki_1697 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer nk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nk.nextToken());
        int k = Integer.parseInt(nk.nextToken());
        
        // �����̰� �������� ū ��� ������ -1�� �̵��ؾ���
        if (n >= k) 
        	System.out.println(n-k);
        else
        	System.out.println(bfs(n,k));
        

	}
	
	private static int bfs(int n, int k)
	{
		int[] visited = new int[100001];
        int queue[] = new int[100001];
        // �ն��� ����, ������������
        int front = 0, rear = 0;
        // ó���� ����
        queue[rear++] = n;
        // �湮 ó��
        visited[n] = 1;
        int temp;
        while (front <= rear)
        {
        	// ���� ����
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
