package com.veio007.jtinyframe.util;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class FileUtil {
    /**
     * 获取完整路径 eg: c:/dir/file.txt => c:/dir/
     *
     * @param filePath
     * @return String
     */
    public String getFullPath(String filePath) {
        return FilenameUtils.getFullPath(filePath);
    }

    /**
     * 获取文件所在目录 eg: c:/dir/file.txt => dir/
     *
     * @param filePath
     * @return String
     */
    public String getPath(String filePath) {
        return FilenameUtils.getPath(filePath);
    }

    /**
     * 获取文件名 eg: c:/dir/file.txt => file.txt
     *
     * @param filePath
     * @return String
     */
    public String getFileName(String filePath) {
        return FilenameUtils.getName(filePath);
    }

    /**
     * 获取文件名不包含后缀 eg: c:/dir/file.txt => file
     *
     * @param filePath
     * @return String
     */
    public String getBaseFileName(String filePath) {
        return FilenameUtils.getBaseName(filePath);
    }

    /**
     * 获取文件后缀 eg: c:/dir/file.txt => txt
     *
     * @param filePath
     * @return String
     */
    public String getExtension(String filePath) {
        return FilenameUtils.getExtension(filePath);
    }

    /**
     * 获得文件路径不包含后缀 eg: c:/dir/file.txt => c:/dir/file
     *
     * @param filePath
     * @return String
     */
    public String getPathWithNoExtension(String filePath) {
        return FilenameUtils.getFullPath(filePath) + FilenameUtils.getBaseName(filePath);
    }

    /**
     * 创建目录
     * @param path
     * @return 是否创建成功
     */
    public boolean mkDir(String path) {
        try {
            FileUtils.forceMkdir(FileUtils.getFile(path));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
