package com.demo.beans;

public class B extends A{
	private int y;

	public B() {
		super();
	}

	public B(int x,int y) {
		super(x);
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return super.toString()+"B [y=" + y + "]";
	}
	

}
