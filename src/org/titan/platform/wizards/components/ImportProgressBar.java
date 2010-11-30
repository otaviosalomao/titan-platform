package org.titan.platform.wizards.components;


import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import static org.titan.platform.utils.Utils.bundle;

public class ImportProgressBar extends JDialog{

	private JLabel importManssageLabel;
	private JProgressBar importProgressBar;

	public ImportProgressBar() {
		super();
		inicializaInterface();
                importProgressBar.setIndeterminate(true);
                
               

	}

	public void inicializaInterface() {
		setTitle(bundle(this.getClass(), "title.import"));
		setFocusable(false);
		getContentPane().setLayout(null);
		setBounds(100, 100, 278, 95);
		setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setResizable(false);
		importManssageLabel = new JLabel(bundle(this.getClass(), "label.import.menssage"));
		importManssageLabel.setBounds(10, 10, 256, 24);
		getContentPane().add(importManssageLabel);
		
		 JLabel waitLabel = new JLabel(bundle(this.getClass(), "label.import.wait"));
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