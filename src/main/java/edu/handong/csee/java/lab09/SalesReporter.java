package edu.handong.csee.java.lab09;

/**2018/04/12 hw1_5 21500483 lee min hoe
 * SalesReporter
 *  : get Data from user, calculate average & highest sales, print out data*/

import java.util.Scanner;//to get input

public class SalesReporter {
	
	private double highestSales=0;//set highestSales as 0
	private double averageSales=0;//set averageSales as 0
	
	private SalesAssociate[] team;//make array of associate name & sales
	
	private int numberOfAssociates;//get number of associate
	
	Scanner keyboard = new Scanner(System.in);// to get user input
	
	
	void getData() { //get data from user
		
		System.out.print("Enter number of sales associates : ");
		this.numberOfAssociates = keyboard.nextInt();//get number of associate
		
		team = new SalesAssociate[numberOfAssociates];//set array team's memory
		
		for(int i=0; i<team.length;i++) {
			
			System.out.println("Enter data for associate number "+(i+1));
			System.out.print("Enter name of sales associate: ");
			String s = keyboard.nextLine();//get \n
			s = keyboard.nextLine();//get associate name

			
			System.out.print("Enter associate's sales : $");
			int l= keyboard.nextInt();//get associate Sales
			
			SalesAssociate SalesMan=new SalesAssociate();//temp SalesAssociate variable SalesMan
			SalesMan.setName(s);//set Name of SalesMan
			SalesMan.setSales(l);//set Sales of SalesMan
			
			team[i]=SalesMan;//put SalesMan data into array
			
		}//do process for team.length times
		
	}
	
	void comuteStats() {//find out highest Sales & average Sales
		
		for(int i=0; i<numberOfAssociates;i++) {
			
			if(team[i].getSales()>highestSales) {
				this.highestSales = team[i].getSales();//change highestSales value
			}//if member i's sales is higher than highestSales than change highestSales as i's sales value
			
			this.averageSales = averageSales+team[i].getSales();//add every members' sales
			
		}//do process for number of associate times
		
		this.averageSales = averageSales/numberOfAssociates;//calculate averageSales
		
	}
	
	void displayResults() {//print out result
		
		System.out.println("Average sales per associate is $"+averageSales);//print out average sales
		System.out.println("The highest sales figure is $"+highestSales);//print out highest sales
		System.out.println("\nThe following had the highest sales:");//print out data of highest sales member
		
		for(int i=0; i<numberOfAssociates;i++) {
			
			if(team[i].getSales()==highestSales) {
				
				System.out.println("Name: "+team[i].getName());//print out member's name
				System.out.println("Sales: $"+team[i].getSales());//print out member's sales
				System.out.println("$"+(team[i].getSales()-averageSales)+" above the average.");//print out difference between average Sales & member's sales	
			}//print out if member's Sale equals to highestSales
		}//do process for number of associate times
		
		System.out.println("\nThe rest performed as follows:");//print out rest members' data
		
		for(int i=0; i<numberOfAssociates;i++) {
			
			if(team[i].getSales()!=highestSales) {
				
				if(team[i].getSales()<averageSales) {
					
					System.out.println("Name: "+team[i].getName());//print out member's name
					System.out.println("Sales: $"+team[i].getSales());//print out member's sales
					System.out.println("$"+(averageSales-team[i].getSales())+" below the average.");//print out difference between average sale & member's sales
					
				}//print out if member's sales is lower than average sales
				
				else {
					
					System.out.println("Name: "+team[i].getName());//print out member's name
					System.out.println("Sales: $"+team[i].getSales());//print out member's sales
					System.out.println("$"+(team[i].getSales()-averageSales)+" above the average.");//print out difference between average sales & member's sales
					
				}////print out if member's sales is lower than average sales
			}//do this process if member's sales is not equals to highestSales 
		}//do process for number of associate times
		
	}

}
