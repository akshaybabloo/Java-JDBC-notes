package com.gollahalli.main.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {

	public static void displayData(ResultSet rs) throws SQLException{
		while (rs.next()) {
			StringBuffer buffer = new StringBuffer();
			
			buffer.append("Tour " + rs.getInt("tourId") + ": ");
			/* if you have seen the database content this tourId is an integer, so we call it 
			 * by using getInt method
			 */
			
			buffer.append(rs.getString("tourName"));
			/* like wise if you have seen the db tourName is in string format. so we call it 
			 * by using getString
			 */
			
			// buffer.append(" (" + rs.getDouble("price") + ") | "); 
			// same goes here
			
			
			/* lets say we want to put a dollar sign before the number below is the following code */
			double price1 = rs.getDouble("price");
			// lets get the value in the price and put it in price1
			 NumberFormat nf = NumberFormat.getCurrencyInstance();
			// we then use NumberFormat class and using the getCurrencyInstance and put the dollar
			// sign to nf
			String formattedPrice = nf.format(price1);
			// format the price1 with a dollar sign and give it a name formattedPrice
			buffer.append(" (" + formattedPrice + ")");
			// append it to buffer
			
			System.out.println(buffer.toString());
			// output these values as string
			
		}
	}
	
}
