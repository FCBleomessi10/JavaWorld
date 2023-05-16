package pattern.responsibility;

public class Manager extends Handler {

    public Manager() {
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handlerLeave(LeaveRequest leaveRequest) {
        System.out.println(leaveRequest.getName() + "请假" + leaveRequest.getNum() + "天，" +
                leaveRequest.getContent() + "。");
        System.out.println("部门经理审批同意");
    }
}
