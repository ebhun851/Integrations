package component;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty"},features={"classpath:component/features/sample.feature"})
public class RunAllComponentCukesTest {
}
