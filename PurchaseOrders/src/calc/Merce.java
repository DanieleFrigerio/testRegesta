package calc;

public class Merce {

	private String fornitore;
	private String name;
	private int quantità;
	private int prezzo;
	private String sconto;
	private int day;
	private double prezzoFinale;
	
	public Merce(String fornitore, String name, int qnt, int prezzo, String sconto, int day, int num) {
		this.fornitore = fornitore;
		this.name = name;
		this.quantità = qnt;
		this.prezzo = prezzo;
		this.sconto = sconto;
		this.day = day;
		this.prezzoFinale = calcola(num, this.prezzo, this.sconto);
	}

	private double calcola(int num, int prezzo, String sconto) {
		CalcolaSconto calc = new CalcolaSconto();
		return calc.calcola(num, prezzo, sconto);
	}
	
	public boolean migliore(Merce m) {
		if(m.getPrezzoFinale() < prezzoFinale) {
			return true;
		}
		else {
			if(m.getPrezzoFinale() == prezzoFinale) {
				if(m.getDay() < day ) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
	}

	public String getFornitore() {
		return fornitore;
	}

	public String getName() {
		return name;
	}
	
	public int getQnt() {
		return quantità;
	}
	
	public int getPrezzo() {
		return prezzo;
	}
	
	public String getSconto() {
		return sconto;
	}
	
	public int getDay() {
		return day;
	}
	
	public double getPrezzoFinale() {
		return prezzoFinale;
	}
}
