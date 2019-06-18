package DeThi;


public class Bai_1 {
    public int[] Caub(int[][] matran, int begin) {
        int n = matran.length;
        boolean[] visit = new boolean[n];//dinh
        for (int i = 0; i < visit.length; i++) {
            visit[i] = false;
        }
        int[] arr1 = new int[n];// dinh truoc cua cac dinh
        int[] arr2 = new int[n];// so luong dinh lon nhat trc do
        boolean[][] visit2 = new boolean[n][n];//canhj
        for (int i = 0; i < visit2.length; i++) {
            for (int j = 0; j < visit2.length; j++) {
                visit2[i][j] = false;
            }
        }
        int a;
        while ((a = select(visit, visit2, matran)) != -1) {

        }
        return null;
    }

    private int select(boolean[] visit, boolean[][] visit2, int[][] matran) {
        // TODO Auto-generated method stub
        int returnn = -1;
        for (int i = 0; i < visit2.length; i++) {
            for (int j = 0; j < visit2.length; j++) {
                if(matran[i][j]==1 && visit[i]==true) {

                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
