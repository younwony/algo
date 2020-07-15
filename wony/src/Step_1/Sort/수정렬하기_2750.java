package Step_1.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 수정렬하기_2750 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        try {
            int n = Integer.valueOf(bufferedReader.readLine());
            int[] nArray = new int[n];
            for(int i = 0 ; i < n; i++){
                nArray[i] = Integer.valueOf(bufferedReader.readLine());
            }

            Arrays.sort(nArray);

            for(int i : nArray){
                result.append(i + "\n");
            }

            System.out.println(result.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null){bufferedReader.close();}
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
