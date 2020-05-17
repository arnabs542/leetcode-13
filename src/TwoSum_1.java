

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
	
	/**
	 *  要查找two-sum的话，其下界必然为O(n^2)
	 * 	最原始的方法即是 从头到尾遍历 需要 O(n^2)
	 *  遍历的目的其实就是为了查找(search),查找之前遍历过的元素中有没有合适的(sum = target)
	 *  
	 *  search的话，可以利用各种数据接口来加快search的过程。
	 *  
	 *  1  如果是array的话，search复杂度为 O(n)
	 *  2 rb-tree 的话，复杂度为 O(lgn)
	 *  3. map 的话，可以达到O(1)
	 *  
	 *  
	 * 
	 */

	public static  int[] twoSum(int[] numbers, int target) {
		int[] index = new int[2];

		Map<Integer, Integer> info = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {

			if (info.containsKey(target - numbers[i])) {
				index[1] = i + 1;
				index[0] = info.get(target - numbers[i]) + 1;
				break;
			}

			info.put(numbers[i], i);
		}

		return index;

	}
	
	public static void main(String[] args){
		
		int[] numbers={2, 7, 11, 15,16,10,30,50,3,4,5};
		int target = 7;
		
		
		int[] index = twoSum(numbers,target);
		
		System.out.println("first"+index[0]+"\tsecond"+index[1]);
		
		
	}

}
