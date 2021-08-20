import org.junit.Assert;
import org.junit.Test;

public class KthMaxTest {

    @Test
    public void KthMaxTest() {
        int[] arr = {6, 4, 5, 9, 101, 0, 99, 2, 4, 6};
        int K = 2;
        Assert.assertEquals(99, KthMax.KthMax(arr, K));
        K = 1;
        Assert.assertEquals(101, KthMax.KthMax(arr, K));
        K = 10;
        Assert.assertEquals(0, KthMax.KthMax(arr, K));

    }

    @Test
    public void forEachTest() {
        int[] arr = {};
        for(int i: arr) {
            System.out.println(i);
        }
    }

}
