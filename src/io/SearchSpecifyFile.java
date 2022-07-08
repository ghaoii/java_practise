package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class SearchSpecifyFile {
    public static void main(String[] args) throws IOException {
        File dir = new File("/Users/harley/Desktop/code/FileTest/b");
        searchFile(dir, "test");
    }

    private static void searchFile(File dir, String str) throws IOException {
        File[] files = dir.listFiles();
        if(files == null) {
            return;
        }
        for(File file : files) {
            if(file.isDirectory()) {
                // 如果是目录，则进行深度搜索
                searchFile(file, str);
            }else {
                // 如果是文件，先判断文件名是否有包含指定字符串
                String fileName = file.getName();
                if(fileName.contains(str)) {
                    System.out.println(fileName + "的文件名包含了字符串：" + str);
                }
                // 然后判断文件内容是否包含指定字符串
                try (InputStream is = new FileInputStream(file)) {
                    try (Scanner scanner = new Scanner(is)) {
                        while(scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if(line.contains(str)) {
                                System.out.println(fileName + "文件的内容：" + line + "中，包含了指定字符串：" + str);
                            }
                        }
                    }
                }
            }
        }
    }
}
