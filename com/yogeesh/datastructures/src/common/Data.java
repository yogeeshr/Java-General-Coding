package common;

/**
 * @author yogeesh.srkvs@gmail.com;
 *
 */
public class Data<T> {

	private T value = (T) new Integer(10);

	/**
	 * @param value
	 */
	public Data(T value) {
		super();
		this.value = (null==value)? this.value: value;
	}

	/**
	 * @return the data
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param object the data to set
	 */
	public void setValue(Object object) {
		this.value = (T) object;
	}
			
}
