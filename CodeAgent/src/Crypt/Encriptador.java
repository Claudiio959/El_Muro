package Crypt;

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
		
		String fraseACodificar=frase;
		int sumaAux;
		int sumaChar=0;
		
		// Primero descomponemos la frase, cada letra, un char
				char caracter[]=new char[fraseACodificar.length()];
				for (int cont=0; cont<fraseACodificar.length(); cont++)
				{
					caracter[cont]=fraseACodificar.charAt(cont);
				}
				
				// El valor del char de la izquierda se le suma al de la derecha, menos la primera vez evidentemente
				
				for (int cont=0; cont<fraseACodificar.length(); cont++)
				{
					sumaAux=caracter[cont];
					caracter[cont]+=sumaChar;
					sumaChar=sumaAux;
					
					// Solo trabajamos con los caracteres imprimibles del código ASCII(del 32 al 126) de forma que si el valor númerico del caracter[cont] es mayor de 126, le vamos restando 95, hasta dar con un char entre 126 y 32(127-95=32)
					while (caracter[cont]>126)
					{
						caracter[cont]-=95;
					}
				}
				
				// Montamos frase de nuevo, la liamos un poco, si char[cont] es par, irá a la derecha, si es impar, a la izquierda, de forma que las primeras letras quedarán centradas y viceversa;
				String fraseAuxiliar=fraseACodificar;
				fraseACodificar="";
				for (int cont=0; cont<fraseAuxiliar.length(); cont++)
				{
					if (cont%2==0)
					{
						fraseACodificar+=caracter[cont];
					}
					else
					{
						fraseACodificar=caracter[cont]+fraseACodificar;
					}
				}
				
				System.out.println(fraseACodificar);
				frase=fraseACodificar;
		
		return frase;
	}

}
