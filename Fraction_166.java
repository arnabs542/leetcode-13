package LeetCode;

import java.util.HashMap;

public class Fraction_166 {
	


    public static String fractionToDecimal(int numerator, int denominator) {
    	
    	long numeratorLong = (long) numerator;
    	long denominatorLong = (long) denominator;
    	if(numeratorLong==0)
    	{
    		return "0";
    	}
    	
    	int minus = 0;
    	if(numeratorLong>=0)
    	{
    		
    	}else{
    		numeratorLong=-numeratorLong;
    		minus = minus+1;
    	}
    	
    	if(denominatorLong>0)
    	{
    		
    	}else{
    		denominatorLong=-denominatorLong;
    		minus = minus+1;
    	}
    	
    	String result = "";
    	if(minus%2==0)
    	{
    		result =positiveNumberfractionToDecimal(numeratorLong, denominatorLong);
    	}else{
    		 result ="-"+positiveNumberfractionToDecimal(numeratorLong, denominatorLong);
    	}
    	
    	return transformIndex(result);

    }
    
    public static String transformIndex(String original)
    {
    	int index = original.indexOf("(");
    	
    	if(index<0)
    	{
    		return original;
    	}
    	StringBuilder builder1 = new StringBuilder(original.substring(0, index));
    	StringBuilder builder2 = new StringBuilder(original.substring(index+1,original.length()-1));
    	
    	while(builder1.charAt(builder1.length()-1)==builder2.charAt(builder2.length()-1))
    	{
    		char ch=builder1.charAt(builder1.length()-1);
    		builder1.deleteCharAt(builder1.length()-1);
    		builder2.deleteCharAt(builder2.length()-1);
    		builder2.insert(0,ch);
    	}
    	
    	return builder1.toString()+"("+builder2.toString()+")";
    	
    	
    }
    
    
    public static String positiveNumberfractionToDecimal(long numerator, long denominator)
    {
    	long div = numerator/denominator;
    	long remainder = numerator%denominator;
    
    	long loopdiv = 0 ;
    	HashMap<String,Integer> tag = new HashMap<String,Integer>();
    	StringBuilder builder = new StringBuilder();
    	if(remainder == 0)
    	{
    		return Long.toString(div);
    	}else{
    		
    		tag.put(remainder+":"+0, builder.length());
    		while(remainder !=0)
    		{
    			remainder = remainder*10;
            	for(;remainder<denominator;remainder*=10)
            	{
            		builder.append(0);
            	}
            	
            	loopdiv = remainder/denominator;
            	
            	
              	remainder = remainder%denominator;
            	
              	String key = remainder+":"+loopdiv;
              	
              	if(tag.containsKey(remainder+":"+0))
              	{
              		builder.append(loopdiv);
              		break;
              	}
              	
            	if(tag.containsKey(key))
            	{
            		break;

            	}else{
            		tag.put(key,builder.length());
            		builder.append(loopdiv);
            	}
    		}
    		
    		// check whether we get it divied
    		String fractionalPart="";
    		
    		if(remainder == 0)
    		{
    			fractionalPart="."+builder.toString();
    		}else{
    	 		int index;
    			if(tag.containsKey(remainder+":"+loopdiv))
    			{
        	 		index = tag.get(remainder+":"+loopdiv);
    			}else{
    				index = tag.get(remainder+":"+0);
    			}

        		
    	 		fractionalPart = "."+builder.substring(0, index)+"("+builder.substring(index)+")";
    		}
    		
   
    		
    		return div==0?"0"+fractionalPart:Long.toString(div)+fractionalPart;
    		
    	}
    }
    
    public static void main(String[] args){
    	
    	/**
    	 *  除数为0
    	 *  负数情况
    	 *  int 负数转正数问题
    	 *  位数偏移问题。
    	 * 
    	 */
//    	for(int i=2;i<100;i++)
//    	{
//    		System.out.println(fractionToDecimal(1,i));
//    	}
    
//    	System.out.println(fractionToDecimal(1,6));
//    	System.out.println(fractionToDecimal(1,99999));
//    	System.out.println(fractionToDecimal(-50,8));
//    	System.out.println(fractionToDecimal(0,3));
//    	System.out.println(fractionToDecimal(0,-5));
    	System.out.println(fractionToDecimal(1, 214748364));
    	
    	// the range of integer 
    	System.out.println(fractionToDecimal(1, -2147483648));
    	System.out.println(fractionToDecimal(1, 5));
    }
}
