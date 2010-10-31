/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform;

import java.beans.PropertyChangeListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.support.ant.AntBasedProjectRegistration;
import org.netbeans.spi.project.support.ant.AntProjectHelper;
import org.openide.filesystems.FileObject;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

@AntBasedProjectRegistration(type = TitanPlataformProjectType.TYPE,
iconResource = TitanPlataformProjectType.ICON_RESOURCE_PATH,
sharedNamespace = TitanPlataformProjectType.PROJECT_CONFIGURATION_NAMESPACE,
privateNamespace = TitanPlataformProjectType.PRIVATE_CONFIGURATION_NAMESPACE)
public class TitanPlatformProject implements Project {

    final AntProjectHelper helper;

    public TitanPlatformProject(AntProjectHelper helper) {
        this.helper = helper;
    }

    @Override
    public FileObject getProjectDirectory() {
       return helper.getProjectDirectory();
    }

    @Override
    public Lookup getLookup() {
        return Lookups.fixed(new Object[]{new Info()});
    }

    private final class Info implements ProjectInformation {

        @Override
        public String getName() {
            return helper.getProjectDirectory().getName();
        }

        public String getDisplayName() {
            return getName();
        }

        @Override
        public Icon getIcon() {
            return new ImageIcon(ImageUtilities.loadImage(
                    TitanPlataformProjectType.ICON_RESOURCE_PATH));
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener pcl) {
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener pcl) {
        }

        @Override
        public Project getProject() {
            return TitanPlatformProject.this;
        }
    }
}
