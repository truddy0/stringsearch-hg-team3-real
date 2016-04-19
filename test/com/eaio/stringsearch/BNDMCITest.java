package com.eaio.stringsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BNDMCITest {
	
		
	@Test
	public void testBNDMPatterLenghtFound_1to32(){
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is found in the string.(pattern length is between 1 and 32)
		StringSearch ss = new BNDMCI();
		String str = "helloworld11";
		String pattern = "HelloworLd11";
		
		int location = ss.searchString(str, pattern);
		
		assertEquals(0, location);
	}
    
	@Test
	public void testBNDMPatterLenghtFound_1to32II(){
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string 
		// - the pattern is found in the string.(str is uppercase while pattern is lowercase)
		StringSearch ss = new BNDMCI();
		String str = "HELLO";
		String pattern = "hello";
		
		int location = ss.searchString(str, pattern);
		
		assertEquals(0, location);
	}
	
	@Test
	public void testBNDMPatterLenghtFound_1to32III(){
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is found in the string.(include non-letter)
		StringSearch ss = new BNDMCI();
		String str = "hello1{z";
		String pattern = "HELLO1{z";
		
		int location = ss.searchString(str, pattern);
		
		assertEquals(0, location);
	}
    @Test
    public void testBNDMPatternNotFoundI_Length1to32() {
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is not found in the string.
	
	StringSearch ss = new BNDMCI();
	String str = "helloworld";
	String pattern = "Ase6367";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }
    
    
	
	@Test
	public void testBNDMPatterFound_Lenghtbiggertha32_allright(){
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is found in the string.
		StringSearch ss = new BNDMCI();
		String str = "helloworldhelloworldhelloworldhelloworld1123";
		String pattern = "Helloworldhelloworldhelloworldhelloworld1123";
		
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
		// BNDMCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is found in the string.
		StringSearch ss = new BNDMCI();
		String str = "helloworldhelloworldhelloworldhelloworld1123";
		String pattern = "Helloworldhelloworldhelloworldhelloworld1124";
		
		int location = ss.searchString(str, pattern);
		
		//Because BNDM.java cannot check the pattern whose length is bigger than 32 bytes, 
		//the pattern will only math the first 32bytes. This case is that pattern matches string at first 32bytes.
		//Although it reports it checks successfully, it is different from the total match case.
		assertEquals(0, location);
	}
	
	
	
	@Test
    public void testBNDMPatternlongerthanStrI() {
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is not found in the string.	
        //pattern & str don’t match at all.
	StringSearch ss = new BNDMCI();
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
		// BNDMCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is not found in the string.	
	 	//pattern longer than str but don’t match
	StringSearch ss = new BNDMCI();
	String str = "hello";
	String pattern = "Helloworld12323232848372934203427328324893927";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

 @Test
    public void testBNDMPatternlongerthanStrIII() {
		// Technique used: input space partitioning
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is not found in the string.	
	 	//pattern is like str but longer than str
	StringSearch ss = new BNDMCI();
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
		// BNDMCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is not found in the string.	
//str length is 32 but pattern is larger than 32 and found
	StringSearch ss = new BNDMCI();
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
	// BNDMCI implementation of StringSearch.Bytes
	// that contain:
	//
	// - a non-null pattern
	// - a non-null text
	// - the pattern is not found in the text.
	
	StringSearch ss = new BNDMCI();
	byte[] text = {1,2,4,'a','A'};
	byte[] pattern = {8,'a','A','{'};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(-1, location);
	}

@Test
public void testbytepatternlongerthantext() {
	// Technique used: statement coverage
	//
	// This test case represents the block of inputs to the
	// BNDMCI implementation of StringSearch.Bytes
	// that contain:
	//
	// - a non-null pattern
	// - a non-null text
	// - the pattern is not found in the text.	
	StringSearch ss = new BNDMCI();
	byte[] text = {1,2,4};
	byte[] pattern = {1,2,4,2,4,1,2,2,(byte) 214,(byte) 244};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(-1, location);
	}


@Test
public void testbytepatternlongerthantext32() {
	// Technique used: statement coverage
	//
	// This test case represents the block of inputs to the
	// BNDMCI implementation of StringSearch.Bytes
	// that contain:
	//
	// - a non-null pattern
	// - a non-null text
	// - the pattern is found in the text.	
	StringSearch ss = new BNDMCI();
	byte[] text = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2};
	byte[] pattern = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(0, location);}

	@Test
	public void UpperCaseLowerCaseTest() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is found in the text.
		
		StringSearch ss = new BNDMCI();
		byte[] text = {'A','b','c','D' };
		byte[] pattern = {'a','B','c','D'};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(0, location);}
	
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestFail1() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is not found in the text.		
		StringSearch ss = new BNDMCI();
		byte[] text = {'@' };
		byte[] pattern = {'`'};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(-1, location);}
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestFail2() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is not found in the text.		
		StringSearch ss = new BNDMCI();
		byte[] text = {'`' };
		byte[] pattern = {'@'};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(-1, location);}
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestFail3() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is not found in the text.		
		StringSearch ss = new BNDMCI();
		byte[] text = {'[' };
		byte[] pattern = {'{'};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(-1, location);}
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestFail4() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is not found in the text.		
		StringSearch ss = new BNDMCI();
		byte[] text = {'{' };
		byte[] pattern = {'['};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(-1, location);}
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestCharFail1() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is found in the text.		
		StringSearch ss = new BNDMCI();
		char[] text = {'a' };
		char[] pattern = {'A'};
		
		int location = ss.searchChars(text, pattern);
		
		assertEquals(0, location);}
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestCharFail2() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is found in the text.		
		StringSearch ss = new BNDMCI();
		char[] text = {'A' };
		char[] pattern = {'a'};
		
		int location = ss.searchChars(text, pattern);
		
		assertEquals(0, location);}
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestCharFail3() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is found in the text.		
		StringSearch ss = new BNDMCI();
		char[] text = {'z' };
		char[] pattern = {'Z'};
		
		int location = ss.searchChars(text, pattern);
		
		assertEquals(0, location);}
	
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestCharFail4() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is found in the text.		
		StringSearch ss = new BNDMCI();
		char[] text = {'Z' ,'['};
		char[] pattern = {'z','['};
		
		int location = ss.searchChars(text, pattern);
		
		assertEquals(0, location);}
	
	@Test
	public void testIdxLargerThan127a() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is found in the text.		
		StringSearch ss = new BNDMCI();
		byte[] text = {(byte) 192};
		byte[] pattern = {(byte) 224};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(0, location);
		}

	@Test
	public void testIdxLargerThan127b() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is not found in the text.
		StringSearch ss = new BNDMCI();
		byte[] text = {(byte) 222};
		byte[] pattern = {(byte) 254};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(0, location);
		}

	@Test
	public void testIdxLargerThan127c() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is not found in the text.
		StringSearch ss = new BNDMCI();
		byte[] text = {(byte) 224};
		byte[] pattern = {(byte) 192};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(0, location);
		}

	@Test
	public void testIdxLargerThan127d() {
		// Technique used: Mutation coverage
		//
		// This test case represents the block of inputs to the
		// BNDMCI implementation of StringSearch.Bytes
		// that contain:
		//
		// - a non-null pattern
		// - a non-null text
		// - the pattern is not found in the text.		
		StringSearch ss = new BNDMCI();
		byte[] text = {(byte) 254};
		byte[] pattern = {(byte) 222};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(0, location);
		}

	
}