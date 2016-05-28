package com.example.dataaccess;

import java.sql.Date;

public class User {
	String name;
	int weight;
	Date lastupdate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Date getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}
	@Override
	public String toString(){
		return this.getName() + "," + this.getWeight() + "," + this.getLastupdate();
	}

}
