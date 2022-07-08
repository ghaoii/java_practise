package io;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws Exception {
        File source = new File("/Users/harley/Desktop/code/FileTest/source.png");
        File dest = new File("/Users/harley/Desktop/code/FileTest/test/dest.png");
        try (InputStream is = new FileInputStream(source)) {
            try (OutputStream os = new FileOutputStream(dest)) {
                byte[] data = new byte[1024];
                int count = 0;
                while(true) {
                    int n = is.read(data);
                    if(n == -1) {
                        break;
                    }
                    // data不一定每次都会读满，读到多少数据，就拷贝多少数据
                    os.write(data, 0, n);
                    count += n;
                    System.out.println("当前共拷贝" + count + "个字节");
                }
                os.flush();
            }
        }
    }
}
