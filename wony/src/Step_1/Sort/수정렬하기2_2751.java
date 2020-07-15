package Step_1.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수정렬하기2_2751 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean[] numberArray = new boolean[1000001];

        try {
            int n = Integer.valueOf(bufferedReader.readLine());
            for(int i = 0; i < n; i++){
                numberArray[Integer.valueOf(bufferedReader.readLine())] = true;
            }

            StringBuilder result = new StringBuilder();
            for(int i = 0; i < numberArray.length; i++) {
                if (numberArray[i]) {
                    result.append(i + "\n");
                }
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
