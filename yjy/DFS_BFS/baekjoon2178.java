package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2178 {
	   public static void main(String[] args)throws Exception{
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      String s = br.readLine();
	      StringTokenizer st = new StringTokenizer(s," ");
	      int n = Integer.parseInt(st.nextToken());//
	      int m = Integer.parseInt(st.nextToken());//
	      Graph g = new Graph(n*m);
	      if((n>=2&&n<=100)&&(m>=2&&m<=100)){
	         int xt=1;
	         for(int x=1;x<=n;x++){
	            
	            String temp=br.readLine().trim();
	            for(int z=0;z<m;z++){
	               int t=xt+z;
	               g.nodes[t].data = (temp.charAt(z)=='1'?true:false);
	               int a = t-1;//좌
	               int b = t-m;//위
	               int c = t+1;//우
	               int d = t+m;//아래
	               if(z!=0) g.addEdge(t, a);
	               if(b>0) g.addEdge(t, b);
	               if(c<(xt+m)) g.addEdge(t, c);
	               if(d<(n*m)) g.addEdge(t, d);
	            }
	            xt+=m;
	         }
	        
	        int z = g.bfs(1,n*m);
	        System.out.println(z);
	      }
	   }
	   static class Graph{
	   
	      class Node{
	         boolean data;
	         LinkedList<Node> adjacent;
	         boolean marked;
	         int x;
	         int dis;
	         Node(int x,int dis){
	            this.data=false;
	            this.marked = false;
	            this.dis=dis;
	            this.x=x;
	            adjacent = new LinkedList<Node>();
	         }
	         
	      }
	      Node[] nodes;
	      Graph(int size){
	         nodes = new Node[size+1];
	         for(int i=1; i<size+1;i++){
	            nodes[i]= new Node(i,1);
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

	      int bfs(int idx,int last){
	    	 int dis=1;
	    	 Node n = nodes[idx];
	    	 Queue<Node> que = new LinkedList<Node>();
	    	 n.marked=true;
	    	 int curDis =n.dis;
	    	 que.offer(n);
	    	 while (!que.isEmpty()) {
				Node node = (Node)que.poll();
				if(node.x==last){
					dis=node.dis;
				}
				curDis=node.dis;
				for(Node nd:node.adjacent){
					if(nd.marked==false){
						nd.marked=true;
						if(nd.data){
							nd.dis= curDis+1;
							que.offer(nd);
						}
					}
				}
			}
	    	 return dis;
	      }
	   }
}
