package com.algorithm.step04;

import java.io.*;
import java.util.*;

/* 그래프와 DFS, BFS */
public class problem_1260 {

    static int N;
    static int M;
    static int V;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 정점(vertex)의 갯수 N, 간선(Edge)의 갯수 M, 탐색시작 번호 V */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
        }

        /* 정점 갯수만큼 리스트 선언 (정점 1부터) */
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        /* 정점 x, y */
        String[] vertexs;
        for(int i=0; i<M; i++){
            vertexs = br.readLine().split(" ");
            int x = Integer.parseInt(vertexs[0]);
            int y = Integer.parseInt(vertexs[1]);
            // 정점들의 간선 연결
            addEdge(x, y);
        }

        visit = new boolean[list.length];

        /*
        for(int i=1; i < list.length; i++) {
            // vertex 1부터 출력
            // System.out.println(i+" : "+ list[i]);
            visitClear();
            dfs(i);
        }
        */

        dfs(V);
        visitClear();
        bw.write("\n");
        bfs(V);

        br.close();
        bw.flush();
        bw.close();
    }

    /* 인접 리스트 생성(양방향) */
    public static void addEdge(int x, int y){
        //System.out.println(x + " " + y);
        list[x].add(y);
        list[y].add(x);
    }

    /* 인접 리스트 별 순환 체크(깊이우선탐색) */
    public static void dfs(int x) throws IOException {
        if(visit[x]) return;
        visit[x] = true;
        //System.out.print(x + " ");
        bw.write(x + " ");

        Collections.sort(list[x]);  // 작은것부터 방문하므로 sort 처리
        for(int y : list[x]){
            // System.out.println("list : " + list[x]);
            // System.out.println("체크 : " + y);
            if(visit[y] == false){
                dfs(y);
            }
        }
    }

    /* 너비 우선 탐색 */
    public static void bfs(int x) throws IOException {
        if(visit[x]) return;
        visit[x] = true;

        Queue<Integer> que = new LinkedList<Integer>();
        que.add(x); // 방문한 정점을 큐에 입력

        while(!que.isEmpty()){
            int q = que.poll(); // 큐에서 하나 추출
            bw.write(q + " ");

            // 추출한 값의 인접리스트 조회
            for(int y : list[q]){
                //System.out.println("list : " + list[q]);
                //System.out.println("체크 : " + y);
                if(visit[y] == false){
                    que.add(y);     // 인접 정점들 큐에 넣어줌
                    visit[y] = true;
                }
            }
        }
    }

    /* 테스트용 방문배열 초기화 */
    public static void visitClear(){
        for(int i=0; i< visit.length; i++){
            visit[i] = false;
        }
    }
}
