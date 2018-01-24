package toyrobot.model;

import org.junit.Test;
import toyrobot.domain.InputValidator;

import static org.junit.Assert.*;

public class InputValidatorTest {
  private String input;

  @Test
  public void givenAValidPlaceCommandFacingNorth_place_shouldReturnTrue() {
    input = "place 0 0 north";
    assertTrue(InputValidator.place().test(input));
  }

  @Test
  public void givenAValidPlaceCommandFacingEast_place_shouldReturnTrue() {
    input = "place 0 0 east";
    assertTrue(InputValidator.place().test(input));
  }

  @Test
  public void givenAValidPlaceCommandFacingSouth_place_shouldReturnTrue() {
    input = "place 0 0 south";
    assertTrue(InputValidator.place().test(input));
  }

  @Test
  public void givenAValidPlaceCommandFacingWest_place_shouldReturnTrue() {
    input = "place 0 0 west";
    assertTrue(InputValidator.place().test(input));
  }

  @Test
  public void givenAnIncompletePlaceCommand_place_shouldReturnFalse() {
    input = "place 0 0";
    assertFalse(InputValidator.place().test(input));
  }

  @Test
  public void givenACommandThatIsNotPlace_place_shouldReturnFalse() {
    input = "move";
    assertFalse(InputValidator.place().test(input));
  }

  @Test
  public void givenAXpositionThatIsNotANumber_place_shouldReturnFalse() {
    input = "place hello";
    assertFalse(InputValidator.place().test(input));
  }

  @Test
  public void givenAYpositionThatIsNotANumber_place_shouldReturnFalse() {
    input = "place 1 hello";
    assertFalse(InputValidator.place().test(input));
  }

  @Test
  public void givenAnInvalidDirection_place_shouldReturnFalse() {
    input = "place 1 1 nowhere";
    assertFalse(InputValidator.place().test(input));
  }
}