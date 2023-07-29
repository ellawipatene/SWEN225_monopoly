package swen.monopoly;

/**
 * Represents any location on the monopoly board. This includes streets,
 * utilities, special areas and stations.
 */
public abstract class Location {
  private String name;

  /**
   * Creates a location.
   *
   * @param name
   *
   */
  public Location(String name) {
    this.name = name;
  }

  /**
   * Returns a name.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Check whether this location has an owner or not. Note that not all locations
   * can actually have owners.
   *
   * @return boolean
   *
   */
  public abstract boolean hasOwner();

  /**
   * equals method.
   */
  public boolean equals(Object o) {
    if (o instanceof Location) {
      Location l = (Location) o;
      return name.equals(l.name);
    }
    return false;
  }
}
