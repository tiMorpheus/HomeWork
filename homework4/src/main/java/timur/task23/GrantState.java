package timur.task23;

public abstract class GrantState {
    protected Grant grant;

    public GrantState(Grant grant) {
        this.grant = grant;
    }

    public abstract void confirm();

    public abstract void deferred();

    public abstract void reject();

    public abstract void consider();
}
