package com.algorithm.step02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem_10866 {

    static String[] arr;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }
        br.close();

        /* 덱 */
        deque();
    }

    public static void deque(){

        Deque<Integer> deq = new ArrayDeque<>();

        for(String s : arr){
            st = new StringTokenizer(s);
            s = st.nextToken();

            switch(s) {
                case "push_front" :
                    deq.offerFirst(Integer.parseInt(st.nextToken())); break;
                case "push_back" :
                    deq.offerLast(Integer.parseInt(st.nextToken())); break;
                case "pop_front" :
                    sb = deq.isEmpty() ? sb.append("-1\n") : sb.append(deq.pollFirst() + "\n");
                    break;
                case "pop_back" :
                    sb = deq.isEmpty() ? sb.append("-1\n") : sb.append(deq.pollLast() + "\n");
                    break;
                case "size" :
                    sb.append(deq.size() + "\n"); break;
                case "empty" :
                    sb = deq.isEmpty() ? sb.append("1\n") : sb.append("0\n");
                    break;
                case "front" :
                    sb = deq.isEmpty() ? sb.append("-1\n") : sb.append(deq.peekFirst() + "\n");
                    break;
                case "back" :
                    sb = deq.isEmpty() ? sb.append("-1\n") : sb.append(deq.peekLast() + "\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
