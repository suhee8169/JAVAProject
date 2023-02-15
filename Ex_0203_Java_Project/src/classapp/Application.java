package classapp;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Application implements Serializable{
	
	private String id;
	private int credit;
	private ArrayList<String>[] list ;
	private int count;
	
	
	
	public ArrayList<String>[] getList() {
		return list;
	}
	public void setList(ArrayList<String>[] list) {
		this.list = list;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	

}