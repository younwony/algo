package step2;

import java.util.Scanner;

/**
 * 10828 스택
 * LIFO
 * 정수를 저장하는 스택 구현하기
 * 명령은 다섯가지
 * push, pop, size, empty, top
 * push X : 정수 X를 스택에 넣는 연산
 * pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력 (스택에 들어있는 정수가 없는 경우는 -1 출력)				=> 출력
 * size : 스택에 들어있는 정수의 개수를 출력														=> 출력
 * empty : 스택이 비어있으면 1, 아니면 0 출력													=> 출력
 * top : 스택의 가장 위에 있는 정수 출력, 들어있는 정수가 없는 경우 -1 출력 								=> 출력
 * @author sooki
 *
 */
public class sooki_10828 {
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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack stk = new Stack();
        String[] command = new String[2];
        for (int i = 0; i <= n; i++) {
            command = sc.nextLine().split(" ");

            switch (command[0]) {
                case "push":
                    stk.push(command[1]);
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
