import java.util.Random;
import javax.swing.JOptionPane;


public class Pole


{
	int[][] tab ;
	boolean poz;
	int X , Y , ilosc ;
	statek[] S;
	private int szer ,wys;
	Random r = new Random();
	int liczbaelementuw=0;
	

	
	Pole(int szer, int wys)
	{	
		this.wys=wys;
		this.szer=szer;
		
		rozmieszczenielosowe();
		
		
	}
	
	void rozmieszczenielosowe()
	{
		
		tab=new int[szer][wys];
		ilosc=10;
		S = new statek[ilosc];	
		for (int i=0 ;i<10 ;i++)
		{
			S[i]= new statek();
		}
		
		czysc();
		
		
		
		
			
			
			S[0].ustawStatek(4);			
			S[1].ustawStatek(3);			
			S[2].ustawStatek(3);			
			S[3].ustawStatek(2);
			
			S[4].ustawStatek(2);
			
			S[5].ustawStatek(2);
			
			S[6].ustawStatek(1);
			
			S[7].ustawStatek(1);
			
			S[8].ustawStatek(1);
			
			S[9].ustawStatek(1);
			
			for(int i=0 ;i<10 ;i++)
			{
				
				X=r.nextInt((szer)-S[i].rozmiar);
				Y=r.nextInt((wys)-S[i].rozmiar);
				sprawc(i);
				
			}
	
		
		
		
		
		
		
	}

	void sprawc( int i)
	{
		

		if(S[i].poziomo==true && tab[Y][X]==0 && tab[Y+1][X]==0 && tab[Y][X+1]==0 && tab[Y+1][X+1]==0 
				&& X!=0 && Y!=0 && tab[Y-1][X-1]==0&& tab[Y][X-1]==0 && tab[Y-1][X]==0
				&& tab[Y-1][X+1]==0&& tab[Y+1][X-1]==0  && tab[Y-1][X+S[i].rozmiar]==0
				&& tab[Y+1][X+S[i].rozmiar]==0 && tab[Y-1][X+S[i].rozmiar-1]==0
				&& tab[Y+1][X+S[i].rozmiar-1]==0 && tab[Y][X+S[i].rozmiar]==0)
		{
			ustaw(X,Y,S[i].rozmiar,S[i].poziomo);
		}
		else if(S[i].poziomo==false && tab[Y][X]==0 && tab[Y+1][X]==0 && tab[Y][X+1]==0 && tab[Y+1][X+1]==0 
				&& X!=0 && Y!=0 && tab[Y-1][X-1]==0&& tab[Y][X-1]==0 && tab[Y-1][X]==0
				&& tab[Y-1][X+1]==0&& tab[Y+1][X-1]==0 && tab[Y+S[i].rozmiar][X-1]==0
				&& tab[Y+S[i].rozmiar][X+1]==0 && tab[Y+S[i].rozmiar-1][X-1]==0
						&& tab[Y+S[i].rozmiar-1][X+1]==0&& tab[Y+S[i].rozmiar][X]==0)
		{
			ustaw(X,Y,S[i].rozmiar,S[i].poziomo);
		}
		
		else
		{
			S[i].losuj();
			X=r.nextInt((szer)-S[i].rozmiar);
			Y=r.nextInt((wys)-S[i].rozmiar);
			sprawc(i);
		}
		
	

	
			
	}
	

	
	


	void ustaw(int x ,int y,int roz,boolean poz)
	{
		if(poz==true)
			for(int i=x ; i<x+roz ;  i++)
			tab[y][i]=1;
		else
			for(int i=y ; i<y+roz ;  i++)
				tab[i][x]=1;
	}
	
	
	
	void rozmieszczeniere(int y ,int x, int wartosc)
	{
		if(liczbaelementuw <20 && tab[y][x] !=wartosc && wartosc==1)
		{
		tab[y][x]=wartosc;
		liczbaelementuw++;
		}
		else if(liczbaelementuw <20 && tab[y][x] !=wartosc && wartosc==0)
		{
		tab[y][x]=wartosc;
		liczbaelementuw--;
		}
	
	
	}
	
	void SprawcStan(String s)
	{
	
		liczbaelementuw--;
		if(liczbaelementuw==0)
		{
			JOptionPane.showMessageDialog(null, "Koniec gry "+ s);
		}
		
	}
	
	
	void czysc()
	{
		for	(int j=0 ;j<10 ;j++)
		{
		for (int i=0 ;i<10 ;i++)
		{
			tab[j][i] = 0;
			
		}			
		}
		liczbaelementuw =0;
	}
	
	

	
	
	
	
}
	

