package step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 백준 2750 수 정렬하기
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오
 *
 */
public class sooki_2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> nArr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            nArr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(nArr);
        for (int i = 0; i<n; i++)
            System.out.println(nArr.get(i));
    }
}
