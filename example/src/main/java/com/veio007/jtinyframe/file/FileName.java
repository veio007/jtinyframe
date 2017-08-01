package com.veio007.jtinyframe.file;

import org.apache.commons.io.FilenameUtils;

public class FileName {
    public static void main(String[] args) {
        String file = "/app/md/";
        System.out.println(FilenameUtils.getFullPath(file));
        System.out.println(FilenameUtils.getPath(file));
        System.out.println(FilenameUtils.getBaseName(file));
        System.out.println(FilenameUtils.getExtension(file));
        System.out.println(FilenameUtils.getFullPathNoEndSeparator(file));
        System.out.println(FilenameUtils.getPathNoEndSeparator(file));
        System.out.println(FilenameUtils.getPrefix(file));
        System.out.println(FilenameUtils.getName(file));
    }
}
