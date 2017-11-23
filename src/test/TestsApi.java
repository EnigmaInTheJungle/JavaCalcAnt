package test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import CalcLogic.CalcAPI;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;

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
                {4, 5, "-", "-1"},
                {6, 7, "*", "42"},
                {8, 4, "/", "2"},
                {2, 3, "+", "5"}
        });
    }

    @Test
    @Asynchronous
	public void testCalc() throws IOException, ExecutionException, InterruptedException {
        String result = CalcAPI.Calc(numberA, numberB, op);
        String assertionResult = new AsyncResult<String>(result).get();
		assertEquals(expected, assertionResult);
	}          
}
