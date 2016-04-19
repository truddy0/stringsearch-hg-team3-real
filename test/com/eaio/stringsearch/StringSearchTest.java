package com.eaio.stringsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringSearchTest {

	@Test
	public void testBNDMPatterLenghtFound_1to32a(){
		StringSearch ss = new BNDM();
		String str = "helloworld11";
		String pattern = "helloworld11";
		
		int location = ss.searchString(str, pattern);
		
		assertEquals(0, location);
	}
    
    @Test
    public void testBNDMPatternNotFoundI_Length1to32a() {
	// Technique used: input space partitioning
	//
	// This test case represents the block of inputs to the
	// BNDM implementation of StringSearch.searchString
	// that contain:
	//
	// - a non-null pattern
	// - a non-null string
	// - the pattern is NOT found in the string.
	
	StringSearch ss = new BNDM();
	String str = "helloworld";
	String pattern = "se6367";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }
    
    @Test
    public void testBNDMPatternNotFoundII_Length1to32a() {
	
	StringSearch ss = new BNDM();
	String str = "helloworld";
	String pattern = "HELLOWORLD";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }
	
	@Test
	public void testBNDMPatterFound_Lenghtbiggertha32_allrighta(){
		StringSearch ss = new BNDM();
		String str = "helloworldhelloworldhelloworldhelloworld1123";
		String pattern = "helloworldhelloworldhelloworldhelloworld1123";
		
		int location = ss.searchString(str, pattern);
		
		//Because BNDM.java cannot check the pattern whose length is bigger than 32 bytes, 
		//the pattern will only math the first 32bytes. This case is that pattern matches string totally.
		
		assertEquals(0, location);
	}
	
	@Test
	public void testBNDMPatterFound_Lenghtbiggertha32_32righta(){
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
    public void testBNDMPatternNotFound_Lengthmorethan32a() {
	//Not Found Caused by CI
	StringSearch ss = new BNDM();
	String str = "helloworldhelloworldhelloworldhelloworld";
	String pattern = "Helloworldhelloworldhelloworldhelloworld";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }
	
	@Test
    public void testBNDMPatternlongerthanStrIa() {
	
//pattern & str don’t match at all.
	StringSearch ss = new BNDM();
	String str = "hello";
	String pattern = "fesjisladso";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

 @Test
    public void testBNDMPatternlongerthanStrIIa() {
	
//pattern longer than str but don’t match
	StringSearch ss = new BNDM();
	String str = "hello";
	String pattern = "helloworld12323232848372934203427328324893927";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

 @Test
    public void testBNDMPatternlongerthanStrIIIa() {
	
//pattern is like str but longer than str
	StringSearch ss = new BNDM();
	String str = "hello";
	String pattern = "helloworld";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
    }

 @Test
    public void testBNDMPatternlongerthanStrIVa() {
	
//str length is 32 but pattern is larger than 32 and found
	StringSearch ss = new BNDM();
	String str = "hello123hello123hello123hello123";
	String pattern = "hello123hello123hello123hello123fesjisladso";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(0, location);
    }

 @Test
 public void testBNDMMismatchIa() {
	
	
	MismatchSearch ss = new ShiftOrMismatches();
	String str = "helloworld";
	String pattern = "hel1ohel1o";
	
	int[] locations = ss.searchString(str, pattern, 1);
	
	for (int i = 0; i < locations.length; i++)
	    System.out.println(locations[i]);
	
	assertArrayEquals(new int[] { -1, 0 }, locations);
 }


@Test
 public void testBNDMMismatchIIa() {
	//mismatch more than half
	
	MismatchSearch ss = new ShiftOrMismatches();
	String str = "helloworld";
	String pattern = "h2110m0r1d";
	
	int[] locations = ss.searchString(str, pattern, 1);
	
	for (int i = 0; i < locations.length; i++)
	    System.out.println(locations[i]);
	
	assertArrayEquals(new int[] { -1, 0 }, locations);
 }

@Test//mismatch check success
 public void testBNDMMismatchIIIa() {
	
	
	MismatchSearch ss = new ShiftOrMismatches();
	String str = "helloworld";
	String pattern = "hel1oworld";
	
	int[] locations = ss.searchString(str, pattern, 1);
	
	for (int i = 0; i < locations.length; i++)
	    System.out.println(locations[i]);
	
	assertArrayEquals(new int[] { 0, 1 }, locations);
 }


@Test
public void testbytenotfounda() {
	
	StringSearch ss = new BNDM();
	byte[] text = {1,2,4};
	byte[] pattern = {8};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(-1, location);
	}

@Test
public void testbytepatternlongerthantexta() {
	
	StringSearch ss = new BNDM();
	byte[] text = {1,2,4};
	byte[] pattern = {1,2,4,2,4,1,2,2};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(-1, location);
	}


@Test
public void testbytepatternlongerthantext32a() {
	
	StringSearch ss = new BNDM();
	byte[] text = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2};
	byte[] pattern = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(0, location);}

@Test
public void testBNDMPatterLenghtFound_1to32b(){
	StringSearch ss = new BNDMCI();
	String str = "helloworld11";
	String pattern = "HelloworLd11";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(0, location);
}

@Test
public void testBNDMPatterLenghtFound_1to32IIb(){
	StringSearch ss = new BNDMCI();
	String str = "HELLO";
	String pattern = "hello";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(0, location);
}

@Test
public void testBNDMPatterLenghtFound_1to32IIIb(){
	StringSearch ss = new BNDMCI();
	String str = "hello1{z";
	String pattern = "HELLO1{z";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(0, location);
}
@Test
public void testBNDMPatternNotFoundI_Length1to32b() {


StringSearch ss = new BNDMCI();
String str = "helloworld";
String pattern = "Ase6367";

int location = ss.searchString(str, pattern);

assertEquals(-1, location);
}



@Test
public void testBNDMPatterFound_Lenghtbiggertha32_allrightb(){
	StringSearch ss = new BNDMCI();
	String str = "helloworldhelloworldhelloworldhelloworld1123";
	String pattern = "Helloworldhelloworldhelloworldhelloworld1123";
	
	int location = ss.searchString(str, pattern);
	
	//Because BNDM.java cannot check the pattern whose length is bigger than 32 bytes, 
	//the pattern will only math the first 32bytes. This case is that pattern matches string totally.
	
	assertEquals(0, location);
}

@Test
public void testBNDMPatterFound_Lenghtbiggertha32_32rightb(){
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
public void testBNDMPatternlongerthanStrIb() {

//pattern & str don’t match at all.
StringSearch ss = new BNDMCI();
String str = "hello";
String pattern = "fesjisladso";

int location = ss.searchString(str, pattern);

assertEquals(-1, location);
}

@Test
public void testBNDMPatternlongerthanStrIIb() {

//pattern longer than str but don’t match
StringSearch ss = new BNDMCI();
String str = "hello";
String pattern = "Helloworld12323232848372934203427328324893927";

int location = ss.searchString(str, pattern);

assertEquals(-1, location);
}

@Test
public void testBNDMPatternlongerthanStrIIIb() {

//pattern is like str but longer than str
StringSearch ss = new BNDMCI();
String str = "hello";
String pattern = "helloworld";

int location = ss.searchString(str, pattern);

assertEquals(-1, location);
}

@Test
public void testBNDMPatternlongerthanStrIVb() {

//str length is 32 but pattern is larger than 32 and found
StringSearch ss = new BNDMCI();
String str = "hello123hello123hello123hello123";
String pattern = "hello123hello123hello123hello123fesjisladso";

int location = ss.searchString(str, pattern);

assertEquals(0, location);
}

@Test
public void testBNDMMismatchIb() {


MismatchSearch ss = new ShiftOrMismatches();
String str = "helloworld";
String pattern = "Hel1ohel1o";

int[] locations = ss.searchString(str, pattern, 1);

for (int i = 0; i < locations.length; i++)
    System.out.println(locations[i]);

assertArrayEquals(new int[] { -1, 0 }, locations);
}


@Test
public void testBNDMMismatchIIb() {
//mismatch more than half

MismatchSearch ss = new ShiftOrMismatches();
String str = "helloworld";
String pattern = "H2110m0r1d";

int[] locations = ss.searchString(str, pattern, 1);

for (int i = 0; i < locations.length; i++)
    System.out.println(locations[i]);

assertArrayEquals(new int[] { -1, 0 }, locations);
}

@Test//mismatch check success
public void testBNDMMismatchIIIb() {


MismatchSearch ss = new ShiftOrMismatches();
String str = "helloworld";
String pattern = "hel1oworld";

int[] locations = ss.searchString(str, pattern, 1);

for (int i = 0; i < locations.length; i++)
    System.out.println(locations[i]);

assertArrayEquals(new int[] { 0, 1 }, locations);
}


@Test
public void testbytenotfoundb() {

StringSearch ss = new BNDMCI();
byte[] text = {1,2,4,'a','A'};
byte[] pattern = {8,'a','A','{'};

int location = ss.searchBytes(text, pattern);

assertEquals(-1, location);
}

@Test
public void testbytepatternlongerthantextb() {

StringSearch ss = new BNDMCI();
byte[] text = {1,2,4};
byte[] pattern = {1,2,4,2,4,1,2,2,(byte) 214,(byte) 244};

int location = ss.searchBytes(text, pattern);

assertEquals(-1, location);
}


@Test
public void testbytepatternlongerthantext32b() {

StringSearch ss = new BNDMCI();
byte[] text = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2};
byte[] pattern = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1};

int location = ss.searchBytes(text, pattern);

assertEquals(0, location);}

@Test
public void testBNDMwildPatterLenghtFound_1to32(){
	StringSearch ss = new BNDMWildcards();
	String str = "helloworld11";
	String pattern = "h.lloworld11";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(0, location);
}

@Test
//Test if all ‘.’  can pass
public void testBNDMwildextrem (){
    StringSearch ss = new BNDMWildcards();
    String str = "helloworld11";
    String pattern = "............";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(0, location);
}

@Test
public void testBNDMwildPatternNotFoundI_Length1to32() {
StringSearch ss = new BNDMWildcards();
String str = "helloworld";
String pattern = "s.6367";

int location = ss.searchString(str, pattern);

assertEquals(-1, location);
}

@Test
public void testBNDMwildPatternNotFoundII_Length1to32() {
//test if the CI can affect
StringSearch ss = new BNDMWildcards();
String str = "helloworld";
String pattern = "H.LLOWORLD";

int location = ss.searchString(str, pattern);

assertEquals(-1, location);
}

@Test
public void testBNDMwildPatterFound_Lenghtbiggertha32_allright(){
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
//Not Found Caused by CI
StringSearch ss = new BNDMWildcards();
String str = "helloworldhelloworldhelloworldhelloworld";
String pattern = "H.lloworldhelloworldhelloworldhelloworld";

int location = ss.searchString(str, pattern);

assertEquals(-1, location);
}

@Test
public void testBNDMwildPatternlongerthanStrI() {

//pattern & str don’t match at all.
StringSearch ss = new BNDMWildcards();
String str = "hello";
String pattern = "fe.jisladso";

int location = ss.searchString(str, pattern);

assertEquals(-1, location);
}

@Test
public void testBNDMwildPatternlongerthanStrII() {

//pattern longer than str but don’t match
StringSearch ss = new BNDMWildcards();
String str = "hello";
String pattern = "hellow.rld12323232848372934203427328324893927";

int location = ss.searchString(str, pattern);

assertEquals(-1, location);
}

@Test
public void testBNDMwildPatternlongerthanStrIII() {

//pattern is like str but longer than str
StringSearch ss = new BNDMWildcards();
String str = "hello";
String pattern = "h.lloworld";

int location = ss.searchString(str, pattern);

assertEquals(-1, location);
}

@Test
public void testBNDMwildPatternlongerthanStrIV() {

//str length is 32 but pattern is larger than 32 and found
StringSearch ss = new BNDMWildcards();
String str = "hello123hello123hello123hello123";
String pattern = "h.llo123hello123hello123hello123fesjisladso";

int location = ss.searchString(str, pattern);

assertEquals(0, location);
}


 

@Test
public void testbytenotfound() {

StringSearch ss = new BNDMWildcards();
byte[] text = {1,2,4};
byte[] pattern = {8,'.'};

int location = ss.searchBytes(text, pattern);

assertEquals(-1, location);
}

@Test
public void testbytefound() {
    
    StringSearch ss = new BNDMWildcards();
    byte[] text = {1,2,4};
    byte[] pattern = {1,2,'.'};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(0, location);
}

@Test
public void testbytepatternlongerthantext() {

StringSearch ss = new BNDMWildcards();
byte[] text = {1,2,4};
byte[] pattern = {1,'.',4,2,4,1,2,2};

int location = ss.searchBytes(text, pattern);

assertEquals(-1, location);
}


@Test
public void testbytepatternlongerthantext32() {

StringSearch ss = new BNDMWildcards();
byte[] text = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2};
byte[] pattern = {1,'.',4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1};

int location = ss.searchBytes(text, pattern);

assertEquals(0, location);}

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
    StringSearch ss = new BNDMWildcardsCI();
    String str = "HELLO";
    String pattern = "h.llo";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(0, location);
}

