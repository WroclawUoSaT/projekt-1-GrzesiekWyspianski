import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Pomoc extends JFrame implements ActionListener
{
	JButton koniecPomocy, zapisz;
	JTextField szer,wysok,rozmiar;
	int szerINT,wysokINT,rozmiarINT;

	Pomoc()	
{

	JFrame Pomoc = new JFrame(); 
	setSize(600,400);
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	setLayout(null);
	setVisible(true);		
	setTitle("Pomoc");
	
	JLabel napis=new JLabel("Gracz posiada plansze o wymiarach 10x10 p�l.Na jednym z kwadrat�w gracz zaznacza swoje statki,");		
	napis.setBounds(10, 10, 580, 20);
	add(napis);
	JLabel napisa=new JLabel("kt�rych po�o�enie b�dzie odgadywa� przeciwnik. Na drugim zaznacza trafione statki przeciwnika ");		
	napisa.setBounds(10, 30, 580, 20);		
	add(napisa);
	JLabel napisb=new JLabel("i oddane przez siebie strza�y. Statki ustawiane s� w pionie lub poziomie , w taki spos�b aby  ");		
	napisb.setBounds(10, 50, 580, 20);
	add(napisb);
	JLabel napisc=new JLabel("nie styka�y si� one ze sob� ani bokami, ani rogami. Okr�ty s� r�nej wielko�ci, wi�cej jest  ");		
	napisc.setBounds(10,70, 580, 20);		
	add(napisc);
	JLabel napisd=new JLabel("jednostek o mniejszej wielko�ci");		
	napisd.setBounds(10,90, 200, 20);		
	add(napisd);		
	JLabel napisqq=new JLabel("");		
	napisqq.setBounds(10,70, 200, 20);		
	add(napisqq);
	
	
	//przycisk zamykaj�cy okno pomocy 
	koniecPomocy = new JButton("Zako�cz ");
	koniecPomocy.setBounds(220,300, 120, 30);		
	add(koniecPomocy);
	koniecPomocy.addActionListener(this);
	
	//przyciski 
	JButton czerwony = new JButton();
	czerwony.setBounds(20,150, 40, 40);		
	add(czerwony);
	czerwony.setBackground(Color.red);
	
	JLabel napisred=new JLabel("- statel");		
	napisred.setBounds(70, 160, 580, 20);
	add(napisred);
	//przycisk niebieski
	JButton niebieski = new JButton();
	niebieski.setBounds(20,200, 40, 40);		
	add(niebieski);
	niebieski.setBackground(Color.blue);
	
	JLabel napisblue=new JLabel("- woda");		
	napisblue.setBounds(70, 210, 580, 20);
	add(napisblue);
	
	
			
}


public void actionPerformed(ActionEvent e) 
{
	Object z= e.getSource();
	if(z==koniecPomocy)
		dispose();

		
	
		
}	


}