package hangman.model;

public class PowerBonusScore implements GameScore{

		/**
		 * This method calculates the final score according with the rules of PowerBonusScore
		 * The correct i letter add 5^i points, wrong letters remain 8 points
		 * @param correctCount total of right letters
		 * @param incorrectCount total of wrong letters
		 * @pre initialScore = 0
		 * @pos finalScore >= 0
		 * @pos finalScore <= 500
		 * @return total of points after discount wrong letters
		 */
	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
