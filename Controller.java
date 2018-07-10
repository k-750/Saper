import java.awt.Color;

import javax.swing.JOptionPane;

public class Controller implements Observer
{
	Model model;
	View view;
	
	public Controller (Model model, View view)
	{
		this.model = model;
		this.view = view;
	}
	
	public void wybuch()
	{
		for (int i =0; i<view.przyciskLength(); i++)
		{
			if (model.getMina(i)) view.przyciskSetBackground(i,Color.RED);
		}
		JOptionPane.showMessageDialog(null, "BUUUUUM", "Wyleciałeś w powietrze",JOptionPane.INFORMATION_MESSAGE);
		for (int i = 0; i < view.przyciskLength(); i ++) view.przyciskSetBackground(i, Color.GREEN);
		model.losujMape();
		view.getMiny();
		view.setStringLminy();
	}

	@Override
	public void update()
	{
		{
			for (int i = 0; i<view.przyciskLength() ; i++)
			{
				if (view.checkPrzycisk(i)) 
				{
					if (model.getMina(i)==true) wybuch();
					else view.przyciskSetBackground(i, Color.WHITE);
				}
			}
		}		
	}
}
