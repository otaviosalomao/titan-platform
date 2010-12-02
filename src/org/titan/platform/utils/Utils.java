package org.titan.platform.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;
import scala.xml.*;

public class Utils {

    private static MessageDigest digest;

    public static String md5(byte[] bytes) throws NoSuchAlgorithmException {
        if (digest == null) {
            digest = java.security.MessageDigest.getInstance("MD5");
        }
        digest.update(bytes);
        BigInteger bigInt = new BigInteger(1, digest.digest());
        String hashtext = bigInt.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }

        return hashtext;
    }

    public static String bundle(Class clazz, String key) {
        return NbBundle.getMessage(clazz, key);
    }

    public static boolean isDirectory(String path) {

        File f = FileUtil.normalizeFile(new File(path).getAbsoluteFile());
        if (f.isDirectory()) {
            return true;
        }

        return false;
    }

    public static String getConfigAttr(FileObject projectDir, String attr) throws FileNotFoundException {
        InputStream file = projectDir.getFileObject("configure/titan.xml").getInputStream();
        Elem config = XML.load(file);
        return config.attribute(attr).get().toString();
    }
}
