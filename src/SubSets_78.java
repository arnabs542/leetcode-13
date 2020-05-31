
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSets_78 {

	public static List<List<Integer>> subsets(int[] S){
		
		List<List<Integer>> sublist = subsets(S,0);
		sublist.add(new ArrayList<Integer>());
		
		for(List<Integer> list: sublist)
		{
			Collections.sort(list);
		}

		return sublist;
		
	}
	
	public static List<List<Integer>> subsets(int[] S,int index)
	{
		if(index>=S.length)
		{
			return new ArrayList<List<Integer>>();
		}
		
		List<List<Integer>> subSets = new ArrayList<List<Integer>>();
		int num = S[index];
		
		List<List<Integer>> listSets = subsets(S,index+1);
		subSets.addAll(listSets);
		

		List<Integer> item = new ArrayList<Integer>();
		item.add(num);
		subSets.add(item);

		for(List<Integer> list: listSets)
		{
			List<Integer> newList = new ArrayList<Integer>();
			newList.addAll(list);
			newList.add(num);
			subSets.add(newList);
		}

				
		return subSets;
	}

	public static void main(String[] args)
	{
		int[] sub = new int[]{1,2,3};
		List<List<Integer>> subset = subsets(sub);
		
		for(List<Integer> list : subset)
		{
			for(Integer integer: list)
			{
				System.out.print(integer);
			}
			System.out.println("");
		}
	}
}
