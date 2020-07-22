package Step_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 에디터_1406 {
    static Deque<String> deque = new ArrayDeque<>();
    static Deque<String> dequeClone = new ArrayDeque<>();
    static StringBuilder result = new StringBuilder();
    static String[] inputData;
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String inputDataString = bufferedReader.readLine();
            for(int i = 0 ; i < inputDataString.length(); i++){
                deque.offer(String.valueOf(inputDataString.charAt(i)));
            }

            int n = Integer.valueOf(bufferedReader.readLine());
            for(int i = 0 ; i < n; i++){
                inputData = bufferedReader.readLine().split(" ");
                Order(inputData[0]);
            }

            while(!deque.isEmpty()){
                result.append(deque.pollFirst());
            }

            while(!dequeClone.isEmpty()){
                result.append(dequeClone.pollFirst());
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

    public static void Order(String order){
        if("L".equals(inputData[0])){
            if(!deque.isEmpty()){
                dequeClone.offerFirst(deque.pollLast());
            }
        }else if("D".equals(inputData[0])){
            if(!dequeClone.isEmpty()){
                deque.offer(dequeClone.pollFirst());
            }
        }else if("B".equals(inputData[0])){
            if(!deque.isEmpty()){
                deque.pollLast();
            }
        }else if("P".equals(inputData[0])){
            deque.offer(inputData[1]);
        }

    }
}
