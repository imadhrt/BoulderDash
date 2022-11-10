package g58132.atlg3.ascii.Model;

 class DeleteCommand implements Command{
    private  Shape shape;
    private Drawing drawing;
   private  int pos;

     public DeleteCommand(Drawing drawing, int pos) {
         this.shape = drawing.getShapeAtIndex(pos);
         this.drawing = drawing;
         this.pos = pos;
     }



     @Override
  public void execute() {
        drawing.delete(pos);

   }

    @Override
    public void unexecute() {
         drawing.addShape(shape, pos);




    }
}
