package Crypt;

import java.util.Random;

public class Encriptador {

	public Encriptador() {
		
	}
	
	/**
	 * En esta función implementaremos nuestro proceso de encriptcaión a partir
	 * de la frase de entrada
	 *
	 * @param  frase un String que contendrá la frase a encriptar
	 * @return       el String encriptado
	 */
	public String encriptarFrase(String frase) {
		
		int ascii=1;
		int aux=1;
		int numLetras=frase.length();
		char letra=1;
		int indiceLargos=0;
		int indiceCortos=1;
		String fraseCod="";
		
		String[] posError=new String[numLetras];
		
		Random rand=new Random();
		int num=rand.nextInt(15)+1;
		
		for (int cont=0; cont<numLetras; cont++)
		{
			letra=frase.charAt(cont);
			int aux2=letra;
			
			if (aux2>126 || aux2<32)
			{
				return frase="error";
			}
			else
			{
				ascii=letra-cont+num;
				
				if (ascii>126)
				{
					posError[indiceLargos]=""+cont;
					indiceLargos+=2;
					ascii-=94;
				}
				
				if (ascii<32)
				{
					posError[indiceCortos]=""+cont;
					indiceCortos+=2;
					ascii+=94;
				}
				
				letra=(char)ascii;
				fraseCod+=letra;
			}
		}
		
		System.out.println(fraseCod);
		
		String posErrorString="";
		
		for (int i=0; i<posError.length; i++)
		{
			if (posError[i]==null)
			{
				posError[i]="å";
			}
			
			if (i==posError.length-1)
			{
				posErrorString+=posError[i];
			}
			else
			{
				posErrorString+=posError[i]+"-";
			}
		}
		
		return fraseCod+"º"+posErrorString+"º"+num+"º";
	}

}
