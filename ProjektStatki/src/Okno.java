import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Okno extends JFrame implements ActionListener

{
	
	
	int szer , wys , wielkosc,klucz;

	JLabel napisnadpole , napisnadpoleprze, napisPodPolem,napisPodPo;
	JButton[][] tab1,tab2;	
	JMenuBar menu;
	JMenu menuPlik, menuNowaGra;	
	JMenuItem  mWyjscie,mPomoc, rozmlos,rozmre;
	JButton start;

	Pole gracz, pc;
	
	 String s, ss;

	
	
	
	
	
	Okno()
	{			
		setSize(600, 400);					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setVisible(true);
		setLayout(null);
		setTitle("Statki");
	}
	
	Okno(int x ,int y)
	{			
		setSize(x, y);			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setVisible(true);
		setLayout(null);
		setTitle("Statki");
		wielkosc= 20;			
							
	}
	
	void ustawPole(int szer,int wys ,int wielkosc  )
	{
		this.wielkosc= wielkosc;
		this.szer=szer;
		this.wys=wys;
	}
	
	// Napisy w polu ---------------------------------------------------------------------------------------------
	
	void napisy ()
	{
		napisnadpole=new JLabel("Pole Przeciwnika");		
		napisnadpole.setBounds((wielkosc*szer)/2, 10, 580, 20);
		add(napisnadpole);	
		napisnadpole.setVisible(false);
		
		napisnadpoleprze=new JLabel("Twoje Pole");		
		napisnadpoleprze.setBounds((7*szer* wielkosc)/4, 10, 580, 30);
		add(napisnadpoleprze);	
		napisnadpoleprze.setVisible(false);
		
		
		napisPodPolem=new JLabel("");
		napisPodPolem.setBounds((wielkosc*szer)/2,100+wielkosc*wys, 580, 20);
		add(napisPodPolem);
		napisPodPolem.setVisible(false);
		
		napisPodPo=new JLabel("");
		napisPodPo.setBounds((7*szer* wielkosc)/4,100+wielkosc*wys, 580, 20);
		add(napisPodPo);
		napisPodPo.setVisible(false);
	}
	
	private void pokarzNapisy(boolean x)
	{
		napisPodPo.setVisible(x);
		napisPodPolem.setVisible(x);
		napisnadpoleprze.setVisible(x);
		napisnadpole.setVisible(x);
		
	}
	
	// pole do gry ------------------------------------------------------------------------------------------
	
	void pole()
	{
		tab1 = new JButton[wys][szer];
		 tab2 = new JButton[wys][szer];	
		 
		 gracz= new Pole(wys,szer);
		 pc = new Pole(wys,szer);
		
	
		for	(int j=0 ;j<wys ;j++)
		{
		for (int i=0 ;i<szer ;i++)
		{
		tab1[j][i] = new JButton();	
		tab2[j][i] = new JButton();			
		add(tab2[j][i]);
		add(tab1[j][i]);				
		}
		}
		
		for(int j=0 ;j<wys ;j++)
		{
		for (int i=0;i<szer;i++)
		{
		tab1[j][i].setBounds(40+ wielkosc*i,40+ wielkosc*j, wielkosc, wielkosc);
		tab2[j][i].setBounds(100+ wielkosc*szer+wielkosc*i,40+ wielkosc*j, wielkosc, wielkosc);		
		add(tab2[j][i]);
		add(tab1[j][i]);
		tab1[j][i].addActionListener( this);
		tab2[j][i].addActionListener( this);
		tab1[j][i].setVisible(false);
		tab2[j][i].setVisible(false);
		
		
		}	
		}
	}
	// wyœwietlanie pola do gry i znikanie
	private void pokarzPole(boolean pokaz)
	{
		for(int j=0 ;j<szer ;j++)
		{
		for (int i=0;i<wys;i++)
		{
			tab1[j][i].setVisible(pokaz);
		}}
		
	}
	private void pokarzPoledwa(boolean pokaz)
	{
		for(int j=0 ;j<szer ;j++)
		{
		for (int i=0;i<wys;i++)
		{
			tab2[j][i].setVisible(pokaz);
		}}
	
		
	}
	// przycisk start------------------------------------------------------------------------------------------
	
	void przyciskStart()
	{
		start= new JButton("Start");
		start.setBounds(100+wielkosc*szer, 20+(wielkosc*wys)/2, 100, 40);
		add(start);
		start.setVisible(false);
		start.addActionListener(this);
		
	}

	//menu -------------------------------------------------------------------------------------------------------
	
	void menu()
	{
		menu = new JMenuBar();
		menuPlik = new JMenu("Plik");
			mWyjscie= new JMenuItem("Koniec gry");				
		menuNowaGra = new JMenu("Nowa gra");
			rozmlos= new JMenuItem("losowe rozmieszczenie statków");
			rozmre = new JMenuItem("rêczne rozmieszczenie statków");
			
		mPomoc= new JMenuItem("Pomoc");
		
		setJMenuBar(menu);
		menu.add(menuPlik);		
		menuPlik.add(menuNowaGra);		
		menuPlik.add(mPomoc);
		
		menuPlik.addSeparator();
		menuPlik.add(mWyjscie);
		menuNowaGra.add(rozmlos);
		menuNowaGra.add(rozmre);
		mWyjscie.addActionListener( this);
		mPomoc.addActionListener( this);
		rozmlos.addActionListener( this);
		rozmre.addActionListener( this);
		
	}
	
	private void tworzeniePomocy()
	{
		Pomoc pa = new Pomoc();
	}
	
	
	
//  Obs³uga zdarzen ------------------------------------------------------------------------------------------------	
	public void actionPerformed(ActionEvent e) 
	{
		Object z= e.getSource();
		if(z==start)	
		{
			pokarzNapisy(true);
	    	pokarzPoledwa(true);
	    	start.setVisible(false);
			klucz=1;
			gracz.rozmieszczenielosowe();
			for(int j=0 ;j<szer ;j++)
	 		{
	 		for (int i=0;i<wys;i++)
	 		{
	 			tab1[j][i].setBackground(Color.green);
	 		}}
			gracz.liczbaelementuw = 20;
			s=Integer.toString(gracz.liczbaelementuw);
			napisPodPolem.setText("pozosta³o "+s+"/20");
			ss=Integer.toString(pc.liczbaelementuw);
			napisPodPo.setText("pozosta³o "+ss+"/20");
	    	klucz=1;
	     maluj();
		  
		}
			
		
		if(z==mWyjscie)
			dispose();
	    if(z==mPomoc)
	    	tworzeniePomocy();
	    //  rozmieszczenie losowe ----------------------------------------------------------------------------------------------------
	    if(z==rozmlos)
	    {
	    	pokarzNapisy(true);
	    	pokarzPole(true);
	    	pokarzPoledwa(true);
	    	gracz.rozmieszczenielosowe();
	    	pc.rozmieszczenielosowe();
	    	pc.liczbaelementuw = 20;
	    	gracz.liczbaelementuw = 20;
	    	  maluj();
	    	s=Integer.toString(gracz.liczbaelementuw);
			napisPodPolem.setText("pozosta³o "+s+"/20");
			ss=Integer.toString(pc.liczbaelementuw);
			napisPodPo.setText("pozosta³o "+ss+"/20");
	    	klucz=1;
		  
	    }
	    //  rozmieszczenie rêczne ----------------------------------------------------------------------------------------------------
	    if(z==rozmre)
	    {	
	    	pc.czysc();
	    	gracz.czysc();
	    	pokarzNapisy(false);
	    	pokarzPoledwa(false);
	    	pokarzPole(true);
	    
	    	klucz=0;
	    	for(int j=0 ;j<szer ;j++)
			{
			for (int i=0;i<wys;i++)
			{
				tab2[j][i].setVisible(false);
			tab1[j][i].setVisible(true);
			tab1[j][i].setBackground(Color.BLUE);
			pc.tab[j][i]=0;
			
			}
			}
	    	
	    	start.setVisible(true);
	    }
	    if(klucz==0)
		    {
		    	for(int j=0 ;j<szer ;j++)
		  		{
		  		for (int i=0;i<wys;i++)
		  		{
		  		
		  			
		  			if(z==tab1[j][i] && pc.tab[j][i]==0)
		  			{
		  				pc.rozmieszczeniere(j, i, 1);
		  				tab1[j][i].setBackground(Color.RED);
		  			}
		  			else if(z==tab1[j][i]&&pc.tab[j][i]==1 )
		  			{
		  				pc.rozmieszczeniere(j, i, 0);
		  				tab1[j][i].setBackground(Color.BLUE);
		  			}
		  			
		  			
		  			
		  		}
		  		}
		    
		   }
	   
	  
	  
	    	
	    
	 // obs³uga zdarzen pola 
	    if(klucz==1)
	    {
	    for(int j=0 ;j<szer ;j++)
		{
		for (int i=0;i<wys;i++)
		{
			if(z==tab1[j][i] && gracz.tab[j][i]==1)
			{
				tab1[j][i].setBackground(Color.RED);
				gracz.tab[j][i]=2;
				ruchPC();
				gracz.SprawcStan("Wygra³es");
				s=Integer.toString(gracz.liczbaelementuw);
				napisPodPolem.setText("pozosta³o "+s+"/20");
				
				
			}
			if(z==tab1[j][i] && gracz.tab[j][i]==0)
			{
				tab1[j][i].setBackground(Color.BLUE);		
				gracz.tab[j][i]=2;
				ruchPC();
			}
			
		}
		}
	    }
	    
	    	
	    	
	}
	void ruchPC()
	{
	
		Random r = new Random();
		int x=r.nextInt(szer);
		int y=r.nextInt(wys);
		if( pc.tab[y][x]==2)
		{
			ruchPC();
		}
		if( pc.tab[y][x]==1)
		{
			tab2[y][x].setBackground(Color.RED);
			pc.tab[y][x]=2;
			pc.SprawcStan("Przegra³es");
			ss=Integer.toString(pc.liczbaelementuw);
			napisPodPo.setText("pozosta³o "+ss+"/20");
			
		}
		if( pc.tab[y][x]==0)
		{
			tab2[y][x].setBackground(Color.BLUE);
			pc.tab[y][x]=2;
		}

		
		
	
	}
	void maluj()
	{
	   	for(int j=0 ;j<szer ;j++)
		 		{
		 		for (int i=0;i<wys;i++)
		 		{
		 			if(pc.tab[j][i]==1)
		 			{
		 				tab2[j][i].setBackground(Color.pink);
		 				tab1[j][i].setBackground(Color.green);
		 				
		 			}
		 			else
		 			{
		 				tab2[j][i].setBackground(Color.BLACK);
		 				tab1[j][i].setBackground(Color.green);
		 			}
		 			
		 		}
		 		}
	}
	

}
