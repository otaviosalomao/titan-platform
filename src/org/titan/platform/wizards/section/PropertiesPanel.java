package org.titan.platform.wizards.section;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import org.titan.platform.parser.Property;

public class PropertiesPanel extends JPanel {

    private Map<String, JTextField> fields = new HashMap<String, JTextField>();
    private int line = 0;

    /**
     * Create the panel.
     */
    public PropertiesPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

    }

    public void addSeparator(org.titan.platform.parser.Package pkg) {
        JLabel label = new JLabel("<html><b>"+pkg.label() + ":</b></html>");
        GridBagConstraints labelConstraint = new GridBagConstraints();
        labelConstraint.insets = new Insets(0, 0, 5, 5);
        labelConstraint.anchor = GridBagConstraints.EAST;
        labelConstraint.gridx = 0;
        labelConstraint.gridy = line;
        add(label, labelConstraint);

        JSeparator separator = new JSeparator();
        GridBagConstraints separatorConstraint = new GridBagConstraints();
        separatorConstraint.insets = new Insets(0, 0, 5, 0);
        separatorConstraint.fill = GridBagConstraints.HORIZONTAL;
        separatorConstraint.gridx = 1;
        separatorConstraint.gridy = line++;
        add(separator, separatorConstraint);

        JLabel labelName = new JLabel("Nome Unix:");
        GridBagConstraints labelNameConstraint = new GridBagConstraints();
        labelConstraint.insets = new Insets(0, 0, 5, 5);
        labelConstraint.anchor = GridBagConstraints.EAST;
        labelConstraint.gridx = 0;
        labelConstraint.gridy = line;
        add(labelName, labelConstraint);

        JTextField field = new JTextField();
        field.setText(pkg.name());
        GridBagConstraints fieldConstraint = new GridBagConstraints();
        fieldConstraint.insets = new Insets(0, 0, 5, 0);
        fieldConstraint.fill = GridBagConstraints.HORIZONTAL;
        fieldConstraint.gridx = 1;
        fieldConstraint.gridy = line++;
        fields.put("name", field);
        add(field, fieldConstraint);
        field.setColumns(10);
    }

    public void addField(Property property) {

        JLabel label = new JLabel(property.label() + ":");
        GridBagConstraints labelConstraint = new GridBagConstraints();
        labelConstraint.insets = new Insets(0, 0, 5, 5);
        labelConstraint.anchor = GridBagConstraints.EAST;
        labelConstraint.gridx = 0;
        labelConstraint.gridy = line;
        add(label, labelConstraint);

        JTextField field = new JTextField();
        field.setText(property.defaultValue());
        GridBagConstraints fieldConstraint = new GridBagConstraints();
        fieldConstraint.insets = new Insets(0, 0, 5, 0);
        fieldConstraint.fill = GridBagConstraints.HORIZONTAL;
        fieldConstraint.gridx = 1;
        fieldConstraint.gridy = line++;
        fields.put(property.name(), field);
        add(field, fieldConstraint);
        field.setColumns(10);
    }

    @Override
    public void removeAll() {
        line = 0;
        super.removeAll();
    }
}
