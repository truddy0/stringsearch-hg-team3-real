package com.eaio.stringsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BNDMWildcardsCITest {
	// Technique used: input space partitioning
	//
	// This test case represents the block of inputs to the
	// BNDMWildcardsCI implementation of StringSearch.searchString
	// that contain:
	//
	// - a non-null pattern
	// - a non-null string
	// - the pattern is found in the string.(pattern length is between 1 and 32)
    
    @Test
    public void testBNDMPatterLenghtFound_1to32(){
        StringSearch ss = new BNDMWildcardsCI();
        String str = "helloworld11";
        String pattern = "H.lloworLd11";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }
    
    @Test
    public void testBNDMPatterLenghtFound_1to32II(){
    	// Technique used: input space partitioning
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null string
    	// - the pattern is found in the string.
        StringSearch ss = new BNDMWildcardsCI();
        String str = "HELLO";
        String pattern = "h.llo";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }
    
    @Test
    public void testBNDMPatterLenghtFound_1to32III(){
    	// Technique used: input space partitioning
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null string
    	// - the pattern is found in the string.
        StringSearch ss = new BNDMWildcardsCI();
        String str = "hello1{z";
        String pattern = "H.LLO1{z";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }
    @Test
    public void testBNDMPatternNotFoundI_Length1to32() {
    	// Technique used: input space partitioning
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null string
    	// - the pattern is not found in the string.        
        
        StringSearch ss = new BNDMWildcardsCI();
        String str = "helloworld";
        String pattern = "A.e6367";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    
    
    
    @Test
    public void testBNDMPatterFound_Lenghtbiggertha32_allright(){
    	// Technique used: input space partitioning
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null string
    	// - the pattern is found in the string.
        StringSearch ss = new BNDMWildcardsCI();
        String str = "helloworldhelloworldhelloworldhelloworld1123";
        String pattern = "H.lloworldhelloworldhelloworldhelloworld1123";
        
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
		// BNDMWildcardsCI implementation of StringSearch.searchString
		// that contain:
		//
		// - a non-null pattern
		// - a non-null string
		// - the pattern is found in the string.
        StringSearch ss = new BNDMWildcardsCI();
        String str = "helloworldhelloworldhelloworldhelloworld1123";
        String pattern = "H.lloworldhelloworldhelloworldhelloworld1124";
        
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
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null string
    	// - the pattern is not found in the string.        
        //pattern & str don’t match at all.
        StringSearch ss = new BNDMWildcardsCI();
        String str = "hello";
        String pattern = "f.sjisladso";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    
    @Test
    public void testBNDMPatternlongerthanStrII() {
    	// Technique used: input space partitioning
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null string
    	// - the pattern is not found in the string.               
        //pattern longer than str but don’t match
        StringSearch ss = new BNDMWildcardsCI();
        String str = "hello";
        String pattern = "H.lloworld12323232848372934203427328324893927";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    
    
    
    @Test
    public void testBNDMPatternlongerthanStrIII() {
    	// Technique used: input space partitioning
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null string
    	// - the pattern is not found in the string.        
        //pattern is like str but longer than str
        StringSearch ss = new BNDMWildcardsCI();
        String str = "hello";
        String pattern = "h.lloworld";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    
    @Test
    public void testBNDMPatternlongerthanStrIV() {
    	// Technique used: input space partitioning
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null string
    	// - the pattern is found in the string.       
        //str length is 32 but pattern is larger than 32 and found
        StringSearch ss = new BNDMWildcardsCI();
        String str = "hello123hello123hello123hello123";
        String pattern = "h.llo123hello123hello123hello123fesjisladso";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }
    
    @Test
    public void testbytenotfound() {
    	// Technique used: Statement Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is not found in the string.        
        StringSearch ss = new BNDMCI();
        byte[] text = {1,2,4,'a','A'};
        byte[] pattern = {8,'.','A','{'};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);
    }
    
    @Test
    public void testbytefound() {
    	// Technique used: Statement Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is found in the string.        
        StringSearch ss = new BNDMWildcardsCI();
        byte[] text = {1,2,4};
        byte[] pattern = {1,2,'.'};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);
    }
  
    @Test
    public void testbytepatternlongerthantext() {
    	// Technique used: Statement Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is not found in the string.        
        StringSearch ss = new BNDMWildcardsCI();
        byte[] text = {1,2,4};
        byte[] pattern = {1,'.',4,2,4,1,2,2,(byte) 214,(byte) 244,'a','A','{',(byte) 288};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);
    }
    
    
    @Test
    public void testbytepatternlongerthantext32() {
    	// Technique used: Statement Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is found in the string.        
        StringSearch ss = new BNDMWildcardsCI();
        byte[] text = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2};
        byte[] pattern = {1,'.',4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestFail1() {
    	// Technique used: Mutation Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is not found in the string.		
		StringSearch ss = new BNDMWildcardsCI();
		byte[] text = {'@' };
		byte[] pattern = {'`'};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(-1, location);}
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestFail2() {
    	// Technique used: Mutation Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is not found in the string.		
		StringSearch ss = new BNDMWildcardsCI();
		byte[] text = {'`' };
		byte[] pattern = {'@'};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(-1, location);}
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestFail3() {
    	// Technique used: Mutation Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is not found in the string.		
		StringSearch ss = new BNDMWildcardsCI();
		byte[] text = {'[' };
		byte[] pattern = {'{'};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(-1, location);}
	
	@Test//Mutation Test
	public void UpperCaseLowerCaseTestFail4() {
    	// Technique used: Mutation Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is not found in the string.		
		StringSearch ss = new BNDMWildcardsCI();
		byte[] text = {'{' };
		byte[] pattern = {'['};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(-1, location);}

	
	
	@Test
	public void testIdxLargerThan127a() {
    	// Technique used: Mutation Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is found in the string.		
		StringSearch ss = new BNDMWildcardsCI();
		byte[] text = {(byte) 192};
		byte[] pattern = {(byte) 224};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(0, location);
		}

	@Test
	public void testIdxLargerThan127b() {
    	// Technique used: Mutation Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is found in the string.		
		StringSearch ss = new BNDMWildcardsCI();
		byte[] text = {(byte) 222};
		byte[] pattern = {(byte) 254};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(0, location);
		}

	@Test
	public void testIdxLargerThan127c() {
    	// Technique used: Mutation Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is found in the string.		
		StringSearch ss = new BNDMWildcardsCI();
		byte[] text = {(byte) 224};
		byte[] pattern = {(byte) 192};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(0, location);
		}

	@Test
	public void testIdxLargerThan127d() {
    	// Technique used: Mutation Coverage
    	//
    	// This test case represents the block of inputs to the
    	// BNDMWildcardsCI implementation of StringSearch.searchString
    	// that contain:
    	//
    	// - a non-null pattern
    	// - a non-null text
    	// - the pattern is found in the string.		
		StringSearch ss = new BNDMWildcardsCI();
		byte[] text = {(byte) 254};
		byte[] pattern = {(byte) 222};
		
		int location = ss.searchBytes(text, pattern);
		
		assertEquals(0, location);
		}
    
}