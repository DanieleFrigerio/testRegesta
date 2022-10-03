package controlli;

import calc.Importa;

public class Controllo {

	private static final String VUOTO = "";
	private static final String SPAZIO = " ";
	private static final String NOME_VUOTO = "Inserito nessun nome merce!";
	private static final String NUM_VUOTO = "Inserito numero non valido!";
	private static final int ERRORE_NUM = -1;
	private static final int LIMITE_RICHIESTA = 1;

	private String nome;
	private int num;
	
	public Controllo(String nome, String num) {
		this.nome = isString(nome);
		this.num = isNum(num);
	}

	private int isNum(String num) {
		try{
			int qnt = Integer.parseInt(num.replaceAll(SPAZIO, VUOTO));
			return qnt;
		}
		catch(Exception e) {
			return ERRORE_NUM;
		}
	}

	private String isString(String nome) {
		if(nome.replaceAll(SPAZIO, VUOTO).isEmpty()) {
			return NOME_VUOTO;
		}
		else {
			return nome;
		}
	}

	public String getResalt() {
		if(nome.equals(NOME_VUOTO)) {
			return NOME_VUOTO;
		}
		else {
			if(num < LIMITE_RICHIESTA) {
				return NUM_VUOTO;
			}
			else {
				Importa imp = new Importa(nome, num);
				return imp.getStampa().toString();
			}
		}
	}
}