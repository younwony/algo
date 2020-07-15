package step1_extra;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 2399 거리의 합
 * 수직선에 n개의 점이 찍혀있다. 각각의 점에 x좌표가 주어졌을 때, n^2개의 모든 쌍에 대하여 거리를 더한 값을 구하는 프로그램을 작성하시오.
 * 절대값으로
 * 첫째 줄 n (1<= n <= 10,000)
 * 둘째 줄 각각의 값 (0 <= 값 <= 1,000,000,000)
 */
public class sooki_2399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] nArr = new long [n];
        for (int i = 0 ; i < n ; i++)
            nArr[i] = sc.nextLong();

        long distance = 0;

        Arrays.sort(nArr);

        for (int i = n-1; i>=0; i--){
            for (int j = 0; j <i; j++){
                distance += nArr[i] - nArr[j];
            }
        }
        System.out.print(distance*2);
    }
}
