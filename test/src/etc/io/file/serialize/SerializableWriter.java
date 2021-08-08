package etc.io.file.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableWriter {
	
	public void write(String filePath) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		TestClassA<String, Integer> testClassA = new TestClassA<>("classA", 123);
		testClassA.classB.setField2(22222);
		
		oos.writeObject(testClassA);
		oos.flush();
		oos.close();
		fos.close();
		
	}
}
