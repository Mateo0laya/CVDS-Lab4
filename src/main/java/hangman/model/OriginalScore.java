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
	public int calculateScore(int correctCount, int incorrectCount) throws ModelException{

		if(correctCount < 0 || incorrectCount <0){
			throw new ModelException("NEGATIVE_COUNTER");
		}

		int score = 100;
		int badScore = incorrectCount*10;
		int finalScore = score - badScore;
		finalScore = finalScore > 0 ? finalScore : 0;
		return finalScore;

	}

}
