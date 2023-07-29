package swen.monopoly;

/**
 * Station class.
 *
 * @author wipateella
 *
 */
public class Station extends Property {
  /**
   * Constructor.
   *
   * @param name
   *
   * @param price
   *
   */
  public Station(String name, int price) {
    super(name, price);
  }

  /**
   * Calcuate rent for this station. Should only be called if hasOwner() == true.
   */
  public int getRent() {
    // first, determine how many stations owned by player
    int nstations = 0;
    for (Property p : getOwner()) {
      if (p instanceof Station) {
        nstations = nstations + 1;
      }
    }
    // now compute rent, taking number owned into account
    return 50 * nstations;
  }

  /**
   * Override default equals() method.
   */
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null)
      return false;
    if (o instanceof Station) {
      Station sa = (Station) o;
      return this.getName().equals(sa.getName()) && this.getPrice() == sa.getPrice();
    }
    return false;
  }

  public int hashCode() {
    assert false : "hashCode not designed";
    return 42; // any arbitrary constant will do
  }
}
