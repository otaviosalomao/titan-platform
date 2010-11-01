/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.titan.platform.operations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.CopyOperationImplementation;
import org.openide.filesystems.FileObject;

/**
 *
 * @author rafael
 */
public class CopyOperation implements CopyOperationImplementation {

    @Override
    public void notifyCopying() throws IOException {
    }

    @Override
    public void notifyCopied(Project prjct, File file, String string) throws IOException {
    }

    @Override
    public List<FileObject> getMetadataFiles() {
           List<FileObject> dataFiles = new ArrayList<FileObject>();
        return dataFiles;
    }

    @Override
    public List<FileObject> getDataFiles() {
         List<FileObject> dataFiles = new ArrayList<FileObject>();
        return dataFiles;
    }



}
