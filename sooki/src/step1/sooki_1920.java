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
public class sooki_1920 {

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
            System.out.println(BSearch(nArr, mArr[i]));
        }
    }
}

