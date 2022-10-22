package com.IsteMySQL.Util;
import java.sql.*;

public class VeritabaniUtil {
static Connection conn=null;


public static Connection Baglan() {
	
	
	try {
		//"jdbc:mysql://serverIPadress/db_ismi",kullanici","sifre"
		conn=DriverManager.getConnection("jdbc:mysql://localhost/birinic","root","mysql");
		System.out.println("Baðlantý Baþarýlý...");
		return conn;
		
		
	}catch(Exception e)
	{
		System.out.print("Baðlantý Baþarýsýz!!!");
		System.out.println(e.getMessage().toString());
		return null;
	}
}



}
