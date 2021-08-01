package etc.io.file;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;


public class TestReader {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		/* 에서 현재 작업공간의 루트 디렉토리 출력 */
		String rootPath = System.getProperty("user.dir");
		System.out.println("rootPath : " + rootPath);
		
//		saveData(".\\src\\etc\\book.dat");

//		saveByteData("123 qweasd&*(", "./test.txt");
//		loadByteData("./test.txt");
		
		File file = new File("./test.txt");
		System.out.println(file.exists());
		
		System.out.println("====== main method end. ======");
	}

	public static void saveData(String filePath) {
		
		try (  ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath))  ) {
			
			TestObjectClass testData = new TestObjectClass("abc");
			
			output.writeObject(testData);
			
			System.out.println("---");
			
		}
		catch (Exception fne) {
			fne.printStackTrace();
		}
	}
	
	
	public static void saveByteData(String data, String filePath) {
		
		try (  OutputStream os = new FileOutputStream(filePath)  ) {
			
			byte[] byteArray = data.getBytes(); // 97|98|99|32|38 ...
			for (int i = 0; i < byteArray.length; i++) {
				System.out.println("data[" + i + "] : " + byteArray[i]);
			}
			
			
			/* byte[] -> 0~255 사이의 각 ascii code로 맵핑된 숫자로 변환 */
			for (int i = -255; i < 256; i++) {
				os.write(i);
				if (i == 0) {
					os.write('\n');
					os.write(95);
					os.write(95);
					os.write(95);
					os.write(95);
					os.write(95);
					os.write(95);
					os.write(95);
					os.write(95);
					os.write('\n');
				}
			}
			os.flush();
			
			System.out.println("====== saveByteData end. ======");
			
		}
		catch (Exception fne) {
			fne.printStackTrace();
		}
	}
	
	
	public static void loadByteData(String filePath) {
		
		try (  InputStream is = new FileInputStream(filePath)  ) {
			
			System.out.println("------ read data ------");
			byte[] data = is.readAllBytes();
			System.out.println(new String(data));
			System.out.println("------ read data ------");
			
		}
		catch (Exception fne) {
			fne.printStackTrace();
		}
		
		System.out.println("====== loadByteData end. ======");
	}
	
	
	@Deprecated
	public static void loadData(String filePath) throws ClassNotFoundException, IOException {
		
		try (  ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath))  ) {
			
			Object obj =  input.readObject();
			System.out.println(obj.getClass());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	protected static class TestObjectClass implements Serializable {
		
		private String label;
		
		public TestObjectClass(String label) {
			this.label = label;
		}
	}
	
}
