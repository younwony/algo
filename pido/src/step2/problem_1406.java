package com.algorithm.step02;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problem_1406 {

    static String[] arr;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();     // 초기 에디터 값
        int M = Integer.parseInt(br.readLine());    // 명령어 갯수

        String[] strArr = str.split("");
        LinkedList<String> list = new LinkedList<>();
        for (String s : strArr) {
            list.addLast(s);
        }

        arr = new String[M];
        for(int i=0; i<M; i++){
            arr[i] = br.readLine();
        }

        getEditor(list);


        for(String s : list){
            bw.write(s);
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void getEditor(LinkedList list){

        int index = list.size();
        for(String s : arr){
            st = new StringTokenizer(s);
            s = st.nextToken();
            switch(s) {
                case "L" :
                    index = index > 0 ? index-1 : index;
                    break;
                case "D" :
                    index = index < list.size() ? index+1 : index;
                    break;
                case "B" :
                    if(index != 0) list.remove(--index);
                    break;
                case "P" :
                    list.add(index, st.nextToken());
                    index ++;
                    break;
            }
        }
    }
}
