/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform.wizards.section;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.openide.util.ImageUtilities;
import org.titan.platform.parser.Parser;

import static org.titan.platform.utils.Utils.bundle;


public final class SectionVisualPanel1 extends JPanel {

    /** Creates new form SectionVisualPanel1 */
    public SectionVisualPanel1() {
        initComponents();
        loadComboBox();
    }

    @Override
    public String getName() {
        return bundle(this.getClass(), "step.one");
    }

    private void loadComboBox(){
        org.titan.platform.parser.Package[] packages = Parser.parse("/var/www/repos/package/package.xml");

        for (org.titan.platform.parser.Package p : packages) {
            pacoteComboBox.addItem(p.label() + " - [" + p.name() + "]");
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        packageLabel = new javax.swing.JLabel();
        pacoteComboBox = new javax.swing.JComboBox();
        readmeButton = new javax.swing.JButton(new ImageIcon(ImageUtilities.loadImage("resources/info.png")));

        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(SectionVisualPanel1.class, "SectionVisualPanel1.nameLabel.text")); // NOI18N

        nameField.setText(org.openide.util.NbBundle.getMessage(SectionVisualPanel1.class, "SectionVisualPanel1.nameField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(packageLabel, org.openide.util.NbBundle.getMessage(SectionVisualPanel1.class, "SectionVisualPanel1.packageLabel.text")); // NOI18N

        pacoteComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Selecione um pacote --" }));

        org.openide.awt.Mnemonics.setLocalizedText(readmeButton, org.openide.util.NbBundle.getMessage(SectionVisualPanel1.class, "SectionVisualPanel1.readmeButton.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(packageLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pacoteComboBox, 0, 297, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(readmeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(packageLabel)
                        .addComponent(pacoteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(readmeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(239, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel packageLabel;
    private javax.swing.JComboBox pacoteComboBox;
    private javax.swing.JButton readmeButton;
    // End of variables declaration//GEN-END:variables
}
