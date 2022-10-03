package interfaccia;

import java.awt.*;
import javax.swing.*;
import controlli.Controllo;

public class Interfaccia {

	private static final String TITOLO_INTERFACCIA = "Purchase Orders";
	private static final String FONT_TITOLO = "Serif";
	private static final String FONT_CORPO = "Timens New Roman";
	private static final String DESCR_MERCE = "Inserire merce: ";
	private static final String DESCR_QUANTITA = "Inserire quantità: ";
	private static final String NOME_BTN = "Cerca";
	private static final String VUOTA = "";
	private static final String RESET = "Reset";
	
	private JFrame frame;
	private JTextField textMerce;
	private JTextField textQnt;
	
	//Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaccia window = new Interfaccia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create the application.
	public Interfaccia() {
		initialize();
	}

	// Application
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(10, 10, 260, 190);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel(TITOLO_INTERFACCIA);
		title.setFont(new Font(FONT_TITOLO, Font.PLAIN, 30));
		title.setBounds(10, 10, 1000, 30);
		frame.getContentPane().add(title);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(0, 45, 2000, 2);
		frame.getContentPane().add(separator1);
		
		JLabel merce = new JLabel(DESCR_MERCE);
		merce.setFont(new Font(FONT_CORPO, Font.PLAIN, 15));
		merce.setBounds(10, 50, 1000, 15);
		frame.getContentPane().add(merce);
		
		textMerce = new JTextField();
		textMerce.setBounds(130, 50, 100, 20);
		frame.getContentPane().add(textMerce);

		JLabel qnt = new JLabel(DESCR_QUANTITA);
		qnt.setFont(new Font(FONT_CORPO, Font.PLAIN, 15));
		qnt.setBounds(10, 75, 1000, 15);
		frame.getContentPane().add(qnt);
		
		textQnt = new JTextField();
		textQnt.setBounds(130, 75, 100, 20);
		frame.getContentPane().add(textQnt);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(0, 99, 2000, 2);
		frame.getContentPane().add(separator2);
		
		JButton btnCalc = new JButton(NOME_BTN);
		btnCalc.setBounds(10, 110, 100, 30);
		frame.getContentPane().add(btnCalc);
		
		JButton btnReset = new JButton(RESET);
		btnReset.setBounds(130, 110, 100, 30);
		frame.getContentPane().add(btnReset);
		
		btnCalc.addActionListener((e)-> {
			Controllo control = new Controllo(textMerce.getText(), textQnt.getText());
			JOptionPane.showMessageDialog(null, control.getResalt());
		});
		
		btnReset.addActionListener((e) -> {
			textMerce.setText(VUOTA);
			textQnt.setText(VUOTA);
		});
	}
}