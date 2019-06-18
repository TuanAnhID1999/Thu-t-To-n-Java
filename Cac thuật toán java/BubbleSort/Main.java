package BubbleSort;

public class Main {
    public static void sort(int []A){
        for (int j =0; j < A.length-1 ; j++)
        {
            for (int i =0; i < A.length- j-1; i++){
                if (A[i] > A[i+1]){
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
            }
        }
        for (int j = 0; j < A.length; j++){
            System.out.print(A[j]);
        }
    }

    public static void main(String[] args) {
        int []A = {1,5,8,3,4};
        sort(A);
    }
}
