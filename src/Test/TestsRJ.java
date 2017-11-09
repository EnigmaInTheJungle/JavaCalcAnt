package Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import CalcUI.CFrame;

@RunWith(Parameterized.class)
public class TestsRJ 
{
	private FrameFixture calc;
	
	@Before
	public void setUp() 
	{

		calc = new FrameFixture(new CFrame());
	}
	
	@After
	public void tearDown() 
	{
 
		calc.cleanUp();
	}
	
 	private String numberA;
    private String numberB;
    private String expected;
    private String op;

    
    public TestsRJ(String numberA, String numberB, String op, String expected) {
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
                {"2", "3", "+", "5"},
                {"4", "5", "-", "-1"},
                {"6", "7", "*", "42"},
                {"8", "4", "/", "2"}
        });
    }

    @Test
	public void testCalc() 
	{	
		calc.button(numberA).click();
		calc.button(op).click();
		calc.button(numberB).click();
		calc.button("=").click();
		assertEquals(expected, calc.textBox("result").text());
	}          
}
