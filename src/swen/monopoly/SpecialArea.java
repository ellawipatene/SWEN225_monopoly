package swen.monopoly;

/**
 * Special Area class.
 *
 * @author wipateella
 *
 */
public class SpecialArea extends Location {
  /**
   * Special area.
   *
   * @param n
   *
   */
  public SpecialArea(String n) {
    super(n);
  }

  public boolean hasOwner() {
    return false;
  }

  /**
   * Should not be called on Special Area.
   *
   * @return player
   */
  public Player getOwner() {
    throw new RuntimeException("Should not call getOwner() on a SpeciaArea!");
  }

  /**
   * Should not be called on Special Area.
   *
   * @return int
   *
   */
  public int getRent() {
    throw new RuntimeException("Should not call getRent() on a SpeciaArea!");
  }

  /**
   * Override default equals() method.
   */
  public boolean equals(Object o) {
    if (o instanceof SpecialArea) {
      return super.equals(o);
    }
    return false;
  }

  public int hashCode() {
    assert false : "hashCode not designed";
    return 42; // any arbitrary constant will do
  }

}
