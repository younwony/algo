package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11650번 좌표 정렬하기
 *
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 *
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 */
public class sooki_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i<n; i++)
        {
            StringTokenizer xy = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(xy.nextToken());
            arr[i][1] = Integer.parseInt(xy.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0])
                return Integer.compare(o1[1], o2[1]);
            else
                return Integer.compare(o1[0], o2[0]);
        });

        for (int i = 0; i<n; i++)
        {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

        if(br !=  null)
            br.close();
    }

}
