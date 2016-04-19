package com.eaio.stringsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BMHTest {

	@Test
	public void testBoyerMooreHorspoolPatterLenghth0(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is found in the string.
		StringSearch ss = new BoyerMooreHorspool();
		String str = "h";
		String pattern = "h";
		
		int location = ss.searchString(str, pattern);
		
		assertEquals(0, location);
	}
    
    @Test
    public void testBoyerMooreHorspoolPatterLenghth1(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is Not found in the string.

        StringSearch ss = new BoyerMooreHorspool();
        String str = "h";
        String pattern = "p";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    @Test
    public void testBoyerMooreHorspoolPatterLenghth2(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is found in the string.

        StringSearch ss = new BoyerMooreHorspool();
        String str = "he";
        String pattern = "he";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }
    @Test
    public void testBoyerMooreHorspoolPatterLenghth3(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is NOT found in the string.

        StringSearch ss = new BoyerMooreHorspool();
        String str = "he";
        String pattern = "h1";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }

    @Test
    public void testBoyerMooreHorspoolPatterLenghth4(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is found in the string.

        StringSearch ss = new BoyerMooreHorspool();
        String str = "hell";
        String pattern = "hell";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }
    @Test
    public void testBoyerMooreHorspoolPatterLenghth41(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is found in the string.

        StringSearch ss = new BoyerMooreHorspool();
        String str = "helllo";
        String pattern = "helllo";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }

    @Test
    public void testBoyerMooreHorspoolPatterLenghth5(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is Not found in the string.

        StringSearch ss = new BoyerMooreHorspool();
        String str = "hello";
        String pattern = "world";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    @Test
    public void testBoyerMooreHorspoolPatterLenghth6(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is found in the string.

        StringSearch ss = new BoyerMooreHorspool();
        String str = "helloworld12345678900987654321";
        String pattern = "helloworld12345678900987654321";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(0, location);
    }
    @Test
    public void testBoyerMooreHorspoolPatterLenghth61(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern longer thaner 32
        // - a non-null string
        // - the pattern is not found in the string.

        StringSearch ss = new BoyerMooreHorspool();
        String str = "helloworld12345678900987654321";
        String pattern = "12345678900987654321helloworld";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    @Test
    public void testBoyerMooreHorspoolPatterLenghth7(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string the CI
        // - the pattern is Nound in the string.

        StringSearch ss = new BoyerMooreHorspool();
        String str = "hello";
        String pattern = "Hello";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    @Test
    public void testBoyerMooreHorspoolPatterLenghth8(){
        // Technique used: input space partitioning
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string is shourter than the pattern
        // - the pattern is Not found in the string.

        StringSearch ss = new BoyerMooreHorspool();
        String str = "hello";
        String pattern = "hello111";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }

    @Test
    public void testbytepatternlongerthantext0() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null text hte length is 1
        // - the pattern is found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1};
        byte[] pattern = {1};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    
    
    @Test
    public void testbytepatternlongerthantext1() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1,2};
        byte[] pattern = {1,2};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    
    @Test
    public void testbytepatternlongerthantext2() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null text the length is 2
        // - the pattern is Not found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1};
        byte[] pattern = {0};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    @Test
    public void testbytepatternlongerthantext3() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null text the length is 1
        // - the pattern is not found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1,2};
        byte[] pattern = {2,1};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    @Test
    public void testbytepatternlongerthantext4() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null text the length is 3-5
        // - the pattern is found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1,2,4};
        byte[] pattern = {1,2,4};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    @Test
    public void testbytepatternlongerthantext5() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null string
        // - the pattern is not found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1,2,4};
        byte[] pattern = {1,2,5};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    @Test
    public void testbytepatternlongerthantext6() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null text
        // - the pattern is found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1,2,4,3,5,7};
        byte[] pattern = {1,2,4,3,5,7};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    @Test
    public void testbytepatternlongerthantext10() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null text
        // - the pattern is found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
        byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(0, location);}
    @Test
    public void testbytepatternlongerthantext11() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null pattern
        // - a non-null text
        // - the pattern is not found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
        byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    @Test
    public void testbytepatternlongerthantext12() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null text
        // - a non-null string length longer than text
        // - the pattern is not found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2};
        byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    @Test
    public void testBoyerMooreHorspoolPatterLenghth00(){
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null str
        // - a non-null string length2
        // - the pattern is not found in the string.
        
        StringSearch ss = new BoyerMooreHorspool();
        String str = "h1";
        String pattern = "h2";
        
        int location = ss.searchString(str, pattern);
        
        assertEquals(-1, location);
    }
    
    @Test
    public void testbytepatternlongerthantext01() {
        // Technique used: Coverage Statement
        //
        // This test case represents the block of inputs to the
        // BoyerMooreHorspool implementation of StringSearch.searchString
        // that contain:
        //
        // - a non-null text
        // - a non-null string length 2
        // - the pattern is not found in the string.
        
        
        StringSearch ss = new BoyerMooreHorspool();
        byte[] text = {1,2};
        byte[] pattern = {1,3};
        
        int location = ss.searchBytes(text, pattern);
        
        assertEquals(-1, location);}
    
}