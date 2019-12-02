package cn.iisheng.solution.bfs;

import javafx.util.Pair;

import java.util.*;

/**
 * @author iisheng
 * @date 2019/11/20 12:24:07
 */
public class No_0127_WordLadder {

    public static void main(String[] args) {
        int path = ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(path);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 所有单词有相同的长度
        int length = beginWord.length();

        // 由Key Value组成的 字典
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < length; i++) {
                // Key 是通用的单词
                // Value 是所有能通过改变一个单词可以转化为Key 的单词 列表
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                ArrayList<String> transformations =
                        allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        // 队列用来给 BFS 使用
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        // 用HashMap 记录访问过的节点
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < length; i++) {

                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);

                // 下一状态是共享相同中间状态的所有单词。
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // 找到 endWord 返回 level + 1
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // 否则 加入BFS 队列中 标记该节点访问过 次数 +1
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
