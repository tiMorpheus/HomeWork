package timur.task23;

public class Grant {

    private GrantState state;

    public Grant() {
        state = new GrantCreated(this);
    }

    public GrantState getState() {
        return state;
    }

    public void setState(GrantState state) {
        this.state = state;
    }

    public void confirm() {
        state.confirm();
    }

    public void deferred() {
        state.deferred();
    }

    public void consider() {
        state.consider();
    }

    public void reject() {
        state.reject();
    }
}
