package checkers;

import java.util.*;

public class pieces 
{
	  private int xCor;
	  private int yCor;
	  private boolean king;
	  private String piece;
	  
	  public pieces()
	  {
	    xCor = 0;
	    yCor = 0;
	    king = false;
	    piece = " ";
	  }
	  
	  public pieces( int x, int y, boolean b, String p)
	  {
	    xCor = x;
	    yCor = y;
	    king = b;
	    piece = p;
	  }
	  
	  //getters
	  public int getX()
	  {
	    return xCor;
	  }
	  
	  public int getY()
	  {
	    return yCor;
	  }
	  
	  public boolean kingStatus()
	  {
	    return king;
	  }
	  
	  public String getPiece()
	  {
	    return piece;
	  }
	  
	  //setters
	  public void setX(int x)
	  {
	    xCor = x;
	  }
	  
	  public void setY(int y)
	  {
	    yCor = y;
	  }
	  
	  public void makeKing(boolean k)
	  {
	    king = k;
	  }
	  
	  public void setPiece(String p)
	  {
	    piece = p;
	  }
}
