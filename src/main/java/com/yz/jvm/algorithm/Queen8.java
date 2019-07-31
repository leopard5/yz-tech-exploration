package com.yz.jvm.algorithm;

public class Queen8 {
    private static int num = 0; //累计方案总数
    private static final int MAX_QUEEN = 8;//皇后个数，同时也是棋盘行列总数
    private static int[] cols = new int[MAX_QUEEN]; //定义cols数组，表示8列棋子摆放情况

    Queen8() {
        //核心函数
        getArrangement(0);
        System.out.print("\n");
        System.out.println(MAX_QUEEN + "皇后问题有" + num + "种摆放方法。");
    }

    private void getArrangement(int n) {
        //遍历该列所有不合法的行，并用rows数组记录，不合法即rows[i]=true
        boolean[] rows = new boolean[MAX_QUEEN];
        for (int i = 0; i < n; i++) {
            rows[cols[i]] = true;
            int d = n - i;
            if (cols[i] - d >= 0) rows[cols[i] - d] = true;
            if (cols[i] + d <= MAX_QUEEN - 1) rows[cols[i] + d] = true;

        }
        for (int i = 0; i < MAX_QUEEN; i++) {
            //判断该行是否合法
            if (rows[i]) continue;
            //设置当前列合法棋子所在行数
            cols[n] = i;
            //当前列不为最后一列时
            if (n < MAX_QUEEN - 1) {
                getArrangement(n + 1);
            } else {

                //累计方案个数
                num++;
                //打印棋盘信息
                printChessBoard();
            }


        }

    }

    private void printChessBoard() {

        System.out.println("第" + num + "种走法");

        for (int i = 0; i < MAX_QUEEN; i++) {
            for (int j = 0; j < MAX_QUEEN; j++) {
                if (i == cols[j]) {
                    System.out.print("0 ");
                } else
                    System.out.print("+ ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]) {
        Queen8 queen = new Queen8();
    }
}
