import java.util.*;

/**
 * TODO
 *
 * @author wuwenqi04
 * @classname：BFS
 * @date 2021/08/16
 */
public class BFS {
    private ArrayList<Integer>[] heads;
    public BFS(int length) {
        heads = new ArrayList[length + 1];
        for(int i = 0; i < heads.length; i++) {
            heads[i] = new ArrayList<Integer>();
        }
    }

    public void add (int start, int end) {
        heads[start].add(end);
    }

    public List<Integer> bfs(int start, int end) {
        if (heads == null || heads.length + 1 < end || heads.length + 1 < start) {
            return new ArrayList<Integer>();
        }
        int l = heads.length;
        int[] pre = new int[l];
        boolean[] visited = new boolean[l];
        Arrays.fill(pre, -1);
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        queue.add(start);
        while(queue.size() > 0) {
            Integer i = queue.poll();
            visited[i] = true;
            for (Integer child: heads[i]) {
                if(!visited[child]) {
                    queue.add(child);
                    pre[child] = i;
                }
                if (end == child) {
                    print(res, pre, end);
                    return res;
                }
            }
        }

        return new ArrayList<Integer>();
    }

    private void print(List<Integer> res, int[] pre, int end){
        if(pre[end] != -1) {
            print(res, pre, pre[end]);
        }

        res.add(end);
    }
}
