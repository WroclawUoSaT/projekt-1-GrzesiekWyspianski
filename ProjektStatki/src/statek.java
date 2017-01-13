import java.util.Random;


public class statek 
{
	 boolean poziomo;
	 int rozmiar;
	 int X ,Y;
	
	statek()
	{
		poziomo= true;
		rozmiar= 1;	
		
				
	}
	statek(int x)
	{
		poziomo= true;
		rozmiar= x;	
		
				
	}
	
	statek(int x, int y)
	{
		poziomo= true;
		rozmiar= 1;
		X=x;
		Y=x;
		
				
	}
	
	void ustawStatek(int X,int Y)
	{
		this.X=Y;
		this.Y=Y;
	}
	void ustawStatek(int rozmiar)
	{
		this.rozmiar=rozmiar;
		losuj();
		
	}
	
	void ustawStatek(boolean poziomo, int X,int Y,int rozmiar )
	{
		this.poziomo=poziomo;
		this.rozmiar=rozmiar;
		this.X=Y;
		this.Y=Y;
	}
	

	void losuj()
	{
		int x=0;
		Random r = new Random();
		x=r.nextInt(2);
		if(x==1)
		poziomo= true;
		else
		poziomo= false;
		
	}
}
