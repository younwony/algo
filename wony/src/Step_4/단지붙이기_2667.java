package Step_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 단지붙이기_2667 {

    static char[][] field;
    static boolean[][] visited;
    static int resultCnt;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bufferedReader.readLine());
        field = new char[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            field[i] = bufferedReader.readLine().toCharArray();
        }

        int result = 0;

        ArrayList<Integer> cntList = new ArrayList<>();

        StringBuilder resultStr = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(field[i][j] == '1'){
                    resultCnt = 0;
                    result++;
                    bfs(i,j);
                    cntList.add(resultCnt);
                }
            }
        }
        resultStr.append(result).append("\n");

        Collections.sort(cntList);
        for(int cnt : cntList)
            resultStr.append(cnt).append("\n");

        System.out.println(resultStr.toString());
    }

    public static void bfs(int x, int y){

        if(x < 0 || y < 0 || x >= field.length || y >= field.length) return;
        if(field[x][y] == '0') return;
        resultCnt++;
        field[x][y] = '0';

        bfs(x - 1, y);
        bfs(x + 1, y);
        bfs(x, y - 1);
        bfs(x, y + 1);
    }
}
