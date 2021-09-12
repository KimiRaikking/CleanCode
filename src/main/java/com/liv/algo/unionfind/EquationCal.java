package com.liv.algo.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 *
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 *
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 *  
 *
 * 提示：
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EquationCal {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,String> parent = new HashMap<>();
        Map<String,Double> weight = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            parent.computeIfAbsent(b, key -> {
                weight.put(b,1.0D);
                return b;
            });
            parent.computeIfAbsent(a, key -> {
                weight.put(a,1.0D);
                return a;
            });
            String pa = find(a,parent,weight);
            String pb = find(b,parent,weight);
            double newvalue= values[i]*weight.get(b)/weight.get(a);
            merge(pa,pb,newvalue, parent,weight);
        }
        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            String px = find(x,parent,weight);
            String py = find(y,parent,weight);
            if(null == px || null == py|| !px.equals(py)){
                res[i] = -1;
                continue;
            }
            res[i] = weight.get(x)/weight.get(y);
        }
        return res;
    }

    private void merge(String a, String b, double value, Map<String,String> parent,Map<String,Double> weight){
        if(value>=1){
            // a>b

            parent.put(a, find(b,parent,weight));
            weight.put(a,value*weight.get(b));
        }else{

            parent.put(b, find(a,parent,weight));
            weight.put(b,weight.get(a)/value);
        }
    }

    private String find(String x, Map<String,String> parent,Map<String,Double> weight){
        if(!parent.containsKey(x)){
            return null;
        }
        if(x.equals(parent.get(x))){
            return x;
        }else{
            String curParent = parent.get(x);
            String y = find(parent.get(x), parent,weight);
            parent.put(x,y);
            double oriWeight = weight.get(x);
            weight.put(x,oriWeight*weight.get(curParent));
            return y;
        }
    }
}
