package etc.io.file.serialize;

import java.io.Serializable;

public class TestClassB implements Serializable {
	
	private static final long serialVersionUID = -1791244142956216044L;
	private static final String field1 = "class_B";
	private int field2;

	public int getField2() {
		return field2;
	}

	public void setField2(int field2) {
		this.field2 = field2;
	}

	public static String getField() {
		return field1;
	}

}
