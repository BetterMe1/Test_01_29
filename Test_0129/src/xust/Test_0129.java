package xust;

/*
1. 有效的完全平方数
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
说明：不要使用任何内置的库函数，如  sqrt。

示例 1：
输入：16
输出：True

示例 2：
输入：14
输出：False
 */
/*
 * 算法思想：
 * 用二分逼近法，l=0;r = num < 46340 ? num : 46340;
 * int型 能存的最大数为2^31-1;能存的最大的平方数为46340^2，因此当num<46340时r=num,反之r=46340
 * 循环条件l<=r,计算l、r的中间数mid,判断mid的平方是否等于num,若等于,返回true.
 * 若mid的平方小于num，则l = mid +1，若mid的平方大于num，则r = mid -1，循环完毕若还是没有找到一个数的平方等于num，返回false。
 */
//public class Test_0129 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int num = 16;
//		System.out.println(So.isPerfectSquare(num));
//	}
//}
//class Solution {
//	 public boolean isPerfectSquare(int num) {
//		 int l = 0;
//		 int r = num < 46340 ? num : 46340;
//		 while(l <= r){
//			 int mid  = l + (r - l)/2;//防止数据溢出
//			 if(mid * mid == num){
//				 return true;
//			 }
//			 else if(mid * mid < num){
//				 l = mid +1;
//			 }
//			 else{
//				 r = mid -1;
//			 }
//		 }
//		 return false;
//	 }
//}
/*
2. 两整数之和
不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

示例 1:
输入: a = 1, b = 2
输出: 3

示例 2:
输入: a = -2, b = 3
输出: 1
 */
/*
 * 算法思想：a^b可以算两个数的和，但是不显示进位，只要再算出进位再加上进位即可。用a&b算出进位值，由于进位要高一位，carry = (a&b)<<1。
 */
//public class Test_0129 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int a = 2;
//		int b = 3;
//		System.out.println(So.getSum(a, b));
//	}
//}
//class Solution {
//    public int getSum(int a, int b) {
//       int sum = a^b;
//       int carry = (a&b)<<1;
//       if(carry != 0){
//    	   return getSum(sum,carry);
//       }
//       return sum;
//    }
//}

/*
3. 找不同
给定两个字符串 s 和 t，它们只包含小写字母。
字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
请找出在 t 中被添加的字母。

示例:
输入：
s = "abcd"
t = "abcde"
输出：
e
解释：
'e' 是那个被添加的字母。
 */
//public class Test_0129 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		String s = "abcd";
//		String t = "abcde";
//		System.out.println(So.findTheDifference(s, t));
//	}
//}
//class Solution {
//	public char findTheDifference(String s, String t) {
//    	char ret = t.charAt(0);
//		for(int i = 0; i<s.length(); i++){
//			ret = (char) (ret ^ (s.charAt(i)));
//			ret = (char) (ret ^ (t.charAt(i+1)));
//		}
//		return ret;
//    }
//}
/*
4. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
案例:
s = "leetcode"
返回 0.
s = "loveleetcode",
返回 2.
注意事项：您可以假定该字符串只包含小写字母。
 */
public class Test_0129 {
	public static void main(String[] args) {
		Solution So = new Solution();
		String s = "loveleetcode";
		System.out.println(So.firstUniqChar(s));
	}
}
class Solution {
    public int firstUniqChar(String s) {
        for(int i=0; i<s.length(); i++){
        	int j=0;
        	for(; j<s.length(); j++){
        		if(s.charAt(i) == s.charAt(j) && i!=j){
        			break;
        		}
        	}
        	if(j == s.length()){
        		return i;
        	}
        }
        return -1;
    }
}