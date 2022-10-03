package calc;

public class CalcolaSconto {

	private static final String SPAZIO = " ";
	private static final String VUOTO = "";
	private static final int INIZIO = 0;
	private static final String CONVERTI_IN_STRINGA = "";
	private static final String SCONTO_SUL_TOTALE = "+";
	private static final String SCONTO_SUI_PEZZI = "-";
	private static final int INIZIO_ANALISI = 1;
	private static final String FINE_NUMERO = "%";
	private static final double CENTO = 100;
	private static final String FINE_SCONTO = "!";
	private static final String NIENTE_SCONTO = "/";
	private static final String SCONTO_TEMPO = "$";
	private static final double LIMITE_SCONTO_SUP = 100;
	private static final double LIMITE_SCONTO_INF = 0;

	public double calcola(int quantit�, int prezzo, String sconto) {
		try {
			switch(sconto.replaceAll(SPAZIO, VUOTO).charAt(INIZIO) + CONVERTI_IN_STRINGA) {
			case NIENTE_SCONTO:
				return getPrezzoNoSconto(quantit�, prezzo);
			case SCONTO_SUL_TOTALE:
				return calcolaSeSconto(quantit�, prezzo, sconto, getPrezzoNoSconto(quantit�, prezzo));
			case SCONTO_SUI_PEZZI:
				return calcolaSeSconto(quantit�, prezzo, sconto, quantit�);
			case SCONTO_TEMPO:
				return calcolaScontoSicuro(quantit�, prezzo, sconto, INIZIO_ANALISI);
			default:
				return getPrezzoNoSconto(quantit�, prezzo);
			}
		}catch(Exception e) {
			return getPrezzoNoSconto(quantit�, prezzo);
		}
	}

	private double calcolaScontoSicuro(int quantit�, int prezzo, String sconto, int pos) {
		StringBuilder sb = new StringBuilder();
		try {
			while(!((sconto.replaceAll(SPAZIO, VUOTO).charAt(pos) + CONVERTI_IN_STRINGA).equals(FINE_SCONTO))){
			sb.append(sconto.replaceAll(SPAZIO, VUOTO).charAt(pos) + CONVERTI_IN_STRINGA);
			pos ++;
			}
			double percentuale = Double.parseDouble(sb.toString());
			if(percentuale <= LIMITE_SCONTO_SUP && percentuale >= LIMITE_SCONTO_INF){
				return getPrezzoNoSconto(quantit�, prezzo) - ((getPrezzoNoSconto(quantit�, prezzo)/CENTO) * percentuale);
			}
			else {
				return getPrezzoNoSconto(quantit�, prezzo);
			}
		}catch(Exception e) {
			return  getPrezzoNoSconto(quantit�, prezzo);
		}
	}

	private int getPrezzoNoSconto(int qnt, int prezzo) {
		return qnt * prezzo;
	}

	private double calcolaSeSconto(int quantit�, int prezzo, String sconto, int paramSconto) {
		int pos = INIZIO_ANALISI;
		StringBuilder sb = new StringBuilder();
		try {
			while(!((sconto.replaceAll(SPAZIO, VUOTO).charAt(pos) + CONVERTI_IN_STRINGA).equals(FINE_NUMERO))){
			sb.append(sconto.replaceAll(SPAZIO, VUOTO).charAt(pos) + CONVERTI_IN_STRINGA);
			pos ++;
			}
			double paramAttuale = Double.parseDouble(sb.toString());
			if(paramSconto >= paramAttuale) {
				pos++;
				return calcolaScontoSicuro(quantit�, prezzo, sconto, pos);
			}
			else {
				return getPrezzoNoSconto(quantit�, prezzo);
			}
		} catch(Exception e) {
			return  getPrezzoNoSconto(quantit�, prezzo);
		}
	}
}