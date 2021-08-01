package etc.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileManager {

	private FileManager() {}
	
	private static class InnerClass {
		private static final FileManager instance = new FileManager();
	}
	
	public static FileManager getInstance() {
		return InnerClass.instance;
	}
	
	
	public void copyFile(File originalFile, File targetFile) throws Throwable {
		
		if (!originalFile.exists()) {
			throw new RuntimeException("[FileManager] - <" + originalFile.getAbsolutePath()  + "> : file not exists.");
		}
		
		System.out.println("-----------------------------------------");
//		System.out.println(targetFile.getPath()); // temp.tmp
//		System.out.println(System.getProperty("user.dir")); // C:\Users\adipy\git\refactored-journey\test\temp.tmp
//		
//		if (  System.getProperty("user.dir").equals(targetFile.getAbsolutePath().replace("\\" + targetFile.getName(), ""))  ) {
//
//		}
//		if (targetFile.getPath().equals(targetFile.getName())) {}
		
		if (targetFile.getParentFile() != null) {
			
			/* 해당 파일까지의 경로가 없는 경우 새로 생성 */
			if (  !targetFile.getParentFile().exists()  ) {
				targetFile.getParentFile().mkdirs();
				System.out.println("[FileManager] - create new directory : \t\t" + targetFile.getParentFile().getAbsolutePath());
			}
		}
		
		System.out.println("[FileManager] - target file path : \t\t" + targetFile.getAbsolutePath());
		
		
		FileInputStream fis = new FileInputStream(originalFile);
		FileOutputStream fos = new FileOutputStream(targetFile);
		
		byte[] data = new byte[1024];
		int readByteLength = 0;
		int fileSize = 0;

		
		/* read data */
		while (  (readByteLength = fis.read(data)) != -1  ) {
			fos.write(data, 0, readByteLength);
			fileSize++;
		}
		
		fos.flush();
		fos.close();
		fis.close();
		
		/* 생성된 파일 객체로 성공여부 확인 */
		File file = new File(targetFile.getPath());
		if (  file.exists()  ) {
			float size = (float) file.length() / 1024;
			System.out.println("[FileManager] - real file size : " + Math.round(size * 100) / 100.0 + "KB");
			System.out.println("[FileManager] - copy file finished. [" + fileSize + "KB]");
		}
		else {
			throw new RuntimeException("[FileManager] - failed to copy file.");
		}
		
	}
	
	
}
