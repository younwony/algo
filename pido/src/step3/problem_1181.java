package com.algorithm.step03;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class problem_1181 {

    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    // 단어 갯수

        // 정렬 : 길이 , 같으면 사전 순, 단어 같으면 한번만 출력
        String[] str = new String[N];
        for (int i=0; i < N; i++) {
            str[i] = br.readLine();                 // 입력 단어
            // 중복 제거
            if(list.indexOf(str[i]) == -1 ){
                list.add(str[i]);
            }
        }

        getSortLength();

        for(String val : list){
            bw.write(val + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void getSortLength() {
        // 문자열 길이 비교
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(list, com);
    }


}
