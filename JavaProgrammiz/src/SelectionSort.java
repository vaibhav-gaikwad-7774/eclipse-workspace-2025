
public class SelectionSort {

	public static void main(int arr[], int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			int mini = i;
			for (int j = i +1; j<n; j ++) {
				if (arr[j]< arr[mini]) {
					mini = j;
				}
			}
			int temp = arr[mini];
			arr [mini] = arr[i];	
			arr[i]= temp;
		}
		System.out.print("after Selection Sort: ");
		for (int i = 0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[]  = {13, 44, 11, 67, 52, 84};
		int n = arr.length;
		System.out.print("Before the Selection sort : ");
		for (int i = 0; i < n ; i++) {
			System.out.print(arr[i] + " " );
		}
		System.out.println();
		main(arr, n);
	}

}