@Test
public void testBNDMPatterLenghtFound_1to32III(){
    StringSearch ss = new BNDMWildcardsCI();
    String str = "hello1{z";
    String pattern = "H.LLO1{z";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(0, location);
}
@Test
public void testBNDMPatternNotFoundI_Length1to32() {
    
    
    StringSearch ss = new BNDMWildcardsCI();
    String str = "helloworld";
    String pattern = "A.e6367";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(-1, location);
}



@Test
public void testBNDMPatterFound_Lenghtbiggertha32_allright(){
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
    
    //pattern & str don’t match at all.
    StringSearch ss = new BNDMWildcardsCI();
    String str = "hello";
    String pattern = "f.sjisladso";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(-1, location);
}

@Test
public void testBNDMPatternlongerthanStrII() {
    
    //pattern longer than str but don’t match
    StringSearch ss = new BNDMWildcardsCI();
    String str = "hello";
    String pattern = "H.lloworld12323232848372934203427328324893927";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(-1, location);
}



@Test
public void testBNDMPatternlongerthanStrIII() {
    
    //pattern is like str but longer than str
    StringSearch ss = new BNDMWildcardsCI();
    String str = "hello";
    String pattern = "h.lloworld";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(-1, location);
}

@Test
public void testBNDMPatternlongerthanStrIV() {
    
    //str length is 32 but pattern is larger than 32 and found
    StringSearch ss = new BNDMWildcardsCI();
    String str = "hello123hello123hello123hello123";
    String pattern = "h.llo123hello123hello123hello123fesjisladso";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(0, location);
}

