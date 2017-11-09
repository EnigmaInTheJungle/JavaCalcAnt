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
public class TestsComplex
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

    
    public TestsComplex(String numberA, String numberB, String expected) 
    {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expected = expected;
    }

    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1","2","12"},
                {"2","3","23"},
                {"3","4","34"},
                {"4","5","45"},
                {"5","6","56"},
                {"6","7","67"},
                {"7","8","78"},
                {"8","9","89"},
                {"9","0","90"}
        });
    }

    @Test
	public void testComplex() 
	{	
		calc.button(numberA).click();
		calc.button(numberB).click();
		assertEquals(expected, calc.textBox("result").text());
	}
}
