package etc.io.file.copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class FileExample {
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		File originalFile = new File(br.readLine());
		File targetFile = new File(br.readLine());
		
		FileManager.getInstance().copyFile(originalFile, targetFile);
	}

}
