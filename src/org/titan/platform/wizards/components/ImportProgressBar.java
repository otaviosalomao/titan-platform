package org.titan.platform.wizards.components;


import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ImportProgressBar extends JDialog{

	private JLabel importManssageLabel;
	private JProgressBar importProgressBar;

	public ImportProgressBar() {
		super();
		inicializaInterface();
                importProgressBar.setIndeterminate(true);
                
               

	}

	public void inicializaInterface() {
		setTitle("Aguarde...");
		setFocusable(false);
		getContentPane().setLayout(null);
		setBounds(100, 100, 278, 95);
		setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setResizable(false);
		importManssageLabel = new JLabel("Importando baco de dados...");
		importManssageLabel.setBounds(10, 10, 256, 24);
		getContentPane().add(importManssageLabel);
		
		 JLabel waitLabel = new JLabel("Aguarde, isso pode levar alguns minutos...");
         waitLabel.setBounds(10, 32, 256, 24);
         getContentPane().add(waitLabel);

		importProgressBar = new JProgressBar();
		importProgressBar.setBounds(10, 67, 256, 14);
		getContentPane().add(importProgressBar);

	}

    public void close() {
        this.dispose();
    }
}