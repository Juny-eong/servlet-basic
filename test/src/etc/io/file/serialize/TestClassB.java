package etc.io.file.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestClassB extends NonSerializableClass implements Serializable {
	
	private static final long serialVersionUID = -1791244142956216044L;
	private static final String staticField = "class_B_staticField";
	private String classBField;
	

	public String getClassBField() {
		return classBField;
	}

	public void setClassBField(String field2) {
		this.classBField = field2;
	}

	public static String getStaticField() {
		return staticField;
	}
	
	/* 상속한 필드가 Serializable 인터페이스를 구현하지 않은 경우 명시적으로 메소드를 선언해주어야 (역)직렬화가 가능 */
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(super.getNonSerializableClassfield());
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		super.setNonSerializableClassfield(in.readUTF());
		in.defaultReadObject();
	}

}
