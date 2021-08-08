package etc.io.file.serialize;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import etc.io.file.copy.FileManager;

public class SerializeExample {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String filePath = br.readLine();
		
		
		/* ---------- write file ---------- */
		SerializableWriter serializableWriter = new SerializableWriter();
		serializableWriter.write(filePath);
		
		
		/* ---------- read object from file ---------- */
		SerializableReader serializableReader = new SerializableReader();
		serializableReader.read(filePath);
		
		
		System.out.println("============ load data with string ==========");
		FileManager.getInstance().loadByteData(filePath);
	}

}
