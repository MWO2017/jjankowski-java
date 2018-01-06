package TO;

import org.junit.Assert;
import org.junit.Test;

public class AutomateTests {

    @Test
    public void shouldDoNotSellMoreCansThatIsInTheAutomate() {
        //Given
        Automate automate = new Automate(10);
        automate.insertCoinAmount(12);

        //When
        automate.discardCanAmount(23);

        //Then
        Assert.assertEquals(10, automate.getSoldAmount());
    }

    @Test
    public void shouldSellAmountOfCansEqualToMoneyAmount() {
        //Given
        Automate automate = new Automate(20);
        automate.insertCoinAmount(5);

        //When
        automate.discardCanAmount(23);

        //Then
        Assert.assertEquals(5, automate.getSoldAmount());
    }
}
