//UVa 11034
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = 
                            new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    for(int i = 0; i < cases; i++) {
      String[] input = br.readLine().split(" ");
      int l = Integer.parseInt(input[0]) * 100;
      int cars = Integer.parseInt(input[1]); 
      LinkedList<Integer> left = new LinkedList<Integer>();
      LinkedList<Integer> right = new LinkedList<Integer>();
      LinkedList<Integer> current;
      for(int j = 0; j < cars; j++) {
        input = br.readLine().split(" ");

        if(input[1].equals("left")) {
          left.offer(Integer.parseInt(input[0]));
        } else {
          right.offer(Integer.parseInt(input[0]));
        } 
      }
      int count = 0;
      int aboard;
      while(!(left.isEmpty() && right.isEmpty())) {
        count++;
        aboard = 0;
        if (count % 2 == 1) {
          current = left;
        } else {
          current = right;
        }
        while(!current.isEmpty() && aboard + current.peek() < l) {
          aboard+= current.poll();
        }
      }
      System.out.println(count);
     
    }
  }
}
