import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class View extends JFrame implements ActionListener,Observable
{
	private JButton[] przycisk = new JButton [36];
	private JLabel lIlosc;
	private JLabel iloscMin;
	private JLabel lMiny;
	private int miny;
	
	Model model;
	
	ArrayList<Observer> observers = new ArrayList<Observer>();
	
	Object source;
	
public View(Model model)
{
	this.model = model;
	
	setSize(500,500);
	setLocation(400,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setLayout(new GridLayout(7,6));
	for (int i = 0; i < przycisk.length; i++)
	{
		przycisk[i]= new JButton();
		przycisk[i].setBackground(Color.GREEN);
		add(przycisk[i]);
		przycisk[i].addActionListener(this);
	}
	lIlosc = new JLabel("Ilość min:");
	add(lIlosc);
	getMiny();
	lMiny = new JLabel(Integer.toString(miny));
	add(lMiny);
}

public void getMiny()
{
	miny = model.getMiny();
}

public void setStringLminy()
{
	lMiny.setText(Integer.toString(miny));
}

public int przyciskLength()
{
	return przycisk.length;
}

public void przyciskSetBackground(int i, Color color)
{
	przycisk[i].setBackground(color);
}

public boolean checkPrzycisk(int i)
{
	boolean check;
	if (source == przycisk[i]) check = true;
	else check = false;
	return check;
}

@Override
public void actionPerformed(ActionEvent e)
{
	source = e.getSource();
	notifyObserver();
}

@Override
public void addObserver(Observer o)
{
	observers.add(o);	
}

@Override
public void remoweObserver(Observer o)
{
	int index = observers.indexOf(o);
	observers.remove(index);
}

@Override
public void notifyObserver()
{
	for (Observer o : observers)
			o.update();
}

}