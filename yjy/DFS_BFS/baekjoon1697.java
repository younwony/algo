package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1697 {

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
		class X{
			int data;
			boolean marked;
			int sec;
			int bef;
			X(int data,int sec,int bef){
				this.data=data;
				this.marked = false;
				this.sec =sec;
				this.bef=bef;
			}
		}

		int bfs(int index,int last){
			int ret =0;
			int curX = index;
			int curSec=0;
			int bef= index;
			Queue<X> que = new LinkedList<X>();
			que.offer(new X(curX,ret,bef));
			while(!que.isEmpty()){
				X x = (X)que.poll();
				curX = x.data;
				curSec = x.sec;
				bef = x.bef;
				ret = curSec;
				if(curX==last){
					break;
				}
				if(curX<last){
					if(curX*2<=last){
						if(curX!=0&&(curX*2)<=100000){
							que.add(new X(curX*2,curSec+1,curX));
						}
					}
					if(curX+1<=100000){
						if(bef!=curX+1){
						que.add(new X(curX+1,curSec+1,curX));
						}
					}
				}
				if(curX-1>=0){
					if(bef!=curX-1){
						que.add(new X(curX-1,curSec+1,curX));
					}
				}
				
			}
			que.clear();
			return ret;
		}
	}
}
