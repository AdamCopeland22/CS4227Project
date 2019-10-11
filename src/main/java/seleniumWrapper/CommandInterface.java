package seleniumWrapper;

public interface CommandInterface {
	void execute();
}

public class Handler {
    private final HashMap<String, Command> commandMap = new HashMap<String, Command>();
    
    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }
    
    public void execute(String commandName) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("No command registered for the command: " + commandName);
        }
        command.execute();
    }
}
