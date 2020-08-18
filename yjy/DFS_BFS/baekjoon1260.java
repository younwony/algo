package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1 
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1 
1 2 4 3
1 2 3 4
예제 입력 2 
5 5 3
5 4
5 2
1 2
3 4
3 1
예제 출력 2 
3 1 2 5 4
3 1 4 2 5
예제 입력 3 
1000 1 1000
999 1000
예제 출력 3 
1000 999
1000 999
 */
public class baekjoon1260 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		int n = Integer.parseInt(st.nextToken());// n 정점
		int m = Integer.parseInt(st.nextToken());// m 간선
		int v = Integer.parseInt(st.nextToken());
		Graph g = new Graph(n+1);
		Graph g2 = new Graph(n+1);
		for(int i=1;i<=m;i++){
			 s = br.readLine();
			 st = new StringTokenizer(s," ");
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 g.addEdge(x, y);
			 g2.addEdge(x, y);
		}
		g.dfs(g.nodes[v]);
		System.out.println("");
		g2.bfs(v);
	}
	static class Graph{
		class Node{
			int data;
			LinkedList<Node> adjacent;
			boolean marked;
			Node(int data){
				this.data=data;
				this.marked = false;
				adjacent = new LinkedList<Node>();
			}
		}
		Node[] nodes;
		Graph(int size){
			nodes = new Node[size+1];
			for(int i=1; i<size+1;i++){
				nodes[i]= new Node(i);
			}
		}
		void addEdge(int i1,int i2){
			Node n1 = nodes[i1];
			Node n2 = nodes[i2];
			if(!n1.adjacent.contains(n2)){
				n1.adjacent.add(n2);
			}
			if(!n2.adjacent.contains(n1)){
				n2.adjacent.add(n1);
			}
		}

		void dfs(Node n){
			if(n==null) return;
			n.marked =true;
			System.out.print(n.data+ " ");
			Collections.sort(n.adjacent,new Comparator<Node>(){

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1.data,o2.data);
				}
				
			});
			for(Node node :n.adjacent){
				if(node.marked==false){
					node.marked=true;
					dfs(node);
				}
			}
		}
		void bfs(int index){
			Node root = nodes[index];
			Queue<Node> que = new LinkedList<Node>();
			que.offer(root);
			root.marked =true;
			
			while(!que.isEmpty()){
				Node node = que.poll();
				System.out.print(node.data+" ");
				Collections.sort(node.adjacent,new Comparator<Node>(){

					@Override
					public int compare(Node o1, Node o2) {
						// TODO Auto-generated method stub
						return Integer.compare(o1.data,o2.data);
					}
					
				});
				for (Node n:node.adjacent) {
					if(n.marked==false){
						n.marked=true;
						que.add(n);
					}
				}
			}
		}
	}
}
