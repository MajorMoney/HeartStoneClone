package PlayerActions;

public abstract class PlayerDraggableAction {

  public abstract boolean validate();

  public abstract void resolve(boolean valid);
}
