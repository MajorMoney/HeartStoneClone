package PlayerActions;

import PlayerActions.PlayerDraggableAction;

public class SelectTarget extends PlayerDraggableAction {

  public SelectTarget() {}

  @Override
  public boolean validate() {
    return false;
  }

  @Override
  public void resolve(boolean valid) {}
}
