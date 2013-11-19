//Desenvolvido por Rômulo Mauriz
package bancoseguro;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.sql.Array;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;

import javax.swing.JButton;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class painel extends JFrame implements ActionListener {

	private MaskFormatter mkAg, mkCt;
	private JButton[] btn = new JButton[5];
	private JFormattedTextField agencia;
	private JFormattedTextField conta;
	private JPanel pTexto = new JPanel();
	private JPasswordField senha = new JPasswordField();
	private JPanel pButton = new JPanel();
	private JButton cancelar = new JButton();
	private JButton acessar = new JButton();

	private String mapa[] = new String[]{"A", "B", "C", "D", "E"};
	
	painel() throws ParseException{
		
		super("Banco Seguro");
		setLayout(new GridLayout(6 ,2));
		setBounds(200, 200, 100, 100);
		
		
		
		//**
		add(new JLabel("Agencia:"));
		mkAg = new MaskFormatter("####-#");
		agencia = new JFormattedTextField(mkAg);
		add(agencia);
		
		add(new JLabel("Conta:"));
		mkCt = new MaskFormatter("######-#");
		conta = new JFormattedTextField(mkCt);
		add(conta);
		
		add(new JLabel("Senha:"));
		add(senha);
		senha.setEnabled(false);
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
		
		add(cancelar);
		cancelar.setLabel("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		add(acessar);
		acessar.setLabel("Acessar");
		acessar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String sn, ag, ct;
				sn = senha.getText().toString();
				ag = agencia.getText().toString();
				ct = conta.getText().toString();
				JOptionPane.showMessageDialog(null, "Verificação dos dados: Agencia: "+ ag + " Conta: " + ct + " Senha: " + sn);
				
			}
		});
		add(pTexto);
		pTexto.setLayout(new FlowLayout());
		pTexto.add(add(new JLabel("A -> 0 ou 9     ")));
		pTexto.add(add(new JLabel("B -> 7 ou 4     ")));
		pTexto.add(add(new JLabel("C -> 6 ou 1     ")));
		pTexto.add(add(new JLabel("D -> 3 ou 8     ")));
		pTexto.add(add(new JLabel("E -> 2 ou 5     ")));
		
		
		
		
		
		//**
		randomizebtns();
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		setVisible(true);
		pack();
	}
	
	
	public static void main(String[] args) throws ParseException {
		@SuppressWarnings("unused")
		painel p = new painel();
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		senha.setText(senha.getText() + ((JButton)ae.getSource()).getText());
		randomizebtns();
		
		
	}
	
	
	private void randomizebtns() {
        
        for (int i = 0;i<5;i++) {
        	Random randomGenerator = new Random();
            boolean repetido;
            
            int n;
            do {
                n =  randomGenerator.nextInt(5);
               
                repetido = false;
                for (int j=0;j<i;j++) {
                    if ((btn[j].getText() ==Integer.toString(n)))
                    {
                        repetido = true;
                        
                    }
                    
                    
                }
                
            } while (repetido);
            
            //*Aqui não consegui resolver o problema das letras repetidas *//
            	btn[i].setText(mapa[n]);
            
            
            
        }
        
    }

}
