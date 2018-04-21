package edu.handong.csee.java.lab09;

/**2018/04/12 hw1_5 21500483 lee min hoe
 * SalesReporter
 *  : get Data from user, calculate average & highest sales, print out data*/

import java.util.Scanner;//to get input
import java.util.ArrayList;//import Array list utility

public class SalesReporter {
	
	private double highestSales=0;//set highestSales as 0
	private double averageSales=0;//set averageSales as 0
	ArrayList<String> name = new ArrayList<String>();//arraylist of name
	ArrayList<Double> sales = new ArrayList<Double>();//arraylist of sales
	boolean moredata=true;//boolean data
	
	Scanner keyboard = new Scanner(System.in);// to get user input
	
	
	void getData() { //get data from user
		
		do {
			System.out.print("Enter name of sales associate: ");//ask name
			this.name.add(keyboard.nextLine());//get associate name
		
			System.out.print("Enter associate's sales : $");//ask sales
			this.sales.add(keyboard.nextDouble());//get associate Sales
		
			System.out.print("another data(yes or no) : ");//ask more data
			String S = keyboard.nextLine();//get \n
			S = keyboard.nextLine();//get answer
			
			if (S.equals("yes")) {
				this.moredata = true;
			}
			else {
				this.moredata = false;
			}
			
		}while(moredata);//do process for while answer is no
		
	}
	
	void comuteStats() {//find out highest Sales & average Sales
		
		for(int i=1; i<=this.name.size();i++) {
			
			if(this.sales.get(i)>highestSales) {
				this.highestSales = this.sales.get(i);//change highestSales value
			}//if member i's sales is higher than highestSales than change highestSales as i's sales value
			
			this.averageSales = averageSales+this.sales.get(i);//add every members' sales
			
		}//do process for number of associate times
		
		this.averageSales = averageSales/this.name.size();//calculate averageSales
		
	}
	
	void displayResults() {//print out result
		
		System.out.println("Average sales per associate is $"+averageSales);//print out average sales
		System.out.println("The highest sales figure is $"+highestSales);//print out highest sales
		System.out.println("\nThe following had the highest sales:");//print out data of highest sales member
		
		for(int i=1; i<=name.size();i++) {
			
			if(this.sales.get(i)==highestSales) {
				
				System.out.println("Name: "+this.name.get(i));//print out member's name
				System.out.println("Sales: $"+this.sales.get(i));//print out member's sales
				System.out.println("$"+(this.sales.get(i)-averageSales)+" above the average.");//print out difference between average Sales & member's sales	
			}//print out if member's Sale equals to highestSales
		}//do process for number of associate times
		
		System.out.println("\nThe rest performed as follows:");//print out rest members' data
		
		for(int i=0; i<this.name.size();i++) {
			
			if(this.sales.get(i)!=highestSales) {
				
				if(this.sales.get(i)<averageSales) {
					
					System.out.println("Name: "+this.name.get(i));//print out member's name
					System.out.println("Sales: $"+this.sales.get(i));//print out member's sales
					System.out.println("$"+(averageSales-this.sales.get(i))+" below the average.");//print out difference between average sale & member's sales
					
				}//print out if member's sales is lower than average sales
				
				else {
					
					System.out.println("Name: "+this.name.get(i));//print out member's name
					System.out.println("Sales: $"+this.sales.get(i));//print out member's sales
					System.out.println("$"+(this.sales.get(i)-averageSales)+" above the average.");//print out difference between average sales & member's sales
					
				}////print out if member's sales is lower than average sales
			}//do this process if member's sales is not equals to highestSales 
		}//do process for number of associate times
		
	}

}
