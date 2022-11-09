package g58132.atlg3.ascii.Model;

 class DeleteCommand implements Command{
    private  Shape shape;
    private Drawing drawing;

    public DeleteCommand(Shape shape, Drawing drawing) {
        this.shape = shape;
        this.drawing = drawing;
    }
    @Override
  public void execute() {

   }

    @Override
    public void unexecute() {

    }
}
