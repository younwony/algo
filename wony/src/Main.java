import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean[] numberArray = new boolean[2000001];

        try {
            int n = Integer.valueOf(bufferedReader.readLine());
            int inputData;
            for (int i = 0; i < n; i++) {
                numberArray[Integer.valueOf(bufferedReader.readLine()) + 1000000] = true;
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numberArray.length; i++) {
                if (numberArray[i]) {
                    result.append((i - 1000000) + "\n");
                }
            }
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}
