package io.testomat;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CreateTestSuiteRawTest {

    Faker faker = new Faker();

    @Test
    @DisplayName("Should Be Possible To Create Test Suite For New Project")
    void shouldBePossibleToCreateTestSuiteForNewProject() {
        open("https://app.testomat.io/users/sign_in");
        loginUser("mmax68955@gmail.com", "d#6m@$MnPzEyg7Z");

        $("#content-desktop h2").shouldBe(Condition.visible);
        $("[href='/projects/new']").click();

        $("#project-form #project_title").setValue(faker.commerce().department());
        $("[name='commit']").click();

        $("[placeholder='First Suite']").shouldBe(Condition.visible);
        $(".back").click();
        String targetTestSuite = faker.commerce().productName();
        $("[placeholder='First Suite']")
                .setValue(targetTestSuite)
                .pressEnter();

        $$(".dragSortItem").shouldHave(CollectionCondition.size(1));
        $(".dragSortList").shouldHave(Condition.text(targetTestSuite));
    }

    private static void loginUser(String mail, String password) {
        $("#content-desktop #user_email").setValue(mail);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop [name='commit']").click();
    }
}
