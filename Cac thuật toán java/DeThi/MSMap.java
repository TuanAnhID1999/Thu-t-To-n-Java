package DeThi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*
 *  getAdjList lĂ  phÆ°Æ¡ng thá»©c tráº£ vá» cĂ¡c Ä‘á»‰nh ká»ƒ
 *  @return map<String,List<String>> trong Ä‘Ă³ String lĂ  tĂªn cĂ¡c Ä‘á»‰nh cĂ²n List String lĂ  cĂ¡c Ä‘á»‰nh ká» tÆ°Æ¡ng á»©ng vá»›i nĂ³
 */

public class MSMap {
    /*
     *
     */
    private Map<String, List<String>> getAdjList(int[][] adjMatrix, String[] verticals) {
        Map<String, List<String>> newmap = new HashMap<>();
        int n = adjMatrix.length;
        for (int i = 0; i < n; i++) {
            List<String> ls = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] != 0)
                    ls.add(verticals[j]);
            }
            newmap.put(verticals[i], ls);
        }
        return newmap;

    }

    private int[] BFS(int[][] adjMatrix, int x) {
        List<Integer> ls = new ArrayList<>();
        int n = adjMatrix.length;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }

        isVisited[x] = true;
        ls.add(x);
        int id = 0;
        while (id <= ls.size()) {
            for (int i = 0; i < n; i++) {
                if (isVisited[i] == false)
                    if (adjMatrix[ls.get(id)][i] != 0) {
                        ls.add(i);
                        isVisited[i] = true;
                    }
            }
            id++;
        }

        int[] f = new int[ls.size()];
        for (int i = 0; i < f.length; i++) {
            f[i] = ls.get(i);
        }
        return f;
    }
    public static void main(String[] args) throws FileNotFoundException {
        MSMap a = new MSMap();
     //   File file=new File("a.txt");
        File file=new File("D:\\a");
        Scanner sc=new Scanner(file);
        int[][] m = new int[6][6];
        /*
         * m[0][1] = 1; m[0][2]=m[0][3] = 1; m[1][0]= m[1][2]= m[1][3]= m[1][4]; m[2][0]
         * = m[2][1] =m[2][4]= 1; m[3][0] = m[3][4]= m[3][5]= 1; m[4][1]= m[4][2]= m[]
         */
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        String[] verticals = { "A", "B", "C", "D", "E", "F" };
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < verticals.length; i++) {
            System.out.println(a.getAdjList(m, verticals).get(verticals[i]));
        }

        for (int string : a.BFS(m, 0)) {
            System.out.println(verticals[string]);
        }

    }
}