@Test
public void testBNDMMismatchI() {
    
    
    MismatchSearch ss = new ShiftOrMismatches();
    String str = "helloworld";
    String pattern = "H.l1ohel1o";
    
    int[] locations = ss.searchString(str, pattern, 1);
    
    for (int i = 0; i < locations.length; i++)
        System.out.println(locations[i]);
    
    assertArrayEquals(new int[] { -1, 0 }, locations);
}



@Test
public void testbytenotfoundc() {
    
    StringSearch ss = new BNDMCI();
    byte[] text = {1,2,4,'a','A'};
    byte[] pattern = {8,'.','A','{'};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(-1, location);
}

@Test
public void testbytefoundc() {
    
    StringSearch ss = new BNDMWildcardsCI();
    byte[] text = {1,2,4};
    byte[] pattern = {1,2,'.'};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(0, location);
}
@Test
public void testbytepatternlongerthantextc() {
    
    StringSearch ss = new BNDMWildcardsCI();
    byte[] text = {1,2,4};
    byte[] pattern = {1,'.',4,2,4,1,2,2,(byte) 214,(byte) 244,'a','A','{',(byte) 288};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(-1, location);
}


@Test
public void testbytepatternlongerthantext32c() {
    
    StringSearch ss = new BNDMWildcardsCI();
    byte[] text = {1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2};
    byte[] pattern = {1,'.',4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1,2,4,2,4,1,2,2,1};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(0, location);}

