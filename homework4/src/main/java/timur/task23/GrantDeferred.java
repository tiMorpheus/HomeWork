package timur.task23;

// отложенный
public class GrantDeferred extends GrantState{


    public GrantDeferred(Grant grant) {
        super(grant);
    }

    @Override
    public void confirm() {
        grant.setState(new GrantConfirmed(grant));
    }

    @Override
    public void deferred() {
        System.out.println("Can't deferred. Not appropriate state");
    }

    @Override
    public void reject() {
        grant.setState(new GrantRejected(grant));
    }

    @Override
    public void consider() {
        System.out.println("Can't consider. Not appropriate state");
    }

    @Override
    public String toString() {
        return "GrantDeferred";
    }
}
