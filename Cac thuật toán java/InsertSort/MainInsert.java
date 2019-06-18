package InsertSort;

public class MainInsert {
    public static void sort(int []A)
    {
        for (int i = 1;i < A.length; i++ )
        {
            int j = i-1;
            int t = A[i];

            while (t < A[j] && j >= 0)
            {
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = t;
        }

        for (int j =0; j < A.length; j++){
            System.out.print(A[j]);
        }

    }
    public static void main(String[] args) {
        int []A = {1,5,3,7,9};
        sort(A);

    }
}
