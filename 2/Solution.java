/**
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode head = null;
        int      lv  = 0;
        int      rv  = 0;
        int      mv  = 0;
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }
            if (l1 != null) {
                lv = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                rv = l2.val;
                l2 = l2.next;
            }
            int sm = lv + rv + mv;
            if (sm >= 10) {
                mv = 1;
                sm = sm % 10;
            } else {
                mv = 0;
            }
            ListNode current = new ListNode(sm);
            if (sum != null) {
                sum.next = current;
            } else {
                head = current;
            }
            sum = current;
            lv = rv = 0;
        }
        if (mv > 0) {
            sum.next = new ListNode(1);
        }
        return head;
    }

    public static void main(String[] argv) {
        System.out.println(nodetonum(numtonode(708)));
        ListNode sum = new Solution().addTwoNumbers(numtonode(5), numtonode(5));
        System.out.println(nodetonum(sum));
    }

    public static class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode numtonode(int num) {
        ListNode n     = new ListNode(0);
        ListNode first = n;
        while (num > 0) {
            n.val = num % 10;
            num = num / 10;
            ListNode next = new ListNode(0);
            n.next = next;
            n = next;
        }
        return first;
    }

    public static int nodetonum(ListNode node) {
        int num = 0;
        int lv = 0;
        while (node != null) {
            int nv = node.val;
            for (int i = 0; i < lv ; i++) {
                nv *= 10;
            }
            num += nv;
            node = node.next;
            lv++;
        }
        return num;
    }

}

