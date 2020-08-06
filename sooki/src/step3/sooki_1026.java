package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1026번 보물
 * 길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
 * S = A[0]*B[0] + ... + A[N-1]*B[N-1]
 * S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
 * S의 최솟값을 출력하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 N이 주어진다.
 * 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다.
 * N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
 */
public class sooki_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        StringTokenizer a = new StringTokenizer(br.readLine());
        StringTokenizer b = new StringTokenizer(br.readLine());

        int[] aArr = new int[n];
        int[] bArr = new int[n];
        for (int i = 0; i<n; i++)
        {
            aArr[i] = Integer.parseInt(a.nextToken());
            bArr[i] = Integer.parseInt(b.nextToken());
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr);

        int tot = 0;

        for (int i =0; i<n; i++)
        {
            tot += aArr[i]*bArr[n-i-1];
        }
        System.out.print(tot);


    }

}
