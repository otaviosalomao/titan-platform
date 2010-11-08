/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.titan.platform;

import java.io.File;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author rafael
 */
public class TitanPlatformUtils {

    public static boolean isDirectory(String path){
        
        File f = FileUtil.normalizeFile(new File(path).getAbsoluteFile());
        if (f.isDirectory()) {
            return true;
        }

        return false;
    }

}
