import java.util.*;


public class WordLadder {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        Set<String> test = new HashSet<>();
        test.add("hot");
        test.add("dot");
        test.add("dog");
        test.add("lot");
        test.add("log");
        System.out.println(ladderLength(begin, end, test));
        String s = "hot";
        String e = "dog";
        Set<String> test2 = new HashSet<>();
        test2.add("hot");
        test2.add("dog");
        test2.add("dot");
        System.out.println(ladderLength(s, e, test2));
    }

    /**
     * 利用bfs的idea，每次将一个单词的所有变形放入一个list，然后判断改list的单词是否是endword
     * 如果不是，则将这个list的单词全部重新放入queue, 进入下一层
     */
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> visit = new HashSet<>();
        if (wordList.size() == 0) return -1;
        if (beginWord.equals(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visit.add(beginWord);
        int len = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                String next = queue.poll();
                for (int j = 0; j < next.length(); j++) {
                    char[] temp = next.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        temp[j] = k;
                        String newWord = new String(temp);
                        if (newWord.equals(endWord)) return len;
                        if (wordList.contains(newWord) && !visit.contains(newWord)) {
                            queue.offer(newWord);
                            visit.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;


       /* // Use queue to help BFS
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);

        // Mark visited word
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;
        while (!queue.isEmpty()) {
            String prevWord = queue.poll();
            if (prevWord != null) {
                // Modify prevWord's each character (so word distance is 1)
                for (int i = 0; i < prevWord.length(); i++) {
                    char[] chars = prevWord.toCharArray();
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
        return 0;*/
        
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
        int n = wordList.size() + 2;//including the begin and end word
        String[] list = new String[n];
        list[0] = beginWord;
        list[n - 1] = endWord;
        int k = 1;
        for (String s : wordList) {
            list[k] = s;
            k++;
        }
        return list;
    }

    private static int[][] getAdjacentMatrix(String beginWord, String endWord, Set<String> wordList) {
        int n = wordList.size() + 2;
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
     *
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
    public static void printSolution(String[] A, int n) {
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }

    //print two D array
    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j != A.length - 1)
                    System.out.print(A[i][j] + ", ");
                else
                    System.out.print(A[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
