package timur.task23;

// рассмаривается
public class GrantIsConsidered extends GrantState {
    public GrantIsConsidered(Grant grant) {
        super(grant);
    }

    @Override
    public void confirm() {
        grant.setState(new GrantConfirmed(grant));
    }

    @Override
    public void deferred() {
        grant.setState(new GrantDeferred(grant));
    }

    @Override
    public void reject() {
        grant.setState(new GrantRejected(grant));
    }

    @Override
    public void consider() {
        System.out.println("Can't confirm. Not appropriate state");
    }

    @Override
    public String toString() {
        return "GrantIsConsidered";
    }
}
