package pattern.responsibility;

public class Client {
    public static void main(String[] args) {
        LeaveRequest leaveRequest = new LeaveRequest("leo", 7, "play");

        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        groupLeader.submit(leaveRequest);
    }
}