@Test
public void testBoyerMooreHorspoolPatterLenghth0(){
	StringSearch ss = new BoyerMooreHorspool();
	String str = "h";
	String pattern = "h";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(0, location);
}

@Test
public void testBoyerMooreHorspoolPatterLenghth1(){
    StringSearch ss = new BoyerMooreHorspool();
    String str = "h";
    String pattern = "p";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(-1, location);
}
@Test
public void testBoyerMooreHorspoolPatterLenghth2(){
    StringSearch ss = new BoyerMooreHorspool();
    String str = "he";
    String pattern = "he";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(0, location);
}
@Test
public void testBoyerMooreHorspoolPatterLenghth3(){
    StringSearch ss = new BoyerMooreHorspool();
    String str = "he";
    String pattern = "h1";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(-1, location);
}

@Test
public void testBoyerMooreHorspoolPatterLenghth4(){
    StringSearch ss = new BoyerMooreHorspool();
    String str = "hell";
    String pattern = "hell";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(0, location);
}
@Test
public void testBoyerMooreHorspoolPatterLenghth41(){
    StringSearch ss = new BoyerMooreHorspool();
    String str = "helllo";
    String pattern = "helllo";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(0, location);
}

@Test
public void testBoyerMooreHorspoolPatterLenghth5(){
    StringSearch ss = new BoyerMooreHorspool();
    String str = "hello";
    String pattern = "world";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(-1, location);
}
@Test
public void testBoyerMooreHorspoolPatterLenghth6(){
    StringSearch ss = new BoyerMooreHorspool();
    String str = "helloworld12345678900987654321";
    String pattern = "helloworld12345678900987654321";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(0, location);
}
@Test
public void testBoyerMooreHorspoolPatterLenghth61(){
    StringSearch ss = new BoyerMooreHorspool();
    String str = "helloworld12345678900987654321";
    String pattern = "12345678900987654321helloworld";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(-1, location);
}
@Test
public void testBoyerMooreHorspoolPatterLenghth7(){
    StringSearch ss = new BoyerMooreHorspool();
    String str = "hello";
    String pattern = "Hello";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(-1, location);
}
@Test
public void testBoyerMooreHorspoolPatterLenghth8(){
    StringSearch ss = new BoyerMooreHorspool();
    String str = "hello";
    String pattern = "hello111";
    
    int location = ss.searchString(str, pattern);
    
    assertEquals(-1, location);
}

