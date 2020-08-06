package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 백준 1181번 단어정렬
 *  알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 *
 * 길이가 짧은 것부터
 * 길이가 같으면 사전 순으로
 *
 * 첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
 * 조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 */
public class sooki_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 0; i<n; i++)
        {
            arr.add(br.readLine());
        }

        Collections.sort(arr, (o1, o2) -> {
            // 길이순
            if (o1.length() > o2.length())
                return 1;
            else if (o1.length() < o2.length())
                return -1;
            else        // 기존 오름차순
                return o1.compareTo(o2);
        });

        for (int i = 0; i<arr.size(); i++)
        {
            if (i != 0 && arr.get(i).equals(arr.get(i-1))) continue;    // 중복되면 스킵
            else System.out.println(arr.get(i));
        }
    }
}
