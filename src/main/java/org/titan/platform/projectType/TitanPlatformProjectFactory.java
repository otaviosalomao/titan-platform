/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform.projectType;

import java.io.IOException;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.netbeans.api.project.Project;


/**
 *
 * @author marcos
 */
@org.openide.util.lookup.ServiceProvider(service=ProjectFactory.class)
public class TitanPlatformProjectFactory implements ProjectFactory  {

    public static final String PROJECT_DIR = "texts";

    //Specifies when a project is a project, i.e.,
    //if the project directory "texts" is present:
    @Override
    public boolean isProject(FileObject projectDirectory) {
        return projectDirectory.getFileObject(PROJECT_DIR) != null;
    }

    //Specifies when the project will be opened, i.e.,
    //if the project exists:
    @Override
    public Project loadProject(FileObject dir, ProjectState state) throws IOException {
        return isProject(dir) ? new TitanPlatformProject(dir, state) : null;
    }

    @Override
    public void saveProject(final Project project) throws IOException, ClassCastException {
        FileObject projectRoot = project.getProjectDirectory();
        if (projectRoot.getFileObject(PROJECT_DIR) == null) {
            throw new IOException("Project dir " + projectRoot.getPath()
                    + " deleted,"
                    + " cannot save project");
        }
        //Force creation of the texts dir if it was deleted:
        ((TitanPlatformProject) project).getTextFolder(true);
    }
}
