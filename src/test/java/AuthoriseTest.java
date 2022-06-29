import Pages.AuthoresationPage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class AuthoriseTest {

    AuthoresationPage authoresationPage = open(AuthoresationPage.URL, AuthoresationPage.class);

    @Test
    @DisplayName("success authorization")
    public void SuccessAuthoriseUser(){

            authoresationPage
                    .setLogin()
                    .tapEnterButton()
                    .setPassword()
                    .tapEnterButton();

            assertTrue("not transaction to the authorization page!", authoresationPage.personalAccount());
    }
}
