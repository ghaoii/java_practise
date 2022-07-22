package leetcode;

import java.util.*;

public class Num49_GroupAnagrams {
    // 哈希表
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] hash = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                hash[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if(hash[j] != 0) {
                    sb.append((char)(j + 'a'));
                    sb.append(hash[j]);// 每个字母出现得次数也需要写
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(strs[i]);
            map.put(sb.toString(), list);
        }
        List<List<String>> ret = new ArrayList<>(map.values());
        return ret;
    }


    // 排序
//    public List<List<String>> groupAnagrams(String[] strs)  {
//        Map<String, List<String>> map = new HashMap<>();
//        List<List<String>> ret = new ArrayList<>();
//        for (int i = 0; i < strs.length; i++) {
//            char[] ch = strs[i].toCharArray();
//            Arrays.sort(ch);
//            String str = new String(ch);
//            List<String> list = map.getOrDefault(str, new ArrayList<>());
//            list.add(strs[i]);
//            map.put(str, list);
//        }
//        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
//            ret.add(entry.getValue());
//        }
//        return ret;
//    }
}
