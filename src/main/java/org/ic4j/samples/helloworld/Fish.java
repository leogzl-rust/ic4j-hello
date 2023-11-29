package org.ic4j.samples.helloworld;

import java.io.Serializable;

public class Fish implements Serializable {

	private static final long serialVersionUID = -6471173502659954547L;

	private String id;
	private String fisher;
	private int weight;
	private int height;

	public Fish() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFisher() {
		return fisher;
	}

	public void setFisher(String fisher) {
		this.fisher = fisher;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
