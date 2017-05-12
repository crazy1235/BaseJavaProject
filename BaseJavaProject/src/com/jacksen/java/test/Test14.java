package com.jacksen.java.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test14 {

	private static final int FLAG_PADDING_NOT_NULL = 0x20;

	private static int mGroupFlags = FLAG_PADDING_NOT_NULL;

	protected static final int FLAG_DISALLOW_INTERCEPT = 0x80000;

	public static void main(String[] args) {
		System.out.println(~FLAG_DISALLOW_INTERCEPT);
		System.out.println(FLAG_DISALLOW_INTERCEPT);
		System.out.println(FLAG_DISALLOW_INTERCEPT & ~FLAG_DISALLOW_INTERCEPT);
		System.out.println(mGroupFlags & FLAG_DISALLOW_INTERCEPT);
		mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
		System.out.println(mGroupFlags);
		System.out.println(mGroupFlags & FLAG_DISALLOW_INTERCEPT);
		mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
		System.out.println(mGroupFlags);
		System.out.println(mGroupFlags & FLAG_DISALLOW_INTERCEPT);

		System.out.println(1 << 0 == 0);

		//

		System.out.println(System.currentTimeMillis());

		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		List<String> list2 = list1;

		System.out.println(list1.size() + "--" + list2.size());

		list2.add("c");
		System.out.println(list1.size() + "--" + list2.size());

		List<String> list3 = new ArrayList<>(Arrays.asList(new String[list1.size()]));
		Collections.copy(list3, list1);
		list3.add("d");

		System.out.println(list1.size() + "--" + list2.size() + "---"
				+ list3.size());
		
		List<String> list4 = new ArrayList<>();
		list4 = (List<String>) ((ArrayList<String>)list3).clone();
		System.out.println(list4.size());
		list1.add("0");
		list4.add("e");
		System.out.println(list1.size() + "--" + list2.size() + "---"
				+ list3.size() + "---" + list4.size());
	}
}
