package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Crypt.Encriptador;

public class testCrypt {

	@Test
	public void test() {
		Encriptador encr=new Encriptador();
		assertEquals(encr.encriptarFrase("Paco"), "Paco");
	}

}
