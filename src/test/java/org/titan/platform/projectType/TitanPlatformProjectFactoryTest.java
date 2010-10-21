package org.titan.platform.projectType;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

public class TitanPlatformProjectFactoryTest {

    private File file;

    @Before
    public void setup() throws URISyntaxException{
        URL url = this.getClass().getResource("/titan-template/");
        file = new File(url.toURI());

    }

    @Test
    public void testIsProject() throws URISyntaxException {
        FileObject fo = FileUtil.toFileObject(FileUtil.normalizeFile(file));

        TitanPlatformProjectFactory instance = new TitanPlatformProjectFactory();
        boolean expResult = false;
        boolean result = instance.isProject(fo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadProject method, of class TitanPlatformProjectFactory.
     */
    @Test
    public void testLoadProject() throws Exception {
        System.out.println("loadProject");
        FileObject dir = null;
        ProjectState state = null;
        TitanPlatformProjectFactory instance = new TitanPlatformProjectFactory();
        Project expResult = null;
        Project result = instance.loadProject(dir, state);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveProject method, of class TitanPlatformProjectFactory.
     */
    @Test
    public void testSaveProject() throws Exception {
        System.out.println("saveProject");
        Project project = null;
        TitanPlatformProjectFactory instance = new TitanPlatformProjectFactory();
        instance.saveProject(project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}