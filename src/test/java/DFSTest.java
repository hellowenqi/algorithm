import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DFSTest {

    @Test
    public void dfsTest() {
        DFS dfs = new DFS(6);
        dfs.add(1, 2);
        dfs.add(1, 4);
        dfs.add(2, 3);
        dfs.add(2, 5);
        dfs.add(3, 5);
        dfs.add(4, 3);
        dfs.add(4, 6);

        List<Integer> list1 = dfs.dfs(1, 5);
        assertArrayEqual(new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(5);
        }}, list1);
        list1 = dfs.dfs(4, 5);
        assertArrayEqual(new ArrayList<Integer>(){{
            add(4);
            add(3);
            add(5);
        }}, list1);
        list1 = dfs.dfs(4, 1);
        Assert.assertEquals(0, list1.size());
    }

    public void assertArrayEqual(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            Assert.fail();
        }

        for (int i = 0; i < list1.size(); i++){
            Assert.assertEquals(list1.get(i), list2.get(i));
        }
    }
}
