package com.gollahalli.main.tables;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {

	public static void displayData(ResultSet rs) throws SQLException {

		rs.last();
		// goto the last row
		int nRows = rs.getRow();
		// get that row number and store it in nRows
		if (nRows == 0) {
			// if there are no rows found out put this
			System.out.println("No tours were found");
		} 
		else {
			//else this
			System.out.println("Number of tours: " + nRows);
			// display the number of rows stored in nRows
			rs.beforeFirst();
			// moves the cursor to the front of the ResultSet just before the first row

			while (rs.next()) {
				// when there is a next row do the following
				StringBuffer buffer = new StringBuffer();

				buffer.append("Tour " + rs.getInt("tourId") + ": ");
				// get the tour id in db
				buffer.append(rs.getString("tourName"));
				// get the tourName from db

				// below is how you set a dollar befor the price
				double price = rs.getDouble("price");
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				String formattedPrice = nf.format(price);
				buffer.append(" (" + formattedPrice +")");

				System.out.println(buffer.toString());

			}
		}
	}

}