@Test
public void testbytepatternlongerthantext0() {

StringSearch ss = new BoyerMooreHorspool();
byte[] text = {1};
byte[] pattern = {1};

int location = ss.searchBytes(text, pattern);

assertEquals(0, location);}


@Test
public void testbytepatternlongerthantext1() {
    
    StringSearch ss = new BoyerMooreHorspool();
    byte[] text = {1,2};
    byte[] pattern = {1,2};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(0, location);}

@Test
public void testbytepatternlongerthantext2() {
    
    StringSearch ss = new BoyerMooreHorspool();
    byte[] text = {1};
    byte[] pattern = {0};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(-1, location);}
@Test
public void testbytepatternlongerthantext3() {
    
    StringSearch ss = new BoyerMooreHorspool();
    byte[] text = {1,2};
    byte[] pattern = {2,1};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(-1, location);}
@Test
public void testbytepatternlongerthantext4() {
    
    StringSearch ss = new BoyerMooreHorspool();
    byte[] text = {1,2,4};
    byte[] pattern = {1,2,4};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(0, location);}
@Test
public void testbytepatternlongerthantext5() {
    
    StringSearch ss = new BoyerMooreHorspool();
    byte[] text = {1,2,4};
    byte[] pattern = {1,2,5};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(-1, location);}
@Test
public void testbytepatternlongerthantext6() {
    
    StringSearch ss = new BoyerMooreHorspool();
    byte[] text = {1,2,4,3,5,7};
    byte[] pattern = {1,2,4,3,5,7};
    
    int location = ss.searchBytes(text, pattern);

    assertEquals(0, location);}
