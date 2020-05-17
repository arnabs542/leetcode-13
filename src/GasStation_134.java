package LeetCode;

public class GasStation_134 {
	
	/*
	 * just iterate the array from n index ,complexities is O(n^2)
	 * 
	 * we shoud lower down our search space.
	 *  
	 * 
	 * 两层迭代：
	 * 
	 * 外部loop以及内部loop
	 * 
	 * 外部loop的跳转距离不是每次更新一次，而是内部loop的循环次数。
	 *  
	 */
	
	public static int canCompleteCircuit(int[] gas,int[] cost)
	{
		
		if(gas.length<=0)
		{
			return -1;
		}
		
		int length = gas.length;
		
		int answer = -1;

		int j;
		int step=0;
		for(int i = 0;i<length;i+=step)
		{
			int left=0;
			for(j=i;j<length+i;j++)
			{
				int index = j%length;
				if((gas[index]+left)>=cost[index])
				{
					left = left + gas[index]-cost[index];
				}else{
					break;
				}
			}
			
			if(j>=length+i)
			{
				return i;
			}
			
			step = j-i;
			if(step==0)
			{
				step=1;
			}

			
		}
		
		
		return answer;
		
	}

	public static void main(String[] args)
	{
//		int[] a = new int[]{6,1,4,3,5}; 
//		int[] b = new int[]{3,8,2,4,2};
		
		int[] a = new int[]{4}; 
		int[] b = new int[]{5};


		System.out.println("result"+canCompleteCircuit(a,b));
	}


}
