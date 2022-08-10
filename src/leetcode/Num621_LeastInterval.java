package leetcode;

public class Num621_LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] hashTable = new int[26];
        int max = 0;
        for(char ch : tasks) {
            max = Math.max(max, ++hashTable[ch - 'A']);
        }
        int num = 0;
        for(int i : hashTable) {
            if(i == max) {
                num++;
            }
        }
        return Math.max((max - 1) * (n + 1) + num,  tasks.length);
    }
}
