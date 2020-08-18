package com.algorithm.step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class problem_2606 {

    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());    // 컴퓨터 수
        int N = Integer.parseInt(br.readLine());    // 연결 쌍

        /* 정점 갯수만큼 리스트 선언 (정점 1부터) */
        list = new ArrayList[C+1];
        for(int i=1; i<=C; i++){
            list[i] = new ArrayList<>();
        }

        /* 정점 x, y */
        String[] vertexs;
        for(int i=0; i<N; i++){
            vertexs = br.readLine().split(" ");
            int x = Integer.parseInt(vertexs[0]);
            int y = Integer.parseInt(vertexs[1]);

            // 정점들의 간선 연결
            addEdge(x, y);
        }

        visit = new boolean[list.length];

        dfs(1);
        System.out.println(count);
    }

    /* 인접 리스트 별 순환 체크(깊이우선탐색) */
    public static void dfs(int x) throws IOException {
        if(visit[x]) return;
        visit[x] = true;
        //System.out.print(x + " ");

        for(int y : list[x]){
            // System.out.println("list : " + list[x]);
            // System.out.println("체크 : " + y);
            if(visit[y] == false){
                dfs(y);
                count ++;
            }
        }
    }

    /* 인접 리스트 생성(양방향) */
    public static void addEdge(int x, int y){
        //System.out.println(x + " " + y);
        list[x].add(y);
        list[y].add(x);
    }
}
