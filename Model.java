import java.util.Random;

public class Model
{
	private boolean[] mapa = new boolean[36];
	private Random losuj = new Random();
	private int miny = 0;
	
	public Model() 
	{
		losujMape();
	}
	
	public void losujMape()
	{
				for (int i = 0; i<mapa.length; i++)
		{
		if (losuj.nextInt(20)>1) mapa[i]=false;
		else mapa[i]=true;
		}
	}

	public boolean getMina(int i)
	{
		return mapa[i];
	}
	
	public int getMiny()
	{
		miny = 0;
		for (int i = 0; i < mapa.length; i++)
		{
			if (mapa[i]) miny++;
		}
		return miny;
	}
}
