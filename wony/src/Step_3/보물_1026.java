package Step_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 보물_1026 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.valueOf(bufferedReader.readLine());
            int[] aArray = new int[n];
            int[] bArray = new int[n];
            String[] inputArray = bufferedReader.readLine().split(" ");
            for(int i = 0 ; i < n; i++){
                aArray[i] = Integer.valueOf(inputArray[i]);
            }
            inputArray = bufferedReader.readLine().split(" ");
            for(int i = 0; i < n; i++){
                bArray[i] = Integer.valueOf(inputArray[i]);
            }

            Arrays.sort(aArray);
            Arrays.sort(bArray);

            int sum = 0;
            for(int i = 0 ; i < n; i++){
                sum += aArray[i]*bArray[n-1-i];
            }
            System.out.println(sum);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null){ bufferedReader.close();}
            }catch (Exception e2){
                e2.printStackTrace();
            }

        }
    }
}
