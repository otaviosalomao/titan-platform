/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform.wizards.newproject;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.util.HelpCtx;
import static org.titan.platform.utils.Utils.bundle;

/**
 *
 * @author marcos
 */
public class ConfigurationWizardPanel implements WizardDescriptor.Panel,
        WizardDescriptor.ValidatingPanel {

    private ConfigurationPanelVisual component;
    private final Set<ChangeListener> listeners = new HashSet<ChangeListener>(1);
    private WizardDescriptor wizardDescriptor;

    public ConfigurationWizardPanel() {
    }

    @Override
    public Component getComponent() {
        if (component == null) {
            component = new ConfigurationPanelVisual(this);
            component.setName(bundle(this.getClass(), "step.two"));
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
        getComponent();
        return component.valid(wizardDescriptor);
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

    protected final void fireChangeEvent() {
        Set<ChangeListener> ls;
        synchronized (listeners) {
            ls = new HashSet<ChangeListener>(listeners);
        }
        ChangeEvent ev = new ChangeEvent(this);
        for (ChangeListener l : ls) {
            l.stateChanged(ev);
        }
    }

    @Override
    public void validate() throws WizardValidationException {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void readSettings(Object settings) {
        wizardDescriptor = (WizardDescriptor) settings;
        component.read(wizardDescriptor);
    }

    @Override
    public void storeSettings(Object settings) {
        WizardDescriptor d = (WizardDescriptor) settings;
        component.store(d);
    }
}