@Test
public void testbytepatternlongerthantext10() {
    
    StringSearch ss = new BoyerMooreHorspool();
    byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
    byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(0, location);}
@Test
public void testbytepatternlongerthantext11() {
    
    StringSearch ss = new BoyerMooreHorspool();
    byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
    byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(-1, location);}
@Test
public void testbytepatternlongerthantext12() {
    
    StringSearch ss = new BoyerMooreHorspool();
    byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2};
    byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2};
    
    int location = ss.searchBytes(text, pattern);
    
    assertEquals(-1, location);}
@Test
public void testBoyerMooreHorspoolPatterLenghth00(){
	StringSearch ss = new BoyerMooreHorspool();
	String str = "h1";
	String pattern = "h2";
	
	int location = ss.searchString(str, pattern);
	
	assertEquals(-1, location);
}

   @Test
public void testbytepatternlongerthantext01() {
    
    StringSearch ss = new BoyerMooreHorspool();
    byte[] text = {1,2};
    byte[] pattern = {1,3};
    
    int location = ss.searchBytes(text, pattern);

    assertEquals(-1, location);}
   
   @Test
	public void testBoyerMooreHorspoolRaitaPatterLenghth0(){
		StringSearch ss = new BoyerMooreHorspoolRaita();
		String str = "h";
		String pattern = "h";
		
		int location = ss.searchString(str, pattern);
		
		assertEquals(0, location);
	}
   
   @Test
   public void testBoyerMooreHorspoolRaitaPatterLenghth1(){
       StringSearch ss = new BoyerMooreHorspoolRaita();
       String str = "h";
       String pattern = "p";
       
       int location = ss.searchString(str, pattern);
       
       assertEquals(-1, location);
   }
   @Test
   public void testBoyerMooreHorspoolRaitaPatterLenghth2(){
       StringSearch ss = new BoyerMooreHorspoolRaita();
       String str = "he";
       String pattern = "he";
       
       int location = ss.searchString(str, pattern);
       
       assertEquals(0, location);
   }
   @Test
   public void testBoyerMooreHorspoolRaitaPatterLenghth3(){
       StringSearch ss = new BoyerMooreHorspoolRaita();
       String str = "he";
       String pattern = "h1";
       
       int location = ss.searchString(str, pattern);
       
       assertEquals(-1, location);
   }

   @Test
   public void testBoyerMooreHorspoolRaitaPatterLenghth4(){
       StringSearch ss = new BoyerMooreHorspoolRaita();
       String str = "hell";
       String pattern = "hell";
       
       int location = ss.searchString(str, pattern);
       
       assertEquals(0, location);
   }
   @Test
   public void testBoyerMooreHorspoolRaitaPatterLenghth41(){
       StringSearch ss = new BoyerMooreHorspoolRaita();
       String str = "helllo";
       String pattern = "helllo";
       
       int location = ss.searchString(str, pattern);
       
       assertEquals(0, location);
   }

   @Test
   public void testBoyerMooreHorspoolRaitaPatterLenghth5(){
       StringSearch ss = new BoyerMooreHorspoolRaita();
       String str = "hello";
       String pattern = "world";
       
       int location = ss.searchString(str, pattern);
       
       assertEquals(-1, location);
   }
   @Test
   public void testBoyerMooreHorspoolRaitaPatterLenghth6(){
       StringSearch ss = new BoyerMooreHorspoolRaita();
       String str = "helloworld12345678900987654321";
       String pattern = "helloworld12345678900987654321";
       
       int location = ss.searchString(str, pattern);
       
       assertEquals(0, location);
   }
   @Test
   public void testBoyerMooreHorspoolRaitaPatterLenghth61(){
       StringSearch ss = new BoyerMooreHorspoolRaita();
       String str = "helloworld12345678900987654321";
       String pattern = "12345678900987654321helloworld";
       
       int location = ss.searchString(str, pattern);
       
       assertEquals(-1, location);
   }
   @Test
   public void testBoyerMooreHorspoolRaitaPatterLenghth7(){
       StringSearch ss = new BoyerMooreHorspoolRaita();
       String str = "hello";
       String pattern = "Hello";
       
       int location = ss.searchString(str, pattern);
       
       assertEquals(-1, location);
   }
   @Test
   public void testBoyerMooreHorspoolRaitaPatterLenghth8(){
       StringSearch ss = new BoyerMooreHorspoolRaita();
       String str = "hello";
       String pattern = "hello111";
       
       int location = ss.searchString(str, pattern);
       
       assertEquals(-1, location);
   }

	@Test
