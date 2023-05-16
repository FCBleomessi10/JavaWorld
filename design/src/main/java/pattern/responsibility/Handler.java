package pattern.responsibility;

public abstract class Handler {
    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;

    private int numStart;
    private int numEnd;
    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void handlerLeave(LeaveRequest leaveRequest);

    public final void submit(LeaveRequest leaveRequest) {
        this.handlerLeave(leaveRequest);
        if (this.nextHandler != null && leaveRequest.getNum() > this.numEnd) {
            this.nextHandler.submit(leaveRequest);
        } else {
            System.out.println("流程结束");
        }
    }
}
