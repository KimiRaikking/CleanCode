package com.liv.algo.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 677. 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 */
public class MapSum {

    private TreeNode root;

    private Map<String, Integer> map ;
    public MapSum() {
        root = new TreeNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int diffValue = val - map.getOrDefault(key, 0);
        map.put(key,val);
        dfs(root, key, -1, diffValue);
    }

    public int sum(String prefix) {
        return find(root, prefix, -1);
    }

    private int find(TreeNode node, String prefix, int index){
        if(null == node){
            return 0;
        }
        index++;
        if(index == prefix.length()){
            return node.val;
        }
        return find(node.getChildren().get(prefix.charAt(index)), prefix, index);
    }

    private void dfs(TreeNode node, String word, int index, int val){
        node.val += val;
        index++;
        if(index == word.length()){
            return;
        }
        char curChar = word.charAt(index);
        TreeNode childNode = node.children.computeIfAbsent(curChar, k-> new TreeNode());
        dfs(childNode, word,index, val);
    }

    public static class TreeNode{

        private int val;

        private Map<Character, TreeNode> children = new HashMap<>();

        public TreeNode() {
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }


        public Map<Character, TreeNode> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, TreeNode> children) {
            this.children = children;
        }
    }
}
