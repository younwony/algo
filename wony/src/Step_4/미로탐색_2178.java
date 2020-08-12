package Step_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색_2178 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] xy = bufferedReader.readLine().split(" ");
        int x = Integer.valueOf(xy[0]);
        int y = Integer.valueOf(xy[1]);

        char[][] field = new char[x][y];

        for(int i = 0; i < x; i++){
            field[i] = bufferedReader.readLine().toCharArray();
        }

        Queue<point> queue = new LinkedList<>();

        queue.offer(new point(0, 0, 1));
        field[0][0] = '0';

        int result = 1;

        int pointX, pointY, pointCount;

        while(!queue.isEmpty()){
            point point = queue.poll();
            pointX = point.x;
            pointY = point.y;
            pointCount = point.count;

            if(pointX == x-1 && pointY == y-1){
                result = pointCount;
                break;
            }

            if(pointX - 1 >= 0)
                if(field[pointX - 1][pointY] == '1'){
                    queue.offer(new point(pointX - 1, pointY, pointCount + 1));
                    field[pointX - 1][pointY] = '0';
                }
            if(pointY - 1 >= 0)
                if(field[pointX][pointY - 1] == '1'){
                    queue.offer(new point(pointX, pointY - 1, pointCount + 1));
                    field[pointX][pointY - 1] = '0';
                }
            if(pointX + 1 < x)
                if(field[pointX + 1][pointY] == '1'){
                    queue.offer(new point(pointX + 1, pointY, pointCount + 1));
                    field[pointX + 1][pointY] = '0';
                }
            if(pointY + 1 < y)
                if(field[pointX][pointY + 1] == '1'){
                    queue.offer(new point(pointX, pointY + 1, pointCount + 1));
                    field[pointX][pointY + 1] = '0';
                }

        }

        System.out.println(result);
    }

    static class point{
        int x;
        int y;
        int count;

        public point(int x, int y, int count) {
            super();
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
