/**
 * @功能:
 * @项目名:test
 * @作者:0cm
 * @日期:2019/8/28下午4:28
 */

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


class Solution {

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char flagChar = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = flagChar;
        }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        //先找出数组最大的数

        return null;
    }

    public static int[] plusOne(int[] digits) {
        int[] numOne = new int[digits.length];
        ArrayList<Integer> sumNumList = new ArrayList<Integer>();
        //给num0ne赋值
        for (int i = 0; i < numOne.length; i++) {
            if (i == numOne.length - 1) {
                numOne[i] = 1;
            } else {
                numOne[i] = 0;
            }
        }
        int flag = 0;//进位

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + numOne[i] + flag;
            flag = sum / 10;
            sumNumList.add(sum % 10);
        }
        if (flag > 0) {
            sumNumList.add(flag);
        }
        int[] finalNum = new int[sumNumList.size()];
        int length = sumNumList.size() - 1;
        for (int num : sumNumList
        ) {
            finalNum[length] = num;
            length--;
        }
        //digits和numOne相加
        return finalNum;
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public static boolean reorderedPowerOf2(int N) {

        return true;
    }

    public static int[] shortestToChar(String S, char C) {
        int[] shortLenArr = new int[S.length()];
        char[] charArr = S.toCharArray();
        int min = S.length();
        ArrayList<Integer> charLoc = new ArrayList<Integer>();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == C) {
                charLoc.add(i);
            }
        }
        for (int i = 0; i < shortLenArr.length; i++) {
            for (Integer loc : charLoc) {
                if (i >= loc) {
                    min = min < i - loc ? min : i - loc;
                } else {
                    min = min < loc - i ? min : loc - i;
                }
            }
            shortLenArr[i] = min;
            min = S.length();
        }
        return shortLenArr;
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            while (nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                if (nums[nums.length - 1] == nums[i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                len = i;
                break;
            }
        }

        return len + 1;
    }

    public static int maxProfit(int[] prices) {
        int n = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                n = prices[i + 1] - prices[i] + n;
            }
        }
        return n;
    }

    public static void rotate(int[] nums, int k) {
        int[] numsCopy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsCopy[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(numsCopy, 0, nums, 0, nums.length);
    }

    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int singleNumber(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    flag = false;
                }
            }
            if (flag) {
                return nums[i];
            } else {
                flag = true;
            }
        }
        return 0;
    }

    /**
     * 两个数组的交集 II （映射）
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        List<Integer> finalArr = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {//数组放到map里
            if (nums1Map.get(nums1[i]) == null) {
                nums1Map.put(nums1[i], 1);
            } else {
                nums1Map.replace(nums1[i], nums1Map.get(nums1[i]) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums1Map.get(nums2[i]) != null && nums1Map.get(nums2[i]) > 0) {
                finalArr.add(nums2[i]);
                nums1Map.get(nums2[i]);
                nums1Map.replace(nums2[i], nums1Map.get(nums2[i]) - 1);
            }
        }
        int[] finaA = new int[finalArr.size()];
        int length = 0;
        for (Integer num : finalArr) {
            finaA[length] = num;
            length++;
        }
        return finaA;
//        ArrayList<Integer> list = new ArrayList<>();
//        int[] smallNum = nums1.length>nums2.length?nums2:nums1;
//        int[] bigNum = nums1.length>nums2.length?nums1:nums2;
//        for (int i = 0; i < smallNum.length ; i++) {
//            for (int j = 0; j < bigNum.length ; j++) {
//                if (smallNum[i]==bigNum[j]){
//                    list.add(smallNum[i]);
//                    break;
//                }
//            }
//        }
//        int[] nums3 = new int[list.size()];
//        for (int i = 0; i <list.size() ; i++) {
//            nums3[i]=list.get(i);
//        }
//
//        return nums3;
    }

    /**
     * 移动零
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        int flagZero = 0;
        for (int i = 0; i < nums.length; i++) {//控制次数
            if (nums[j] == 0) {
                flagZero++;
                for (int k = j; k < nums.length - 1; k++) {
                    if (k == nums.length) {
                        break;
                    }
                    nums[k] = nums[k + 1];
                }
            } else {
                j++;
            }
        }
        for (int i = 0; i < flagZero; i++) {
            nums[nums.length - 1 - i] = 0;
        }

    }

    public static int firstUniqChar(String s) {
        boolean flag = true;
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (j == i) {
                    continue;
                }
                if (c[i] == c[j]) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 回文数
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] num = s.toCharArray();
        for (int i = 0; i < num.length / 2; i++) {
            if (num[i] != num[num.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最长回文子串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        return null;
    }

    /**
     * 验证回文字符串
     */
    public static boolean isPalindrome(String s) {
        //双指针法
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))) {
                start++;
                end--;
            } else {
                return false;
            }
