//UVa 10194
import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br =
                            new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    for(int i=0; i< cases ; i++) {
      String title = br.readLine();
      int n = Integer.parseInt(br.readLine());
      Team[] teams = new Team[n];
      for(int j=0; j< n ; j++) {
        teams[j] = new Team(br.readLine());
      }
      Arrays.sort(teams);
      int games = Integer.parseInt(br.readLine());
      for(int j=0; j< games ; j++) {
        String[] game = br.readLine().split("@");
        String[] team1 = game[0].split("#");
        String[] team2 = game[1].split("#");
        int team1_s = Integer.parseInt(team1[1]);
        int team2_s = Integer.parseInt(team2[0]);
        
        teams[Arrays.binarySearch(teams, new Team(team1[0]))].play(team1_s, team2_s);
        teams[Arrays.binarySearch(teams, new Team(team2[1]))].play(team2_s, team1_s);
      }

      Arrays.sort(teams, new Comparator<Team>() {
        public int compare(Team t1, Team t2) {
          if(t2.points - t1.points != 0) {
            return t2.points - t1.points;
          } else if (t2.wins - t1.wins != 0) {
            return t2.wins - t1.wins;
          } else if (t2.diff() - t1.diff() != 0) {
            return t2.diff() - t1.diff();
          } else if (t2.scored - t1.scored != 0) {
            return t2.scored - t1.scored;
          } else if (t1.games - t2.games != 0) {
            return t1.games - t2.games;
          } else {
            return t1.name.compareToIgnoreCase(t2.name);
          }
        }
      });
      int rank = 1;
      System.out.println(title);
      for(Team t : teams) {
        System.out.printf("%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)\n", rank, t.name, t.points, t.games, t.wins, t.ties, t.losses, t.diff(), t.scored, t.against);
        rank++;
      }
      if (i+1 < cases) {
        System.out.println();
      }
    }
  }
  
}

class Team implements Comparable<Team> {
    public String name;
    public int games;
    public int points;
    public int wins;
    public int losses;
    public int ties;
    public int scored;
    public int against;

    public Team(String name){
      this.name = name;
      this.games = 0;
      this.points = 0;
      this.wins = 0;
      this.scored = 0;
      this.against = 0;
      this.losses = 0;
      this.ties = 0;
    }

    public void play(int scored, int against) {
      if(scored > against) {
        this.win(scored, against);
      } else if (scored < against) {
        this.loss(scored, against);
      } else {
        this.tie(scored, against);
      }
    }

    public void win(int scored, int against) {
      this.points += 3;
      this.games++;
      this.wins++;
      this.scored += scored;
      this.against += against;
    }
    public void tie(int scored, int against) {
      this.points += 1;
      this.games++;
      this.scored += scored;
      this.against += against;
      this.ties++;
    }
    public void loss(int scored, int against) {
      this.games++;
      this.losses++;
      this.scored += scored;
      this.against += against;
    }
    public int diff() {
      return this.scored - this.against;
    }

    public int compareTo(Team b) {
      return this.name.compareTo(b.name);
    }
  }

