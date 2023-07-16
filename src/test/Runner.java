import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.car.*;
import tests.login.*;
import tests.product.*;
import tests.users.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreateUserTest.class,
})
public class Runner {

}
