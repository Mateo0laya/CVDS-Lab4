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
	public int calculateScore(int correctCount, int incorrectCount) throws ModelException{

		if(correctCount < 0 || incorrectCount <0){
			throw new ModelException("NEGATIVE_COUNTER");
		}

		int score = 0;
		int goodScore = correctCount*10;
		int badScore = incorrectCount*5;
		int finalScore = score + goodScore - badScore;
		finalScore = finalScore > 0 ? finalScore : 0;
		return finalScore;
		
	}

}
