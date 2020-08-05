package Step_3;

import java.util.Scanner;

public class 중복빼고정렬하기_10867 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String[] inputData = scanner.nextLine().split(" ");

        boolean[] isNumber = new boolean[2001];

        for(String str : inputData){
            isNumber[Integer.valueOf(str) + 1000] = true;
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < isNumber.length; i++){
            if(isNumber[i]){
                result.append(i - 1000 + " ");
            }
        }

        System.out.println(result.toString());

    }
}
