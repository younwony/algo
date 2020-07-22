package Step_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 덱_10866 {

    static Deque<Integer> deque = new ArrayDeque<>();
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
        if("push_front".equals(order)){
            deque.offerFirst(Integer.valueOf(inputData[1]));
        }else if("push_back".equals(order)){
            deque.offerLast(Integer.valueOf(inputData[1]));
        }else if("pop_front".equals(order)){
            result.append((deque.isEmpty() ? "-1" : deque.pollFirst()) + "\n");
        }else if("pop_back".equals(order)){
            result.append((deque.isEmpty() ? "-1" : deque.pollLast()) + "\n");
        }else if("size".equals(order)){
            result.append(Integer.toString(deque.size()) + "\n");
        }else if("empty".equals(order)){
            result.append((deque.isEmpty() ? "1" : "0") + "\n");
        }else if("front".equals(order)){
            result.append((deque.isEmpty() ? "-1" : deque.peekFirst()) + "\n");
        }else if("back".equals(order)){
            result.append((deque.isEmpty() ? "-1" : deque.peekLast()) + "\n");
        }
    }
}
