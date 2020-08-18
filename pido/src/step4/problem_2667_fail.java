package com.algorithm.step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class problem_2667_fail {

    static int value = 0;
    static int[][] maps;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> sortQue = new PriorityQueue<>();  // 오름차순 sort 처리를 위한 큐

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        maps = new int[N][N];

        // 맵 생성
        for(int i=0; i<N; i++){
            String[] str = br.readLine().split("");
            for(int j=0; j<N; j++){
                maps[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if (maps[i][j] == 1) {
                    sortQue.add(bfs(new Map(i, j)));
                }
            }
        }

        System.out.println(sortQue.size());
        while(!sortQue.isEmpty()) {
            System.out.println(sortQue.poll());
        }

        br.close();
    }


    public static int bfs(Map map) {
        Queue<Map> que = new LinkedList<>();
        value = 0;
        que.add(map);
        maps[map.x][map.y] = 0;

        while(!que.isEmpty()){
            int x = map.x;
            int y = map.y;

            que.poll();
            value ++;

            // 위
            if(x-1>= 0 && maps[x-1][y] == 1){
                maps[x-1][y] = 0;
                que.add(new Map(x-1,y));
                bfs(new Map(x-1,y));
            }

            // 아래
            if(x+1 < maps.length && maps[x+1][y] == 1) {
                maps[x+1][y] = 0;
                que.add(new Map(x+1,y));
                bfs(new Map(x+1,y));
            }

            // 왼쪽
            if(y-1 >= 0 && maps[x][y-1] == 1) {
                maps[x][y-1] = 0;
                que.add(new Map(x,y-1));
                bfs(new Map(x,y-1));
            }

            // 오른쪾
            if(y+1 < maps.length && maps[x][y+1] == 1) {
                maps[x][y+1] = 0;
                que.add(new Map(x,y+1));
                bfs(new Map(x,y+1));
            }
        }
        return value;
    }

    static class Map{
        int x;
        int y;
        Map(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

