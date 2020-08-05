package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class sooki_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String initStr = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for(int i=0; i<initStr.length(); i++)
            left.push(initStr.substring(i,i+1));


        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            String command = st.nextToken();
            switch(command) {
                case "L":
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if(!left.isEmpty()) left.pop();
                    break;
                case "P":
                    left.push(st.nextToken());
                    break;
            }
        }

        while(!left.isEmpty())
            right.push(left.pop());

        while(!right.isEmpty())
            System.out.print(right.pop());
    }

}

