package com.eaio.stringsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BMHRaitaTest {
    
    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth00(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is not found in the string
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "h1";
        String pattern = "h2";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }

	@Test
	public void testBoyerMooreHorspoolRaitaPatterLenghth0(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 1
        // - a non-null string length is 1
        // - the pattern is found in the string.

		StringSearch ss = new BoyerMooreHorspoolRaita();
		String str = "h";
		String pattern = "h";
		
		int location = ss.searchString(str, pattern);
		
		assertEquals(0, location);
	}
    
    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth1(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 1
        // - a non-null string length is 1
        // - the pattern is not found in the string.
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "h";
        String pattern = "p";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth2(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 2
        // - a non-null string
        // - the pattern is found in the string.
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "he";
        String pattern = "he";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }
    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth3(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string length is 2
        // - the pattern is not found in the string.
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "he";
        String pattern = "h1";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }

    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth4(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 4
        // - a non-null string
        // - the pattern is found in the string.
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "hell";
        String pattern = "hell";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }
    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth41(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is found in the string.
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "helllo";
        String pattern = "helllo";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }

    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth5(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is not found in the string.
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "hello";
        String pattern = "world";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth6(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is found in the string.
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "helloworld12345678900987654321";
        String pattern = "helloworld12345678900987654321";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }
    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth61(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 30
        // - a non-null string
        // - the pattern is not found in the string.
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "helloworld12345678900987654321";
        String pattern = "12345678900987654321helloworld";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth7(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern the CI
        // - a non-null string
        // - the pattern is not found in the string.
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "hello";
        String pattern = "Hello";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    @Test
    public void testBoyerMooreHorspoolRaitaPatterLenghth8(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern longer than str
        // - a non-null string
        // - the pattern is not found in the string.
        StringSearch ss = new BoyerMooreHorspoolRaita();
        String str = "hello";
        String pattern = "hello111";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }

    @Test
    public void testbytepatternlongerthantext0() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 1
        // - a non-null text
        // - the pattern is found in the string.
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1};
        byte[] pattern = {1};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    
    
    @Test
    public void testbytepatternlongerthantext1() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 2
        // - a non-null text
        // - the pattern is found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1,2};
        byte[] pattern = {1,2};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    
    @Test
    public void testbytepatternlongerthantext2() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 1
        // - a non-null text
        // - the pattern is not found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1};
        byte[] pattern = {0};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    @Test
    public void testbytepatternlongerthantext3() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 2
        // - a non-null text
        // - the pattern is not found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1,2};
        byte[] pattern = {2,1};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    @Test
    public void testbytepatternlongerthantext4() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 3
        // - a non-null text
        // - the pattern is found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1,2,4};
        byte[] pattern = {1,2,4};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    @Test
    public void testbytepatternlongerthantext5() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length is 3
        // - a non-null text
        // - the pattern is not found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1,2,4};
        byte[] pattern = {1,2,5};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    @Test
    public void testbytepatternlongerthantext6() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length
        // - a non-null text
        // - the pattern is found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1,2,4,3,5,7};
        byte[] pattern = {1,2,4,3,5,7};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    @Test
    public void testbytepatternlongerthantext10() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length longer than 32
        // - a non-null text
        // - the pattern is found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
        byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    @Test
    public void testbytepatternlongerthantext11() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length longer than 32 and longer than text
        // - a non-null text
        // - the pattern is  not found in the string.
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
        byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    @Test
    public void testbytepatternlongerthantext12() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern length longer than 32
        // - a non-null text
        // - the pattern is not found in the string.
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2};
        byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    
    
    @Test
    public void testbytepattern01() {
        // Technique used: Coverage statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspoolRaita implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null text
        // - the pattern is not found in the string.
        
        StringSearch ss = new BoyerMooreHorspoolRaita();
        byte[] text = {1,2};
        byte[] pattern = {1,3};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}

       
      
       
}