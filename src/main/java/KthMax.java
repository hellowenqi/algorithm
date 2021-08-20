/**
 * 第K大的
 *
 * @author wuwenqi04
 * @classname：KthMax
 * @date 2021/08/09
 */
public class KthMax {
    public static void main(String[] args) {
    }

    public static int KthMax (int arr[], int K) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int pos = pos(arr, start, end);
            if (pos + 1 == K) {
                return arr[pos];
            } else if (pos + 1 < K) {
                start = pos + 1;
            } else {
                end = pos - 1;
            }
        }
        throw new IllegalArgumentException("未找到");
    }
    private static int pos(int arr[], int start, int end) {
        int i = start, j = start + 1;
        int ref = arr[start];
        while(j <= end) {
            if(arr[j] > ref) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
            j++;
        }
        return i;
    }
}
