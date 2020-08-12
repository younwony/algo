package Step_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질_1697 {
    static Queue<node> queue = new LinkedList<>();
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().split(" ");
        int n = Integer.valueOf(nk[0]);
        int k = Integer.valueOf(nk[1]);

        System.out.println(bfs(n,k));

    }

    public static int bfs(int n, int k){
        queue.offer(new node(n,0));

        node node;
        int nowNode;
        int nowCount;

        int result = 0;

        if(n == k){
            return result;
        }

        while(!queue.isEmpty()){
            node = queue.poll();
            nowNode = node.node;
            nowCount = node.count;

            if(nowNode == k){
                result = nowCount;
                break;
            }

            visited[nowNode] = true;

            if(isNode(nowNode - 1))
                if(!visited[nowNode - 1])
                    queue.offer(new node(nowNode - 1, nowCount + 1));

            if(isNode(nowNode + 1))
                if(!visited[nowNode + 1])
                    queue.offer(new node(nowNode + 1, nowCount + 1));

            if(isNode(nowNode * 2))
                if(!visited[nowNode * 2])
                    queue.offer(new node(nowNode * 2, nowCount + 1));
        }

        return result;
    }

    public static boolean isNode(int node){
        return node >= 0 && node < visited.length;
    }

    static class node{
        int node;
        int count;

        public node(int node, int count) {
            this.node = node;
            this.count = count;
        }
    }
}