//            if ((s.charAt(start)>'z'||s.charAt(start)<'A')&&(s.charAt(start)<'0'||s.charAt(start)>'9')){
//                start++;
//            }else if ((s.charAt(end)>'z'||s.charAt(end)<'A')&&(s.charAt(end)<'0'||s.charAt(end)>'9')){
//                end--;
//            }else if (s.charAt(start)==s.charAt(end)||s.charAt(start)==s.charAt(end)+32||s.charAt(start)==s.charAt(end)-32){
//               start++;
//               end--;
//           }else {
//                return false;
//            }
        }
        return true;
    }

//    /**
//     * 判断是不是字目
//     */
//    private Boolean is


    /**
     * 盛最多的水
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int heightLen = height[i] < height[j] ? height[i] : height[j];
                max = max > (j - i) * heightLen ? max : (j - i) * heightLen;
            }
        }
        return max;
    }

    /**
     * 盛最多的水for双指针法
     *
     * @param height
     * @return
     */
    public static int maxAreaByDouPoint(int[] height) {
        int max = 0;
        int shortPoint = 0;
        int longPoint = height.length - 1;
        while (shortPoint < longPoint) {
            max = Math.max(max, (longPoint - shortPoint) * Math.min(height[longPoint], height[shortPoint]));
            if (height[longPoint] > height[shortPoint]) {
                shortPoint++;
            } else {
                longPoint--;
            }
        }
        return max;
    }

    /**
     * 三数之和(三个for循环的傻比方法)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> arrList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = nums.length - 1; k > j; k--) {
                    if (nums[i] + nums[j] + nums[k] < 0) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[k]);
                        if (!arrList.contains(arr)) {
                            arrList.add(arr);
                        }
                    }
                }
//                for (int k = nums.length-1; k > j; k--) {
//                    if( nums[i]+nums[j]+nums[k]==0){
//                        List<Integer> arr = new ArrayList<>();
//                        arr.add(nums[i]);
//                        arr.add(nums[j]);
//                        arr.add(nums[k]);
//                        if (!arrList.contains(arr)){
//                            arrList.add(arr);
//                        }
//
//                    }
//                }
            }
        }
        return arrList;
    }

    /**
     * 最接近的三数之和 给定数组 nums = [-1，2，1，-4], 和 target = 1.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

    /**
     * 电话号码的字母组合
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<String, String> telNo = new HashMap<>();
        telNo.put("2", "abc");
        telNo.put("3", "def");
        telNo.put("4", "ghi");
        telNo.put("5", "jkl");
        telNo.put("6", "mno");
        telNo.put("7", "pqrs");
        telNo.put("8", "tuv");
        telNo.put("9", "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            list = Solution.addListFromNums(list, telNo.get(String.valueOf(digits.charAt(i))));
        }
        return list;
    }

    /**
     * 将字符串添加到List里
     * 假如 lsit{"abc"}  def
     *
     * @param list
     * @param s
     * @return
     */
    public static List<String> addListFromNums(List<String> list, String s) {
        List<String> newList = new ArrayList<>();
        if (list.size() == 0) {
            for (int i = 0; i < s.length(); i++) {
                newList.add(String.valueOf(s.charAt(i)));
            }
        } else {
            for (String ss : list) {
                StringBuffer sss = new StringBuffer(ss);
                for (int i = 0; i < s.length(); i++) {
                    sss = new StringBuffer(ss);
                    newList.add(sss.append(s.charAt(i)).toString());
                }
            }
        }
        return newList;
    }

    /**
     * 合并两个有序数组(ok)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[l];
            l++;
        }
        Arrays.sort(nums1);
    }

    /**
     * 寻找两个有序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0) {
            if (nums2.length % 2 > 0) {//奇数
                return nums2[nums2.length / 2];
            } else {
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 + 1]) / 2;
            }
        } else if (nums2.length == 0) {
            if (nums1.length % 2 > 0) {//奇数
                return nums1[nums1.length / 2];
            } else {
                return (nums1[nums1.length / 2] + nums1[nums1.length / 2 + 1]) / 2;
            }
        } else {
            int[] sumNum = new int[nums1.length + nums2.length];
            for (int i = 0; i < nums1.length; i++) {
                sumNum[i] = nums1[i];
            }
            for (int i = 0; i < nums2.length; i++) {
                sumNum[nums1.length + i] = nums2[i];
            }
            Arrays.sort(sumNum);
            if (sumNum.length % 2 > 0) {//奇数
                return sumNum[sumNum.length / 2];
            } else {
                return (sumNum[sumNum.length / 2] + sumNum[sumNum.length / 2 + 1]) / 2;
            }
        }


//        return sumNum[]
    }

    public int game(int[] guess, int[] answer) {
        int rightCount = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                rightCount++;
            }
        }
        return rightCount;
    }

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == J.charAt(i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int lengthOfLongestSubstring(String s) {//20191113未写完
        //滑动窗口原理
        char[] c = s.toCharArray();
        boolean flag = false;
        int maxLength = 0;
        ArrayList<Character> win = new ArrayList<>();//窗口
        for (int i = 0; i < s.length(); i++) {
            for (char cc : win) {
                if (c[i] == cc) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                win.add(c[i]);
                maxLength = maxLength > win.size() ? maxLength : win.size();
            } else {
                maxLength = maxLength > win.size() ? maxLength : win.size();
                win.clear();
                win.add(c[i]);
            }
        }
        return maxLength;
    }

    public boolean allUnique(String s) {

        return true;
    }


    /**
     * 一个强密码应满足以下所有条件：
     * 由至少6个，至多20个字符组成。
     * 至少包含一个小写字母，一个大写字母，和一个数字。
     * 同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
     */
    public int strongPasswordChecker(String s) {

        return 0;
    }

    /**
     * 有效的数独
     */
    public static boolean isValidSudoku(char[][] board) {
        return true;
    }

    /**
     * 多数元素
     *
     * @param nums
     */
    public static int majorityElement(int[] nums) {
        int t = nums.length / 2;
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numMap.get(nums[i]) == null) {
                numMap.put(nums[i], 1);
            } else {
                numMap.replace(nums[i], numMap.get(nums[i]) + 1);
                if (numMap.get(nums[i]) > t) {
                    return nums[i];
                }
            }

        }
        return nums[0];
    }

    /**
     * 搜索二维矩阵 II
     *
     * @param matrix
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        return true;
    }

    /**
     * 整数反转
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long newX = 0;
        while (x != 0) {
            newX = newX * 10 + x % 10;
            if (newX > Integer.MAX_VALUE || newX < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) newX;
    }

    /**
     * 有效的字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> T = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (T.get(t.charAt(i)) == null) {
                T.put(t.charAt(i), 1);
            } else {
                T.replace(t.charAt(i), T.get(t.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (T.get(s.charAt(i)) != null && T.get(s.charAt(i)) > 0) {
                T.replace(s.charAt(i), T.get(s.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * 字符串转换整数 (atoi) 1.跳过空字符 2.确定正负号 3.找出数字部分
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        //先去空格;
        String newStr = str.trim();
        //1.跳过空字符
        int loc = newStr.length();
        if (loc == 0) {
            return 0;
        }
        if (loc == 1 && newStr.charAt(0) == '-') {
            return 0;
        }
        if (!(newStr.charAt(0) >= '0' && newStr.charAt(0) <= '9' || newStr.charAt(0) == '-')) {
            return 0;
        }
        for (int i = 0; i < newStr.length(); i++) {
            if (i > 0 && newStr.charAt(i) == '.') {
                loc = i;
                break;
            }
            if (!(newStr.charAt(i) >= '0' && newStr.charAt(i) <= '9' || newStr.charAt(i) == '-')) {
                loc = i;
                break;
            }
        }
        String finalStr = newStr.substring(0, loc);
        try {
            int finalNum = Integer.parseInt(finalStr);
            return finalNum;
        } catch (Exception e) {
            return Integer.MIN_VALUE;
        }

    }

    /**
     * 实现 strStr()
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {

        }
        return -1;
    }

    /**
     * 报数（递归）
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String finaInt = "1";
        StringBuffer finalIntBuffer = new StringBuffer("11");
        StringBuffer newFinalIntBuffer = new StringBuffer();
        if (n == 1) {
            return finaInt;
        }
        for (int i = 1; i < n - 1; i++) {//要进行递归的次数
            //读出finaInt中的数据
            int left = 0;
            int right = 1;
            while (right < finalIntBuffer.length()) {
                if (finalIntBuffer.charAt(right) == finalIntBuffer.charAt(left)) {
                    right++;
                } else {
                    newFinalIntBuffer.append(right - left);
                    newFinalIntBuffer.append(finalIntBuffer.charAt(left));
                    left = right;
                    right++;
                }
            }
            newFinalIntBuffer.append(right - left);
            newFinalIntBuffer.append(finalIntBuffer.charAt(left));
            finalIntBuffer = newFinalIntBuffer;
            newFinalIntBuffer = new StringBuffer("");
        }
        return finalIntBuffer.toString();
    }

    /**
     * 最长公共前缀
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int loc = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {//获取数组最短的字符串长度
            minLen = minLen < strs[i].length() ? minLen : strs[i].length();
        }
        System.out.println(minLen);
        while (loc < minLen) {
            strs[0].charAt(loc);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(loc) != strs[0].charAt(loc)) {
                    return strs[0].substring(0, loc);
                }
            }
            loc++;
        }
        return strs[0].substring(0, loc);
    }

    /**
     * 爬楼梯 （动态规划）
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 打家劫舍
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        return -1;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //计算链表的长度
        int length = 0;
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        while (head.next != null) {
            length++;
        }
        System.out.println(length);
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Solution.climbStairs(4));
//        System.out.println(Solution.longestCommonPrefix(new String[]{"ffnd","ff","ff"}));
        //13112221  1113213211  31131211131221
//        System.out.println(Solution.countAndSay(23));
//        System.out.println(Solution.myAtoi(" -42"));
//          System.out.println('a'-'z');

//        Solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        List<String> list=new ArrayList<>();
//        list = Solution.letterCombinations("223");
//        for (String ss: list
//             ) {
//            System.out.println(ss);
//        }
//        System.out.println(Solution.letterCombinations);
//        System.out.println(Solution.isPalindrome("0P"));
//        System.out.println(Solution.isAnagram("anagram","nagaram"));
//        System.out.println(Solution.reverse(1534236469));
//         int[] num1 = new int[]{3,2,3};
//        System.out.println(Solution.majorityElement(num1));
//          char [][] sudo = new char[][]{{}};
//        int[] num1 = new int[]{4,9,5};
//        int[] num2 = new int[]{9,4,9,8,4};
//        Solution.intersect(num1,num2);
//        System.out.println(Solution.findMedianSortedArrays(num1,num2));
//        System.out.println( Solution.isPalindrome(1221));
//        int [] height = new int[]{1,8,6,2,5,4,8,3,7};
//        System.out.println(Solution.maxArea(height));
//        System.out.println(Solution.maxAreaByDouPoint(height));
//        String s = "loveleetcode";
//        System.out.println(Solution.firstUniqChar(s));
//          char[] s = new char[]{'h','e','l','l'};
//          Solution.reverseString(s);
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(s[i]);
//        }
//        int[] num = new int[]{1,2,3};
//        int [] newNum = Solution.plusOne(num);
//        for (int i = 0; i <newNum.length ; i++) {
//            System.out.print(newNum[i]);
//        }

//        Scanner sc = new Scanner(System.in);
//        do {
//            int i = sc.nextInt();
//            System.out.println(Solution.isPowerOfThree(i));
//        }while (true);

//        for (int i = 1; i <= 2147483647; i++) {
//            if (Solution.isPowerOfThree(i)){
//                System.out.println(i);
//            }
//
//        }
//        int[] nums4 = new int[]{0,1,2,0,4,0};
//        Solution.moveZeroes(nums4);
//        for (int i = 0; i <nums4.length ; i++) {
//            System.out.println(nums4[i]);
//        }
//        String s = "loveleetcode";
//        char c = 'e';
//        int[] test = Solution.shortestToChar(s,c);
//        for (int i = 0; i < test.length; i++) {
//            System.out.println(test[i]);
//        }
//
//        System.out.println(new Date());
//        int[] nums3 = new int[]{2,2,1};
//        System.out.println(Solution.containsDuplicate(nums3));
//        System.out.println(Solution.singleNumber(nums3));
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int len = Solution.removeDuplicates(nums);
//
//        int[] nums2 = new int[]{1,2,3,4,5,6,7};
//        Solution.rotate(nums2,3);
//        for (int n: nums
//             ) {
//            System.out.println(n);
//        }
//        for (int n: nums2
//                ) {
//            System.out.println(n);
//        }
//        System.out.println(len);
//        System.out.println(Solution.lengthOfLongestSubstring("dvdf"));
//        int[] a = new int[10];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = i;
//        }
//        for (int b:a) {
//            System.out.println(b);
//        }
//        for (String arg: args
//             ) {
//            System.out.println(arg);
//        }
    }
}
