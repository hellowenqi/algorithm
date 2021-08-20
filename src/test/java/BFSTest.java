import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BFSTest {

    @Test
    public void bfsTest() {
        BFS bfs = new BFS(6);
        bfs.add(1, 2);
        bfs.add(1, 4);
        bfs.add(2, 3);
        bfs.add(2, 5);
        bfs.add(3, 5);
        bfs.add(4, 3);
        bfs.add(4, 6);

        List<Integer> list1 = bfs.bfs(1, 5);
        assertArrayEqual(new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(5);
        }}, list1);
        list1 = bfs.bfs(4, 5);
        assertArrayEqual(new ArrayList<Integer>(){{
            add(4);
            add(3);
            add(5);
        }}, list1);
        list1 = bfs.bfs(4, 1);
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
