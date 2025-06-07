package com.github;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

//Pending comments

//Some comments on the master branch
//Added some comments on the branch for the egit demo

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Test that the hello world message is correct
     */
    public void testHelloWorldMessage()
    {
        String expectedMessage = "Hello World!";
        String actualMessage = App.getHelloWorldMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    
    /**
     * Test that main method prints hello world correctly
     */
    public void testMainMethodOutput()
    {
        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            // Call main method
            App.main(new String[]{});
            
            // Verify output
            String expectedOutput = "Hello World!" + System.lineSeparator();
            assertEquals(expectedOutput, outContent.toString());
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}