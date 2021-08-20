import json.JsonUtils;

/**
 * BM 算法，效率是BMP 算法的3-5倍： 坏字符 + 好后缀
 *
 * @author wuwenqi04
 * @classname：BM
 * @date 2021/08/20
 */
public class BM {
    public static int bmSort(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[] bc = new int[256];
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        for(int i = 0; i < 256; i++) {
            bc[i] = -1;
        }
        // TODO 初始化
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        generateBadCharacter(bc, p);
        generateGoodSuffixPrefix(p, prefix, suffix);
/*        System.out.println(String.format("s:%s, pattern: %s\n prefix:%s\nsuffix:%s\nbc:%s",
                s,p,
                JsonUtils.toJsonString(prefix),
                JsonUtils.toJsonString(suffix),
                JsonUtils.toJsonString(bc)
        ));
 */

        int i = 0;
        while (i <= n - m){
            int j = m - 1;
            for (; j >=0 ; j--) {
                if (p.charAt(j) != s.charAt(i+j)) {
                    break;
                }
            }
            if (j < 0) {
                return i;
            }
            // 坏字符
            int x = j - bc[s.charAt(j + i)];
            int y = 0;
            // 好后缀
            if (j < m - 1) {
                y = moveGS(suffix, prefix, m, j);
            }

            i += Math.max(x, y);
        }

        return -1;
    }

    private static void generateBadCharacter(int[] bc, String p) {
        for (int i = 0; i < p.length(); i++) {
            bc[p.charAt(i)] = i;
        }
    }

    private static void generateGoodSuffixPrefix(String p, boolean[] prefix, int[] suffix) {
        int m = p.length();
        for (int i = 1; i <= m - 1 ; i++) { // i 为长度
            for (int j = m - 2; j >= i - 1; j--){  // j 指向子串尾中与p尾开始比较的位置
                int k = 0;
                while(k < i && p.charAt(m - 1 - k) == p.charAt(j - k)) {
                    k++;
                }
                if (k == i) {  // 找到了
                    suffix[i] = j - i + 1;
                    if (j + 1 == i) {
                        prefix[i] = true;
                    }
                    break;
                }
            }
        }
    }

    private static int moveGS(int[] suffix, boolean[] prefix, int m, int j) {
        if (suffix[m - 1 - j] != -1) {
            return j + 1 - suffix[m - 1 - j];
        }
        int r = j + 2;
        while (r <= m - 1) {
            if (prefix[m-r]) {
                return r;
            }
            r++;
        }

        return m;
    }
}
