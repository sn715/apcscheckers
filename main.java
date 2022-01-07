package checkers;

import java.util.ArrayList;
import java.util.Scanner;

public class main 
{
	public static void main(String[] args)
	{

		//player turns

		Scanner eyeball = new Scanner(System.in);
		
		Boolean notOver = true;
		Boolean winner = false;
		
		board b = new board();
		
		//12 x pieces
		pieces x1 = new pieces(0, 1, false, "x");
		//pieces x1 = new pieces(3, 2, false, "x");
		pieces x2 = new pieces(0, 3, false, "x");
		pieces x3 = new pieces(0, 5, false, "x");
		pieces x4 = new pieces(0, 7, false, "x");
		pieces x5 = new pieces(1, 0, false, "x");
		pieces x6 = new pieces(1, 2, false, "x");
		pieces x7 = new pieces(1, 4, false, "x");
		pieces x8 = new pieces(1, 6, false, "x");
		pieces x9 = new pieces(2, 1, false, "x");
		pieces x10 = new pieces(2, 3, false, "x");
		pieces x11 = new pieces(2, 5, false, "x");
		pieces x12 = new pieces(2, 7, false, "x");
		
		ArrayList<pieces> x = new ArrayList();
		x.add(x1);
		x.add(x2);
		x.add(x3);
		x.add(x4);
		x.add(x5);
		x.add(x6);
		x.add(x7);
		x.add(x8);
		x.add(x9);
		x.add(x10);
		x.add(x11);
		x.add(x12);
			
		//12 o pieces (front end of board bottom up left to right)
		pieces o1 = new pieces(7, 0, false, "o");
		//pieces o1 = new pieces(4, 3, false, "o");
		pieces o2 = new pieces(7, 2, false, "o");
		pieces o3 = new pieces(7, 4, false, "o");
		pieces o4 = new pieces(7, 6, false, "o");
		pieces o5 = new pieces(6, 1, false, "o");
		pieces o6 = new pieces(6, 3, false, "o");
		pieces o7 = new pieces(6, 5, false, "o");
		pieces o8 = new pieces(6, 7, false, "o");
		pieces o9 = new pieces(5, 0, false, "o");
		pieces o10 = new pieces(5, 2, false, "o");
		pieces o11 = new pieces(5, 4, false, "o");
		pieces o12 = new pieces(5, 6, false, "o");
		
		ArrayList<pieces> o = new ArrayList();
		o.add(o1);
		o.add(o2);
		o.add(o3);
		o.add(o4);
		o.add(o5);
		o.add(o6);
		o.add(o7);
		o.add(o8);
		o.add(o9);
		o.add(o10);
		o.add(o11);
		o.add(o12);
		
		b.set(x1);
		b.set(x2);
		b.set(x3);
		b.set(x4);
		b.set(x5);
		b.set(x6);
		b.set(x7);
		b.set(x8);
		b.set(x9);
		b.set(x10);
		b.set(x11);
		b.set(x12);
		
		b.set(o1);
		b.set(o2);
		b.set(o3);
		b.set(o4);
		b.set(o5);
		b.set(o6);
		b.set(o7);
		b.set(o8);
		b.set(o9);
		b.set(o10);
		b.set(o11);
		b.set(o12);
		
		b.showBoard();
		
		/*
		System.out.println();
		System.out.println("======");
		System.out.println();
		
		//b.move(x1, 5, 4);
		
		b.showBoard();
		*/
		
		while(notOver)
		{
			boolean valid = false;
			
			//player-1
			while (!valid)
			{
				System.out.println("count from 1");
				System.out.println("player 1: enter the initial x-coordinate");
				int icol1 = eyeball.nextInt();
				eyeball.nextLine();

				System.out.println("player 1: enter the initial y-coordinate");
				int irow1 = eyeball.nextInt();
				eyeball.nextLine();
				
				System.out.println("player 1: enter the final x-coordinate");
				int fcol1 = eyeball.nextInt();
				eyeball.nextLine();

				System.out.println("player 1: enter the final y-coordinate"); 
				int frow1 = eyeball.nextInt();
				eyeball.nextLine();
				
				pieces px = new pieces();
				for (pieces temp: x)
				{
					if (temp.getX() == irow1 - 1 && temp.getY() == icol1 - 1)
					{
						px = temp;
					}
				}
				 /*1: 2,1
				if (b.testMove(px, frow1-1, fcol1-1) == false)
				{
					valid = false;
				}
				else
				{
					b.move(px, frow1-1, fcol1-1);
					valid = true;
				}*/
				
				valid = b.move(px, frow1-1, fcol1-1);
				
				b.showBoard();
			}
			
			
			valid = false;
			//player2
			while (!valid)
			{
				System.out.println("count from 1");
				System.out.println("player 2: enter the initial x-coordinate"); 
				int icol2 = eyeball.nextInt();
				eyeball.nextLine();
	
				System.out.println("player 2: enter the initial y-coordinate"); //2
				int irow2 = eyeball.nextInt();
				eyeball.nextLine();
				
				System.out.println("player 2: enter the final x-coordinate"); //4
				int fcol2 = eyeball.nextInt();
				eyeball.nextLine();
	
				System.out.println("player 2: enter the final y-coordinate"); //3
				int frow2 = eyeball.nextInt();
				eyeball.nextLine();
				
				pieces po = new pieces();
				for (pieces temp: o)
				{
					if (temp.getX() == irow2 - 1 && temp.getY() == icol2 - 1)
					{
						po = temp; 
					}
				}
				valid = b.move(po, frow2 - 1, fcol2 - 1);
				
				//b[frow2][fcol2] = 
				
				b.showBoard();
				
				/*
				if (b.move(po, frow2 - 1, fcol2 - 1) == false)
				{
					valid = false;
				}
				else
				{
					b.move(po, frow2 - 1, fcol2 - 1);
					valid = true;
				}
				 b.showBoard();
				*/
			}
			
			if (x.size() == 0 || o.size() == 0)
			{
				notOver = false;
			}
		}		
	}
}