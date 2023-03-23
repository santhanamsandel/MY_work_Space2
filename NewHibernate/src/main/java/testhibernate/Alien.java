package testhibernate;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="alien_tab")

public class Alien {
	
	@Id
	private int alienNo;
	
	@Column(name="Alien_name")
	private Name alienname;
	public void setAlienname(Name alienname) {
		this.alienname = alienname;
	}
	@Column(name="Alien_Color")
	private String alienColor;
	
	
	public int getAlienNo() {
		return alienNo;
	}
	public void setAlienNo(int alienNo) {
		this.alienNo = alienNo;
	}

	public String getAlienColor() {
		return alienColor;
	}
	public void setAlienColor(String alienColor) {
		this.alienColor = alienColor;
	}
	@Override
	public String toString() {
		return "Alien [alienNo=" + alienNo + ", alienname=" + alienname + ", alienColor=" + alienColor + "]";
	}

	

}
