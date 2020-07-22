package com.algorithm.step02;

import org.omg.Messaging.SyncScopeHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class problem_10845 {

    static String[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }
        br.close();

        /* 큐 */
        queue();
    }

    public static void queue(){

        int back = 0;
        String push = "";
        Queue<Integer> que = new LinkedList<Integer>();
        for(String s : arr){
            if(s.indexOf("push") > -1){
                push = s.replaceAll("[^0-9]","");
                s = "push";
            }
            switch(s) {
                case "push" :
                    back = Integer.parseInt(push);
                    que.offer(Integer.parseInt(push)); break;
                case "pop" :
                    sb = que.isEmpty() ? sb.append("-1\n") : sb.append(que.poll() + "\n");
                    break;
                case "size" :
                    sb.append(que.size() + "\n"); break;
                case "empty" :
                    sb = que.isEmpty() ? sb.append("1\n") : sb.append("0\n");
                    break;
                case "front" :
                    sb = que.isEmpty() ? sb.append("-1\n") : sb.append(que.peek() + "\n");
                    break;
                case "back" :
                    sb = que.isEmpty() ? sb.append("-1\n") : sb.append(back + "\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
