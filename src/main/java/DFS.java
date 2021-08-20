import java.util.*;

/**
 * TODO
 *
 * @author wuwenqi04
 * @classname：BFS
 * @date 2021/08/16
 */
public class DFS {
    private ArrayList<Integer>[] heads;
    public DFS(int length) {
        heads = new ArrayList[length + 1];
        for(int i = 0; i < heads.length; i++) {
            heads[i] = new ArrayList<Integer>();
        }
    }

    public void add (int start, int end) {
        heads[start].add(end);
    }

    public List<Integer> dfs(int start, int end) {
       boolean[] visited = new boolean[heads.length];
       Arrays.fill(visited, false);
       int[] pre = new int[heads.length];
       Arrays.fill(pre, -1);
       List<Integer> res = new ArrayList<Integer>();
       if (bfsRecursive(start, end, pre, visited)) {
           print(res, pre, end);
       }
       return res;
    }

    private boolean bfsRecursive(int start, int end, int[] pre, boolean[] visited) {
        for (Integer i: heads[start]) {
            if (end == i) {
                pre[i] = start;
                return true;
            }
            if(!visited[i]) {
                pre[i] = start;
                visited[i] = true;
                return bfsRecursive(i, end, pre, visited);
            }
        }
        return false;
    }

    private void print(List<Integer> res, int[] pre, int end){
        if (pre[end] != -1) {
            print(res, pre, pre[end]);
        }

        res.add(end);
    }
}
