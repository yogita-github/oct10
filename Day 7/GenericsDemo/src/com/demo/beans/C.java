package com.demo.beans;

public class C extends B{
     private int z;

	public C() {
		super();
	}

	public C(int x, int y,int z) {
		super(x,y);
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return super.toString()+"C [z=" + z + "]";
	}
     
}
