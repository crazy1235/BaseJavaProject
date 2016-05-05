package com.jacksen.java.pattern;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Admin
 * 
 */
public class TestPatternDemo {

	public static void main(String[] args) {
		System.out.println(Pattern.matches("\\d*", "123"));
		System.out.println(Pattern.matches("a{2}", "2323a1aa2as"));
		System.out.println(Pattern.matches("^1\\w*", "1ad"));
		System.out
				.println(Pattern
						.matches(
								"\\d{6}(?:1|2){1}\\d{3}(0[1-9]|1[0-2])[0-3][0-9](\\d{4}|\\d{3}X)",
								"41142219921233101X"));

		System.out.println(Pattern.matches(
				"^\\w+@[0-9a-zA-Z]+\\.[0-9a-zA-Z]+$", "924ads@sss.com"));

		// Pattern pattern = Pattern.compile("[1-4]{2}(a|b|\\.){3}");
		// Matcher matcher = pattern.matcher("abc12541.ab..");
		// System.out.println(matcher.group(0));

		// 懒惰匹配
		String str = "rrwerqq84461376qqasfdasdfrrwerqq84461377qqasfdasdaa654645aafrrwerqq84461378qqasfdaa654646aaasdfrrwerqq84461379qqasfdasdfrrwerqq84461376qqasfdasdf";
		Pattern p = Pattern.compile("qq(.*?)qq");
		Matcher m = p.matcher(str);
		ArrayList<String> strs = new ArrayList<String>();
		System.out.println(m.groupCount());
		while (m.find()) {
			strs.add(m.group(1));
		}
		for (String s : strs) {
			System.out.println(s);
		}

		//
		// Pattern pattern = Pattern.compile("(.+)\1");
		System.out.println(Pattern.matches("(.+)\1+", "ss113ab0"));

		// 匹配汉字
		System.out.println(Pattern.matches("^[\u4e00-\u9fa5]{0,}$", "1大方的"));

		System.out.println("A".matches("[a-zB-Z]"));
		System.out.println("_".matches("[\\w&&[^_]]"));

		System.out.println("1a12_AAS2d__".matches("[A-Za-z]\\w{5,17}"));

		System.out.println("=asA@#1=d"
				.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,10}$"));

		Pattern pa = Pattern.compile("(a\\w*?b)");
		Matcher ma = pa.matcher("aabba2baz~de3baba");
		while (ma.find()) {
			System.out.println(ma.group(1));
		}

		Pattern pattern = Pattern.compile("(\\d+)(m²|%|¥)");
		Matcher matcher = pattern.matcher("125%");
		while (matcher.find()) {
			System.out.println(matcher.group(1) + " -- " + matcher.group(2));
		}

		pattern = Pattern.compile("(\\d+)\\.?\\d+(m²|%|¥)");
		matcher = pattern.matcher("1234.512¥");
		while (matcher.find()) {
			System.out.println(matcher.group(1) + " -- " + matcher.group(2));
		}

		//
		//(\\w{2})(?:ab)
		pattern = Pattern.compile("\\w{2}(?=ab)");
		matcher = pattern.matcher("23ababc2ab_Aab34");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		
		System.out.println("~~~~~~~~");
		
		pattern = Pattern.compile("\\w{2}(?!ab)");
		matcher = pattern.matcher("23ab2aabAab34");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		
		System.out.println("------------");
		
		pattern = Pattern.compile("(?<!a)\\d*(?=b)");
		matcher = pattern.matcher("ssa2ba1a13b");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
