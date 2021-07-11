package com.liv.algo.binary;


/***
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 *
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 *
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 *
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
 * 输出：3
 * 解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
 * 现在需要制作 3 束花，每束只需要 1 朵。
 * 1 天后：[x, _, _, _, _]   // 只能制作 1 束花
 * 2 天后：[x, _, _, _, x]   // 只能制作 2 束花
 * 3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
 * 示例 2：
 *
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 2
 * 输出：-1
 * 解释：要制作 3 束花，每束需要 2 朵花，也就是一共需要 6 朵花。而花园中只有 5 朵花，无法满足制作要求，返回 -1 。
 * 示例 3：
 *
 * 输入：bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * 输出：12
 * 解释：要制作 2 束花，每束需要 3 朵。
 * 花园在 7 天后和 12 天后的情况如下：
 * 7 天后：[x, x, x, x, _, x, x]
 * 可以用前 3 朵盛开的花制作第一束花。但不能使用后 3 朵盛开的花，因为它们不相邻。
 * 12 天后：[x, x, x, x, x, x, x]
 * 显然，我们可以用不同的方式制作两束花。
 * 示例 4：
 *
 * 输入：bloomDay = [1000000000,1000000000], m = 1, k = 1
 * 输出：1000000000
 * 解释：需要等 1000000000 天才能采到花来制作花束
 * 示例 5：
 *
 * 输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
 * 输出：9
 *  
 *
 * 提示：
 *
 * bloomDay.length == n
 * 1 <= n <= 10^5
 * 1 <= bloomDay[i] <= 10^9
 * 1 <= m <= 10^6
 * 1 <= k <= n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BloomLeastDaysCal {

    public int minDays(int[] bloomDay, int m, int k) {
        int totalNeedBloom = m * k;
        if (totalNeedBloom > bloomDay.length) {
            return -1;
        }
        int minBloomDay = Integer.MAX_VALUE;
        int maxBloomDay = Integer.MIN_VALUE;
        for (int bloom : bloomDay) {
            minBloomDay = Math.min(minBloomDay, bloom);
            maxBloomDay = Math.max(maxBloomDay, bloom);
        }
        int left = minBloomDay;
        int right = maxBloomDay;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBloomDaysSatisfied(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBloomDaysSatisfied(int[] bloomDay, int m, int k, int bloomDayMax) {
        int count = 0;
        for (int i = 0; i < bloomDay.length; ) {
            boolean isSatisfied = true;
            for (int j = 0; j < k; j++) {
                if ((i + j) < bloomDay.length && bloomDay[i + j] <= bloomDayMax) {
                    // ok
                } else {
                    isSatisfied = false;
                    i = i + j + 1;
                    break;
                }
            }
            if (isSatisfied) {
                i = i + k;
                count++;
            }
        }
        return count >= m;
    }
}
