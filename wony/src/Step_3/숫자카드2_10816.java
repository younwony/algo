package Step_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 숫자카드2_10816 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            bufferedReader.readLine();

            int[] nArray = new int[20000001];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            while(stringTokenizer.hasMoreTokens()){
                nArray[Integer.valueOf(stringTokenizer.nextToken()) + 10000000]++;
            }

            bufferedReader.readLine();

            StringBuilder result = new StringBuilder();
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while(stringTokenizer.hasMoreTokens()){
                result.append(nArray[Integer.valueOf(stringTokenizer.nextToken()) + 10000000] + " ");
            }

            System.out.println(result.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null){bufferedReader.close();}
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
