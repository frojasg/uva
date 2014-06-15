import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line = in.readLine()) != null && line.length() > 0) {
      String[] input = line.split(" ");
      int n = Integer.parseInt(input[0]);
      int goals = Integer.parseInt(input[1]);
      Integer[] matches = new Integer[n];
      for(int i=0; i < n; i++) {
        input = in.readLine().split(" ");
        matches[i] = Integer.parseInt(input[0]) - Integer.parseInt(input[1]);
      }
      Arrays.sort(matches, new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
          return i2 - i1;
        }
      });
      int points = 0;
      for(int i=0; i < n; i++) {
        if(matches[i] <= 0 && goals > 0) {
          int ajust = Math.min(Math.abs(matches[i] - 1), goals);
          matches[i] += ajust;
          goals -= ajust;
        }

        if (matches[i] > 0) {
          points += 3;
        } else if (matches[i] == 0) {
          points += 1;
        }
      }
      System.out.println(points);
    }
   in.close();
   System.exit(0);
 }
}
