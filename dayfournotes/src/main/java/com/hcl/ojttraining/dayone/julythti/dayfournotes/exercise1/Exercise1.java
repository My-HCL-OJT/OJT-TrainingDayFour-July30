package com.hcl.ojttraining.dayone.julythti.dayfournotes.exercise1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * You are part of a hiring event where you have been assigned to perform a survey regarding the most popular skills. The skills are represented by the numbers starting with 1.
The skill with highest number is the most popular and the skill with lowest number is the least popular.
Given the budget and other constraints, you want to select a skill for your company from a survey using a very unique rule.
1. For a skill represented by number i, the skill i appears exactly i times.
2. For ties, the most popular skill would be chosen.
Example1:
Input arr=[2,2,3,4]
Output:2
Example 2:
Input arr =[1,2,2,3,3,3]
Output:3
Example 3:
Input arr=[2,2,2,3,3]
Output=-1 as there are no skills which match the rule
 */
public class Exercise1 {

	public static void main(String[] args) {
		Exercise1 e1 = new Exercise1();
		int[] temp = { 2, 2, 3, 4 };
		int[] temp1 = { 1, 2, 2, 3, 3, 3 };
		int[] temp2 = { 2, 2, 2, 3, 3 };
		HashMap<Integer, Integer> tempH = new HashMap<Integer, Integer>();
		HashSet<Integer> tempS = new HashSet<Integer>();

		tempH = e1.checkOccur(temp, tempH);
		tempS = e1.checkEqual(tempH, tempS);
		System.out.println(Arrays.toString(temp) + " " + e1.output(tempS));
		tempH.clear();
		tempS.clear();
		
		tempH = e1.checkOccur(temp1, tempH);
		tempS = e1.checkEqual(tempH, tempS);
		System.out.println(Arrays.toString(temp1) + " " + e1.output(tempS));
		tempH.clear();
		tempS.clear();
		
		tempH = e1.checkOccur(temp2, tempH);
		tempS = e1.checkEqual(tempH, tempS);
		System.out.println(Arrays.toString(temp2) + " " + e1.output(tempS));

	}

	public HashMap<Integer, Integer> checkOccur(int[] temp, HashMap<Integer, Integer> tempH) {
		// checks the number of occurrences
		for (Integer i : temp) {
			if (tempH.containsKey(i)) {
				tempH.put(i, tempH.get(i) + 1);
			} else {
				tempH.put(i, 1);
			}
		}
		return tempH;
	}

	public HashSet<Integer> checkEqual(HashMap<Integer, Integer> tempH, HashSet<Integer> tempS) {
		// if the number of occurrences match the skill than add to the set
		for (Map.Entry<Integer, Integer> entry : tempH.entrySet()) {
			if (entry.getKey() == entry.getValue()) {
				tempS.add(entry.getKey());
			} else {
				continue;
			}
		}
		return tempS;
	}

	public Integer output(HashSet<Integer> tempS) {
		// return -1 if the skills do not match or else return the highest skill
		if (tempS.size() == 0) {
			return -1;
		}
		return Collections.max(tempS);
	}
}
