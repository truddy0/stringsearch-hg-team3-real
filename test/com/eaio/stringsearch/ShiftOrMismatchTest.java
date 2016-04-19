package com.eaio.stringsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShiftOrMismatchTest {

	@Test
    public void testBNDMPatternShorterThanString() {
	// Technique used: input space partitioning
	//
	// This test case represents the block of inputs to the
	// ShiftOrMismatches implementation of MismatchSearch.searchString
	// that contain:
	//
	// - a non-null pattern
	// - a non-null string
	// - the pattern is NOT found in the string.
	MismatchSearch ss = new ShiftOrMismatches();
	String str = "helloworld";
	String pattern = "he";
	
	int[] locations = ss.searchString(str, pattern, -1);
	
	for (int i = 0; i < locations.length; i++)
	    System.out.println(locations[i]);
	
	assertArrayEquals(new int[] { -1, 0 }, locations);
    }
    
	
	@Test
    public void testBNDMPatternLongerThanString() {
	// Technique used: input space partitioning
	//
	// This test case represents the block of inputs to the
	// ShiftOrMismatches implementation of MismatchSearch.searchString
	// that contain:
	//
	// - a non-null pattern
	// - a non-null string
	// - the pattern is NOT found in the string.
	MismatchSearch ss = new ShiftOrMismatches();
	String str = "helloworld";
	String pattern = "hell12131231232";
	
	int[] locations = ss.searchString(str, pattern, 1);
	
	for (int i = 0; i < locations.length; i++)
	    System.out.println(locations[i]);
	
	assertArrayEquals(new int[] { -1, 0 }, locations);
	}
    
	
	@Test
    public void testBNDMPatternEqualsString() {
	// Technique used: input space partitioning
	//
	// This test case represents the block of inputs to the
	// ShiftOrMismatches implementation of MismatchSearch.searchString
	// that contain:
	//
	// - a non-null pattern
	// - a non-null string
	// - the pattern is NOT found in the string.
	MismatchSearch ss = new ShiftOrMismatches();
	String str = "helloworld";
	String pattern = "h123123123";
	
	int[] locations = ss.searchString(str, pattern, 0);
	
	for (int i = 0; i < locations.length; i++)
	    System.out.println(locations[i]);
	
	assertArrayEquals(new int[] { -1, 0 }, locations);
	}

    @Test
    public void ShiftOrMismatchesTest0() {
    // Technique used: input space partitioning
   	//
   	// This test case represents the block of inputs to the
   	// ShiftOrMismatches implementation of MismatchSearch.searchString
   	// that contain:
   	//
   	// - a non-null pattern
   	// - a non-null string
   	// - the pattern is NOT found in the string.
        MismatchSearch ss = new ShiftOrMismatches();
        String str = "helloworld";
        String pattern = "hel1ohel1o";
        
        int[] locations = ss.searchString(str, pattern, 1);
        
        for (int i = 0; i < locations.length; i++)
            System.out.println(locations[i]);
        
        assertArrayEquals(new int[] { -1, 0 }, locations);
    }
    
    
    @Test
    public void ShiftOrMismatchesTest1() {
    // Technique used: input space partitioning
    //
    // This test case represents the block of inputs to the
    // ShiftOrMismatches implementation of MismatchSearch.searchString
    // that contain:
    //
    // - a non-null pattern
    // - a non-null string
    // - the pattern is found in the string.
        MismatchSearch ss = new ShiftOrMismatches();
        String str = "helloworld";
        String pattern = "hel1oworld";
        
        int[] locations = ss.searchString(str, pattern, 1);
        
        for (int i = 0; i < locations.length; i++)
            System.out.println(locations[i]);
        
        assertArrayEquals(new int[] { 0, 1 }, locations);
    }
    
    
    @Test
    public void ShiftOrMismatchesTest2() {
    // Technique used: input space partitioning
    //
    // This test case represents the block of inputs to the
    // ShiftOrMismatches implementation of MismatchSearch.searchString
    // that contain:
    //
    // - a non-null pattern
    // - a non-null string
    // - the pattern is NOT found in the string.
        MismatchSearch ss = new ShiftOrMismatches();
        String str = "helloworld";
        String pattern = "he1111111d";
        
        int[] locations = ss.searchString(str, pattern, 0);
        
        for (int i = 0; i < locations.length; i++)
            System.out.println(locations[i]);
        
        assertArrayEquals(new int[] { -1, 0}, locations);
    }


    @Test
    public void ShiftOrMismatchesTest3() {
    // Technique used: input space partitioning
    //
    // This test case represents the block of inputs to the
    // ShiftOrMismatches implementation of MismatchSearch.searchString
    // that contain:
    //
    // - a non-null pattern
    // - a non-null string
    // - the pattern is NOT found in the string.
        MismatchSearch ss = new ShiftOrMismatches();
        String str = "helloworld";
        String pattern = "hel1oworl1";
        
        int[] locations = ss.searchString(str, pattern, 0);
        
        for (int i = 0; i < locations.length; i++)
            System.out.println(locations[i]);
        
        assertArrayEquals(new int[] { -1, 0 }, locations);
    }
    
    
    @Test
    public void ShiftOrMismatchesTest4() {
    // Technique used: statement coverage
    //
    // This test case represents the block of inputs to the
    // ShiftOrMismatches implementation of MismatchSearch.searchBytes
    // that contain:
    //
    // - a non-null pattern
    // - a non-null text
    // - the pattern is found in the text.
        MismatchSearch ss = new ShiftOrMismatches();
        byte[] text = {1,2};
        byte[] pattern = {1,3};
        
        int[] locations = ss.searchBytes(text, pattern, 1);
        
        for (int i = 0; i < locations.length; i++)
            System.out.println(locations[i]);
        
        assertArrayEquals(new int[] { 0, 1 }, locations);
    }

    
  @Test
    public void ShiftOrMismatchesTest5() {
	// Technique used: statement coverage
	//
    // This test case represents the block of inputs to the
    // ShiftOrMismatches implementation of MismatchSearch.searchBytes
    // that contain:
    //
    // - a non-null pattern
    // - a non-null text
    // - the pattern is NOT found in the text.
        MismatchSearch ss = new ShiftOrMismatches();
        byte[] text = {1,2,3};
        byte[] pattern = {1,'b'};
        
        int[] locations = ss.searchBytes(text, pattern, -1);
        
        for (int i = 0; i < locations.length; i++)
            System.out.println(locations[i]);
        
        assertArrayEquals(new int[] { -1, 0 }, locations);
    }

    @Test
    public void ShiftOrMismatchesTest6() {
    // Technique used: statement coverage
    //
    // This test case represents the block of inputs to the
    // ShiftOrMismatches implementation of MismatchSearch.searchBytes
    // that contain:
    //
    // - a non-null pattern
    // - a non-null text
    // - the pattern is NOT found in the text.
        MismatchSearch ss = new ShiftOrMismatches();
        byte[] text = {1,2,3};
        byte[] pattern = {1,2,3,4};
        
        int[] locations = ss.searchBytes(text, pattern, 1);
        
        for (int i = 0; i < locations.length; i++)
            System.out.println(locations[i]);
        
        assertArrayEquals(new int[] { -1, 0}, locations);
    }
}    