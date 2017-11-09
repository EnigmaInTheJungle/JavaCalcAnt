package Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestsExist.class, TestsRJ.class, TestsComplex.class, TestsSimple.class })
public class AllTests {

}
