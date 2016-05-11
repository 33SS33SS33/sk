package hard;

/**
 * Created by GAOSHANSHAN835 on 2016/5/11.
 */

/**
 * "Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * Given [3, 1, 5, 8]
 * Return 167
 * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167"
 */

/**
 * "k表示left和right之间的跨度  这个跨度是越来越大的
 * left和right是当前跨度下的 左右边界
 * dp[l][r]表示扎破(l, r)范围内所有气球获得的最大硬币数，不含边界；
 * i就是枚举当前left到right得范围内  扎破第i个气球的收益"
 */
public class BurstBalloons {
}
