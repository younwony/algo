package Step_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS_1260 {

    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nmv = bufferedReader.readLine().split(" ");
        int n = Integer.valueOf(nmv[0]);
        int m = Integer.valueOf(nmv[1]);
        int v = Integer.valueOf(nmv[2]);

        String[] inputXY;
        int x,y;
        for(int i = 0 ; i< n + 1; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            inputXY = bufferedReader.readLine().split(" ");
            x = Integer.valueOf(inputXY[0]);
            y = Integer.valueOf(inputXY[1]);

            // 인접 리스트
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        visited = new boolean[n+1];
        stack.push(v);
        dfs();
        result.append("\n");
        visited = new boolean[n+1];
        queue.offer(v);
        bfs();
        System.out.println(result.toString());
    }

    public static void dfs(){

        while(!stack.isEmpty()){
            int nowNode = stack.pop();
            // Stack 나가면서 방문 체크
            if(!visited[nowNode]){
                visited[nowNode] = true;
                result.append(nowNode + " ");
            }
            // 현재 노드에 연결된 노드리스트 가져오기
            ArrayList<Integer> linkNodeList = adjList.get(nowNode);
            // 작은 숫자부터 방문되게 하기위해서는 Stack의 LIFO로 인해 내림차순으로 정렬
            Collections.sort(linkNodeList, Collections.reverseOrder());

            // 현재 방문 안된 노드만 Stack Push
            for(int node : linkNodeList){
                if (!visited[node]){
                    stack.push(node);
                }
            }
        }
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            // Queue 나가면서 방문 체크
            if(!visited[nowNode]){
                visited[nowNode] = true;
                result.append(nowNode + " ");
            }

            // 현재 노드에 연결된 노드리스트 가져오기
            ArrayList<Integer> linkNodeList = adjList.get(nowNode);
            // 작은 숫자부터 방문되게 하기위해서는 queue의 FIFO로 인해 내림차순으로 정렬
            Collections.sort(linkNodeList);

            // 현재 방문 안된 노드만 Queue Push
            for(int node : linkNodeList){
                if (!visited[node]){
                    queue.offer(node);
                }
            }
        }
    }
}
