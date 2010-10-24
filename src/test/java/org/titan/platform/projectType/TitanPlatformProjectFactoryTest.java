package org.titan.platform.projectType;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

public class TitanPlatformProjectFactoryTest {

    private File file;
    TitanPlatformProject project;

    @Before
    public void setup() throws URISyntaxException {
        URL url = this.getClass().getResource("/titan-template/");
        file = new File(url.toURI());
        project = new TitanPlatformProject(FileUtil.toFileObject(file), null);

    }

    @Test
    public void testIsProject() throws URISyntaxException {
        FileObject fo = FileUtil.toFileObject(file);
        TitanPlatformProjectFactory instance = new TitanPlatformProjectFactory();
        assertTrue("Should validate project folder", instance.isProject(fo));
    }

    @Test
    public void testIsNotProjectWithConfigDir() throws URISyntaxException {

        URL url = this.getClass().getResource("/fake/");
        file = new File(url.toURI());
        FileObject fo = FileUtil.toFileObject(file);
        TitanPlatformProjectFactory instance = new TitanPlatformProjectFactory();
        assertFalse("Should not validate project folder", instance.isProject(fo));
    }

    @Test
    public void testIsNotProject() throws URISyntaxException {

        URL url = this.getClass().getResource("/fake2/");
        file = new File(url.toURI());
        FileObject fo = FileUtil.toFileObject(file);
        TitanPlatformProjectFactory instance = new TitanPlatformProjectFactory();
        assertFalse("Should not validate project folder", instance.isProject(fo));
    }

    @Test
    public void testLoadProject() throws Exception {
        FileObject dir = FileUtil.toFileObject(file);
        TitanPlatformProjectFactory instance = new TitanPlatformProjectFactory();
        Project loaded = instance.loadProject(dir, null);
        assertEquals(project, loaded);

    }

    @Test
    public void testLoadInexistentProject() throws Exception {

        URL url = this.getClass().getResource("/fake2/");
        file = new File(url.toURI());
        FileObject dir = FileUtil.toFileObject(file);
        TitanPlatformProjectFactory instance = new TitanPlatformProjectFactory();
        Project loaded = instance.loadProject(dir, null);
        assertFalse(project.equals(loaded));

    }

    /**
     * Test of saveProject method, of class TitanPlatformProjectFactory.
     */
    @Ignore
    public void testSaveProject() throws Exception {
        System.out.println("saveProject");
        Project project = null;
        TitanPlatformProjectFactory instance = new TitanPlatformProjectFactory();
        instance.saveProject(project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
