package com.edu.Entity1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Bookstore")
public class Book {
public Book(String bname, String bauthor, int price, int bisbnno) {
		super();
		this.bname = bname;
		this.bauthor = bauthor;
		this.price = price;
		this.bisbnno = bisbnno;
	}
public Book() {
		
		// TODO Auto-generated constructor stub
	}
public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBisbnno() {
		return bisbnno;
	}
	public void setBisbnno(int bisbnno) {
		this.bisbnno = bisbnno;
	}
private String bname;
private String bauthor;
private int price;
@Id
private int bisbnno;


}
