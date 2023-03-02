package hangman.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerBonusScoreTest {

	/**
	 * 1- Equivalence Class: negative parameters, border condition(-1)
	 * 2- Equivalence Class: normal parameters (0-27), border condition(1)
	 * 3- Equivalence Class: large parameters (>27), border condition(1000)
	 */

	private GameScore score = new PowerBonusScore();

	@Test
	public void ShouldThrowsExceptionWhenAnyParameterIsNegative() {
		//arrange
		String expectedResult = new ModelException("NEGATIVE_COUNTER").getMessage();
		int correctCount = 0;
		int incorrectCount = -1;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);
		} catch (ModelException e) {
			//assert
			assertEquals(expectedResult, e.getMessage());
		}

	}

	@Test
	public void ShouldReturnZeroWhenBothParametersAreOne() {
		//arrange
		int expectedResult = 0;
		int correctCount = 1;
		int incorrectCount = 1;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
	}

	@Test
	public void ShouldReturnFiveHundredWhenCorrectIs1000AndIncorrectIs0() {
		//arrange
		int expectedResult = 500;
		int correctCount = 1000;
		int incorrectCount = 0;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
	}

	@Test
	public void ShouldReturnZeroWhenCorrectIs0AndIncorrectIs1000() {
		//arrange
		int expectedResult = 0;
		int correctCount = 0;
		int incorrectCount = 1000;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
	}

	@Test
	public void ShouldReturnFiveHundredWhenCorrectIs1000AndIncorrectIs1000() {
		//arrange
		int expectedResult = 500;
		int correctCount = 1000;
		int incorrectCount = 1000;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
	}
}