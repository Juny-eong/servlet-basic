package etc.io.file.serialize;

public class NonSerializableClass { // not implements Serializable
	private String nonSerializableClassfield;

	public String getNonSerializableClassfield() {
		return nonSerializableClassfield;
	}

	public void setNonSerializableClassfield(String nonSerializableClassfield) {
		this.nonSerializableClassfield = nonSerializableClassfield;
	}

}
