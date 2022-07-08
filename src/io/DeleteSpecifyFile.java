package io;

import java.io.File;
import java.util.Scanner;

public class DeleteSpecifyFile {
    public static void main(String[] args) {
        File dir = new File("/Users/harley/Desktop/code/FileTest/b");
        searchFile(dir, "c");
    }

    private static void searchFile(File dir, String str) {
        File[] files = dir.listFiles();
        if(files == null) {
            return;
        }
        for (File file : files) {
            if(file.isDirectory()) {
                searchFile(file, str);
            }else {
                String fileName = file.getName();
                if(fileName.contains(str)) {
                   while(true) {
                       System.out.println(fileName + "文件包含字符串：" + str + "，请问是否删除?");
                       System.out.println("如果想要删除该文件，请输入yes，否则输入no");
                       Scanner scanner = new Scanner(System.in);
                       String choice = scanner.nextLine();
                       if(choice.equals("yes")) {
                           // 删除文件
                           System.out.println(file.delete());
                           break;
                       }else if(choice.equals("no")){
                           break;
                       }else {
                           System.out.println("输入有误！请重新输入！");
                       }
                   }
                }
            }
        }
    }
}
