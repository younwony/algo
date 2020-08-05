package Step_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 단어정렬_1181 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.valueOf(bufferedReader.readLine());
            Set<String> set = new HashSet<>();
            for(int i = 0; i < n; i++){
                set.add(bufferedReader.readLine());
            }
            ArrayList<word> wordList = new ArrayList<>();
            for(String setStr : set){
                wordList.add(new word(setStr));
            }

            Collections.sort(wordList, new word());

            StringBuilder result = new StringBuilder();

            for(word word : wordList){
                result.append(word.str + "\n");
            }

            System.out.println(result.toString());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null){ bufferedReader.close();}
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public static class word implements Comparator<word> {
        String str;

        public word() {
        }

        public word(String str) {
            this.str = str;
        }

        @Override
        public int compare(word o1, word o2) {
            if(o1.str.length() < o2.str.length()){
                return -1;
            }else if(o1.str.length() > o2.str.length()){
                return 1;
            }else{
                return o1.str.compareTo(o2.str);
            }
        }
    }
}
