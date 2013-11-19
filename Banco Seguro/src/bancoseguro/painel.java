package bancoseguro;
//Desenvolvido por Rômulo Mauriz
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class painel extends JFrame implements ActionListener {

	
	painel(){
		super("Painel");
		setLayout(new GridLayout());
		setBounds(400, 400, 250, 250);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}
	
	
	public static void main(String[] args) {
		painel p = new painel();
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
