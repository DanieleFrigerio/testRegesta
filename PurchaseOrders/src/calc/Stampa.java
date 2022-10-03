package calc;

import java.util.*;

public class Stampa {

	private static final String LISTA_VUOTA = "Nessun fornitore ha la quantità desiderata della merce inserita!";
	private static final String A_CAPO = "\n";
	private static final String DOLLARO = "$";
	private static final String SPAZIO = " ";
	private static final String GIORNI = " giorni";
	private static final String IN = "in ";
	private static final String DUE_PUNTI = ":";

	public String getStampa(ListaMerci list) {
		if(list.isEmpty()) {
			return LISTA_VUOTA;
		}
		else {
			list.ordina();
			StringBuilder sb = new StringBuilder();
			Date data = new Date();
			sb.append(data).append(A_CAPO).append(A_CAPO);
			for(int i = 0;i < list.getSize();i ++) {
				sb.append(list.getMerce(i).getFornitore()).append(DUE_PUNTI).append(SPAZIO);
				sb.append(list.getMerce(i).getPrezzoFinale()).append(DOLLARO).append(SPAZIO);
				sb.append(IN).append(list.getMerce(i).getDay()).append(GIORNI).append(SPAZIO).append(A_CAPO);
			}
			return sb.toString();
		}
	}
}
