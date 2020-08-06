package step3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 10867번 중복빼고정렬하기
 *  N개의 정수가 주어진다. 이때, N개의 정수를 오름차순으로 정렬하는 프로그램을 작성하시오. 같은 정수는 한 번만 출력한다.
 *
 * 첫째 줄에 수의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다.
 * 첫째 줄에 수를 오름차순으로 정렬한 결과를 출력한다. 이때, 같은 수는 한 번만 출력한다.
 */
public class sooki_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        StringTokenizer num = new StringTokenizer(br.readLine());
        ArrayList<String> arr = new ArrayList<String>();
        while (num.hasMoreTokens())
        {
            arr.add(num.nextToken());
        }
        Collections.sort(arr);

        for (int i = 0; i<arr.size(); i++)
        {
            if (i != 0 && arr.get(i).equals(arr.get(i-1))) continue;    // 중복되면 스킵
            else bw.write(arr.get(i));

            if (i != arr.size()-1)  bw.write(" ");
        }

        if(br !=  null)
            br.close();
        if(bw != null)
        {
            bw.flush();
            bw.close();
        }
    }
}
