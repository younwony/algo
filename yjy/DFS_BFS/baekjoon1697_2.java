package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1697_2 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		br.close();
		Graph graph = new Graph();
		int sec = graph.bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		System.out.print(sec);
	}
	static class Graph{
		class Node{
			int data;
			LinkedList<Node> adjacent;
			boolean marked;
			int sec;
			Node(int data){
				this.data=data;
				this.marked = false;
				adjacent = new LinkedList<Node>();
			}
		}
		Node[] nodes;
		Graph(){
			nodes = new Node[100001];
			for(int i=0; i<100001;i++){
				nodes[i]= new Node(i);
			}
			for(int i=0; i<100001;i++){
				if(i==0){
					addEdge(i,i+1);
				}else if (i==100000){
					addEdge(i,i-1);
				}else{
					if(i*2<=100000){
						addEdge(i,i*2);
					}
					addEdge(i,i+1);
					addEdge(i,i-1);
				}
			}
		}
		void addEdge(int i1,int i2){
			Node n1 = nodes[i1];
			Node n2 = nodes[i2];
			if(!n1.adjacent.contains(n2)){
				n1.adjacent.add(n2);
			}
		}

		int bfs(int index,int last){
			Node root = nodes[index];
			Queue<Node> que = new LinkedList<Node>();
			que.offer(root);
			int secon=0;
			root.marked =true;
			int ref =0;
			while(!que.isEmpty()){
				Node node = que.poll();
				if(node.data==last){
					ref=node.sec;
					break;
				}
				secon=node.sec;
				for (Node n:node.adjacent) {
					if(n.marked==false){
						n.marked=true;
						n.sec =secon+1;
						que.offer(n);
					}
				}
			}
			return ref;
		}
	}
}
