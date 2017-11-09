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
public class TestsExist
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
    private String expected;

    
    public TestsExist(String numberA, String expected) 
    {
        this.numberA = numberA;
        this.expected = expected;
    }

    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1","1"},
                {"2","2"},
                {"3","3"},
                {"4","4"},
                {"5","5"},
                {"6","6"},
                {"7","7"},
                {"8","8"},
                {"9","9"},
                {"0","0"}
        });
    }

    @Test
	public void testExist() 
	{	
		calc.button(numberA).click();
		assertEquals(expected, calc.textBox("result").text());
	}
}
