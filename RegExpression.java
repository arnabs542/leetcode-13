package LeetCode;


public class RegExpression {
	
	
	
//    public static boolean isMatch(String s, String p) {
//        if (p.length() == 0) {
//            return s.length() == 0;
//        }
//
//        // length == 1 is the case that is easy to forget.
//        // as p is subtracted 2 each time, so if original
//        // p is odd, then finally it will face the length 1
//        if (p.length() == 1) {
//            return (s.length() == 1)
//                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
//        }
//
//        // next char is not '*': must match current character
//        if (p.charAt(1) != '*') {
//            if (s.length() < 1) {
//                return false;
//            } else {
//                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
//                        && isMatch(s.substring(1), p.substring(1));
//            }
//        }
//        // next char is *
//        while (s.length() > 0
//               && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
//            if (isMatch(s, p.substring(2))) {
//                return true;
//            }
//            s = s.substring(1);
//        }
//        return isMatch(s, p.substring(2));
//    }

	 public static boolean isMatch(String s, String p) {
	    	if(s.length()<1 && p.length()<1)
	    	{
	    		return true;
	    	}
	    	if(s.length()<1)
	    	{
	    		// ""
	    		// "c*c*"
	    		if(p.length()>= 2 && p.charAt(1)=='*')
	    		{
	    			return isMatch(s,p.substring(2, p.length()));
	    		}
	    		return false;
	    	}
	    	if(p.length()<1)
	    	{
	    		return false;
	    	}
	    	char[] sa = s.toCharArray();
	    	char[] pa = p.toCharArray();
	    	
	    	int i=0,j=0;
	    	
	    	while(i<sa.length && j<pa.length)
	    	{
	    		if((sa[i]==pa[j]&&(pa[j]!='.' || pa[i]!='*')))
	    		{
	    			
	    		}else{
	    			
	    			if(sa[i]!=pa[j])
	    			{
	    				if(pa[j]=='.')
	    				{
	    					
	    				}else if(pa[j]=='*'){
	    					
	    					if(pa[j-1]=='.')
	    					{
	    						// some explaination here ,whether 
	    						for(i = i-1;i<sa.length;i++)
	    						{
	    							
		    						String sasub = String.copyValueOf(sa,i,sa.length-i);
		    						String pasub = String.copyValueOf(pa,j+1,pa.length-j-1);
		    						
		    						if(isMatch(sasub,pasub))
		    						{
		    							return true;
		    						}
	    							
	    						}
	    						
//	    						while((i+1)<sa.length)
//	    						{
//	    							i++;
//	    							
//		    						String sasub = String.copyValueOf(sa,i,sa.length-i);
//		    						String pasub = String.copyValueOf(pa,j+1,pa.length-j-1);
//		    						
//		    						if(isMatch(sasub,pasub))
//		    						{
//		    							return true;
//		    						}
//	    							
//	    						}
	    						 												
	    						String pasub = String.copyValueOf(pa,j+1,pa.length-j-1);
	    						
	    						String sasubOne = String.copyValueOf(sa, i, sa.length-i);
	    						return isMatch(sasubOne,pasub);
	    						
	   						
	    						
	    					}else{
	    						
	    						char temp=sa[i];
	    						
	    						String pasub = String.copyValueOf(pa,j+1,pa.length-j-1);
	    						//  a c a
	    						//  a * c 
	    						//
	    						//  a b b 
	    						//  a b * 
	    						//
	    						
	    						// if before is not a same char ,we just start from this point.
	    						if(sa[i]!=sa[i-1])
	    						{
	    							
	        						String sasubOne = String.copyValueOf(sa, i, sa.length-i);
	        						return isMatch(sasubOne,pasub);
	    							
	    						}else{
	    							
	    							// if before is  a same char , we should step back one char to search.
	    							i = i -1;
	    							
		    						for(;i<sa.length;i++)
		    						{
		    							if(sa[i]==temp)
		    							{
		    	    						String sasub = String.copyValueOf(sa,i,sa.length-i);
		    	    						
		    	    						if(isMatch(sasub,pasub))
		    	    						{
		    	    							return true;
		    	    						}
		    								
		    							}else{
		    								break;
		    							}
		    								
		    						}
		    						
		    						// we have iterate all the same chars.
	        						String sasubOne = String.copyValueOf(sa, i, sa.length-i);
	        						return isMatch(sasubOne,pasub);
	    							
	    						}

	    					}
	    					
	    				}else if((j+1)<pa.length && pa[j+1]=='*')
	    				{
	    					
	    					String sasub = String.copyValueOf(sa,i,sa.length-i);
							String pasub = String.copyValueOf(pa,j+2,pa.length-j-2);
	    					
	    					return isMatch(sasub,pasub);
	    				}else{
	    					return false;
	    				}
	    			}
	    			
	    			
	    		}
	    		
				i++;
				j++;
	    	}
	    	
	    	if(i==sa.length && j==pa.length)
	    	{
	    		return true;
	    	}
	    	
	    	
	    	// 
	    	
	    	// b*
	    	
			if((pa.length-j)== 2 && pa[j+1]=='*')
			{
				return true;
			}
			
			// . * 
			if(j<pa.length)
			{
				if(pa[j]=='*')
				{
					// step one futher
					String pasub = String.copyValueOf(pa,j+1,pa.length-j-1);
					String sasub = String.copyValueOf(sa, i-1, sa.length-i+1);    						
					if(isMatch(sasub,pasub))
					{
						return true;
					}
					
					
					String sasubNow = String.copyValueOf(sa,i,sa.length-i);

					if(isMatch(sasubNow,pasub))
					{
						return true;
					}
				}
			}


			return false;       
	    }

    
    public static void main(String[] args)
    {
    	
    	
//    	System.out.println(isMatch("aa","a"));
//    	System.out.println(isMatch("aa","aa")) ;
//    	System.out.println(isMatch("aaa","aa"));
//    	System.out.println(isMatch("aa", "a*"));
//    	System.out.println(isMatch("aa", ".*"));
//    	System.out.println(isMatch("ab", ".*"));
//    	System.out.println(isMatch("aab", "c*a*b"));    	
//     	System.out.println(isMatch("", "c*a*b"));
//     	System.out.println(isMatch("a", "b"));  	  	
//     	System.out.println(isMatch("aaa", "a*a"));
    	
     	
//     	System.out.println(isMatch("aaa", "ab*a*c*a")); 
    	
//    	System.out.println(isMatch("aaba", "ab*a*c*a")); 
    	
//    	System.out.println(isMatch("a", "ab*"));
    	
//    	System.out.println(isMatch("bbbba", ".*a*a"));
    	
//    	System.out.println(isMatch("a","a*a"));
    	
    	
//    	System.out.println(isMatch("a",".*"));
    	
//    	System.out.println(isMatch("ab",".*.."));
    	
//    	System.out.println(isMatch("abbbcd","ab*bbbcd"));
    	
//    	System.out.println(isMatch("aaca","ab*a*c*a"));
    	
//    	System.out.println(isMatch("aca","a*c*a"));
    	
    	System.out.println(isMatch("","c*c*"));
    	
    	
    	System.out.println(isMatch("baabbbaccbccacacc","c*..b*a*a.*a..*c"));
    }
}
