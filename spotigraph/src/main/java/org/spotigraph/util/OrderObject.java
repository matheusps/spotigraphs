package org.spotigraph.util;

public class OrderObject<T> {

	private Integer value;
	
	private T obj;
	
	public OrderObject(Integer value,T obj) {
		this.value = value;
		this.obj = obj;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return this.value + ":" + this.obj;
	}
	
	
	
}
