package hangman.model;

public class BonusScore implements GameScore{

	/**
	 * This method calculates the final score according with the rules of BonusScore
	 * The correct letters add 10 points, wrong letters remain 5 points
	 * @param correctCount total of right letters
	 * @param incorrectCount total of wrong letters
	 * @pre initialScore = 0
	 * @pos finalScore >= 0
	 * @return total of points after discount wrong letters
	 */
	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
