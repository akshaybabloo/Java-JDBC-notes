package com.gollahalli.main.tables;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {

	public static void displayData(ResultSet rs) throws SQLException{
		while (rs.next()) {
			StringBuffer buffer = new StringBuffer();
			
			// 1. the below was the old code which i have converted into
			
//			buffer.append("Tour " + rs.getInt("tourId") + ": ");
//			buffer.append(rs.getString("tourName"));
//			buffer.append(" (" + rs.getDouble("price") + ") | ");
			
			
			// 2. this, so that i have seperated them with assigned variables
//			int tourId 		= rs.getInt("tourId");
//			String tourName = rs.getString("tourName");
//			double price 	= rs.getDouble("price");
			
			// you use a generic method called getObject in ResultSet class in which you have to 
			// give the table name and the data type followed by .class
			int tourId 		= rs.getObject("tourId", Integer.class);
			String tourName = rs.getObject("tourName", String.class);
			BigDecimal price 	= rs.getObject("price", BigDecimal.class);
			// BigDecimal is a type of data type which gives the exact place value for a decimal
			// uses java.math.* class
			
			
			// 3. from this 
			buffer.append("Tour " + tourId + ": ");			
			buffer.append(tourName);
			buffer.append(" (" + price + ") | "); 
		
			BigDecimal price1 = price;
			NumberFormat nf = NumberFormat.getCurrencyInstance();
		
			String formattedPrice = nf.format(price1);
			buffer.append("(" + formattedPrice + ")");
			
			System.out.println(buffer.toString());
			
		}
	}
	
}
