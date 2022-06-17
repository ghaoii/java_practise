package exam;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        int count = 0;
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            String[] food = str.split(" ");
            for (int i = 0; i < food.length; i++) {
                set.add(food[i]);
            }
        }
        for(String food : set){
            count++;
        }
        System.out.println(count);
    }
}
