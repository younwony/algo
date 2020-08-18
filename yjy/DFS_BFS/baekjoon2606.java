package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjooin2606 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		if(c>0&&c<=100){
		Graph g =new Graph(c);
		int z= Integer.parseInt(br.readLine());
		for(int i=0;i<z;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			g.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int v= g.bfs(1);
		System.out.println(v);
		}else{
			System.out.println(0);
		}
		
		
	}
	static class Graph{
		class Node{
			int data;
			boolean marked;
			LinkedList<Node> lnkList;
			Node(int data){
				this.data= data;
				this.marked = false;
				lnkList= new LinkedList<Node>();
			}
		}
		Node[] nodes;
		Graph(int size){
			nodes = new Node[size+1];
			for(int i=0;i<size+1;i++){
				nodes[i] = new Node(i);
			}
		}
		void addEdge(int i1, int i2){
			Node n1 = nodes[i1];
			Node n2 = nodes[i2];
			if(!n1.lnkList.contains(n2)){
				n1.lnkList.add(n2);
			}
			if(!n2.lnkList.contains(n1)){
				n2.lnkList.add(n1);
			}
		}
		int bfs(int idx){
			int v=0;
			Node n = nodes[idx];
			Queue<Node> que = new LinkedList<Node>();
			n.marked=true;
			que.offer(n);
			while(!que.isEmpty()){
				Node node=(Node)que.poll();
				for(Node no:node.lnkList){
					if(no.marked==false){
						no.marked=true;
						v++;
						que.offer(no);
					}
				}
			}
			return v;
		}
	}
}
