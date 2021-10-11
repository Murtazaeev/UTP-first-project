import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ContainerTest {

    private static final Person P1 = new Person(18);
    private static final Person P2 = new Person(22);
    private static final Person P3 = new Person(30);

    private IContainer<Account, Double> container;

    @Before
    public void before() {
        List<Account> accounts = new ArrayList<>(3);
        accounts.add(new Account(P1, 23.0));
        accounts.add(new Account(P2, 27.0));
        accounts.add(new Account(P3, 40.0));
        container = new Container<>(accounts);
        Assert.assertEquals(3, container.elements().size());
    }

    @Test
    public void aggregateAllElements() {
        Assert.assertEquals(90.0, container.aggregateAllElements(), 0.01);
    }

    @Test
    public void cloneElementAtIndex() {
        Account original = container.get(1);
        Account account = container.cloneElementAtIndex(1);
        Assert.assertSame(account.getOwner(), original.getOwner());
        Assert.assertNotSame(original, account);
        Assert.assertEquals(27.0, account.getSum(), 0.01);
    }
}
