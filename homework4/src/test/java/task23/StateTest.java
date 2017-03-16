package task23;

import org.junit.Before;
import org.junit.Test;
import timur.task23.Grant;
import timur.task23.GrantConfirmed;
import timur.task23.GrantRejected;

public class StateTest {


    Grant grant;

    @Before
    public void setUp() {

        grant = new Grant();
    }

    @Test
    public void changeState() {
        grant.setState(new GrantConfirmed(grant));
        grant.confirm();
        grant.consider();
        grant.setState(new GrantRejected(grant));
        grant.confirm();
    }

}
