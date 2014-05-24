//UVa 514
import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = 
                            new BufferedReader(new InputStreamReader(System.in));
    //int l = Integer.parseInt(br.readLine());
    int l;
    while(Integer.parseInt(br.readLine()) != 0) {
      while(true){
        String[] targetS = br.readLine().split(" ");
        int[] target = new int[targetS.length];
        for(int i=0; i < targetS.length; i++) {
          target[i] = Integer.parseInt(targetS[i]);
        }

        if (target[0] == 0) {
          break;
        }
        Stack<Integer> station = new Stack<Integer>();
        int targetIndex = 0;
        for(int current=1; current <= target.length; current++) {
          station.push(current);
          while(!station.empty() && station.peek() == target[targetIndex] && 
              targetIndex <= target.length) {
            station.pop();
            targetIndex++;
          }
        }
        if(station.empty()) {
          System.out.println("Yes");
        } else {
          System.out.println("No");
        }
      }
      System.out.println();
    }
  }
}
