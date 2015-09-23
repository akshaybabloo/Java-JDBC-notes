package com.gollahalli.main.tables;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {

	public static void displayData(ResultSet rs, int nRows) throws SQLException {
	// this function takes a string vale and an int value	
//		rs.last();
//		int nRows = rs.getRow();
		// we comment this out as we have already declared nRows in MysqlMain.java
		
		if (nRows == 0) {
			System.out.println("No tours were found");
		} 
		else {
			System.out.println("Number of tours: " + nRows);
			rs.beforeFirst();

			while (rs.next()) {
				StringBuffer buffer = new StringBuffer();

				buffer.append("Tour " + rs.getInt("tourId") + ": ");
				buffer.append(rs.getString("tourName"));

				double price = rs.getDouble("price");
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				String formattedPrice = nf.format(price);
				buffer.append(" (" + formattedPrice +")");

				System.out.println(buffer.toString());

			}
		}
	}

}