public void testbytepatternlongerthantext0d() {
	
	StringSearch ss = new BoyerMooreHorspoolRaita();
	byte[] text = {1};
	byte[] pattern = {1};
	
	int location = ss.searchBytes(text, pattern);
	
	assertEquals(0, location);}


   @Test
   public void testbytepatternlongerthantext1d() {
       
       StringSearch ss = new BoyerMooreHorspoolRaita();
       byte[] text = {1,2};
       byte[] pattern = {1,2};
       
       int location = ss.searchBytes(text, pattern);
       
       assertEquals(0, location);}

   @Test
   public void testbytepatternlongerthantext2d() {
       
       StringSearch ss = new BoyerMooreHorspoolRaita();
       byte[] text = {1};
       byte[] pattern = {0};
       
       int location = ss.searchBytes(text, pattern);
       
       assertEquals(-1, location);}
   @Test
   public void testbytepatternlongerthantext3d() {
       
       StringSearch ss = new BoyerMooreHorspoolRaita();
       byte[] text = {1,2};
       byte[] pattern = {2,1};
       
       int location = ss.searchBytes(text, pattern);
       
       assertEquals(-1, location);}
   @Test
   public void testbytepatternlongerthantext4d() {
       
       StringSearch ss = new BoyerMooreHorspoolRaita();
       byte[] text = {1,2,4};
       byte[] pattern = {1,2,4};
       
       int location = ss.searchBytes(text, pattern);
       
       assertEquals(0, location);}
   @Test
   public void testbytepatternlongerthantext5d() {
       
       StringSearch ss = new BoyerMooreHorspoolRaita();
       byte[] text = {1,2,4};
       byte[] pattern = {1,2,5};
       
       int location = ss.searchBytes(text, pattern);
       
       assertEquals(-1, location);}
   @Test
   public void testbytepatternlongerthantext6d() {
       
       StringSearch ss = new BoyerMooreHorspoolRaita();
       byte[] text = {1,2,4,3,5,7};
       byte[] pattern = {1,2,4,3,5,7};
       
       int location = ss.searchBytes(text, pattern);

       assertEquals(0, location);}
   @Test
   public void testbytepatternlongerthantext10d() {
       
       StringSearch ss = new BoyerMooreHorspoolRaita();
       byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
       byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
       
       int location = ss.searchBytes(text, pattern);
       
       assertEquals(0, location);}
   @Test
   public void testbytepatternlongerthantext11d() {
       
       StringSearch ss = new BoyerMooreHorspoolRaita();
       byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4};
       byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1};
       
       int location = ss.searchBytes(text, pattern);
       
       assertEquals(-1, location);}
   @Test
   public void testbytepatternlongerthantext12d() {
       
       StringSearch ss = new BoyerMooreHorspoolRaita();
       byte[] text = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2};
       byte[] pattern = {1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2,4,1,2};
       
       int location = ss.searchBytes(text, pattern);
       
       assertEquals(-1, location);}
   @Test
	public void testBoyerMooreHorspoolRaitaPatterLenghth00(){
		StringSearch ss = new BoyerMooreHorspoolRaita();
		String str = "h1";
		String pattern = "h2";
		
		int location = ss.searchString(str, pattern);
		
		assertEquals(-1, location);
	}
   
      @Test
   public void testbytepatternlongerthantext01d() {
       
       StringSearch ss = new BoyerMooreHorspoolRaita();
       byte[] text = {1,2};
       byte[] pattern = {1,3};
       
       int location = ss.searchBytes(text, pattern);

       assertEquals(-1, location);}

}
