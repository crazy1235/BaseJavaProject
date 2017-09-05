package com.jacksen.java.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 测试Map的子类
 * 
 * @author jacksen
 * @date 2016-10-18 下午4:52:36
 */
public class TestMap {

	public static void main(String[] args) {
		
		int capacity = 1 << 30;
		
		System.out.println(capacity);
		
		HashMap<String, String> hashMap = new HashMap<>();

		hashMap.put("1", "a");

		System.out.println(hashMap.size());

		hashMap.put("2", "b");
		
		System.out.println(hashMap.size());

		hashMap.put("2", "bb");

		System.out.println(hashMap.size());

		hashMap.put(null, "c");

		System.out.println(hashMap.size());
		
		System.out.println(tableSizeFor(16));
	}
	
	static final int MAXIMUM_CAPACITY = 1 << 30;
	static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
