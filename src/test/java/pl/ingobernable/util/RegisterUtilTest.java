package pl.ingobernable.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RegisterUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"asdfghj", "DHFVRTF", "3058204", "&$^#%!*", "ghGH87^"})
    public void test_isPasswordValid_false_hasLessThan8Characters(String strings){

        //when
        boolean result = RegisterUtil.isPasswordValid(strings);

        //then
        Assertions.assertThat(result).isEqualTo(false);

    }

    @ParameterizedTest
    @ValueSource(strings = {"sdfgdfdser",  "FSFDDSMFK", "1913146811684", "!@#$!@$%^@#%"})
    public void test_isPasswordValid_false_hasNotContainRequiredCharacters(String strings){

        //when
        boolean result = RegisterUtil.isPasswordValid(strings);

        //then
        Assertions.assertThat(result).isEqualTo(false);

    }

    @ParameterizedTest
    @ValueSource(strings = {"fffdgGDFFDS6787%^%", "67687VYUfgkh$%", "asdasfSDFDS2334&*"})
    public void test_isPasswordValid_true_passwordIsCorrect(String strings){

        //when
        boolean result = RegisterUtil.isPasswordValid(strings);

        //then
        Assertions.assertThat(result).isEqualTo(true);

    }

    @ParameterizedTest
    @ValueSource(strings = {"sdfgdfdserFSFDDSMFKFSFDDSMFK1913146811684fffdgGDFFDS6787fffdgGDFFDS6787", "$!@#$!@$!sdfgFSFD67687VYUfgkh$DSMFKdfdser@#$!@$%^@#%%^@!@#$!@$%^@#%#%"})
    public void test_isPasswordValid_false_hasMoreThan30Characters(String strings){

        //when
        boolean result = RegisterUtil.isPasswordValid(strings);

        //then
        Assertions.assertThat(result).isEqualTo(false);

    }
}