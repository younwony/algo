package Step_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_10828 {

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder result = new StringBuilder();
    static String[] inputData;
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.valueOf(bufferedReader.readLine());
            for(int i = 0 ; i < n; i++){
                inputData = bufferedReader.readLine().split(" ");
                stackOrder(inputData[0]);
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

    public static void stackOrder(String order){
        if("push".equals(order)){
            stack.push(Integer.valueOf(inputData[1]));
        }else if("pop".equals(order)){
            result.append((stack.empty() ? "-1" : stack.pop()) + "\n");
        }else if("size".equals(order)){
            result.append(Integer.toString(stack.size()) + "\n");
        }else if("empty".equals(order)){
            result.append((stack.empty() ? "1" : "0") + "\n");
        }else if("top".equals(order)){
            result.append((stack.empty() ? "-1" : stack.peek()) + "\n");
        }
    }
}
