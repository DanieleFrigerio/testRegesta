package test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import calc.CalcolaSconto;

public class testCalcolaSconto {
 
	@Test
	public void testNoSconto() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "/";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo);
	}
	
	@Test
	public void testNoScontoPerFineErrata() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "+12%30";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo);
	}
	
	@Test
	public void testNoScontoPerInizioErrato() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "12%30!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo);
	}
	
	@Test
	public void testNoScontoPerParametroErrato() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "+%30!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo);
	}
	
	@Test
	public void testNoScontoPerPercentualeErrata() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "+12%!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo);
	}
	
	@Test
	public void testNoScontoPerSimboloPercentualeErrato() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "+1230!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo);
	}
	
	@Test
	public void testNoScontoPerTotale() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "+2000%10!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo);
	}
	
	@Test
	public void testScontoPerTotale() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "+500%10!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo - ((qnt*prezzo)/100.00) * 10);
	}
	
	@Test
	public void testNoScontoPerNumero() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "-30%10!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo);
	}
	
	@Test
	public void testScontoPerNumero() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "-2%10!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo - ((qnt*prezzo)/100.00) * 10);
	}
	
	@Test
	public void testNoScontoPerFisso() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "$131!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo);
	}
	
	@Test
	public void testScontoFisso() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "$10!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo - ((qnt*prezzo)/100.00) * 10);
	}	
	
	@Test
	public void testScontoVuoto() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo);
	}
	
	@Test
	public void testScontoZero() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "+10%0!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo - ((qnt*prezzo)/100.00) * 0);
	}
	
	@Test
	public void testScontoCento() throws Exception{
		CalcolaSconto calc = new CalcolaSconto();
		int qnt = 10;
		int prezzo = 100;
		String sconto = "-10%100!";
		double res = calc.calcola(qnt, prezzo, sconto);
		assertTrue(res == qnt*prezzo - ((qnt*prezzo)/100.00) * 100);
	}
}