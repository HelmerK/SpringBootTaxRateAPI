package Packages;


import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;


//USed to create SQL scripts for Capstone2023 project
public class DbScriptWrite {

	public static void main(String[] args) throws IOException {

		try {
		System.out.println("Enter 1 for CANADA and 2 for US");
		Scanner userIn = new Scanner(System.in);
		
		
			String input = userIn.next();
			userIn.close();
			if (input.equals("1")) {
				ArrayList<TaxRate> taxRates = new ArrayList<>();
				Scanner in = new Scanner(new File("res/postalcodes.txt"));

				while (in.hasNext()) {
					String line = in.nextLine();
					String[] fields = line.split(";");
					taxRates.add(new TaxRate(Double.parseDouble(fields[4]), Double.parseDouble(fields[6]),
							Double.parseDouble(fields[8]), fields[1], fields[2], fields[0]));
				}
				
				
				FileWriter insertWrite = new FileWriter("res/CanInserts.sql");
				for (TaxRate temp : taxRates) {
					insertWrite.write(
							"INSERT INTO `canadaTaxRate` (`gst`,`pst`,`hst`,`location_code`) VALUES (" + temp.getGst()
									+ "," + temp.getPst() + "," + temp.getHst() + ",'" + temp.getPostalCode() + "');");
					insertWrite.write("\r\n");
				}

				for (TaxRate temp : taxRates) {
					insertWrite.write("INSERT INTO `location` VALUES ('" + temp.getPostalCode() + "','"
							+ temp.getCOUNTRY() + "','" + temp.getProvince() + "');");
					insertWrite.write("\r\n");
				}

				// US
			} else if (input.equals("2")) {
				ArrayList<UsTaxRate> taxRates = new ArrayList<>();

				String temp = "";
				double rate = 0;


				Scanner zipIn = new Scanner(new File("res/zipcodes.csv"));
				while (zipIn.hasNext()) {
					String line = zipIn.nextLine();
					String[] fields = line.split(",");
					
					//Crude switch statement to deal with the naming of the states based off of the given abbreviations in the CSV file. 
					switch (fields[6]) {
					case "AL":
						rate = 4;
						temp = "Alabama";
						break;

					case "AK":
						rate = 0;
						temp = "Alaska";
						break;

					case "AZ":
						rate = 5.6;
						temp = "Arizona";
						break;

					case "AR":
						rate = 6.5;
						temp = "Arkansas";
						break;

					case "AS":
						rate = 0;
						temp = "American Samoa";
						break;

					case "CA":
						rate = 7.25;
						temp = "California";
						break;

					case "CO":
						rate = 2.9;
						temp = "Colorado";
						break;

					case "CT":
						rate = 6.35;
						temp = "Connecticut";
						break;

					case "DE":
						rate = 0;
						temp = "Delaware";
						break;

					case "DC":
						rate = 6;
						temp = "District of Columbia";
						break;

					case "FL":
						rate = 6;
						temp = "Florida";
						break;

					case "GA":
						rate = 4;
						temp = "Georgia";
						break;

					case "GU":
						rate = 0;
						temp = "Guam";
						break;

					case "HI":
						rate = 4;
						temp = "Hawaii";
						break;

					case "ID":
						rate = 6;
						temp = "Idaho";
						break;

					case "IL":
						rate = 6.25;
						temp = "Illinois";
						break;

					case "IN":
						rate = 7;
						temp = "Indiana";
						break;

					case "IA":
						rate = 6;
						temp = "Iowa";
						break;

					case "KS":
						rate = 6.5;
						temp = "Kansas";
						break;

					case "KY":
						rate = 6;
						temp = "Kentucky";
						break;

					case "LA":
						rate = 4.45;
						temp = "Louisiana";
						break;

					case "ME":
						rate = 5.5;
						temp = "Maine";
						break;

					case "MD":
						rate = 6;
						temp = "Maryland";
						break;

					case "MA":
						rate = 6.25;
						temp = "Massachusetts";
						break;

					case "MI":
						rate = 6;
						temp = "Michigan";
						break;

					case "MN":
						rate = 6.875;
						temp = "Minnesota";
						break;

					case "MS":
						rate = 7;
						temp = "Mississippi";
						break;

					case "MO":
						rate = 4.225;
						temp = "Missouri";
						break;

					case "MT":
						rate = 0;
						temp = "Montana";
						break;

					case "NE":
						rate = 5.5;
						temp = "Nebraska";
						break;

					case "NV":
						rate = 6.85;
						temp = "Nevada";
						break;

					case "NH":
						rate = 0;
						temp = "New Hampshire";
						break;

					case "NJ":
						rate = 6.625;
						temp = "New Jersey";
						break;

					case "NM":
						rate = 5.125;
						temp = "New Mexico";
						break;

					case "NY":
						rate = 4;
						temp = "New York";
						break;

					case "NC":
						rate = 4.7;
						temp = "North Carolina";
						break;

					case "ND":
						rate = 5;
						temp = "North Dakota";
						break;

					case "MP":
						rate = 0;
						temp = "Northern Mariana Islands";
						break;

					case "OH":
						rate = 5.75;
						temp = "Ohio";
						break;

					case "OK":
						rate = 4.5;
						temp = "Oklahoma";
						break;

					case "OR":
						rate = 0;
						temp = "Oregon";
						break;

					case "PA":
						rate = 6;
						temp = "Pennsylvania";
						break;

					case "PR":
						rate = 0;
						temp = "Puerto Rico";
						break;

					case "RI":
						rate = 7;
						temp = "Rhode Island";
						break;

					case "SC":
						rate = 6;
						temp = "South Carolina";
						break;

					case "SD":
						rate = 4.5;
						temp = "South Dakota";
						break;

					case "TN":
						rate = 7;
						temp = "Tennessee";
						break;

					case "TX":
						rate = 6.25;
						temp = "Texas";
						break;

					case "TT":
						rate = 0;
						temp = "Trust Territories";
						break;

					case "UT":
						rate = 6.1;
						temp = "Utah";
						break;

					case "VT":
						rate = 6;
						temp = "Vermont";
						break;

					case "VA":
						rate = 5.3;
						temp = "Virginia";
						break;

					case "VI":
						rate = 0;
						temp = "Virgin Islands";
						break;

					case "WA":
						rate = 6.5;
						temp = "Washington";
						break;

					case "WV":
						rate = 6;
						temp = "West Virginia";
						break;

					case "WI":
						rate = 5;
						temp = "Wisconsin";
						break;

					case "WY":
						rate = 4;
						temp = "Wyoming";
						break;

					}

					taxRates.add(new UsTaxRate(rate, "USA", temp, fields[0]));
				}

				 
				FileWriter insertRateWrite = new FileWriter("res/usInsertsTax.sql");
				FileWriter insertLocWrite = new FileWriter("res/usInsertsLoc.sql");
				
				for (UsTaxRate temp2 : taxRates) {							
					insertRateWrite.write("INSERT INTO `usTaxRate` (`state_tax`,`zip_code`) VALUES (" + temp2.getStateRate()
					+ ",'" + temp2.getZipcode() + "');\r\n");					
					}
				
				for (UsTaxRate temp2 : taxRates) {
					insertLocWrite.write("INSERT INTO `location` VALUES ('" + temp2.getZipcode() + "','"
									+ "USA" + "','" + temp2.getState() + "');\r\n");
						}
				insertLocWrite.close();
				insertRateWrite.close();
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}

}
