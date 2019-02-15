public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            throw new IllegalArgumentException("haystack is null");
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle == null || needle.length() == 0 ) return 0;
        char[] hcs = haystack.toCharArray();
        char[] ncs = needle.toCharArray();
        char nf = ncs[0];
        for (int hi = 0; hi < hcs.length; hi++) {
            char hc = hcs[hi];
            if (hc == nf) {
                int ni = 1;
                for (; ni < ncs.length && hi + ni < hcs.length; ni++) {
                    if (ncs[ni] != hcs[hi + ni]) {
                        break;
                    }
                }
                if (ni == ncs.length) {
                    return hi;
                }
            }
            if (hcs.length - hi < ncs.length) {
                break;
            }
        }
        return -1;
    }

    public static void main (String[] argv) {
        int idx = new Solution().strStr("hello", "ll");
        System.out.println(idx);
        idx = new Solution().strStr("aaa", "a");
        System.out.println(idx);
        idx = new Solution().strStr("mississippi", "issip");
        System.out.println(idx);
        idx = new Solution().strStr("mississippi", "issipi");
        System.out.println(idx);

    }
}