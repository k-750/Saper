import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Saper extends JFrame implements ActionListener 
	{
		private JButton[] przycisk = new JButton [36];
		private Mapa mapa;
		private JLabel lIlosc;
		private JLabel iloscMin;
		private JLabel lMiny;
		private int miny;
		
	public Saper()
	{
		setSize(500,500);
		setLocation(400,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(7,6));
		mapa = new Mapa();
		for (int i = 0; i < przycisk.length; i++)
		{
			przycisk[i]= new JButton();
			przycisk[i].setBackground(Color.GREEN);
			add(przycisk[i]);
			przycisk[i].addActionListener(this);
		}
		lIlosc = new JLabel("Ilość min:");
		add(lIlosc);
		miny = mapa.getMiny();
		lMiny = new JLabel(Integer.toString(miny));
		add(lMiny);
	}
	
	public static void main(String[] args) 
	{
		Saper p1 = new Saper();
	}
	
	public void wybuch()
	{
		for (int i =0; i<przycisk.length; i++)
		{
			if (mapa.getMina(i)) przycisk[i].setBackground(Color.RED);
		}
		JOptionPane.showMessageDialog(null, "BUUUUUM", "Wyleciałeś w powietrze",JOptionPane.INFORMATION_MESSAGE);
		for (int i = 0; i < przycisk.length; i ++) przycisk[i].setBackground(Color.GREEN);
		mapa.losujMape();
		miny = mapa.getMiny();
		lMiny.setText(Integer.toString(miny));
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		for (int i = 0; i<przycisk.length ; i++)
		{
			if (source == przycisk[i]) 
			{
				if (mapa.getMina(i)==true) wybuch();
				else przycisk[i].setBackground(Color.WHITE);
			}
		}
	}
	
}
