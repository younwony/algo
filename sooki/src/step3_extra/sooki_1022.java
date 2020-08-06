package step3_extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 1022번 소용돌이 예쁘게 출력하기
 * https://www.acmicpc.net/problem/1022
 * 반시계방향으로 소용돌이 채움
 * 입력 : 첫째 줄에 r1, c1, r2, c2가 주어진다.
 * 모두 절댓값이 5000보다 작거나 같은 정수이고, r2-r1은 0보다 크거나 같고, 49보다 작거나 같으며, c2-c1은 0보다 크거나 같고, 4보다 작거나 같다.
 * 출력 : r2-r1+1개의 줄에 소용돌이를 예쁘게 출력한다.
 */
public class sooki_1022 {

    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input =br.readLine();
        String[] arr = input.split(" ");
        int r1 = Integer.parseInt(arr[0]);
        int c1 = Integer.parseInt(arr[1]);
        int r2 = Integer.parseInt(arr[2]);
        int c2 = Integer.parseInt(arr[3]);

        int max = 0;
        if(getValue(r1,c1)>max) max = getValue(r1,c1);
        if(getValue(r1,c2)>max) max = getValue(r1,c2);
        if(getValue(r2,c1)>max) max = getValue(r2,c1);
        if(getValue(r2,c2)>max) max = getValue(r2,c2);

        int size = String.valueOf(max).length();

        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                String p = String.valueOf(getValue(i,j));
                for(int k=0; k<size-p.length(); k++)
                {
                    sb.append(" ");
                }
                sb.append(p);
                if(j!=c2)
                {
                    sb.append(" ");
                }
            }
            if(i!=r2)
            {
                sb.append(System.lineSeparator());
            }
        }

        System.out.println(sb.toString());

        if(br !=  null)
            br.close();
    }

    public static int getValue(int r, int c){
        int rtn = 0;
        if(c<0 && -c>=-r && -c>r){//b
            int base = 4*(-c)*(-c)+1;
            int gap = -c+r;
            rtn = base+gap;
        }
        else if(r>=0 && r>=-c && r>=c){//d
            int base = 4*r*r+2*r+1;
            int gap = r+c;
            rtn = base+gap;
        }
        else if(c>0 && c>r && c>-r){//c
            int base = 4*(c)*(c)-4*c+2;
            int gap = c-r-1;
            rtn = base+gap;
        }
        else if(r<0 && -r>=c && -r>-c){//a
            int base = 4*(-r)*(-r)-2*(-r)+1;
            int gap = -r-c;
            rtn = base+gap;
        }

        return rtn;
    }
}
