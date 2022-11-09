package g58132.atlg3.ascii.Model;

import java.util.Stack;

public class ManagerCommand {
    private Stack<Command> undoStack=new Stack();
    private Stack<Command> redoStack=new Stack();




    public void addAllCommand(Command command){
        command.execute();
        undoStack.push(command);
        redoStack.clear();;
    }

    public void undo(){
        if(!undoStack.isEmpty()){
            Command command=undoStack.pop();
            command.unexecute();
            redoStack.push(command);
        }
    }
    public void redo(){
        if(!redoStack.isEmpty()){
            Command command=redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

}

