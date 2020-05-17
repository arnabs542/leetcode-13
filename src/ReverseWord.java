

public class ReverseWord {

	
	public static String reverseWords(String s)
	{
		if(s==null)
		{
			throw new NullPointerException();
		}
		String reverse = reverseString(s.trim());
		
		String[] reverseArray = reverse.split(" ");
		
		StringBuilder builder = new StringBuilder();
		for(String word: reverseArray)
		{
			if(word.length()<1)
			{
				
			}else{
				builder.append(reverseString(word));
				builder.append(" ");
			}
		}
		if(builder.toString().length()<1)
		{
			return "";
		}else{
			return builder.toString().substring(0,builder.toString().length()-1);
		}

	}
	
	public static String reverseString(String s)
	{
		if(s.length()<1)
		{
			return s;
		}else{
			char[] charArray = s.toCharArray();
			int length = charArray.length;
			char[] reverseArray = new char[length];
			for(int i=length;i>0;i--)
			{
				reverseArray[length-i]=charArray[i-1];
			}
			return new String(reverseArray).toString();
		}
	}
	
	public static void main(String[] args)
	{
//		System.out.println(reverseWord(""));
//		System.out.println(reverseWord("   "));
//		System.out.println(reverseWord("word"));
//		System.out.println(reverseWord(" word "));
//		System.out.println(reverseWord(" word for you   "));
		
		System.out.println(reverseWord("b a"));

		
		
	}
	
	public static String reverseWord(String s)
	{
		if(s==null)
		{
			throw new NullPointerException();
		}
		
		String[] wordArray = s.split(" ");
		
		StringBuilder builder = new StringBuilder();
		for(int i = wordArray.length;i>0;i--)
		{
			if(wordArray[i-1].length()<1)
			{
				
			}else{
				builder.append(wordArray[i-1]);
				builder.append(" ");
			}
		}
		
		if(builder.toString().length()<1)
		{
			return "";
		}else{
			return builder.toString().substring(0,builder.toString().length()-1);
		}
			
	}

}

