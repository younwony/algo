package com.algorithm.step04;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class problem_1697 {

    static int[] count = new int[100001];   // 이동한 경로 체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);   // 수빈이 위치
        int K = Integer.parseInt(str[1]);   // 동생 위치

        if(N == K){ // 초기 시작점 같은경우
            System.out.println(0);
        }else {
            bfs(new Map(N, K));
        }

    }

    public static void bfs(Map map){

        Queue<Map> que = new LinkedList<>();
        que.add(map);

        while(!que.isEmpty()){

            Map m = que.poll();
            int n = m.x;    // 수빈이 위치
            int k = m.y;    // 동생 위치

            // 동생과 수빈이 위치 동일 할 경우(잡음!)
            if(n == k){
                System.out.println(count[n]);
                break;
            }
            // 조건 (N-1, N+1, N*2), 범위를 벗어나지않으면서 방문하지 않은 곳
            if(n-1 >= 0 && count[n-1]==0){
                que.add(new Map(n-1, k));
                count[n-1] = count[n]+1;
            }
            if(n+1 <= 100000 && count[n+1]==0){
                que.add(new Map(n+1, k));
                count[n+1] = count[n]+1;
            }
            if(n*2 <= 100000 && count[n*2]==0){
                que.add(new Map(n*2, k));
                count[n*2] = count[n]+1;
            }
        }

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
