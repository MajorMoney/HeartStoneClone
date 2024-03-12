package Player;


import java.util.Arrays;

public class Mana {

  private int totalMana, overload, overloadNext, extraMana;
  private ManaCrystal[] manaCrystals;

  public Mana() {
    manaCrystals = new ManaCrystal[10];
    overloadNext = 0;
  }

  private void manaReset() {
    overload = overloadNext;
    overloadNext = 0;
    extraMana = 0;
    totalMana = Math.max(currentMana() + extraMana - overload, 0);
  }

  private int currentManaCrystals() {
    return (int) Arrays.stream(manaCrystals).filter(crystal -> crystal != null).count();
  }

  private int currentMana() {
    return (int)
        Arrays.stream(manaCrystals)
            .filter(crystal -> crystal != null)
            .filter(crystal -> !crystal.isEmpty())
            .count();
  }

  public void setOverloadNext(int value) {
    this.overloadNext = value;
  }

  public void setExtraMana(int extraMana) {
    this.extraMana = extraMana;
  }

  public boolean spendMana(int value) {
    if (value < totalMana) {
      return false;
    }
    totalMana -= value;
    return true;
  }

  public void newTurn() {
    int current = currentManaCrystals();
    if (current < 10) manaCrystals[current] = new ManaCrystal();
    manaReset();
  }

  private class ManaCrystal {
    private boolean _isEmpty;

    public ManaCrystal() {
      _isEmpty = false;
    }

    public boolean isEmpty() {
      return _isEmpty;
    }
  }
}
