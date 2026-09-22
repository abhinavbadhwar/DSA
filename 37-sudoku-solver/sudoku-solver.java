class Solution {
    public void solveSudoku(char[][] b) {
        solve(b);
    }

    boolean solve(char[][] b) {
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                if (b[r][c] == '.') {
                    for (char n = '1'; n <= '9'; n++) {
                        if (valid(b, r, c, n)) {
                            b[r][c] = n;
                            if (solve(b)) return true;
                            b[r][c] = '.';
                        }
                    }
                    return false;
                }
        return true;
    }

    boolean valid(char[][] b, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            if (b[r][i] == n || b[i][c] == n ||
                b[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == n)
                return false;
        }
        return true;
    }
}