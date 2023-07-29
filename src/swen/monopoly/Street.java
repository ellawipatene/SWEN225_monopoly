package swen.monopoly;

/**
 * Street.
 *
 * @author wipateella
 *
 */
public class Street extends Property {
  private int numHouses;
  private int numHotels;
  private int rent; // in $
  private ColourGroup colourGroup;

  /**
   * Constructor.
   *
   * @param name
   *
   * @param price
   *
   * @param rent
   *
   */
  public Street(String name, int price, int rent) {
    super(name, price);
    this.rent = rent;
    colourGroup = null;
  }

  /**
   * set group.
   *
   * @param group
   *
   */
  public void setColourGroup(ColourGroup group) {
    colourGroup = group;
  }

  /**
   * Get colour group to which this street belongs. Will return null if
   * setColourGroup not already called.
   *
   * @return ColourGroup .
   *
   */
  public ColourGroup getColourGroup() {
    return colourGroup;
  }

  public int getRent() {
    return rent;
  }

  /**
   * get houses.
   *
   * @return int
   */
  public int getHouses() {
    return numHouses;
  }

  /**
   * get hotels
   *
   * @return int
   */
  public int getHotels() {
    return numHotels;
  }

  /**
   * Override default equals() method.
   */
  public boolean equals(Object o) {
    if (o instanceof Street) {
      return super.equals(o);
    }
    return false;
  }

  public int hashCode() {
    assert false : "hashCode not designed";
    return 42; // any arbitrary constant will do
  }
}
