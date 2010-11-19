package org.titan.platform.wizards.components;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ImportProgressBar extends JDialog{

	private JLabel importandoBacoDeLabel;
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
		setBounds(100, 100, 240, 77);
		setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setResizable(false);
		importandoBacoDeLabel = new JLabel("Importando baco de dados...");
		importandoBacoDeLabel.setBounds(10, 10, 217, 24);
		getContentPane().add(importandoBacoDeLabel);

		importProgressBar = new JProgressBar();
		importProgressBar.setBounds(10, 40, 217, 14);
		getContentPane().add(importProgressBar);

	}

    public void close() {
        this.dispose();
    }
}
