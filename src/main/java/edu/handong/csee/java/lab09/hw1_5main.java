package edu.handong.csee.java.lab09;

/**2018/04/12 hw1_5 21500483 lee min hoe
 * hw1_5main
 *  : main class*/


public class hw1_5main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SalesReporter sr = new SalesReporter();//get new SalesReporter as sr
		
		sr.getData();//get Data form user
		sr.comuteStats();//find out highest sales and average sales
		sr.displayResults();//display result

	}

}
