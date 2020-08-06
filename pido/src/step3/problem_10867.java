package com.algorithm.step03;

import java.io.*;
import java.util.*;

public class problem_10867 {

    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());;

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            if(list.indexOf(arr[i]) == -1 ) {
                list.add(arr[i]);
            }
        }

        Collections.sort(list);

        for(Integer val : list){
            bw.write(val + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
