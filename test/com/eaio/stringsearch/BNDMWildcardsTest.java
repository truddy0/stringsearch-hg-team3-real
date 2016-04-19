package com.eaio.stringsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BNDMWildcardsTest {

		
	@Test
	public void testBNDMwildPatterLenghtFound_1to32(){
		// Technique used: Statement coverage
				//
				// This test case represents the block of inputs to the
				// BNDMWildcard implementation of StringSearch.searchString
				// that contain:
				//
				// - a non-null pattern
				// - a non-null string
				// one wildcard
				// - the pattern is found in the string.
		StringSearch ss = new BNDMWildcards();
		String str = "helloworld11";
		String pattern = "h.lloworld11";
		
		int location = ss.searchString(str, pattern);
		
		assertEquals(0, location);
	}
    
    @Test

    public void testBNDMwildextrem (){
    	// Technique used: Statement coverage
    			//
    			// This test case represents the block of inputs to the
    			// BNDMWildcard implementation of StringSearch.searchString
    			// that contain:
    			//
    			// - all wildcards pattern
    			// - a non-null string
    			// - the pattern is found in the string.
        StringSearch ss = new BNDMWildcards();
        String str = "helloworld11";
        String pattern = "............";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }

    @Test
    public void testBNDMwildPatternNotFoundI_Length1to32() {
    	// Technique used: Statement coverage
    			//
    			// This test case represents the block of inputs to the
    			// BNDMWildcard implementation of StringSearch.searchString
    			// that contain:
    			//
    			// - a non-null with one wildcard pattern
    			// - a non-null longer string
    			// - the pattern is not found in the string.
	StringSearch ss = new BNDMWildcards();
	String str = "helloworld";
	String pattern = "s.6367";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

@Test
    public void testBNDMwildPatternNotFoundII_Length1to32() {
	// Technique used: Statement coverage
			//
			// This test case represents the block of inputs to the
			// BNDMWildcard implementation of StringSearch.searchString
			// that contain:
			//
			// - a non-null with one wildcard and UP_letter pattern
			// - a non-null string
			// - the pattern is not found in the string.
	StringSearch ss = new BNDMWildcards();
	String str = "helloworld";
	String pattern = "H.LLOWORLD";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }
	
	@Test
	public void testBNDMwildPatterFound_Lenghtbiggertha32_allright(){
		// Technique used: Statement coverage
				//
				// This test case represents the block of inputs to the
				// BNDMWildcard implementation of StringSearch.searchString
				// that contain:
				//
				// - a longer than 32 pattern with one wildcard
				// - a longer than 32 string
				// - the pattern is found in the string.
		StringSearch ss = new BNDMWildcards();
		String str = "helloworldhelloworldhelloworldhelloworld1123";
		String pattern = "h.lloworldhelloworldhelloworldhelloworld1123";
		
		int location = ss.searchString(str, pattern);
		
		//Because BNDM.java cannot check the pattern whose length is bigger than 32 bytes, 
		//the pattern will only math the first 32bytes. This case is that pattern matches string totally.
		
		assertEquals(0, location);
	}
	

	@Test
	public void testBNDMwildPatterFound_Lenghtbiggertha32_32right(){
		// Technique used: Statement coverage
				//
				// This test case represents the block of inputs to the
				// BNDMWildcard implementation of StringSearch.searchString
				// that contain:
				//
				// - a longer than 32 pattern with one wildcard
				// - a longer than 32 string
				// - the pattern is found in the string.StringSearch ss = new BNDMWildcards();
		StringSearch ss = new BNDMWildcards();
		String str = "helloworldhelloworldhelloworldhelloworld1123";
		String pattern = "h.lloworldhelloworldhelloworldhelloworld1124";
		
		int location = ss.searchString(str, pattern);
		
		//Because BNDM.java cannot check the pattern whose length is bigger than 32 bytes, 
		//the pattern will only math the first 32bytes. This case is that pattern matches string at first 32bytes.
		//Although it reports it checks successfully, it is different from the total match case.
		assertEquals(0, location);
	}
	
	@Test
    public void testBNDMwildPatternNotFound_Lengthmorethan32() {
		// Technique used: Statement coverage
				//
				// This test case represents the block of inputs to the
				// BNDMWildcard implementation of StringSearch.searchString
				// that contain:
				//
				// - a longer than 32 pattern with wildcard and Big letter
				// - a longer than 32 string
				// - the pattern is not found in the string.
	StringSearch ss = new BNDMWildcards();
	String str = "helloworldhelloworldhelloworldhelloworld";
	String pattern = "H.lloworldhelloworldhelloworldhelloworld";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }
	
	@Test
    public void testBNDMwildPatternlongerthanStrI() {
		// Technique used: Statement coverage
				//
				// This test case represents the block of inputs to the
				// BNDMWildcard implementation of StringSearch.searchString
				// that contain:
				//
				// - a longer pattern
				// - a non-null string
				// - the pattern is not found in the string.
				// pattern & str don't match at all.
	StringSearch ss = new BNDMWildcards();
	String str = "hello";
	String pattern = "fe.jisladso";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

 @Test
    public void testBNDMwildPatternlongerthanStrII() {
	// Technique used:Statement coverage
			//
			// This test case represents the block of inputs to the
			// BNDMWildcard implementation of StringSearch.searchString
			// that contain:
			//
			// - a non-null pattern
			// - a non-null string
			// - the pattern is not found in the string.
//pattern longer than str but don't match
	StringSearch ss = new BNDMWildcards();
	String str = "hello";
	String pattern = "hellow.rld12323232848372934203427328324893927";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

 @Test
    public void testBNDMwildPatternlongerthanStrIII() {
	// Technique used:Statement coverage
			//
			// This test case represents the block of inputs to the
			// BNDMWildcard implementation of StringSearch.searchString
			// that contain:
			//
			// - a longer pattern
			// - a non-null string
			// - the pattern is not found in the string.
	 		//pattern is like str but longer than str
	StringSearch ss = new BNDMWildcards();
	String str = "hello";
	String pattern = "h.lloworld";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

 @Test
    public void testBNDMwildPatternlongerthanStrIV() {
	// Technique used: Statement coverage
			//
			// This test case represents the block of inputs to the
			// BNDMWildcard implementation of StringSearch.searchString
			// that contain:
			//
			// - a longer than32 pattern with wildcard
			// - a longer than 32 string with first 32 same with pattern
			// - the pattern is found in the string.
	 		//str length is 32 but pattern is larger than 32 and found
	StringSearch ss = new BNDMWildcards();
	String str = "hello123hello123hello123hello123";
	String pattern = "h.llo123hello123hello123hello123fesjisladso";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(0, location);
    }


 
 
 @Test
 public void testbytenotfound() {
	// Technique used: Statement coverage
			//
			// This test case represents the block of inputs to the
			// BNDMWildcard implementation of StringSearch.searchString
			// that contain:
			//
			// - a non-null pattern length is shorter than text with wildcard
			// - a non-null text
			// - the pattern is not found in the text.	
	StringSearch ss = new BNDMWildcards();
	byte[] text = {1,2,4};
	byte[] pattern = {8,'.'};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(-1, location);
	}
   
   @Test
   public void testbytefound() {
   	// Technique used: Statement coverage
   	//
   	// This test case represents the block of inputs to the
   	// BNDMWildcard implementation of StringSearch.searchString
   	// that contain:
   	//
   	// - a non-null pattern with one wildcard
   	// length is same between pattern and text
   	// - a non-null text
   	// - the pattern is found in the text.	
       StringSearch ss = new BNDMWildcards();
       byte[] text = {1,2,4};
       byte[] pattern = {1,2,'.'};
       
       int location = ss.searchBytes(text, pattern);
       
       assertEquals(0, location);
   }

@Test
 public void testbytepatternlongerthantext() {
	// Technique used: Statement coverage
				//
				// This test case represents the block of inputs to the
				// BNDMWildcard implementation of StringSearch.searchString
				// that contain:
				//
				// - a non-null pattern with wildcard
				// pattern length is longer than text
				// - a non-null text
				// - the pattern is not found in the text.	
	StringSearch ss = new BNDMWildcards();
	byte[] text = {1,2,4};
	byte[] pattern = {1,'.',4,2,4,1,2,2};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(-1, location);
	}


@Test
 public void testbytepatternlongerthantext32() {
	// Technique used: Statement coverage
				//
				// This test case represents the block of inputs to the
				// BNDMWildcard implementation of StringSearch.searchString
				// that contain:
				//
				// - a non-null pattern with wildcard longer than 32
				// first 32 is same
				// - a non-null text
				// - the pattern is found in the text.	
	StringSearch ss = new BNDMWildcards();
	byte[] text = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2};
	byte[] pattern = {1,'.',4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(0, location);}

}