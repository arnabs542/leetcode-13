
public class RegExpression2 {

	public static boolean isMatch(String s, String p) 
	{
		// iteration abort condition
		if(p.length()<1 )
		{
			if(s.length()==0)
			{
				return true;
			}
			return false;
		}
		
		// 
		if(p.length()==1)
		{
			// left one pattern character
			if(s.length()==1)
			{
				return p.charAt(0)==s.charAt(0)|| p.charAt(0)=='.';
			}
			else{
				return false;
			}
		}else{
			// more than one pattern character
			
			if(p.charAt(1)!='*')
			{
				if(s.length()<1)
				{
					return false;
				}else{
					return (p.charAt(0)==s.charAt(0)|| p.charAt(0)=='.')&&(isMatch(s.substring(1),p.substring(1)));
				}
				
			}else{

				// check whether s is end
				if(s.length()<1)
				{
					return isMatch(s,p.substring(2));
				}else{
					
					
					/*
					 *  three conditons
					 * 
					 *  
					 * 
					 */
					
					if(p.charAt(0)!='.')
					{
						if(p.charAt(0)!=s.charAt(0))
						{
							// char doesn't equal
							return isMatch(s,p.substring(2));
						}else{
							// equal
							char temp = s.charAt(0);
							while((s.length()>0)&&(s.charAt(0)==temp))
							{
								if(isMatch(s,p.substring(2)))
								{
									return true;
								}
								s = s.substring(1);
							}
							return isMatch(s,p.substring(2));
						}
					}else{
						
						while(s.length()>0)
						{
							if(isMatch(s,p.substring(2)))
							{
								return true;
							}
							s =s.substring(1);
						}
						
						return isMatch(s,p.substring(2));
						
						
					}
					
				}
				

			}
			
			
		}
		
		
	}

	 public static void main(String[] args)
	 {
		 
		 System.out.println(isMatch("","c*a*b"));
	 }
}
