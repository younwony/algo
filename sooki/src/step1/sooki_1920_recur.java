package step1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 1920번 수 찾기
 * 첫째 줄에 자연수 N 입력
 * 둘째 줄에 정수 A[N]가 N개 입력
 * 셋째 줄에 M 입력
 * 넷째 줄에 정수 M개 입력
 * 넷째 줄의 정수 M이 둘째 줄의 A[N]에 존재하는지 찾기
 *
 * M개의 줄에 답 출력. 존재하면 1, 없으면 0 출력
 * 모든 정수의 범위는 -2^31보다 크거나 같고 2^31보다 작다
 */
public class sooki_1920_recur {
    static int [] A ;

    public static int bs(int start, int end, int input)
    {
        int mid = (start + end )/2;

        if (mid >= end)
            return 0;

        if(A[mid] == input)
        {
            return 1;
        }else if (A[mid] < input)
        {
            return bs(mid+1, end, input);
        }else {
            return bs(start, mid, input);
        }
    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        A = new int [input];
        for (int i = 0 ; i < input ; i++)
        {
            A[i] = sc.nextInt();
        }

        int input2 = sc.nextInt();
        int check ;
        boolean exist = false;

        Arrays.sort(A);

        for (int i = 0 ; i < input2 ; i++)
        {
            check = sc.nextInt();
            System.out.println(bs(0,A.length, check));
        }
    }
}

