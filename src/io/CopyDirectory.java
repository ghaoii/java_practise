package io;

import java.io.*;

public class CopyDirectory {
    public static void main(String[] args) throws IOException {
        File source = new File("/Users/harley/Desktop/code/FileTest/b");
        File dest = new File("/Users/harley/Desktop/code/FileTest/copyb");
        traversal(source, dest);
    }

    private static void traversal(File source, File dest) throws IOException {
        File[] files = source.listFiles();
        for(File file : files) {
            String sourPath = source.getCanonicalPath();
            String filePath = file.getCanonicalPath();
            String destPath = dest.getCanonicalPath();
            String relativePath = destPath + filePath.substring(sourPath.length());
            if(file.isDirectory()) {
                // 创建目录
                File newDir = new File(relativePath);
                newDir.mkdir();
                traversal(file, newDir);
            }else {
                // 拷贝普通文件
                try (InputStream is = new FileInputStream(file)) {
                    try (OutputStream os = new FileOutputStream(relativePath)) {
                        byte[] data = new byte[1024];
                        while(true) {
                            int n = is.read(data);
                            if(n == -1) {
                                break;
                            }
                            // data不一定每次都会读满，读到多少数据，就拷贝多少数据
                            os.write(data, 0, n);
                        }
                        os.flush();
                    }
                }
            }
        }
    }
}
