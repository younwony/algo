package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon2667 {
   static    ArrayList<Integer> zip =new ArrayList<Integer>();
   public static void main(String[] args)throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      StringTokenizer st = new StringTokenizer(s," ");
      int n = Integer.parseInt(st.nextToken());// 
      Graph g = new Graph(n*n);
      ArrayList arr= new ArrayList();
      if(n>=5&&n<=25){
         int xt=1;
         for(int x=1;x<=n;x++){
            
            String temp=br.readLine();
            for(int z=0;z<temp.length();z++){
               int t=xt+z;
               g.nodes[t].data = (temp.charAt(z)=='1'?true:false);
               int a = t-1;//좌
               int b = t-n;//위
               int c = t+1;//우
               int d = t+n;//아래
               if(z!=0) g.addEdge(t, a);
               if(b>0) g.addEdge(t, b);
               if(c<(xt+n)) g.addEdge(t, c);
               if(d<(n*n)) g.addEdge(t, d);
            }
            xt+=n;
         }
         for(int x=1;x<=(n*n);x++){
        	if(!g.nodes[x].marked) { 
	            g.dfs(g.nodes[x], x-1);
	            if(zip.get(x-1)>0){
	               arr.add(zip.get(x-1));
	            }
        	}
         }
         Collections.sort(arr);
         System.out.println(arr.size()); 
         for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
         }
      }
   }
   static class Graph{
   
      class Node{
         boolean data;
         LinkedList<Node> adjacent;
         boolean marked;
         Node(){
            this.data=false;
            this.marked = false;
            adjacent = new LinkedList<Node>();
         }
         
      }
      Node[] nodes;
      Graph(int size){
         nodes = new Node[size+1];
         for(int i=1; i<size+1;i++){
            nodes[i]= new Node();
            zip.add(0);
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

      void dfs(Node n,int num){
         if(n==null) return;
         n.marked =true;
         if(!n.data){
            return;
         }
         
        zip.set(num, zip.get(num)+1);
            
         n.marked =true;
         
         for(Node node :n.adjacent){
            if(node.marked==false){
               node.marked=true;
               
               if(node.data){
                  dfs(node,num);
                  
               }
            }
         }
      }
   }
}