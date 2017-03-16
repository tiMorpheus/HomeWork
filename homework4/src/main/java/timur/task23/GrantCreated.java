package timur.task23;

public class GrantCreated extends GrantState {

    public GrantCreated(Grant grant) {
        super(grant);
    }
    
    @Override
    public void confirm() {
        System.out.println("Can't confirm. Not appropriate state");
    }

    @Override
    public void deferred() {
        System.out.println("Can't deferred. Not appropriate state");
    }

    @Override
    public void reject() {
        System.out.println("Can't reject. Not appropriate state");
    }

    @Override
    public void consider() {
        grant.setState(new GrantIsConsidered(grant));
    }

    @Override
    public String toString() {
        return "GrantCreated";
    }
}
