
public class Hilos extends Thread {

	private int[] ha;
	private int[] hb;
	private int[] hr;
	private int hilo=0;
	private int tamanyo=0;
	private int tamh=0;
	
	public Hilos(int[] a, int[] b, int[] r, int i, int f, int tamh)
	{

			ha=a;
			hb=b;
			hr=r;
			hilo=i;
			tamanyo=f;
			this.tamh=tamh;
	}

	@Override
	public void run()
	{
		for(int i=hilo*tamh; i<(hilo+1)*(tamanyo/tamh); i++)
		{
			//if(ha[i]%2==0 && hb[i]%2==0)
				hr[i]=ha[i]+hb[i];
		}
	}
}
