import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BMTest {

    @Test
    void bmSort() {
        for(int i = 0; i < 100000; i++) {
            String s = getRandomString(20);
            Random random=new Random();
            int number=random.nextInt(5);
            String pattern  = getRandomString(6);
            int a = BM.bmSort(s, pattern);
            if (a > -1) {
                System.out.println(String.format("%s %s, %d", s, pattern, a));
            }
            Assert.assertEquals(s.indexOf(pattern), a);
//            break;
        }

    }

    @Test
    void bmSort1() {
        String s = "abdabcdefabcabc";
        String pattern  = "abcabc";
        int a = BM.bmSort(s, pattern);

        Assert.assertEquals(s.indexOf(pattern), a);

    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyz";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(26);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
