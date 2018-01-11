package Crypt;

public class Desencriptador {

	//AQUI SE DEFINIR� LAS VARIABLES A UTILIZAR
	
	//AQU� LAS INICIALIZACIONES
	public Desencriptador() {
	}
	
	/**
	 * En esta funci�n implementaremos nuestro proceso de desencriptaci�n a partir
	 * de la frase de entrada
	 *
	 * @param  frase un String que contendr� la frase a desencriptar
	 * @return       el String desencriptado
	 */
	public String desencriptarFrase(String frase) {
		
		char letra=1;
		int auxLetra;
		String fraseADecod="";
		int trigger=0;
		int numRnd=0;
		String fraseDecod="";
		
		for (int cont=0; cont<frase.length(); cont++)
		{
			auxLetra=frase.charAt(cont);
			
			if (frase.charAt(cont)=='�')
			{
				trigger++;
			}
			
			if (trigger<1)
			{
				fraseADecod+=frase.charAt(cont);
			}
			
			if ((trigger==2) && Character.isDigit(frase.charAt(cont)))
			{
				numRnd*=10;
				numRnd+=Character.getNumericValue(frase.charAt(cont));
			}
		}
		
		System.out.println(numRnd);
		System.out.println(fraseADecod);
		
		for (int cont=0; cont<fraseADecod.length(); cont++)
		{
			auxLetra=frase.charAt(cont)+cont-numRnd;
			if (auxLetra>126)
			{
				auxLetra-=94;
			}
			if (auxLetra<32)
			{
				auxLetra+=94;
			}
			
			letra=(char)auxLetra;
			if (letra=='~')
			{
				letra=' ';
			}
			fraseDecod+=letra;
		}
		
		System.out.println(fraseDecod);
		
		return fraseDecod;
	}

}
