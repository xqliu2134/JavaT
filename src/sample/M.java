package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sample.cp.CpData;

public class M {

	public static void main(String[] args) {
		CpData cp = new CpData();
		System.out.println("出现次数最多的前五个:"+cp.calceMax(0));
		System.out.println("出现次数最少的前十个:"+cp.calceMax(2));
		System.out.println("还没有出现过的数字:"+cp.calceMax(1));
		//05,14,17,25,32,02,12
		//09,21,23,31,34,08,11
		System.out.println("=================================");
		System.out.println("出现次数最多的前五个:"+cp.calceRear(0));
		System.out.println("出现次数最少的前十个:"+cp.calceRear(2));
		System.out.println("还没有出现过的数字:"+cp.calceRear(1));
	}

	private static boolean test(String reg, String str) {
		Pattern mPattern = Pattern.compile(reg);
		Matcher matcher = mPattern.matcher(str);
		return matcher.find();
	}

	private static String[] splitArray() {
		Matcher m = Pattern.compile("\\d{2}").matcher("01 02 03 04");
		List<String> result = new ArrayList<>();
		while (m.find()) {
			System.out.println(m.group(0));
			result.add(m.group(0));
		}
		String[] array = new String[result.size()];
		for (int i = 0; i < result.size(); i++) {
			array[i] = result.get(i);
		}
		result = null;
		return array;
	}

	public static String switchChar(String item, int start) {
		String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s" };
		String[] array = splitArray();
		List<String> result = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			int index = Integer.parseInt(array[i]) - start;
			if (index >= 0 && index < chars.length) {
				result.add(chars[index]);
			}
		}
		return join(result, "");
	}

	private static String join(List<String> strs, String tag) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < strs.size(); i++) {
			sb.append(strs.get(i));
			if (i < strs.size() - 1) {
				sb.append(tag);
			}
		}
		return sb.toString();
	}
}
