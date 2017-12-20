package Crypt;

import java.util.Scanner;

public class Desencriptador {

	//AQUI SE DEFINIRÁ LAS VARIABLES A UTILIZAR
	Scanner sc=new Scanner(System.in);
	String fraseADecodear;
	String fraseDecodeada="";
	int valorCharAnterior=0;
	int valorCharActual=0;
	//AQUÍ LAS INICIALIZACIONES
	
	public Desencriptador() {
	}
	
	/**
	 * En esta función implementaremos nuestro proceso de desencriptación a partir
	 * de la frase de entrada
	 *
	 * @param  frase un String que contendrá la frase a desencriptar
	 * @return       el String desencriptado
	 */
	public String desencriptarFrase(String frase) {
		
		
		
		fraseADecodear=frase;
		
		char caracter[]=new char[fraseADecodear.length()];
		for (int cont=0; cont<fraseADecodear.length(); cont++)
		{
			caracter[cont]=fraseADecodear.charAt(cont);
		}
		
		int inicioDecodeDerecha=fraseADecodear.length()/2;
		int inicioDecodeIzquierda=inicioDecodeDerecha-1;
		for (int cont=0; cont<fraseADecodear.length();cont++)
		{
				if (cont%2==0)
				{
					fraseDecodeada+=caracter[inicioDecodeDerecha];
					inicioDecodeDerecha++;
				}
				if (cont%2!=0)
				{
					fraseDecodeada+=caracter[inicioDecodeIzquierda];
					inicioDecodeIzquierda--;
				}
		}
		fraseADecodear=fraseDecodeada;
		fraseDecodeada="";
		
		for (int cont=0; cont<fraseADecodear.length(); cont++)
		{
			caracter[cont]=fraseADecodear.charAt(cont);
		}
		
		for (int cont=0; cont<fraseADecodear.length(); cont++)
		{
			if (cont!=0)
			{
				valorCharAnterior=caracter[cont-1];
			}
			valorCharActual=caracter[cont];
			valorCharActual-=valorCharAnterior;
			
			while (valorCharActual<32)
			{
				valorCharActual+=95;
			}
			caracter[cont]=0;
			caracter[cont]+=valorCharActual;
		}
		
		for (int cont=0; cont<fraseADecodear.length(); cont++)
		{
			fraseDecodeada+=caracter[cont];
		}
		
		frase=fraseDecodeada;
	
		return frase;
	}

}
