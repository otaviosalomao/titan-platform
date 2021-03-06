/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform.wizards.newproject;

import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.filesystems.FileUtil;
import org.openide.util.HelpCtx;
import org.titan.platform.database.Database;
import static org.titan.platform.utils.Utils.bundle;

/**
 *
 * @author marcos
 */
public class DatabaseWizardPanel implements WizardDescriptor.Panel,
        WizardDescriptor.ValidatingPanel {

    private DataBasePanelVisual component;
    private final Set<ChangeListener> listeners = new HashSet<ChangeListener>(1);
    private WizardDescriptor wizardDescriptor;

    public DatabaseWizardPanel() {
    }

    public void importDatabase(String database,String user, String password) throws IOException, SQLException{
        File sql = null; 
        InputStream is = this.getClass().getResourceAsStream("db.sql");
        
        Connection connection = Database.getConnection(database, user, password);
        Database.resetDatabase(user, password, is, connection);
    }

    @Override
    public Component getComponent() {
        if (component == null) {
            component = new DataBasePanelVisual(this);
            component.setName(bundle(this.getClass(), "step.three"));
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public final void addChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.add(l);
        }
    }

    public final void removeChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.remove(l);
        }
    }

    @Override
    public void validate() throws WizardValidationException {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void readSettings(Object settings) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void storeSettings(Object settings) {
        WizardDescriptor d = (WizardDescriptor) settings;
        component.store(d);
    }
}
