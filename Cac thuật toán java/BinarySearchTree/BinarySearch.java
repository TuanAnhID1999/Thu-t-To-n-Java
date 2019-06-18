package BinarySearchTree;

class BinarySearch {

    int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // Nếu arr[mid] = x, trả về chỉ số và kết thúc
            if (arr[mid] == x)
                return mid;

            // Nếu arr[mid] > x, gọi đệ quy tìm kiếm bên trái
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Ngược lại, nếu arr[mid] < x, gọi đệ quy tìm kiếm bên phải
            return binarySearch(arr, mid + 1, r, x);
        }

        // Trong trường hợp không tìm thấy
        return -1;
    }


    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Không tìm thấy phần tử " + x);
        else
            System.out.println("Phần tử " + x + " được tìm thấy tại chỉ số " +
                    result);
    }

/*
int u = 0;
		int v = n -1;
		while(u<=v) {
			int m = u+(v-u)/2;
			if(keys[m].compareTo(key)>0)
				v = m-1;
			else if(keys[m].compareTo(key)<0)
				u = m+1;
			else
				return m;
		}
		return u;
 */
}
