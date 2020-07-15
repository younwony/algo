package step1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 10815 숫자카드
 * 첫째 줄 숫자카드 개수 N개 (1<= N <= 500,000)
 * 둘째 줄 숫자카드에 적혀있는 정수 (-10,000,000 <= 숫자카드 값 <= 10,000,000)
 * 셋째 줄 질문 개수 M (1<= M <= 500,000)
 * 넷째 줄 질문에 적혀있는 정수값 (-10,000,000 <= 값 <= 10,000,000)
 * 질문에 적힌 정수값이 숫자카드 중에 있으면 1 출력, 없으면 0 출력
 */
public class sooki_10815 {

    public static int BSearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == target)
                return 1;
            else if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nArr = new int [n];
        for (int i = 0 ; i < n ; i++)
            nArr[i] = sc.nextInt();

        Arrays.sort(nArr);

        int m = sc.nextInt();

        int[] mArr = new int [m];
        for (int i = 0 ; i < m ; i++)
            mArr[i] = sc.nextInt();

        for (int i = 0 ; i < m ; i++)
        {
            System.out.print(BSearch(nArr, mArr[i]) + " ");
        }
    }
}

