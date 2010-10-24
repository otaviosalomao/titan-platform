/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform.projectType;

import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.StringReader;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author marcos
 */
public class TitanPlatformProject implements Project {

    private final FileObject projectDir;
    private final ProjectState state;
    private Lookup lkp;

    public TitanPlatformProject(FileObject projectDir, ProjectState state) {
        this.projectDir = projectDir;
        this.state = state;
    }

    public FileObject getProjectDirectory() {
        return projectDir;
    }

    public Lookup getLookup() {
        if (lkp == null) {
            lkp = Lookups.fixed(new Object[]{
                        state, //allow outside code to mark the project as needing saving
                        new Info(), //Project information implementation
                        new TitanPlatformLogicalView(this), //Logical view of project implementation
                    });
        }
        return lkp;
    }

    @Override
    public boolean equals(Object o) {

        if(o == null){
            return false;
        }

        if (this == o) {
            return true;
        } else {
            try {
                FileObject fo = projectDir.getFileObject("configure/titan.xml");
                Document document = new SAXReader().read(new StringReader(fo.asText()));
                String myName = document.valueOf("/titan-configuration/@name");

                fo = ((TitanPlatformProject) o).getProjectDirectory().getFileObject("configure/titan.xml");
                document = new SAXReader().read(new StringReader(fo.asText()));
                String name = document.valueOf("/titan-configuration/@name");

                return name.equals(myName);

            } catch (DocumentException ex) {
                Exceptions.printStackTrace(ex);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        return false;
    }

    private final class Info implements ProjectInformation {

        @Override
        public Icon getIcon() {
            return new ImageIcon(ImageUtilities.loadImage("org/ledes/titan/titan.ico"));
        }

        @Override
        public String getName() {
            return getProjectDirectory().getName();
        }

        @Override
        public String getDisplayName() {
            return getName();
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener pcl) {
            //do nothing, won't change
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener pcl) {
            //do nothing, won't change
        }

        @Override
        public Project getProject() {
            return TitanPlatformProject.this;
        }
    }
}
