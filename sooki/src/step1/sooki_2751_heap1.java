package step1;

import java.util.Scanner;

/**
 * 백준 2750 수 정렬하기
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오
 *
 */
public class sooki_2751_heap1 {
    public static void heap(int[] data, int number){
        for (int i=1; i<number; i++){
            int child = i;
            while(child>0){
                int parent = (child-1)/2;
                if (data[child] >data[parent]){
                    int temp = data[parent];
                    data[parent] = data[child];
                    data[child] = temp;
                }
                child = parent;
            }
        }
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nArr = new int [n];
        for (int i = 0 ; i < n ; i++)
            nArr[i] = sc.nextInt();

        System.out.print("정렬 전 : ");
        for (int i = 0; i < n; i++){
            System.out.print(nArr[i] + " ");
        }

        heap(nArr,n);

        for(int i = n-1;i>0;i--){
            int temp = nArr[0];
            nArr[0] = nArr[i];
            nArr[i] = temp;

            heap(nArr,i);
        }
        System.out.print("\n정렬 후 : ");
        for (int i = 0; i < n; i++){
            System.out.print(nArr[i] + " ");
        }

/*        for (int i = 0 ; i < n ; i++)
        {
            System.out.println(nArr[i]);
        }*/
    }
}
