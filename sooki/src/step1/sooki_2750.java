package step1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 2750 수 정렬하기
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오
 *
 */
public class sooki_2750 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nArr = new int [n];
        for (int i = 0 ; i < n ; i++)
            nArr[i] = sc.nextInt();

        Arrays.sort(nArr);

        for (int i = 0 ; i < n ; i++)
        {
            System.out.println(nArr[i]);
        }
    }
}
