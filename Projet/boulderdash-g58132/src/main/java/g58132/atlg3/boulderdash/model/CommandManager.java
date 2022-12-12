package g58132.atlg3.boulderdash.model;

import java.util.Stack;

public class CommandManager {
    private Stack<Command> undoStack=new Stack();
    private Stack<Command> redoStack=new Stack();
    public void addAllCommand(Command command){
        command.execute();
        undoStack.push(command);
        redoStack.clear();;
    }

    /**
     * Allows to return to the movement make
     */
    public void undo(){
        if(!undoStack.isEmpty()){
            Command command=undoStack.pop();
            command.unexecute();
            redoStack.push(command);
        }
    }

    /**
     * Allows to return to the movement make cancel
     */
    public void redo(){
        if(!redoStack.isEmpty()){
            Command command=redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

}
