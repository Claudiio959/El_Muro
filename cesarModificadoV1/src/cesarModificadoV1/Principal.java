package cesarModificadoV1;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String alfabeto="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz0123456789";
		String alfabetoCod="";
		String fraseCodificada="";
		Scanner sc = new Scanner(System.in);
		int paso=0;
		int posicionLetra=0;
		
		do
		{
			System.out.println("Introduce el paso entre 1-10");
			paso=sc.nextInt();
		}
		while (paso<1 || paso>10);
		sc.nextLine();
		
		alfabetoCod=alfabetoCesar(paso, alfabeto);
		
		fraseCodificada=codificacionCesar(alfabetoCod, alfabeto, sc);
		
		codificacionEl_Muro(fraseCodificada, paso);
	}
	
	public static String alfabetoCesar(int paso, String alfabeto)
	{
		String alfabetoCod="";
		String alfabetoCodTemp="";
		
		for (int cont=0; cont<alfabeto.length()-paso; cont++)
		{
			alfabetoCod+=alfabeto.charAt(cont);
		}
		
		for (int cont=alfabeto.length()-paso; cont<alfabeto.length(); cont++)
		{
			alfabetoCodTemp+=alfabeto.charAt(cont);
		}
		
		alfabetoCod=alfabetoCodTemp+alfabetoCod;
		
		System.out.println(alfabetoCod);
		
		return alfabetoCod;
	}
	
	public static String codificacionCesar(String alfabetoCod, String alfabeto, Scanner sc)
	{
		int posicionLetra;
		String fraseCodificada="";
		String fraseCodificar;
		
		System.out.println("Introduce la frase a codificar");
		fraseCodificar=sc.nextLine();
		
		for (int cont=0; cont<fraseCodificar.length(); cont++)
		{
			posicionLetra=alfabeto.indexOf(fraseCodificar.charAt(cont));
			fraseCodificada=fraseCodificada+alfabetoCod.charAt(posicionLetra);
		}
		System.out.println(fraseCodificada);
		
		return fraseCodificada;
	}
	
	public static void codificacionEl_Muro(String fraseCodificada, int paso)
	{
		char caracter[]=new char[fraseCodificada.length()];
		int sumaChar=0;
		
		// Primero descomponemos la frase, cada letra, un char
		for (int cont=0; cont<fraseCodificada.length(); cont++)
		{
			caracter[cont]=fraseCodificada.charAt(cont);
			System.out.println(caracter[cont]);
		}
		
		// Acumulamos el valor númerico de cada char en un int, y se lo sumamos al caracter[cont], no lo hacemos en la primera pasada para que la desencriptación sea posible
		for (int cont=0; cont<fraseCodificada.length(); cont++)
		{
			caracter[cont]+=sumaChar;
			sumaChar+=caracter[cont];
			
			// Solo trabajamos con los caracteres imprimibles del código ASCII(del 32 al 126) de forma que si el valor númerico del caracter[cont] es mayor de 126, le vamos restando 95, hasta dar con un char entre 126 y 32(127-95=32)
			while (caracter[cont]>126)
			{
				caracter[cont]-=95;
			}
			System.out.println(caracter[cont]);
		}
	}

}
