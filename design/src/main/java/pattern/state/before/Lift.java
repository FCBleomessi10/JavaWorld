package pattern.state.before;

public class Lift implements ILift {

    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (state) {
            case OPENING_STATE:
            case RUNNING_STATE:
                break;
            case CLOSING_STATE:
            case STOPPING_STATE:
                System.out.println("open");
                setState(OPENING_STATE);
                break;
        }
    }

    @Override
    public void close() {
        switch (state) {
            case OPENING_STATE:
                System.out.println("close");
                setState(CLOSING_STATE);
                break;
            case CLOSING_STATE:
            case RUNNING_STATE:
            case STOPPING_STATE:
                break;
        }
    }

    @Override
    public void run() {
        switch (state) {
            case RUNNING_STATE:
            case OPENING_STATE:
                break;
            case CLOSING_STATE:
            case STOPPING_STATE:
                System.out.println("run");
                setState(RUNNING_STATE);
                break;
        }
    }

    @Override
    public void stop() {
        switch (state) {
            case OPENING_STATE:
            case STOPPING_STATE:
                break;
            case CLOSING_STATE:
            case RUNNING_STATE:
                System.out.println("stop");
                setState(STOPPING_STATE);
                break;
        }
    }
}
