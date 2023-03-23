package jpa;

import javax.persistence.*;

@Entity
public class Product {
	
	@Id
	private int pId;
	private String pName;
	private String Pcolor;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getPcolor() {
		return Pcolor;
	}
	public void setPcolor(String pcolor) {
		Pcolor = pcolor;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", Pcolor=" + Pcolor + "]";
	}
	
}
