package org.titan.platform.wizards.section;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.titan.platform.parser.Property;

public class PropertiesPanel extends JPanel {

    private Map<String, JTextField> fields = new HashMap<String, JTextField>();
    /**
     * Create the panel.
     */
    public PropertiesPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

    }

    public void addField(Property property, int linha) {

        JLabel label = new JLabel(property.label());
        GridBagConstraints labelConstraint = new GridBagConstraints();
        labelConstraint.insets = new Insets(0, 0, 5, 5);
        labelConstraint.anchor = GridBagConstraints.EAST;
        labelConstraint.gridx = 0;
        labelConstraint.gridy = linha;
        add(label, labelConstraint);

        JTextField field = new JTextField();
        field.setText(property.defaultValue());
        GridBagConstraints fieldConstraint = new GridBagConstraints();
        fieldConstraint.insets = new Insets(0, 0, 5, 0);
        fieldConstraint.anchor = GridBagConstraints.HORIZONTAL;
        fieldConstraint.gridx = 1;
        fieldConstraint.gridy = linha;

        fields.put(property.name(), field);
        add(field, fieldConstraint);
    }
}
