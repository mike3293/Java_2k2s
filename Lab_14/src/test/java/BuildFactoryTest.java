import by.gorodilov.builder.Builder;
import by.gorodilov.builder.BuilderFactory;
import by.gorodilov.builder.UserBuilder;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(DataProviderRunner.class)
public class BuildFactoryTest {
    private static final String USER = "user";

    private static final Class USER_BUILDER = UserBuilder.class;

    @Test
    @UseDataProvider("dataForBuilderCreator")

    public void shouldCreateAndReturnAppropriateBuilder(Class Builer, String BuilderName) {
        Builder builder = BuilderFactory.create(BuilderName);

        Class<? extends Builder> builderClass = builder.getClass();
        assertEquals(Builer, builderClass);
    }

    @DataProvider
    public static Object[][] dataForBuilderCreator() {
        return new Object[][]{
                {USER_BUILDER, USER},
        };
    }
}
