package Step_1.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 수찾기_1920 {

    public static String[] nArray,mArray;
    public static int[] nIntegerArray;
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n,m;

        try {
            n = Integer.parseInt(bufferedReader.readLine());
            nArray = bufferedReader.readLine().split(" ");
            m = Integer.parseInt(bufferedReader.readLine());
            mArray = bufferedReader.readLine().split(" ");

            nIntegerArray = new int[n];

            // String 배열을 정렬하 것보다 int 배열을 정렬하는게 더빠르다
            /**
             * 비교 기반 정렬에선 정수의 경우 두 수를 연산 한번으로 비교할 수 있지만,
             *
             * 문자열의 경우 최악에 모든 문자에 대해 비교를 하게 됩니다.
             *
             * 정수의 정렬 시간복잡도를 O(NlgN) 이라 한다면
             *
             * 문자열은 문자열의 길이가 더해져 O(NlgNM) 이라 할 수 있습니다.
             * 출처 - https://www.acmicpc.net/board/view/34668
             */
            for(int i = 0; i < n; i++){
                nIntegerArray[i] = Integer.valueOf(nArray[i]);
            }

            Arrays.sort(nIntegerArray);


            /* 최소시간 로직
            for(String data : mArray){
                if(Arrays.binarySearch(nIntegerArray, Integer.parseInt(data)) >= 0)
                    bufferedWriter.write(1 + "\n");
                else
                    bufferedWriter.write(0 + "\n");
            }*/

            for(String searchNumber : mArray){
                bufferedWriter.write(BinarySearch(Integer.valueOf(searchNumber)) + "\n");
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null) bufferedReader.close();
                if(bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedReader.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }


    public static int BinarySearch(int searchNumber){
        int left = 0;
        int right = nArray.length - 1;
        int middle;

        while(right >= left){
            middle = (left + right) / 2;

            if(nIntegerArray[middle] == searchNumber){
                return 1;
            }else if(nIntegerArray[middle] < searchNumber){
                left = middle + 1;
            }else{
                right = middle -1;
            }
        }
        return 0;
    }
}
