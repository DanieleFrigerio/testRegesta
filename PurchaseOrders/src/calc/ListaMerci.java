package calc;

import java.util.ArrayList;

public class ListaMerci {

	private static final int UNO = 1;
	private ArrayList<Merce> list;
	
	public ListaMerci() {
		list = new ArrayList<Merce>();
	}

	public void add(Merce merce) {
		list.add(merce);
	}

	public boolean isEmpty() {
		if(list.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public void ordina() {
		for(int i = 0;i < list.size() - UNO;i ++) {
			if(list.get(i).migliore(list.get(i+UNO))) {
				scambia(i, i+UNO);
				i = -UNO;
			}
		}
	}
	
	private void scambia(int i, int j) {
		Merce temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public int getSize() {
		return list.size();
	}

	public Merce getMerce(int i) {
		return list.get(i);
	}
}