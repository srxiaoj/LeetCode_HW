public class DFS
{
    /**
     * http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Graph/dfs.html
     * @param args
     */
   public static void main(String[] args)
   {
//            0  1  2  3  4  5  6  7  8
// ===================================================
      int[][] conn = 
         {  { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
            { 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
            { 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
            { 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
            { 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
            { 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
            { 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
            { 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
            { 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8


      Graph G = new Graph(conn);

      G.clearVisited();
//      G.dfs(0);
      // iterative method
      G.dfs();
   }
}