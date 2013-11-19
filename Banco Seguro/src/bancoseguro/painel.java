package bancoseguro;
//Desenvolvido por Rômulo Mauriz
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class painel extends JFrame implements ActionListener {

	private JButton[] btn = new JButton[5];
	private JTextField agencia = new JTextField();
	private JTextField conta = new JTextField();
	private JTextField senha = new JTextField();
	private JPanel pButton = new JPanel();
	private String mapa[] = new String[]{"A", "B", "C", "D", "E"};
	
	painel(){
		
		super("Banco Seguro");
		setLayout(new GridLayout(5 ,3));
		setBounds(400, 400, 180, 150);
		//**
		add(new JLabel("Agencia:"));
		add(agencia);
		add(new JLabel("Conta:"));
		add(conta);
		add(new JLabel("Senha:"));
		add(senha);
		add(new JLabel(""));
		add(pButton);
		pButton.setLayout(new FlowLayout());
		for(int i = 0; i<btn.length; i++)
		{
			btn[i] = new JButton();
			btn[i].setBorder(new EmptyBorder(5, 5, 5, 5));
			pButton.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		
		
		
		
		//**
		randomizebtns();
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		painel p = new painel();
		
		

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		senha.setText(senha.getText() + ((JButton)ae.getSource()).getText());
		randomizebtns();
	}
	
	
	private void randomizebtns() {
        Random randomGenerator = new Random();
        for (int i = 0;i<btn.length;i++) {
            boolean repetido;
            int n;
            do {
                n = randomGenerator.nextInt(5);
                repetido = false;
                for (int j=0;j<i;j++) {
                    if (Integer.valueOf(btn[j].getText()) == n)
                        repetido = true;
                }
            } while (repetido);
            
            btn[i].setText(Integer.toString(n));
            btn[i].setLabel(mapa[n]);
            
            
            
        }
        
    }

}
