package com.main;
import java.sql.SQLException;

import com.bean.supermarketbean;
import com.DOA.DOA;
import java.util.*;

public class supermarketmain {
	public static void main(String args[]) throws Exception
	{
		Scanner s=new Scanner(System.in);
		supermarketbean sb=new supermarketbean();
		DOA d=new DOA();
		while(true) {
			System.out.println("1.INSERTION");
			System.out.println("2.DISPLAY");
			System.out.println("3.TOTAL COST");
			System.out.println("4.EXIT");
			System.out.println("OPT AN OPTION");
			int option=s.nextInt();
			switch(option) {
			case 1:
				System.out.println("Enter item details as itid,name,cost");
				int num = s.nextInt();
				String name=s.next();
				int cost=s.nextInt();
				sb.setItid(num);
				sb.setName(name);
				sb.setCost(cost);
				int insertion=d.itemInsert(sb);
				if(insertion>0)
				{
					System.out.println("Insertion Successfull");
					
				}
				else
				{
					System.out.println("Inserion Failed");
				}
				break;
			case 2:
				d.itemDisplay();
				break;
			case 3:
				int total=d.totalCost();
				if(total>0)
				{
					System.out.println("total cost");
				}
				else
				{
					System.out.println("total cost cannot be displayed");
				}
				break;
			case 4:
				System.out.println("visit again:)");
				System.exit(0);
			default:
				System.out.println("enter a valid option");
				
			}
		}
	}

}
