package com.algorithm.step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class problem_2178 {

    static int[][] maps;
    static int[][] count;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);   // x축
        M = Integer.parseInt(str[1]);   // y축
        count = new int[N][M];          // 이동한 경로 체크

        maps = new int[N][M];
        for(int i=0; i<N; i++){
            String[] mapVal = br.readLine().split("");
            for(int j=0; j<M; j++){
                maps[i][j] = Integer.parseInt(mapVal[j]);   // 맵 생성
            }
        }

        // (1,1) 부터 시작
        bfs(new Map(0, 0));

    }

    public static void bfs(Map map){

        Queue<Map> que = new LinkedList<>();
        que.add(map);

        count[map.x][map.y] = 1;    // 초기값 체크

        while(!que.isEmpty()){
            Map m = que.poll();
            int x = m.x;
            int y = m.y;

            // 위
            if(x-1>= 0 && count[x-1][y]==0 && maps[x-1][y] == 1) {
                que.add(new Map(x-1,y));
                count[x-1][y] = count[x][y]+1;
            }

            // 아래
            if(x+1 < N && count[x+1][y]==0 && maps[x+1][y] == 1) {
                que.add(new Map(x+1,y));
                count[x+1][y] = count[x][y]+1;
            }

            // 왼쪽
            if(y-1 >= 0 && count[x][y-1]==0 && maps[x][y-1] == 1) {
                que.add(new Map(x,y-1));
                count[x][y-1] = count[x][y]+1;
            }

            // 오른쪽
            if(y+1 < M && count[x][y+1]==0 && maps[x][y+1] == 1) {
                que.add(new Map(x,y+1));
                count[x][y+1] = count[x][y]+1;
            }
        }
        System.out.println(count[N-1][M-1]);
    }

    static class Map {
        int x;
        int y;
        Map(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


}
