package etc.preview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CheckPermutation {
	
	/*
	 * 2°³ÀÇ byte[] array x 2
	 */
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word1 = br.readLine();
		String word2 = br.readLine();
		
		boolean result = permutation(toSortedArray(word1), toSortedArray(word2));
		System.out.println(result);
		
	
	}
	
	
	public static byte[] toSortedArray(String word) {
		byte[] byteArray = word.getBytes();
		Arrays.sort(byteArray);
		
		return byteArray;
	}
	
	
    public static boolean permutation(byte[] arr1, byte[] arr2) {
    	
    	if (arr1.length != arr2.length) {
    		return false;
    	}
    	
    	for (int i = 0; i < arr1.length; i++) {
    		if (arr1[i] != arr2[i]) {
    			return false;
    		}
    	}
    	return true;
    }
}
