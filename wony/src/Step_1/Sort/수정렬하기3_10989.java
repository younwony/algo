package Step_1.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수정렬하기3_10989 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.valueOf(bufferedReader.readLine());
            int[] numberCheck = new int[10001];
            for(int i = 0; i < n; i ++){
                numberCheck[Integer.valueOf(bufferedReader.readLine())]++;
            }

            StringBuilder str = new StringBuilder();
            for(int i = 0; i < numberCheck.length; i++){
                int numberCount = numberCheck[i];
                for(int j = 0 ;j < numberCount; j++){
                    str.append(i + "\n");
                }
            }
            System.out.println(str.toString());
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
