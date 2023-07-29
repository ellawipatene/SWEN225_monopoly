package swen.monopoly;

import java.util.ArrayList;

/**
 * Is a colourGroup.
 *
 * @author dip.
 *
 */
public class ColourGroup {
  private ArrayList<Street> streets = new ArrayList<Street>();
  private String colour;

  /**
   * Create colour group made up of Streets supplied as arguments.
   *
   * @param colour
   *
   * @param streets
   *
   */
  public ColourGroup(String colour, Street... streets) {
    for (Street street : streets) {
      this.streets.add(street);
      street.setColourGroup(this);
    }
    this.colour = colour;
  }

  /**
   * Returns the color.
   *
   * @return String
   *
   */
  public String getColour() {
    return colour;
  }
}
