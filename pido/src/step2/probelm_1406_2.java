package com.algorithm.step02;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class probelm_1406_2 {

    static String[] arr;
    static StringTokenizer st;
    static LinkedList<String> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();     // 초기 에디터 값
        String[] strArr = str.split("");
        list = new LinkedList<>();

        ListIterator<String> itor = list.listIterator();
        for (String s : strArr) {
            itor.add(s);
        }

        int M = Integer.parseInt(br.readLine());    // 명령어 갯수
        arr = new String[M];
        for(int i=0; i<M; i++){
            arr[i] = br.readLine();
        }

        getEditor(itor);

        for(String s : list){
            bw.write(s);
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void getEditor(ListIterator iter){
        for(String s : arr){
            st = new StringTokenizer(s, " ");
            s = st.nextToken();
            switch(s) {
                case "L" :
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case "D" :
                    if(iter.hasNext()) iter.next();
                    break;
                case "B" :
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P" :
                    iter.add(st.nextToken());
                    break;
            }
        }
    }
}
