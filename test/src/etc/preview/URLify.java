package etc.preview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class URLify {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		
		String word = st.nextToken();
		int length = Integer.parseInt(st.nextToken());
		
		System.out.println(Encoding(word, length).toString());
		
	}

	
	public static char[] Encoding(String word, int length) {
		
		char[] charArray = word.toCharArray();
		int spaceCnt = 0;
		int newIdx = 0;
		
		for (int i = 0; i < length; i++) {
			if (charArray[i] == ' ') {
				spaceCnt++;
			}
		}
		newIdx = length + spaceCnt * 2;
		charArray[length] = '\0';
		
		for (int i = length - 1; i <= 0; i--) {
			if (charArray[i] == ' ') {
				charArray[newIdx - 1] = '0';
				charArray[newIdx - 2] = '2';
				charArray[newIdx - 3] = '%';
				newIdx -= 3;
			}
			else {
				charArray[newIdx - 1] = charArray[i];
				newIdx--;
			}
		}
		
		return charArray;
		
	}
}
