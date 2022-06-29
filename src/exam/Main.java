package exam;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            if(str.length() == 0) {
                System.out.println(str);
                return;
            }
            char[] ch = str.toCharArray();
            List<String> strings = new ArrayList<>();
            boolean isNum = ch[0] >= '0' && ch[0] <= '9';
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < ch.length; i++) {
                if(ch[i] >= '0' && ch[i] <= '9' && isNum) {
                    sb.append(ch[i]);
                }else if(ch[i] >= '0' && ch[i] <= '9' && !isNum) {
                    sb = new StringBuilder();
                    sb.append(ch[i]);
                    isNum = true;
                }else if((ch[i] < '0' || ch[i] > '9') && isNum) {
                    strings.add(sb.toString());
                    isNum = false;
                }
            }
            if(isNum) {
                strings.add(sb.toString());
            }
            int index = 0;
            int max = 0;
            for (int i = 0; i < strings.size(); i++) {
                if(strings.get(i).length() > max) {
                    max = strings.get(i).length();
                    index = i;
                }
            }
            System.out.println(strings.get(index));
        }
    }



//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String str = scanner.nextLine();
//            if(str.length() == 0) {
//                System.out.println(str);
//            }
//            char[] ch = str.toCharArray();
//            List<String> list = new ArrayList<>();
//            int i = 0;
//            boolean isNum = ch[0] >= '0' && ch[0] <= '9';
//            for(int j = 1; j < ch.length; j++) {
//                if((ch[j] < '0' || ch[j] > '9') && isNum) {
//                    list.add(str.substring(i, j));
//                    isNum = false;
//                }else if(ch[j] >= '0' && ch[j] <= '9' && !isNum) {
//                    i = j;
//                    isNum = true;
//                }
//            }
//            if(isNum) {
//                list.add(str.substring(i, str.length()));
//            }
//            if(list.size() == 0) {
//                System.out.println("");
//                return;
//            }
//            int index = 0;
//            int max = 0;
//            // 遍历list
//            for(int j = 0; j < list.size(); j++) {
//                if(list.get(j).length() > max) {
//                    max = list.get(j).length();
//                    index = j;
//                }
//            }
//            System.out.println(list.get(index));
//        }
//    }
}
