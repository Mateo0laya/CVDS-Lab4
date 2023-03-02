package hangman.model;

public class OriginalScore implements GameScore{

	/**
	 * This method calculates the final score according with the rules of OrginalScore
	 * The correct letters don´t add points, wrong letters remain 5 points
	 * @param correctCount total of right letters
	 * @param incorrectCount total of wrong letters
	 * @pre initialScore = 100
	 * @pos finalScore >= 0
	 * @return int finalScore total of points after discount wrong letters
	 */
	
	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
