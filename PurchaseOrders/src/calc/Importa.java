package calc;

import java.sql.*;

public class Importa {
	
	private static final String URL_DATABASE = "jdbc:ucanaccess://DataBase.accdb";
	private static final String COMANDO_SQL_LETTURA = "SELECT * FROM Fornitore";
	private static final String FORNITORE = "Fornitore";
	private static final String NOME = "Nome";
	private static final String QUANTITA = "Quantità";
	private static final int PRIMA_TABELLA = 1;
	private static final int ULTIMA_TABELLA = 4;
	private static final String PREZZO = "Prezzo";
	private static final String SCONTO = "Sconto";
	private static final String DAY = "Giorni";

	private ListaMerci list;
	
	public Importa(String nome, int num) {
		list = new ListaMerci();
		importa(nome, num);
	}

	private void importa(String nome, int num) {
		Connection connection = null;
		String databaseURL = URL_DATABASE;
		try {
			connection = DriverManager.getConnection(databaseURL);
			
			for(int tabNum = PRIMA_TABELLA;tabNum <= ULTIMA_TABELLA; tabNum ++){
				String sq = COMANDO_SQL_LETTURA + tabNum;
				Statement state = connection.createStatement();
				ResultSet res = state.executeQuery(sq);
				
				while(res.next()) {
					String fornitore = FORNITORE + tabNum;
					String name = res.getString(NOME);
					int qnt = res.getInt(QUANTITA);
					int prezzo = res.getInt(PREZZO);
					String sconto = res.getString(SCONTO);
					int day = res.getInt(DAY);
					if(name.equals(nome)) {
						if(qnt >= num) {
							list.add(new Merce(fornitore, name, qnt, prezzo, sconto, day, num));
						}
					}
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getStampa() {
		Stampa stamp = new Stampa();
		return stamp.getStampa(list);
	}
}