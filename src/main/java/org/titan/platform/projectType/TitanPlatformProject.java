/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform.projectType;


import java.beans.PropertyChangeListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author marcos
 */
public class TitanPlatformProject implements Project
{

    private final FileObject projectDir;
    private final ProjectState state;
    private Lookup lkp;

    public TitanPlatformProject(FileObject projectDir, ProjectState state)
    {
        this.projectDir = projectDir;
        this.state = state;
    }



    public FileObject getProjectDirectory()
    {
        return projectDir;
    }

    public Lookup getLookup()
    {
        if (lkp == null)
        {
            lkp = Lookups.fixed(new Object[]{
                        state, //allow outside code to mark the project as needing saving
                        new Info(), //Project information implementation
                        new TitanPlatformLogicalView(this), //Logical view of project implementation
                    });
        }
        return lkp;
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