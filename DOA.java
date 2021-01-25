package com.DOA;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.supermarketbean;
import com.connection.DBUtil;
import com.bean.supermarketbean;

public class DOA {
	public int itemInsert(supermarketbean item) throws SQLException, ClassNotFoundException {
		Connection con = DBUtil.DBConnection();
//		Statement statement = con.createStatement();
		PreparedStatement statement = con.prepareStatement("insert into sales values(?, ?, ?)");
//		int i = statement.executeUpdate("insert into student_table values(student.regno, student.name, student.email)");
		statement.setInt(1,  item.getItid());
		statement.setString(2,  item.getName());
		statement.setInt(3,  item.getCost());
		int i = statement.executeUpdate();
		con.close();
		return i;
		
	}
	public void itemDisplay()throws SQLException, ClassNotFoundException {
		System.out.println("ITEM LIST");
		Connection con = DBUtil.DBConnection();
		PreparedStatement statement = con.prepareStatement("Select * from sales");
		ResultSet rs=statement.executeQuery();
		System.out.println("ITEMID\t\tITEMNAME\t\tITEMCOST");
		while(rs.next()) {
		System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3));		
		}
		
	    con.close();
	}
	public int totalCost()throws SQLException, ClassNotFoundException {
		Connection con = DBUtil.DBConnection();
		PreparedStatement statement = con.prepareStatement("Select sum(cost) from sales");
		ResultSet rs=statement.executeQuery();
		while(rs.next()) {
		System.out.println("TOTAL COST OF ALL ITEMS :"+rs.getInt(1)+"rupees");
		}
		int i=statement.executeUpdate();
		con.close();
		return i;


}
}
