package guru.qa.properties;

import static java.lang.String.format;

import guru.qa.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("owner")
public class OwnerTests {
    public CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();

        System.out.println(login);
        System.out.println(password);

        String message = format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", login, password);
        System.out.println(message);
    }
}
