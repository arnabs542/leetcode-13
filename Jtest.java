package LeetCode;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;

import annotation.UnitTest.Test;

public class Jtest extends TestCase{



	@Before
	public void init() {
		
	}
	
	
	
	@Test
	public void testRegExpression2() {

    	
		Assert.assertEquals(RegExpression2.isMatch("aa","a"),false);		
    	Assert.assertEquals(RegExpression2.isMatch("aa","aa"),true) ;
    	Assert.assertEquals(RegExpression2.isMatch("aaa","aa"),false);
    	Assert.assertEquals(RegExpression2.isMatch("aa", "a*"),true);
    	Assert.assertEquals(RegExpression2.isMatch("aa", ".*"),true);
    	Assert.assertEquals(RegExpression2.isMatch("ab", ".*"),true);
    	Assert.assertEquals(RegExpression2.isMatch("aab", "c*a*b"),true);    	
     	Assert.assertEquals(RegExpression2.isMatch("", "c*a*b"),false);
     	Assert.assertEquals(RegExpression2.isMatch("a", "b"),false);    	
     	Assert.assertEquals(RegExpression2.isMatch("aaa", "a*a"),true);      	
     	Assert.assertEquals(RegExpression2.isMatch("aaa", "ab*a*c*a"),true);  
     	Assert.assertEquals(RegExpression2.isMatch("aaba", "ab*a*c*a"),false);
     	Assert.assertEquals(RegExpression2.isMatch("a","a*a"), true);  	
     	Assert.assertEquals(RegExpression2.isMatch("bbbba", ".*a*a"), true);
     	Assert.assertEquals(RegExpression2.isMatch("a", ".*"), true);
     	
     	Assert.assertEquals(RegExpression2.isMatch("abbbcd","ab*bbbcd"), true);
     	
     	Assert.assertEquals(RegExpression2.isMatch("aca","a*c*a"), true);
     	
     	Assert.assertEquals(RegExpression2.isMatch("","a*c*"), true);
     	
     	Assert.assertEquals(RegExpression2.isMatch("baabbbaccbccacacc","c*..b*a*a.*a..*c"),true);
     	
	}
}

