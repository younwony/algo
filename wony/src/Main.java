import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int size = 0;
    public static class Node {
        Object data;
        Node link;
    }

    public static class Stack
    {
        Node top;

        void push (String x)
        {
            Node temp;
            if (top == null)
            {
                top = new Node();
                top.data = x;
                top.link = null;
            }
            else
            {
                temp = new Node();
                temp.data = x;
                temp.link = top;
                top = temp;
            }
            size ++;
        }

        void pop()
        {
            if (top == null)
                System.out.println(-1);
            else
            {
                System.out.println(top.data);
                top = top.link;
                size --;
            }
        }

        void size()
        {
            System.out.println(size);
        }

        void isEmpty()
        {
            if (top == null)
                System.out.println(1);
            else
                System.out.println(0);
        }

        void top()               // 스택에서 원소 값을 반환
        {
            if (top == null)
                System.out.println(-1);
            else
                System.out.println(top.data);
        }

    }


    public static void main(String[] args) throws NumberFormatException, IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack stk = new Stack();
        for (int i = 0; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String stn = st.nextToken();

            switch (stn) {
                case "push":
                    stk.push(st.nextToken());
                    break;
                case "pop":
                    stk.pop();
                    break;
                case "size":
                    stk.size();
                    break;
                case "empty":
                    stk.isEmpty();
                    break;
                case "top":
                    stk.top();
                    break;

                default:
                    break;
            }
        }

    }

}