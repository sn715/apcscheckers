package checkers;

import java.util.ArrayList;

public class board 
{
	private pieces[][] b; 
	
	public board()
	{
		b = new pieces[8][8];
	}

	private boolean empty(int row, int col) 
	{
        if (b[row][col] == null)
        {
        	return true;
        }
        else
        {
        	return false;
        }
	}
	
	private boolean isX(int row, int col) 
	{
		pieces p = b[row][col]; //new pieces();
        if (p != null)
        {
        	if (p.getPiece() == "x")
        	{
        		return true;
        	}
        	else
        		return false;
        }
        else
        {
        	return false;
        }
	}
	
	private boolean isO(int row, int col) 
	{
		pieces p = b[row][col];
        if (p != null)
        {
        	if (p.getPiece() == "o")
        	{
        		return true;
        	}
        	else
        		return false;
        }
        else
        {
        	return false;
        }
	}

	public void set(pieces p)
    {
		if(empty(p.getX(), p.getY())) 
		{
			b[p.getX()][p.getY()] = p;
	    } 
		else 
	    {
            System.out.println("invalid move: please try again");
        }
    }
	
	public boolean testMove(pieces p, int x, int y)
    {

		boolean ret = true;
		
		if (p.getPiece() == "x" && p.kingStatus() == false)
		{
			if ((x == p.getX() + 1) && (y == p.getY() + 1 || y == p.getY() - 1) && empty(x, y)) 
			{

			}
			else if ((x == p.getX() + 2) && y == p.getY() + 2 && isO(x-1, y-1) == true) 
			{

			}
			else if ((x == p.getX() - 2) && y == p.getY() + 2 && isO(x+1, y-1) == true) 
			{

			}
			else 
		    {
	            ret = false;
	        }
		}
		else if (p.getPiece() == "o" && p.kingStatus() == false)
		{
			if ((x == p.getX() + 1 || x == p.getX() - 1) && y == p.getY() - 1 && empty(x, y)) 
			{
				b[p.getX()][p.getY()] = null;
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() + 2) && y == p.getY() - 2 && isX(x-1, y+1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				//b[p.getX() + 1][p.getY() - 1] = null;
				remove(p.getX() + 1, p.getY() - 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() - 2) && y == p.getY() - 2 && isX(x+1, y+1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				b[p.getX() - 1][p.getY() + 1] = null;
				remove(p.getX() - 1, p.getY() + 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else 
		    {
	            System.out.println("err001:: invalid move: please try again");
	            ret = false;
	        }
		}
		else if (p.getPiece() == "x" && p.kingStatus() == true)
		{
			if ((x == p.getX() + 1 || x == p.getX() - 1) && (y == p.getY() + 1 || y == p.getY() - 1) && empty(x, y)) 
			{
				b[p.getX()][p.getY()] = null;
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			//jumps
			else if ((x == p.getX() + 2) && (y == p.getY() + 2 || y == p.getY() + 2) && isO(x-1, y-1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				//b[p.getX() + 1][p.getY() + 1] = null;
				remove(p.getX() + 1, p.getY() + 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() - 2) && (y == p.getY() + 2 || y == p.getY() + 2) && isO(x+1, y-1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				//b[p.getX() - 1][p.getY() + 1] = null;
				remove(p.getX() - 1, p.getY() + 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else 
		    {
	            System.out.println("err002:: invalid move: please try again");
	            ret = false;
	        }
		}
		else if (p.getPiece() == "o" && p.kingStatus() == false)
		{
			if ((x == p.getX() + 1 || x == p.getX() - 1) && y == p.getY() - 1 && empty(x, y)) 
			{
				b[p.getX()][p.getY()] = null;
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() + 2) && y == p.getY() - 2 && isX(x-1, y+1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				//b[p.getX() + 1][p.getY() - 1] = null;
				remove(p.getX() + 1, p.getY() - 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() - 2) && y == p.getY() - 2 && isX(x+1, y+1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				b[p.getX() - 1][p.getY() + 1] = null;
				remove(p.getX() - 1, p.getY() + 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else 
		    {
	            System.out.println("err003:: invalid move: please try again");
	            ret = false;
	        }
		}
		else 
	    {
            System.out.println("err004:: invalid move: please try again");
            ret = false;
        }
		
		return ret;
    }

	public boolean move(pieces p, int x, int y)
    {

		boolean ret = true;
		
		if (p.getPiece() == "x" && p.kingStatus() == false)
		{
			if ((x == p.getX() + 1) && (y == p.getY() + 1 || y == p.getY() - 1) && empty(x, y)) 
			{
				b[p.getX()][p.getY()] = null;
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() + 2) && y == p.getY() + 2 && isO(x-1, y-1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				remove(p.getX() + 1, p.getY() + 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() - 2) && y == p.getY() + 2 && isO(x+1, y-1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				remove(p.getX() - 1, p.getY() + 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else 
		    {
	            System.out.println("err000:: invalid move: please try again");
	            ret = false;
	        }
		}
		else if (p.getPiece() == "o" && p.kingStatus() == false)
		{
			if ((x == p.getX() + 1 || x == p.getX() - 1) && y == p.getY() - 1 && empty(x, y)) 
			{
				b[p.getX()][p.getY()] = null;
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() + 2) && y == p.getY() - 2 && isX(x-1, y+1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				//b[p.getX() + 1][p.getY() - 1] = null;
				remove(p.getX() + 1, p.getY() - 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() - 2) && y == p.getY() - 2 && isX(x+1, y+1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				b[p.getX() - 1][p.getY() + 1] = null;
				remove(p.getX() - 1, p.getY() + 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else 
		    {
	            System.out.println("err001:: invalid move: please try again");
	            ret = false;
	        }
		}
		else if (p.getPiece() == "x" && p.kingStatus() == true)
		{
			if ((x == p.getX() + 1 || x == p.getX() - 1) && (y == p.getY() + 1 || y == p.getY() - 1) && empty(x, y)) 
			{
				b[p.getX()][p.getY()] = null;
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			//jumps
			else if ((x == p.getX() + 2) && (y == p.getY() + 2 || y == p.getY() + 2) && isO(x-1, y-1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				//b[p.getX() + 1][p.getY() + 1] = null;
				remove(p.getX() + 1, p.getY() + 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() - 2) && (y == p.getY() + 2 || y == p.getY() + 2) && isO(x+1, y-1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				//b[p.getX() - 1][p.getY() + 1] = null;
				remove(p.getX() - 1, p.getY() + 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else 
		    {
	            System.out.println("err002:: invalid move: please try again");
	            ret = false;
	        }
		}
		else if (p.getPiece() == "o" && p.kingStatus() == false)
		{
			if ((x == p.getX() + 1 || x == p.getX() - 1) && y == p.getY() - 1 && empty(x, y)) 
			{
				b[p.getX()][p.getY()] = null;
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() + 2) && y == p.getY() - 2 && isX(x-1, y+1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				//b[p.getX() + 1][p.getY() - 1] = null;
				remove(p.getX() + 1, p.getY() - 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else if ((x == p.getX() - 2) && y == p.getY() - 2 && isX(x+1, y+1) == true) 
			{
				b[p.getX()][p.getY()] = null;
				b[p.getX() - 1][p.getY() + 1] = null;
				remove(p.getX() - 1, p.getY() + 1);
				p.setX(x);
				p.setY(y);
				b[x][y] = p;
			}
			else 
		    {
	            System.out.println("err003:: invalid move: please try again");
	            ret = false;
	        }
		}
		else 
	    {
            System.out.println("err004:: invalid move: please try again");
            ret = false;
        }
		
		return ret;
    }
	
	
	
    public void showBoard() 
    {
	    for(int i = 0; i < b.length; i++) 
	    {
	    	for(int j = 0; j < b[0].length; j++) 
	    	{
		   		pieces piece = b[i][j];
		   		if (piece == null) 
		        {
		          	System.out.print("|_|");
		        }
		        else 
		        {
	            	System.out.print("|" + piece.getPiece() + "|");
		        }
		    }
	    	System.out.println();
	    }
    }
    
    public void remove(int x, int y) 
    {
        b[x][y] = new pieces();
    }
    
    public void possibleMove(pieces[] m)
    {	
    	int counter = 0;
    	
		for (int i = 0; i < m.length; i++)
    	{
			if (m[i].getPiece() == "x")
			{
				if (isX(m[i].getX() + 1, m[i].getY()+1)) /* (empty(m[i].getX() + 2, m[i].getY() + 2) == false  */
	    		{
	    			counter++;
	    		}
			}    		
    	}
    	
    }
    
    
}
