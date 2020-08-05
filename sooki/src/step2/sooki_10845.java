package step2;

import java.util.Scanner;

/**
 * 10845번 큐
 * 큐 구현
 * FIFO
 * 명령은 총 6가지
 * push X : 정수 X를 큐에 넣는 연산
 * pop : 큐에서 가장 앞에있는 정수를 빼고 그 수를 출력, 정수가 없는 경우에는 -1 출력
 * size : 큐에 들어있는 정수의 개수 출력
 * empty : 큐가 비어있으면 1, 아니면 0 출력
 * front : 큐의 가장 앞에 있는 정수 출력, 정수가 없는 경우에는 -1 출력
 * back : 큐의 가장 뒤에 있는 정수 출력, 정수가 없는 경우에는 -1 출력
 * @author sooki
 *
 */
public class sooki_10845 {
    private int front =0;   // 큐 삭제위치
    private int rear = 0;   // 큐 삽입위치
    private int count = 0;  // 원소 수
    private int size = 5;   //배열 크기
    private int increment = 10;
    private Object[] item = new Object[size];

    public boolean empty()
    {
        return (count==0);
    }

    public void increaseArr()
    {
        size += increment;
        Object[] tempArr = new Object[size];
        for (int i = 0; i < rear; i++)
            tempArr[i] = item[i];
        item = tempArr;
    }

    public void push(Object x)
    {
        item[rear] = x;
        rear++;
        if (rear == size)
            increaseArr();
        count++;
    }

    public void pop()
    {
        if (empty())
            System.out.println(-1);
        else
        {
            System.out.println(item[0]);
            for (int i = 0; i < count; i++)
                item[i] = item[i+1];
            count--;
            rear--;
        }
    }

    public void size()
    {
        System.out.println(count);
    }

    public void front()
    {
        if (empty())
            System.out.println(-1);
        else
            System.out.println(item[0]);
    }

    public void back()
    {
        if (empty())
            System.out.println(-1);
        else
            System.out.println(item[rear-1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sooki_10845 que = new sooki_10845();
        String[] command = new String[2];
        for (int i = 0; i <= n; i++) {
            command = sc.nextLine().split(" ");

            switch (command[0]) {
                case "push":
                    que.push(command[1]);
                    break;
                case "pop":
                    que.pop();
                    break;
                case "size":
                    que.size();
                    break;
                case "empty":
                    if (que.empty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    que.front();
                    break;
                case "back":
                    que.back();
                    break;

                default:
                    break;
            }
        }

    }

}
