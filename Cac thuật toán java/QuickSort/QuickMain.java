package QuickSort;

public class QuickMain {



        public int partition(int[] a) {
            sort(a);

            int tbc = 0;
            for (int i = 0; i < a.length; i++) {
                tbc += a[i];
            }
            tbc /= a.length;

            int key = 0;
            for (int i = 0; i < a.length - 1; i++) {
                int temp = tbc - a[i];
                if (temp >= 0) {
                    int test = tbc - a[i];
                    int test1 = tbc - a[i + 1];
                    if (test > test1) {
                        key = i;
                    }
                }
            }
            return key;
        }

        private void sort(int[] a) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }

        }

        public static void main(String[] args) {
            QuickMain q = new QuickMain();

            int[] a = {10, 3, 5, 2, 4, 6, 8, 9, 1, 7};

            int key = q.partition(a);

            System.out.println("key = " + a[key] + " index = " + key);
            System.out.print("Array a = ");
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + " ");
        }

    }

