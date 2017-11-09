package Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import CalcLogic.CalcAPI;

@RunWith(Parameterized.class)
public class TestsApi
{	
 	private int numberA;
    private int numberB;
    private String expected;
    private String op;

    
    public TestsApi(int numberA, int numberB, String op, String expected) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expected = expected;
        this.op = op;
    }

	// name attribute is optional, provide an unique name for test
	// multiple parameters, uses Collection<Object[]>
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 3, "+", "5"},
                {4, 5, "-", "-1"},
                {6, 7, "*", "42"},
                {8, 4, "/", "2"}
        });
    }

    @Test
	public void testCalc() throws ClientProtocolException, IOException 
	{	
		assertEquals(expected, CalcAPI.Calc(numberA, numberB, op));
	}          
}
