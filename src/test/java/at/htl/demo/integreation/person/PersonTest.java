package at.htl.demo.integreation.person;

import at.htl.demo.DatabaseGenericResource;
import com.intuit.karate.junit5.Karate;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(DatabaseGenericResource.class)
public class PersonTest {

    @Karate.Test
    Karate testPersonCreation() {
        return Karate.run("person-creation").relativeTo(getClass());
    }
}
