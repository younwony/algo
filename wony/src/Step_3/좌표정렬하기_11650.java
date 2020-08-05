package Step_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 좌표정렬하기_11650 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.valueOf(bufferedReader.readLine());

            ArrayList<point> pointList = new ArrayList<>();

            String[] str;
            for(int i = 0; i < n; i++){
                str = bufferedReader.readLine().split(" ");
                pointList.add(new point(Integer.valueOf(str[0]), Integer.valueOf(str[1])));
            }

            Collections.sort(pointList, new point());

            StringBuilder result = new StringBuilder();

            for(point point : pointList){
                result.append(point.x + " " + point.y + "\n");
            }

            System.out.println(result.toString());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }


    }

    public static class point implements Comparator<point> {
        int x;
        int y;

        public point() {
        }

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compare(point o1, point o2) {
            if(o1.x < o2.x){
                return -1;
            }else if(o1.x > o2.x){
                return 1;
            }else{
                return o1.y - o2.y;
            }
        }
    }
}
