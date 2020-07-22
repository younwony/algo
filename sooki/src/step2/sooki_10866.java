package step2;

import java.util.Scanner;

/**
 * 10866 덱
 * 명령은 총 여덟가지
 * push_front x : 정수 x를 덱 앞에 넣는다
 * push_back x : 정수 x를 덱 뒤에 넣는다
 * pop_front : 덱의 가장 앞에 있는 수를 빼고 그 수를 출력, 만약 값이 없으면 -1 출력			--출력
 * pop_back : 덱의 맨 뒤에 있는 수를 빼고 그 수를 출력, 만약 값이 없으면 -1 출력			--출력
 * size : 덱에 들어있는 정수의 개수 출력 										--출력
 * empty : 덱이 비어있으면 1, 아니면 0 출력									--출력
 * front : 덱의 가장 앞에있는 정수 출력, 만약 값이 없으면 -1 출력						--출력
 * back : 덱의 맨 위에 있는 정수 출력, 만약 값이 없으면 -1 출력						--출력
 * @author sooki
 *
 */
public class sooki_10866 {
    private int front =0;   // 덱 삭제위치
    private int rear = 0;   // 덱 삽입위치
    private int count = 0;  // 덱 원소수
    private int size = 5;
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

    public void pushBack(Object x)
    {
        item[rear] = x;
        rear++;
        if (rear == size)
            increaseArr();
        count++;
    }

    public void pushFront(Object x)
    {
        if (count != 0)
            for (int i = count; i>0; i--)
                item[i] = item[i-1];
        item[0] = x;
        count++;
        rear = count;
        if (rear == size)
            increaseArr();
    }

    public void popFront()
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

    public void popBack()
    {
        if (empty())
            System.out.println(-1);
        else
        {
            System.out.println(item[count-1]);
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
        sooki_10866 deque = new sooki_10866();
        String[] command = new String[2];
        for (int i = 0; i <= n; i++) {
            command = sc.nextLine().split(" ");

            switch (command[0]) {
                case "push_front":
                    deque.pushFront(command[1]);
                    break;
                case "push_back":
                    deque.pushBack(command[1]);
                    break;
                case "pop_front":
                    deque.popFront();
                    break;
                case "pop_back":
                    deque.popBack();
                    break;
                case "size":
                    deque.size();
                    break;
                case "empty":
                    if (deque.empty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    deque.front();
                    break;
                case "back":
                    deque.back();
                    break;

                default:
                    break;
            }
        }

    }

}
