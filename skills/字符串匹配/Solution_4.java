package string;

/**
 * 字符串匹配算法
 * BM算法，时间复杂度O(n)
 */

public class Solution_4 {
    // ASCII表中的256个字符
    private final static int ASIZE = 256;

    public int strStr(String haystack, String needle) {
        return bmSearch(haystack, needle);
    }

    private int bmSearch(String haystack, String needle) {
        int i, j = 0;
        int bmBc[] = preBmBc(needle);

        while (j <= haystack.length() - needle.length()) {
            for (i = needle.length() - 1; i >= 0 && haystack.charAt(i + j) == needle.charAt(i); i--) ;
            if (i < 0)
                return j;
            else
                j++;
        }

        return -1;
    }

    // 构建坏字符表
    private int[] preBmBc(String needle) {
        int bmBc[] = new int[ASIZE];
        int length = needle.length();

        for (int i = 0; i < ASIZE; i++)
            bmBc[i] = length;

        for (int i = 0; i < length; i++)
            bmBc[needle.charAt(i)] = length - 1 - i;

        return bmBc;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_4().strStr("", ""));
    }
}
