/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform.projectType;

import java.io.IOException;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcos
 */
@org.openide.util.lookup.ServiceProvider(service=ProjectFactory.class)
public class TitanPlatformProjectFactory implements org.netbeans.spi.project.ProjectFactory
{


    private static final String PROJECT_DIR = "nbproject";
    private static final String CONFIG_DIR = "configure";


    @Override
    public boolean isProject(FileObject fo)
    {
        if(fo.getFileObject(CONFIG_DIR) != null)
        {
            FileObject xml = fo.getFileObject(CONFIG_DIR);
            return xml.getFileObject("titan.xml") != null;
        }

        return false;
    }



    public Project loadProject(FileObject dir, ProjectState state) throws IOException
    {
        return isProject(dir) ? new TitanPlatformProject(dir, state) : null;
    }



    public void saveProject(Project project) throws IOException, ClassCastException
    {
        FileObject projectRoot = project.getProjectDirectory();
        if (projectRoot.getFileObject(PROJECT_DIR) == null) {
            throw new IOException("Project dir " + projectRoot.getPath() +
                    " deleted," +
                    " cannot save project");
        }
        //Force creation of the texts dir if it was deleted:
        //((TitanProject) project).getTextFolder(true);
    }


}