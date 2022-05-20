package edu.umb.cs680.hw06;

import java.time.LocalDateTime;


public class FSElement {

	protected String name;
	protected int size;
	protected LocalDateTime  creationTime;
	protected Directory parent;
	
	public FSElement(Directory parent,String name,int size,LocalDateTime creationTime) {
		this.parent=parent;
		this.creationTime=creationTime;
		this.name=name;
		this.size=size;
	}
	public void setParent(Directory parent) {
		this.parent = parent;
	}
	public Directory getParent() {
		return parent;	
	}
	public void setSize(int size) {
		this.size=size;	
	}
	public int getSize() {
		return size;	
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	 public void setCreationTime(LocalDateTime creationTime) {
	        this.creationTime = creationTime;
	    }
	public LocalDateTime getCreationTime() {
        return creationTime;
    }
	public boolean isDirectory() {
		return false;
	}
}
