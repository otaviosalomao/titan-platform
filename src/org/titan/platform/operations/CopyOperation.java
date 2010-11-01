/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.titan.platform.operations;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.CopyOperationImplementation;
import org.openide.filesystems.FileObject;

import org.titan.platform.TitanPlatformProject;

public final class CopyOperation implements CopyOperationImplementation {

        private final TitanPlatformProject project;
        private final FileObject projectDir;

        public CopyOperation(TitanPlatformProject project) {
            this.project = project;
            this.projectDir = project.getProjectDirectory();
        }

        public List<FileObject> getMetadataFiles() {
            return Collections.EMPTY_LIST;
        }

        public List<FileObject> getDataFiles() {
            return Collections.EMPTY_LIST;
        }

        public void notifyCopying() throws IOException {
        }

        public void notifyCopied(Project arg0, File arg1, String arg2) throws IOException {
        }
}
