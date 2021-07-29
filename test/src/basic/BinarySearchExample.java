package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchExample {
	
	private static final int OFFSET = 3;
	
	/**
	 * 	find key index by binary-search (80)
	 * 
	      |   10   20   30   40   50   60   70   80   90   100   110   120   130   140   150   160   170   180   190   200
	   ---+-------------------------------------------------------------------------------------------------------------------- 
	      |   <-                                           +                                                            ->
	      |   <-                  +                   ->
	      |                            <-   +         ->
	      |                                      <-+  ->
	
	   ==============
	
	   key index : 7
	
	   ==============
       
	 */
	
	public static void main(String[] args) throws IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine());
//		int[] testArr = new int[N];
//		
//		for (int i = 0; i < N; i++) {
//			testArr[i] = Integer.parseInt(br.readLine());
//		}
		
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200 };
		System.out.println("\n\n==============\nkey index : " + search(arr, 185) + "\n\n==============");
	}
	
	
	
	public static int search(int[] arr, int key) {
		
		int firstIndex = 0;
		int lastIndex = arr.length - 1;
		
		// The number of spaces required to reach the element.
		int[] spaceCountArr = new int[arr.length];
		
		/* initialize position */
		int firstPosition = 0;
		int centerPosition = 0;
		int lastPosition = 0;
		
		/*------------------------ first line of table -------------------------*/
		System.out.print("   |");
		for (int var : arr) {
			System.out.print("   " + var);
		}
		/*----------------------------------------------------------------------*/

		
		/*------------------------ second line of table ------------------------*/
		System.out.print("\n---+");
		
		
		for (int i = 0; i <= arr.length; i++) {
			if (i == 0) {
				spaceCountArr[i] = OFFSET;
			}
			
			if (i < arr.length - 1) {
				spaceCountArr[i + 1] = spaceCountArr[i] + String.valueOf(arr[i]).length() + OFFSET;
			}
			
			for (int j = 0; j <= String.valueOf(i).length() + OFFSET; j++) {
				System.out.print("-");
			}

		}
		/*----------------------------------------------------------------------*/
		
//		for (int var : spaceCountArr) {
//			System.out.print(var + " ");
//		}
		
		System.out.println();
		do {
			System.out.print("   |");
			int centerIndex = (lastIndex + firstIndex) / 2;
			
			/* get first index */
			for (int i = 0; i < spaceCountArr[firstIndex]; i++) {
				System.out.print(" ");
			}
			System.out.print("<-");
			firstPosition = spaceCountArr[firstIndex] + 2;
			/* --------------- */
			
			
			
			/* get center index -> centerPos. - firstPos */
			for (int i = 0; i < spaceCountArr[centerIndex] - firstPosition; i++) {
				System.out.print(" ");
				centerPosition++;
			}
			System.out.print("+");
			centerPosition += 1;
			/* ----------------------------------------- */
			
			
			
			/* get last index -> lastPos. - (firstPos. + centerPos.) */
			lastPosition = spaceCountArr[lastIndex] - (centerPosition + firstPosition);
			
			// length of last value - 2(length of "->")
			lastPosition += String.valueOf(arr[lastIndex]).length() - 2;
			
			for (int i = 0; i < lastPosition; i++) {
				System.out.print(" ");
			}
			System.out.println("->");
			/* ----------------------------------------------------- */
			
			centerPosition = 0;
			firstPosition = 0;
			lastPosition = 0;
			
			if (arr[centerIndex] == key) {
				return centerIndex;
			}
			else if (arr[centerIndex] < key) {
				firstIndex = centerIndex + 1;
			}
			else {
				lastIndex = centerIndex - 1;
			}
		}
		while (firstIndex <= lastIndex);
		
		
		return -1;
	}
	
}
