package com.algorithm.step02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem_10828 {

    static String[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new String[N];

        for (int i=0; i < N; i++){
            arr[i] = br.readLine();

        }
        br.close();

        /* 스택 */
        stack();
    }

    public static void stack(){

        Stack<Integer> stack = new Stack<>();

        for(String s : arr){

            if(s.indexOf("push") > -1){
                s = s.replaceAll("[^0-9]","");
                stack.push(Integer.parseInt(s));
            }else if(s.equals("pop")){
                if(stack.empty()){
                    sb.append("-1\n");     // 스택에 정수가 없는 경우
                }else{
                    sb.append(stack.pop() + "\n"); // 스택에서 뺀 정수
                }
            }else if(s.equals("size")){       // 스택 사이즈
                sb.append(stack.size() + "\n");
            }else if(s.equals("empty")){
                if(stack.empty()){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }else if(s.equals("top")){
                if(stack.empty()){
                    sb.append("-1\n");
                }else{
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
