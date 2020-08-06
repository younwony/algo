package step3_extra;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 1946번 신입사원
 * 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다
 * 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
 * 이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다.
 * 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다.
 * 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.
 *
 * 각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.
 */
public class sooki_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.valueOf(br.readLine());

        for (int i=0; i<t; i++)
        {
            int n = Integer.valueOf(br.readLine());
            int[][] scoreArr = new int[n][2];
            for (int j = 0; j <n; j++){
                StringTokenizer score = new StringTokenizer(br.readLine());
                while (score.hasMoreTokens())
                {
                    scoreArr[j][0] = Integer.parseInt(score.nextToken());
                    scoreArr[j][1] = Integer.parseInt(score.nextToken());
                }
            }

            Arrays.sort(scoreArr, Comparator.comparingInt(o -> o[0]));

            int result = n;
            int min = scoreArr[0][1];
            for (int j = 1; j <scoreArr.length; j++)
            {
                if (min < scoreArr[j][1])
                {
                    result--;
                } else
                {
                    min = scoreArr[j][1];
                }
            }

            sb.append(result);
            sb.append(System.lineSeparator());

        }
        System.out.println(sb.toString());


        if(br !=  null)
            br.close();
    }
}
