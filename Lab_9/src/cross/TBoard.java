package cross;

public class TBoard {
    private int player;
    int[][] table = new int[3][3];

    public TBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                table[i][j] = 0;
        player = 1;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int pl) {
        player = pl;
    }

    public void setTable(int[][] a) {
        table = a;
    }

    public int[][] getTable() {

        return table;
    }

    public int winner() {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == 1 && table[i][1] == 1 &&
                    table[i][2] == 1) ||
                    (table[0][i] == 1 && table[1][i] == 1 &&
                            table[2][i] == 1))
                return 1;
        if ((table[0][0] == 1 && table[1][1] == 1 &&
                table[2][2] == 1) ||
                (table[2][0] == 1 && table[1][1] == 1 &&
                        table[0][2] == 1))
            return 1;
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == 2 && table[i][1] == 2 &&
                    table[i][2] == 2) ||
                    (table[0][i] == 2 && table[1][i] == 2 &&
                            table[2][i] == 2))
                return 1;
        if ((table[0][0] == 2 && table[1][1] == 2 &&
                table[2][2] == 2) ||
                (table[2][0] == 2 && table[1][1] == 2 &&
                        table[0][2] == 2))
            return 1;
        return 0;
    }

    public boolean make_move(int x, int y) {
        if (player == 1) {
            if (table[x][y] == 0)
                table[x][y] = 1;
            else
                return false;
        }
        if (player == 2) {
            if (table[x][y] == 0)
                table[x][y] = 2;
            else
                return false;
        }
        return true;
    }

}
