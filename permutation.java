//UVa 482
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = 
                            new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int cases = Integer.parseInt(line);

    for(int i=0; i< cases; i++) {
      br.readLine();
      String[] index = br.readLine().split(" ");
      String[] values = br.readLine().split(" ");
      Pair[] list = new Pair[index.length];
      for(int j=0; j < index.length ; j++) {
        list[j] = new Pair(index[j], values[j]);
      }
      Arrays.sort(list);
      for (Pair p : list) {
        System.out.println(p.value);
      }
      if (i+1 < cases) {
        System.out.println();
      }
    }
  }
}
  class Pair implements Comparable<Pair> {
    public String x;
    public String value;
    public Pair(String x, String v) {
      this.x = x;
      this.value = v;
    }

    public int compareTo(Pair p2) {
      int x1 = Integer.parseInt(this.x);
      int x2 = Integer.parseInt(p2.x);

      return x1  - x2;
    }

  }
