
public class PruebaHilos {
	


	
	public static void main(String[] args) {
	
		int tamanyo=10000000;
		int hilos=10;
		
		int[] a=new int[tamanyo];
		int[] b=new int[tamanyo];
		int[] r=new int[tamanyo];
		
		Hilos[] hs=new Hilos[hilos];
		
		for(int i=0; i<tamanyo; i++)
		{
			a[i]=(int)(Math.random()*100);
			b[i]=(int)(Math.random()*100);
		}
		
		long inicio=System.currentTimeMillis();
		
		for(int i=0; i<hilos; i++)
		{
				hs[i]=new Hilos(a, b, r, i, tamanyo, hilos);
				hs[i].start();
		}
		
		for(int i=0; i<hilos; i++)
		{
			try {
				hs[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		long fin=System.currentTimeMillis();
		
		long tiempo=fin-inicio;
		
		System.out.println("El array resultado es: ");
	
		
		int j=1;
		for(int i=0; i<tamanyo; i++)
		{
			System.out.print("num: " + (i+1) + ": " + r[i] + ", " + a[i] + "+" + b[i] + "=" + r[i] + "; ");
			j++;
			
			if(j==10)
			{
				System.out.println();
				j=1;
			}
		}
		
		
		
		System.out.println("\n\nEl tiemmpo empleado con hilos es: " + tiempo + " Milisegundos.");
		
		for(int i=0; i<tamanyo; i++)
		{
			r[i]=0;
		}
		
		inicio=System.currentTimeMillis();

		
		for(int i=0; i<tamanyo; i++)
		{
			//if(a[i]%2==0 && b[i]%2==0)
				r[i]=a[i]+b[i];
		}
		
		System.out.println("\nInicio: " + inicio);
		
		fin=System.currentTimeMillis();
		
		System.out.println("Fin: " + fin);
		
		tiempo=fin-inicio;
		
		System.out.println("\n\nEl tiemmpo empleado sin hilos es: " + tiempo + " Milisegundos.");
	}

}
