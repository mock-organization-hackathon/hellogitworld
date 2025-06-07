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
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

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
     * Set up test environment - capture System.out
     */
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Clean up test environment - restore System.out
     */
    public void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Test that App.main() prints "Hello World!" correctly
     */
    public void testAppPrintsHelloWorld()
    {
        // Act: Run the main method
        App.main(new String[]{});
        
        // Assert: Verify the output
        String output = outContent.toString().trim();
        assertEquals("Hello World!", output);
    }

    /**
     * Test that App.main() prints exactly one line
     */
    public void testAppPrintsOneLine()
    {
        // Act: Run the main method
        App.main(new String[]{});
        
        // Assert: Verify only one line is printed
        String output = outContent.toString();
        String[] lines = output.split("\\n");
        assertEquals(1, lines.length);
    }

    /**
     * Test that App.main() output contains expected greeting
     */
    public void testAppOutputContainsHello()
    {
        // Act: Run the main method
        App.main(new String[]{});
        
        // Assert: Verify output contains "Hello"
        String output = outContent.toString();
        assertTrue("Output should contain 'Hello'", output.contains("Hello"));
        assertTrue("Output should contain 'World'", output.contains("World"));
    }

    /**
     * Test that App.main() handles null arguments gracefully
     */
    public void testAppWithNullArgs()
    {
        // Act: Run the main method with null args
        App.main(null);
        
        // Assert: Should still print Hello World
        String output = outContent.toString().trim();
        assertEquals("Hello World!", output);
    }

    /**
     * Test that App.main() ignores command line arguments
     */
    public void testAppIgnoresArguments()
    {
        // Act: Run with various arguments
        App.main(new String[]{"arg1", "arg2", "test"});
        
        // Assert: Should still print Hello World regardless of args
        String output = outContent.toString().trim();
        assertEquals("Hello World!", output);
    }

    /**
     * Rigourous Test :-) - keeping original test for compatibility
     */
    public void testApp()
    {
        assertTrue( true );
    }
}