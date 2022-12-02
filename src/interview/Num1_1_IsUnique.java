package interview;

public class Num1_1_IsUnique {
    public boolean isUnique(String astr) {
        if(astr == null || astr.length() < 2) {
            return true;
        }

        int[] arr = new int[26];

        for(char ch : astr.toCharArray()) {
            if(arr[ch - 'a'] > 0) {
                return false;
            }
            arr[ch - 'a']++;
        }

        return true;
    }
}
