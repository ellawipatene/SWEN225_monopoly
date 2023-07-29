import static org.junit.Assert.fail;

import org.junit.Test;

import swen.monopoly.Board;
import swen.monopoly.GameOfMonopoly;
import swen.monopoly.Location;
import swen.monopoly.Player;

/**
 * @author wipateella
 *
 */
public class MonopolyTests {
  // this is where you must write your tests; do not alter the package, or the
  // name of this file. An example test is provided for you.

  /**
   * .
   */
  @Test
  public void testValidBuyProperty_1() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      Player player = setupMockGame(game, "Park Lane");
      game.buyProperty(player);
    } catch (GameOfMonopoly.InvalidMove e) {
      fail(e.getMessage());
    }
  }

  /**
   * .
   */
  @Test
  public void testValidBuyProperty_2() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      Player player = setupMockGame(game, "Water Works");
      game.buyProperty(player);
    } catch (GameOfMonopoly.InvalidMove e) {
      fail(e.getMessage());
    }
  }

  /**
   * .
   */
  @Test
  public void testInvalidBuyProperty_1() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      // Cannot buy change!
      Player player = setupMockGame(game, "Chance");
      game.buyProperty(player);
      fail("Cannot buy property \"Chance\"");
    } catch (GameOfMonopoly.InvalidMove e) {
      // OK
    }
  }

  /**
   * .
   */
  @Test
  public void testInvalidBuyProperty_2() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      // Cannot buy same property twice
      Player player = setupMockGame(game, "Park Lane");
      game.buyProperty(player);
      game.buyProperty(player);
    } catch (GameOfMonopoly.InvalidMove e) {
      // OK
    }
  }

  /**
   * .
   */
  @Test
  public void testValidSell_1() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      Player player = setupMockGame(game, "Park Lane");
      game.buyProperty(player);
      game.sellProperty(player, player.getLocation());
    } catch (GameOfMonopoly.InvalidMove e) {
      fail(e.getMessage());
    }
  }

  /**
   * .
   */
  @Test
  public void testInvalidSell_1() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      Player player = setupMockGame(game, "Park Lane");
      game.sellProperty(player, player.getLocation());
      fail("Cannot sell property you don't own!");
    } catch (GameOfMonopoly.InvalidMove e) {
      fail(e.getMessage());
    }
  }

  /**
   * .
   */
  @Test
  public void testValidMortgage_1() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      Player player = setupMockGame(game, "Park Lane");
      game.buyProperty(player);
      game.mortgageProperty(player, player.getLocation());
    } catch (GameOfMonopoly.InvalidMove e) {
      fail(e.getMessage());
    }
  }

  /**
   * .
   */
  @Test
  public void testInvalidMortgage_1() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      Player player = setupMockGame(game, "Park Lane");
      game.mortgageProperty(player, player.getLocation());
      fail("Cannot mortgage property you don't own!");
    } catch (GameOfMonopoly.InvalidMove e) {
      fail(e.getMessage());
    }
  }

  /**
   * .
   */
  @Test
  public void testInvalidMortgage_2() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      Player player = setupMockGame(game, "Park Lane");
      game.buyProperty(player);
      game.sellProperty(player, player.getLocation());
      game.mortgageProperty(player, player.getLocation());
      fail("Cannot mortgage property you don't own!");
    } catch (GameOfMonopoly.InvalidMove e) {
      fail(e.getMessage());
    }
  }

  /**
   * .
   */
  @Test
  public void testValidUnmortgage_1() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      Player player = setupMockGame(game, "Park Lane");
      game.buyProperty(player);
      game.mortgageProperty(player, player.getLocation());
      game.unmortgageProperty(player, player.getLocation());
    } catch (GameOfMonopoly.InvalidMove e) {
      fail(e.getMessage());
    }
  }

  /**
   * .
   */
  @Test
  public void testInvalidUnmortgage_1() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      Player player = setupMockGame(game, "Park Lane");
      game.buyProperty(player);
      game.unmortgageProperty(player, player.getLocation());
      fail("Cannot unmortgage property which is not already mortgated!");
    } catch (GameOfMonopoly.InvalidMove e) {
      fail(e.getMessage());
    }
  }

  /**
   * .
   */
  @Test
  public void testInvalidUnmortgage_2() {
    GameOfMonopoly game = new GameOfMonopoly();
    try {
      Player player = setupMockGame(game, "Park Lane");
      game.unmortgageProperty(player, player.getLocation());
      fail("Cannot unmortgage property which you don't own!");
    } catch (GameOfMonopoly.InvalidMove e) {
      fail(e.getMessage());
    }
  }

  /**
   * Setup a mock game of monopoly with a play located at a given location.
   */
  private Player setupMockGame(GameOfMonopoly game, String locationName)
      throws GameOfMonopoly.InvalidMove {
    Board board = game.getBoard();
    Location location = board.findLocation(locationName);
    Player player = new Player("Dave", "Dog", 1500, location);
    return player;
  }

}
