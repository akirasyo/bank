package ams;
/* @ Date : 6.29
 * @ Author : 구로
 * @ Story : 	정렬 예제		*/
public class SelectionSort {
	public static void main(String[] args) {
		int length=10;
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((Math.random()*100)+1);
		}
		System.out.println("정렬 전");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("정렬 후");
		//선택적 정렬
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) {	// 스왓 알고리즘
					temp = arr[i]	;
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for (int i : arr) {
			System.out.print(i + "\t");			
		}
	}
}
