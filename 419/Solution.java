/**
 */
public class Solution {

    public int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return 0;

        int      h    = board.length;
        int      w    = board[0].length;
        char[][] copy = new char[h][w];

        System.arraycopy(board, 0, copy, 0, h);

        char nil   = 0;
        int  count = 0;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                char c = copy[y][x];
                char r = x < w - 1 ? copy[y][x + 1] : nil;
                char b = y < h - 1 ? copy[y + 1][x] : nil;
                char l = x > 0 ? copy[y][x - 1] : '?';
                if (c == 'X' || c == 'x') {
                    if ((r == 'X' || r == 'x' || l == 'x' || l == 'X') && b == 'X') {
                        return -1;
                    }
                    if (r == 'X') {
                        copy[y][x + 1] = 'x';
                    }
                    if (b == 'X') {
                        copy[y + 1][x] = 'x';
                    }
                    if (c == 'X') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] argv) {
        String b = "X..X\n...X\n...X";
        b = "...X\nXXXX\n...X";
        String[] s     = b.split("\n");
        char[][] board = new char[s.length][];
        for (int i = 0; i < board.length; i++) {
            board[i] = s[i].toCharArray();
        }
        int c = new Solution().countBattleships(board);
        System.out.println(c);
    }
}

