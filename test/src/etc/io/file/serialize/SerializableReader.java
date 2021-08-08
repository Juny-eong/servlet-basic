package etc.io.file.serialize;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializableReader {
	
	public void read(String filePath) throws Exception {
		
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object object = null;
		if (  (object = ois.readObject()) != null  ) {
			
			TestClassA<String, Integer> deserializedClassA = (TestClassA<String, Integer>) object;
			
			System.out.println("classA.getEntry : " + deserializedClassA.getEntry());
			System.out.println("classA.transientField : " + deserializedClassA.transientField);
			System.out.println("classA.classB : " + deserializedClassA.classB.getClass());
			System.out.println("classB.getClassBField : " + deserializedClassA.classB.getClassBField());
			System.out.println("classB.getNonSerializableClassField : " 
						+ deserializedClassA.classB.getNonSerializableClassfield());
		}
		else {
			ois.close();
			throw new RuntimeException("empty file.");
		}
		
		ois.close();
		fis.close();
		
	}
	

}
