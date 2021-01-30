import java.util.HashMap;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FordFulkerson;

public class BaseballElimination {
    private final int numberOfTeams;
    // teamname - int of {index, wins, loose, remaining}
    private final HashMap<String, Integer[]> teams;
    private final HashMap<Integer, String> teamNumbers;
    private final int[][] againstTeam;
    private Bag<String> subset;
    private final int[] wins;
    
    public BaseballElimination(String filename) {                   // create a baseball division from given filename in format specified below
       In in = new In(filename);
       numberOfTeams = in.readInt();
       teams = new HashMap<>();
       teamNumbers = new HashMap<>();
       againstTeam = new int[numberOfTeams][numberOfTeams];
       wins = new int[numberOfTeams];
       
       // read team name, number, wins, losses, and remaining to hashmap
       int index = 0;
       while(!in.isEmpty()) {
           String teamNm = in.readString();
           int wns = in.readInt();
           int loss = in.readInt();
           int remains = in.readInt();
           
           teams.put(teamNm, new Integer[] {index, wns, loss, remains});
           wins[index] = wns;
           teamNumbers.put(index, teamNm);
           
           for (int j = 0; j < numberOfTeams; j++)
               againstTeam[index][j] = in.readInt();
           index++;
       }
    }
    
    private void validTeam(String teamName) {
        if (!teams.containsKey(teamName))
            throw new IllegalArgumentException("Invalid team name...");
    }

    public int numberOfTeams() {                       // number of teams
       return numberOfTeams;
    }

    public Iterable<String> teams() {                               // all teams
       return teams.keySet();
    }

    public int wins(String team) {                      // number of wins for given team
       validTeam(team);
       return teams.get(team)[1];
    }

    public  int losses(String team) {                   // number of losses for given team
       validTeam(team);
       return teams.get(team)[2];
    }

    public int remaining(String team) {                // number of remaining games for given team
       validTeam(team);
       return teams.get(team)[3];
    }

    public int against(String team1, String team2) {    // number of remaining games between team1 and team2
       validTeam(team1);
       validTeam(team2);
       return againstTeam[teams.get(team1)[0]][teams.get(team2)[0]];
    }

    public boolean isEliminated(String team) {             // is given team eliminated?
       validTeam(team);
       subset = new Bag<>();
       for (String tm : teams.keySet()) {
           if (wins(team) + remaining(team) < wins(tm)) {
               subset.add(tm);
               return true;
           }
       }
       return nontrivialCheck(team);
    }

    private boolean nontrivialCheck(String team) {
        int frstLayer = ((numberOfTeams - 1) * (numberOfTeams - 2) /2 );
        int ttlSZ = numberOfTeams + frstLayer + 1; // src(ttlSZ -2 ) + n(n-1)/2 + teams + sink(ttlSZ-1)
        int teamNumber = teams.get(team)[0];
        FlowNetwork network = new FlowNetwork(ttlSZ);
        
        // adding edges
        int sum = 0; // value of network
        
        int x = 0; int y = 0; int z = 0;
        int secondLayerteamA = 0;
        int srcIdx = ttlSZ - 2;
        int destIdx = ttlSZ - 1;
        String[] networkTeams = new String[numberOfTeams - 1]; // maintaining subset than will make current team lose

        for (int i = 0; i < numberOfTeams; i++) {
            if (i != teamNumber) {
                for (int j = 0; j < numberOfTeams; j++) { // first layer after src
                    if (j != teamNumber && j > i) {
                        network.addEdge(new FlowEdge(srcIdx, x, againstTeam[i][j])); // src to firstLayer
                        sum += againstTeam[i][j];
                        
                        secondLayerteamA = ttlSZ - 1 - numberOfTeams + y; //  count from last using y
                        int secondLayerteamB = ttlSZ - numberOfTeams + z; //  ttlSZ - numberOfTeams complete src and firstLayer Nodes

                        network.addEdge(new FlowEdge(x, secondLayerteamA, Double.POSITIVE_INFINITY)); // firstLeyr to second layer
                        network.addEdge(new FlowEdge(x, secondLayerteamB, Double.POSITIVE_INFINITY)); // firstLeyr to second layer
                        x++; z++;
                    }                    
                }
                
                int weight = wins(team) + remaining(team) - wins[i];
                network.addEdge(new FlowEdge(secondLayerteamA, destIdx, weight)); // second layer to sink
                networkTeams[y] = teamNumbers.get(i);
                
                y++; z = y;                
            }
        }


        FordFulkerson ff = new FordFulkerson(network, ttlSZ - 2, ttlSZ - 1);        
        if (sum == ff.value()) return false; // means there is capacity to flow i.e. other team can win
        else {
            for (int v = frstLayer; v < ttlSZ - 2; v++) {
                if (ff.inCut(v)) {                    
                    subset.add(networkTeams[v - frstLayer]);          
                }
            }
            return true;
        }
    }

    public Iterable<String> certificateOfElimination(String team) { // subset R of teams that eliminates given team; null if not eliminated
      validTeam(team);
      if (isEliminated(team))
          return subset;
      return null;
    }

}