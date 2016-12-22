package mine;

import java.util.Arrays;
import java.util.List;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

}

public class LeetCode {
	/* 
	 * 1. Two Sum
	 * 
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	 * You may assume that each input would have exactly one solution.
	 * 
	 * Example:
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * Because nums[0] + nums[1] = 2 + 7 = 9,
	 * return [0, 1].
	 * 
	 * UPDATE (2016/2/13):
	 * The return format had been changed to zero-based indices. 
	 * Please read the above updated description carefully.
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					return new int[] { i, j };
				}
			}
		}
		return nums;
	}
	
	/*
	 * 2. Add Two Numbers
	 * You are given two linked lists representing two non-negative numbers. 
	 * The digits are stored in reverse order and each of their nodes contain a single digit. 
	 * Add the two numbers and return it as a linked list.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int temp = l1.val + l2.val;
		ListNode result = new ListNode(temp % 10);
		ListNode tmp = result;
		while (true) {
			if (l1.next == null && l2.next == null) {
				break;
			}
			l1 = l1.next == null ? new ListNode(0) : l1.next;
			l2 = l2.next == null ? new ListNode(0) : l2.next;
			temp = temp / 10 + l1.val + l2.val;
			tmp.next = new ListNode(temp % 10);
			tmp = tmp.next;
		}
		if (temp / 10 > 0) {
			tmp.next = new ListNode(temp / 10);
		}
		return result;
	}

	/*
	 * 3. Longest Substring Without Repeating Characters
	 * Given a string, find the length of the longest substring without repeating characters.
	 * 
	 * Examples:
	 * Given "abcabcbb", the answer is "abc", which the length is 3.
	 * Given "bbbbb", the answer is "b", with the length of 1.
	 * Given "pwwkew", the answer is "wke", with the length of 3. 
	 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int length = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.substring(i, j).indexOf(s.charAt(j)) > -1) {
					length = j - i;
					break;
				} else {
					length++;
				}
			}
			if (length > result) {
				result = length;
			}
		}
		if (result == 0) {
			result = s.length();
		}
		return result;
	}

	/*
	 * 4. Median of Two Sorted Arrays
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	 * 
	 * Example 1:
	 * nums1 = [1, 3]
	 * nums2 = [2]
	 * The median is 2.0
	 * 
	 * Example 2:
	 * nums1 = [1, 2]
	 * nums2 = [3, 4]
	 * The median is (2 + 3)/2 = 2.5
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int target = (nums1.length + nums2.length) / 2;
		int i = 0;
		int j = 0;
		int index = 0;
		double a = 0.0;
		double b = 0.0;
		boolean flag = true;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				if (index == target - 1) {
					a = nums1[i];
				} else if (index == target) {
					b = nums1[i];
					flag = false;
					break;
				}
				i++;
			} else {
				if (index == target - 1) {
					a = nums2[j];
				} else if (index == target) {
					b = nums2[j];
					flag = false;
					break;
				}
				j++;
			}
			index++;
		}
		if (flag) {
			while (i < nums1.length) {
				if (index == target - 1) {
					a = nums1[i];
				} else if (index == target) {
					b = nums1[i];
					break;
				}
				i++;
				index++;
			}
			while (j < nums2.length) {
				if (index == target - 1) {
					a = nums2[j];
				} else if (index == target) {
					b = nums2[j];
					break;
				}
				j++;
				index++;
			}
		}
		if ((nums1.length + nums2.length) % 2 == 1) {
			return b;
		} else {
			return (a + b) / 2;
		}
	}
	
	/*
	 * 5. Longest Palindromic Substring
	 * Given a string s, find the longest palindromic substring in s. 
	 * You may assume that the maximum length of s is 1000.
	 * 
	 * Example:
	 * Input: "babad"
	 * Output: "bab"
	 * Note: "aba" is also a valid answer.
	 */
	public String longestPalindrome(String s) {
		String result = "";
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			left = i;
			right = i;
			while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			left++;
			if ((right - left) > result.length()) {
				result = s.substring(left, right);
			}
			left = i;
			right = i + 1;
			while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			left++;
			if ((right - left) > result.length()) {
				result = s.substring(left, right);
			}
		}
		return result;
	}
	/*
	 * 6. ZigZag Conversion
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
	 * (you may want to display this pattern in a fixed font for better legibility)
	 * P   A   H   N
	 * A P L S I I G
	 * Y   I   R
	 * And then read line by line: "PAHNAPLSIIGYIR"
	 * Write the code that will take a string and make this conversion given a number of rows:
	 * 
	 * string convert(string text, int nRows);
	 * 
	 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 */
	public String convert(String s, int numRows) {
		StringBuilder result = new StringBuilder();
		char[][] temp = new char[numRows][];
		if (numRows == 1) {
			return s;
		} else {
			for (int i = 0; i < temp.length; i++) {
				temp[i] = new char[s.length() / 2 + 1];
			}
			int x = 0;
			int y = 0;
			boolean flag = true;
			for (int i = 0; i < s.length(); i++) {
				temp[x][y] = s.charAt(i);
				if (x == (numRows - 1)) {
					flag = false;
				} else if (x == 0) {
					flag = true;
				}
				if (flag) {
					x++;
				} else {
					x--;
					y++;
				}
			}
		}
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < (s.length() / 2 + 1); j++) {
				if (!"".equals(String.valueOf(temp[i][j]).trim())) {
					result.append(temp[i][j]);
				}
			}
		}
		return result.toString();
	}
	/*
	 * 7. Reverse Integer
	 * Reverse digits of an integer.
	 * Example1: x = 123, return 321
	 * Example2: x = -123, return -321
	 */
	public int reverse(int x) {
		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x = x / 10;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) result;
	}
	/*
	 * 8. String to Integer (atoi)
	 * Implement atoi to convert a string to an integer.
	 * Hint: Carefully consider all possible input cases. 
	 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
	 * 
	 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
	 * You are responsible to gather all the input requirements up front.
	 * 
	 * Update (2015-02-10):
	 * The signature of the C++ function had been updated. 
	 * If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
	 */
	public int myAtoi(String str) {
		int result = 0;
		str = str.trim();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if ((i == 0 && (temp == '-' || temp == '+')) || (temp >= '0' && temp <= '9')) {
				sb.append(temp);
				if (sb.length() > 11) {
					break;
				}
			} else {
				break;
			}
		}
		try {
			long tempInt = Long.parseLong(sb.toString());
			if (tempInt > Integer.MAX_VALUE) {
				result = Integer.MAX_VALUE;
			} else if (tempInt < Integer.MIN_VALUE) {
				result = Integer.MIN_VALUE;
			} else {
				result = (int) tempInt;
			}
		} catch (NumberFormatException e) {
			return 0;
		}
		return result;
	}
	
	/*
	 * 9. Palindrome Number
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int temp = x;
		int result = 0;
		while (temp != 0) {
			result = result * 10 + temp % 10;
			temp = temp / 10;
		}
		return result == x;
	}
	/*
	 * 10. Regular Expression Matching
	 * Implement regular expression matching with support for '.' and '*'.
	 * 
	 * '.' Matches any single character.
	 * '*' Matches zero or more of the preceding element.
	 * 
	 * The matching should cover the entire input string (not partial).
	 * The function prototype should be:
	 * bool isMatch(const char *s, const char *p)
	 * 
	 * Some examples:
	 * isMatch("aa","a") → false
	 * isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false
	 * isMatch("aa", "a*") → true
	 * isMatch("aa", ".*") → true
	 * isMatch("ab", ".*") → true
	 * isMatch("aab", "c*a*b") → true
	 */
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() == 0 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		} else {
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return isMatch(s, p.substring(2));
		}
	}
	/*
	 * 11. Container With Most Water
	 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
	 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	 * Note: You may not slant the container.
	 */
	public int maxArea(int[] height) {
		int result = 0, start = 0, end = height.length - 1;
		while (start < end) {
			result = Math.max(result, Math.min(height[start], height[end]) * (end - start));
			if (height[start] > height[end]) {
				end--;
			} else {
				start++;
			}
		}
		return result;
	}
	/*
	 * 12. Integer to Roman
	 * Given an integer, convert it to a roman numeral.
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	public String intToRoman(int num) {
		String[][] roman = new String[][]{{"","I","II","III","IV","V","VI","VII","VIII","IX"},
										  {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
										  {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
										  {"","M","MM","MMM"}};
		StringBuilder sb = new StringBuilder();
		sb.append(roman[3][num/1000]);
		sb.append(roman[2][(num%1000)/100]);
		sb.append(roman[1][(num%100)/10]);
		sb.append(roman[0][num%10]);
		return sb.toString();
    }
	/*
	 * 13. Roman to Integer
	 * Given a roman numeral, convert it to an integer.
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	public int romanToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'M':
				result += 1000;
				break;
			case 'D':
				result += 500;
				break;
			case 'C':
				if (i < s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
					result -= 100;
				} else {
					result += 100;
				}
				break;
			case 'L':
				result += 50;
				break;
			case 'X':
				if (i < s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
					result -= 10;
				} else {
					result += 10;
				}
				break;
			case 'V':
				result += 5;
				break;
			case 'I':
				if (i < s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
					result -= 1;
				} else {
					result += 1;
				}
				break;
			default:
				break;
			}
		}
		return result;
	}
	/*
	 * 14. Longest Common Prefix
	 * Write a function to find the longest common prefix string amongst an array of strings.
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String result = strs[0];
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() == 0) {
				return "";
			}
			int mark = 0;
			while (mark < result.length() && mark < strs[i].length()) {
				if (result.charAt(mark) == strs[i].charAt(mark)) {
					mark++;
				} else {
					break;
				}
			}
			result = result.substring(0, mark);
		}
		return result;
	}
	/*
	 * 15. 3Sum
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
	 * Find all unique triplets in the array which gives the sum of zero.
	 * Note: The solution set must not contain duplicate triplets.
	 * For example, given array S = [-1, 0, 1, 2, -1, -4],
	 * A solution set is:
	 * [
	 *   [-1, 0, 1],
	 *   [-1, -1, 2]
	 * ]
	 */
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	if (nums.length<3) {
			return null;
		}
    	for(int i=0;i<nums.length-2;i++){
    		
    	}
        return null;
    }
	
	public static void main(String[] args) {
		LeetCode leetCode = new LeetCode();
		try {
			leetCode.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
