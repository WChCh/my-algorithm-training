package demo;

/**
 * 
 * 题目描述： 假设这有一个各种字母组成的字符串A，和另外一个字符串B，字符串里B的字母数相对少一些。
 * 什么方法能最快的查出所有小字符串B里的字母在大字符串A里都有？
 * 
 */
public class CompareStr {
	/**
	 * o(m*n)
	 */
	public boolean compareStr(String source, String target) {
		if (source == null || target == null) {
			return false;
		}
		int j;
		for (int i = 0; i < target.length(); i++) {
			for (j = 0; j < source.length(); j++) {
				if (source.charAt(j) == target.charAt(i)) {
					break;
				}
			}
			if (j == source.length()) {
				return false;
			}
		}
		return true;

	}

	/**
	 * 
	 * 0(mlogm+nlogn+(m+n))
	 */
	public boolean compareStr2(String source, String target) {
		source = quickSort(source);
		char[] sour = source.toCharArray();
		target = quickSort(target);
		char[] tar = target.toCharArray();
		int i = 0, j = 0;
		while (i < sour.length && j < tar.length) {
			while (sour[i] < tar[j] && i < sour.length - 1) {
				i++;
			}
			if (sour[i] != tar[j]) {
				break;
			}
			j++;
		}
		if (j != tar.length) {
			return false;
		}
		return true;
	}

	private String quickSort(String str) {
		if (str.length() == 0) {
			return str;
		}
		char[] chars = str.toCharArray();
		helper(chars, 0, chars.length - 1);
		return String.valueOf(chars);
	}

	private void helper(char[] chars, int low, int high) {
		if (low < high) {
			int pivot = Partition(chars, low, high);
			helper(chars, 0, pivot - 1);
			helper(chars, pivot + 1, high);
		}
	}

	private int Partition(char[] chars, int low, int high) {
		char tmp = chars[low];
		while (low < high) {
			while (low < high && chars[high] > tmp) {
				high--;
			}
			chars[low] = chars[high];
			while (low < high && chars[low] < tmp) {
				low++;
			}
			chars[high] = chars[low];
		}
		chars[low] = tmp;
		return low;
	}

	public static void main(String[] args) {
		CompareStr compareStr = new CompareStr();
		System.out.println(compareStr.compareStr2("defabc", "abc"));
	}

}
