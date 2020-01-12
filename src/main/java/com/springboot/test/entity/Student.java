package com.springboot.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_entity")

public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String stuName;
	
	private String stuPhone;
	
	private String stuAddress;

	
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	
	public String getStuName() {
		return stuName;
	}

	
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	
	public String getStuPhone() {
		return stuPhone;
	}

	
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	
	public String getStuAddress() {
		return stuAddress;
	}

	
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", stuPhone=" + stuPhone + ", stuAddress=" + stuAddress
				+ "]";
	}
	
	/*
	 * @Override public String toString() { return "Student [id=" + id +
	 * ", stuName=" + stuName + ", stuPhone=" + stuPhone + ", stuAddress=" +
	 * stuPhone + "]";
	 * 
	 * }
	 */
	
	

}
