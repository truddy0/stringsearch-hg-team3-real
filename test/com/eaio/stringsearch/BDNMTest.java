package com.eaio.stringsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BDNMTest {
		
	@Test
	public void testBNDMPatterLenghtFound_1to32(){
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
	    // BNDM implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is found in the string.(pattern length is between 1 and 32)
		StringSearch ss = new BNDM();
		String str = "helloworld11";
		String pattern = "helloworld11";
		
		int location = ss.searchString(str, pattern);
		
		assertEquals(0, location);
	}
	
	
    
    @Test
    public void testBNDMPatternNotFoundI_Length1to32() {
	// Technique used: input space partitioning
	//
	// This test case represents the block of inputs to the
	// BNDM implementation of StringSearch.searchString
	// that contain:
	//
	// - a non-null pattern
	// - a non-null string
	// - the pattern is NOT found in the string.(the pattern is different from str)
	
	StringSearch ss = new BNDM();
	String str = "helloworld";
	String pattern = "se6367";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }
    
    
    @Test
    public void testBNDMPatternNotFoundII_Length1to32() {
    	// Technique used: input space partitioning
    	//
    	// This test case represents the block of inputs to the
        // BNDM implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null string
    	// - the pattern is not found in the string.(The pattern is lowercase while str is uppercase)
	
	StringSearch ss = new BNDM();
	String str = "helloworld";
	String pattern = "HELLOWORLD";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }
	
	@Test
	public void testBNDMPatterFound_Lenghtbiggertha32_allright(){
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
	    // BNDM implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is found in the string.(pattern length is bigger than 32 and pattern is the same as str)
		StringSearch ss = new BNDM();
		String str = "helloworldhelloworldhelloworldhelloworld1123";
		String pattern = "helloworldhelloworldhelloworldhelloworld1123";
		
		int location = ss.searchString(str, pattern);
		
		//Because BNDM.java cannot check the pattern whose length is bigger than 32 bytes, 
		//the pattern will only math the first 32bytes. This case is that pattern matches string totally.
		
		assertEquals(0, location);
	}
	
	@Test
	public void testBNDMPatterFound_Lenghtbiggertha32_32right(){
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
	    // BNDM implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is found in the string.(pattern length is bigger than 32)
		StringSearch ss = new BNDM();
		String str = "helloworldhelloworldhelloworldhelloworld1123";
		String pattern = "helloworldhelloworldhelloworldhelloworld1124";
		
		int location = ss.searchString(str, pattern);
		
		//Because BNDM.java cannot check the pattern whose length is bigger than 32 bytes, 
		//the pattern will only math the first 32bytes. This case is that pattern matches string at first 32bytes.
		//Although it reports it checks successfully, it is different from the total match case.
		assertEquals(0, location);
	}
	
	@Test
    public void testBNDMPatternNotFound_Lengthmorethan32() {
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
		// BNDM implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is not found in the string.(pattern length is bigger than 32)	
	//Not Found Caused by CI
	StringSearch ss = new BNDM();
	String str = "helloworldhelloworldhelloworldhelloworld";
	String pattern = "Helloworldhelloworldhelloworldhelloworld";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }
	
	@Test
    public void testBNDMPatternlongerthanStrI() {
		// Technique used: input space partitioning
				//
				// This test case represents the block of inputs to the
			    // BNDM implementation of StringSearch.searchString
				// that contain:
				//
				// - a non-null pattern
				// - a non-null string
				// - the pattern is not found in the string.	
				//pattern & str don’t match at all.
	StringSearch ss = new BNDM();
	String str = "hello";
	String pattern = "fesjisladso";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

 @Test
    public void testBNDMPatternlongerthanStrII() {
	// Technique used: input space partitioning
	//
	// This test case represents the block of inputs to the
	// BNDM implementation of StringSearch.searchString
	// that contain:
	//
	// - a non-null pattern
	// - a non-null string
	// - the pattern is not found in the string.
	 //pattern longer than str but don’t match
	StringSearch ss = new BNDM();
	String str = "hello";
	String pattern = "helloworld12323232848372934203427328324893927";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

 @Test
    public void testBNDMPatternlongerthanStrIII() {
	 	// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
		// BNDM implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is not found in the string.
	
      	//pattern is like str but longer than str
	StringSearch ss = new BNDM();
	String str = "hello";
	String pattern = "helloworld";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

 @Test
    public void testBNDMPatternlongerthanStrIV() {
	 	// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
		// BNDM implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is found in the string.	
	 	//str length is 32 but pattern is larger than 32 and found
	StringSearch ss = new BNDM();
	String str = "hello123hello123hello123hello123";
	String pattern = "hello123hello123hello123hello123fesjisladso";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(0, location);
    }


@Test
public void testbytenotfound() {
	// Technique used: statement coverage
	//
	// This test case represents the block of inputs to the
	// BNDM implementation of StringSearch.searchBytes
	// that contain:
	//
	// - a non-null pattern
	// - a non-null text
	// - the pattern is not found in the text.	
	
	StringSearch ss = new BNDM();
	byte[] text = {1,2,4};
	byte[] pattern = {8};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(-1, location);
	}

@Test
public void testbytepatternlongerthantext() {
	// Technique used: statement coverage
	//
	// This test case represents the block of inputs to the
	// BNDM implementation of StringSearch.searchBytes
	// that contain:
	//
	// - a non-null pattern
	// - a non-null text
	// - the pattern is not found in the text.	
	StringSearch ss = new BNDM();
	byte[] text = {1,2,4};
	byte[] pattern = {1,2,4,2,4,1,2,2};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(-1, location);
	}


@Test
public void testbytepatternlongerthantext32() {
	// Technique used: statement coverage
	//
	// This test case represents the block of inputs to the
	// BNDM implementation of StringSearch.searchBytes
	// that contain:
	//
	// - a non-null pattern
	// - a non-null text
	// - the pattern is found in the text.
	
	StringSearch ss = new BNDM();
	byte[] text = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2};
	byte[] pattern = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(0, location);}
	
	@Test
	public void minmin(){
	
	// Technique used: mutation coverage
	//
	// This test case represents the block of inputs to the
	// BNDM implementation of BNDM.min
	// that contain:
	//
	// - two chars
	// - return the minimum one 
	char one = 'a';
	char two = 'd';
	BNDM ss = new BNDM();
	char R = ss.min(two, one);
	assertEquals(R,one);
	}
	@Test
	//mutation test
	public void maxmax(){
	
	// Technique used: mutation coverage
	//
	// This test case represents the block of inputs to the
	// BNDM implementation of BNDM.max
	// that contain:
	//
	// - two chars
	// - return the max one 
	char one = 'd';
	char two = 'a';
	BNDM ss = new BNDM();
	char R = ss.max(two, one);
	assertEquals(R,one);
	}
	
	@Test//BDNM codes No.140; first31 are right.
	public void ChangeRange() {
		// Technique used: mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDM implementation of BNDM.searchBytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is not found in the text.
		
		StringSearch ss = new BNDM();
		byte[] text = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,1,1};
		byte[] pattern = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,4,4};
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(-1, location);}

}
