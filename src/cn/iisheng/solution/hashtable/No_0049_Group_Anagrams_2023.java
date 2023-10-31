package cn.iisheng.solution.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author iisheng
 * @date 2023/10/08 15:18:33
 */
public class No_0049_Group_Anagrams_2023 {
    
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
    
    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            if (list.size() == 1) {
                result.add(list);
            }
            map.put(key, list);
        }
        return result;
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            // 将字符串key放入map
            map.put(str, 1);
        }
        List<List<String>> result = new ArrayList<>();
        while (!map.isEmpty()) {
            List<String> cur = new ArrayList<>();
            String s = map.keySet().stream().findAny().get();
            List<String> anagrams = getAnagrams(s);
            for (String anagram : anagrams) {
                if (map.containsKey(anagram)) {
                    cur.add(anagram);
                    map.remove(anagram);
                }
            }
            result.add(cur);
        }
        return result;
    }
    
    private static List<String> getAnagrams(String str) {
        List<String> result = new ArrayList<>();
        df(str, "", result);
        return result;
    }
    
    private static void df(String x, String y, List<String> list) {
        if (x.length() == 0) {  //判断一下，如果String s 的长度为0 则直接输出字符串y
//            System.out.println(y);
            list.add(y);
            return;   //结束
        }
        
        for (int i = 0; i < x.length(); i++) {//循环将的到的字符串排列输出
            String news = x.substring(0, i) + x.substring(i + 1, x.length());
            df(news, y + x.charAt(i), list);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(groupAnagrams1(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams1(new String[]{"", ""}));
//        String str = "abc";  // 给定的字符串
//        df(str, "", new ArrayList<>());
    }
}
