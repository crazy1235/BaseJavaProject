package com.jacksen.java.test;

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

		// System.out.println(1 << 0);
	}
}
