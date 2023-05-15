package pattern.command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command command) {
        commands.add(command);
    }

    public void orderUp() {
        System.out.println("订单来了");
        for (Command command : commands) {
            if (command != null) {
                command.execute();
            }
        }
    }
}
