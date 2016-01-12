import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class WordLadder {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String begin = "hit";
        String end = "cog";
        Set<String> test = new HashSet<>();
        test.add("hot");
        test.add("dot");
        test.add("dog");
        test.add("lot");
        test.add("log");
        int res = ladderLength(begin, end, test);
        System.out.println(res);
        String s = "a";
        String e = "c";
        Set<String> test2 = new HashSet<>();
        test.add("b");
        System.out.println(ladderLength(s, e, test2));
    }
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // Use queue to help BFS
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);

        // Mark visited word
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
          String str = queue.poll();

          if (str != null) {
            // Modify str's each character (so word distance is 1)
            for (int i = 0; i < str.length(); i++) {
              char[] chars = str.toCharArray();

              for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;

                String word = new String(chars);

                // Found the end word
                if (word.equals(endWord)) return level + 1;

                // Put it to the queue
                if (wordList.contains(word) && !visited.contains(word)) {
                  queue.add(word);
                  visited.add(word);
                }
              }
            }
          } else {
            level++;

            if (!queue.isEmpty()) { 
              queue.add(null);
            }
          }
        }

        return 0;
        
        /*
        // method 2: dijkstra search, using adjacent matrix, O(n^2)
        int n = wordList.size()+2;//including the begin and end word
        int[] dist = new int[n];//store the distance from src to i
        boolean[] reached = new boolean[n];//store whether the node has been reached or not
        int [][] graph = getAdjacentMatrix(beginWord, endWord, wordList);
        
        String[] list = getSource(beginWord, endWord, wordList);
        //printSolution(list, n);
        //printSolution(dist, n);
        //printArray(graph);
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            reached[i] = false;
        }
        dist[0] = 0;
        for (int i = 0; i < n-1; i++) {
            int u = getNextMove(dist, reached);
            reached[u] = true;
            for (int j = 0; j < n; j++) {
                if (!reached[j] && graph[u][j] > 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][j] < dist[j]) {
                    dist[j] = dist[u] + graph[u][j];
                }
            }
        }
        //printSolution(dist, n);
        for (int i = 0; i < n; i++) {
            if (list[i].equals(endWord)) {
                return dist[i]+1;
            }
        }
        return 0;
        */
    }
    private static String[] getSource(String beginWord, String endWord, Set<String> wordList) {
        int n = wordList.size()+2;//including the begin and end word      
        String[] list = new String[n];
        list[0] = beginWord;
        list[n-1] = endWord;
        int k = 1;
        for (String s : wordList) {
            list[k] = s;
            k++;
        }
        return list;
    }
    private static int[][] getAdjacentMatrix(String beginWord, String endWord, Set<String> wordList) {
        int n = wordList.size()+2;
        String[] list = getSource(beginWord, endWord, wordList);
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isOneMove(list[i], list[j])) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
    /**
     * get the index of next string with one change of character
     * @param st string list
     * @param u target string
     * @param reached 
     * @return
     */
    private static int getNextMove(int[] dist, boolean[] reached) {
        int min = Integer.MAX_VALUE, minIndex = 0;
        for (int i = 0; i < dist.length; i++) {
            if (!reached[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    /**
     * check whether a and b are only one move away
     * @param a string a
     * @param b string b
     * @return true or false
     */
    private static boolean isOneMove(String a, String b) {
        if (a.length() != b.length()) return false;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        if (count == 1) return true;
        else return false;
    }
    private static void printSolution(int[] dist, int n) {
        System.out.printf("Vertex   Distance from Source\n");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d \t\t %d\n", i, dist[i]);
        }
    }
    //print array
    public static void printSolution(String[] A, int n)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(i != A.length-1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
    //print two D array
    public static void printArray(int[][] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A.length; j++) {
                if(j != A.length-1)
                    System.out.print(A[i][j] + ", ");
                else
                    System.out.print(A[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
