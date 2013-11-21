package com.botree.dp.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author subhash.shah
 * 
 * Adapter
 *
 */

public class ListToStackAdapter implements Stack {
	
	/** class which has adapted the behavior of Stack */
	List<Integer> list = new ArrayList<Integer>();

	@Override
	public void push(int i) {
		list.add(i);
	}

	@Override
	public int pop() {
		return list.remove(list.size() - 1);
	}

	@Override
	public int top() {
		return list.get(list.size() - 1);
	}

}
