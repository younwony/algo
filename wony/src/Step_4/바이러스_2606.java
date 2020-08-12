package Step_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class 바이러스_2606 {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(bufferedReader.readLine());

        int m = Integer.valueOf(bufferedReader.readLine());

        adjList = new ArrayList[n+1];
        for(int i = 0; i < adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        String[] xy;
        int x,y;
        for(int i = 0; i < m; i++){
            xy = bufferedReader.readLine().split(" ");
            x = Integer.valueOf(xy[0]);
            y = Integer.valueOf(xy[1]);

            adjList[x].add(y);
            adjList[y].add(x);
        }

        dfs(1);

        System.out.println(result);
    }

    public static void dfs(int index){
        visited[index] = true;
        for(int i : adjList[index]){
            if(!visited[i]){
                result++;
                dfs(i);
            }
        }
    }
}
