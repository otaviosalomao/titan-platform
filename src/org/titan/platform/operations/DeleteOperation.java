package org.titan.platform.operations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.spi.project.DeleteOperationImplementation;
import org.openide.filesystems.FileObject;

public final class DeleteOperation implements DeleteOperationImplementation {

    public void notifyDeleting() throws IOException {
    }

    public void notifyDeleted() throws IOException {
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
