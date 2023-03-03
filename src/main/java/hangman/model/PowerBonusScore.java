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
	public int calculateScore(int correctCount, int incorrectCount) throws ModelException{
		if(correctCount < 0 || incorrectCount <0){
			throw new ModelException("NEGATIVE_COUNTER");
		}

		int score = 0;
		int goodScore = calculateBonus(correctCount);
		int badScore = incorrectCount*8;
		int finalScore = score + goodScore - badScore;
		finalScore = finalScore < 500 ? finalScore : 500;
		finalScore = finalScore > 0 ? finalScore : 0;
		return finalScore;
		
	}

	private int calculateBonus(int correctCount) {
		int bonus = 0;
		for(int i = 1; i <= correctCount; i++) {
			bonus += 5^i;
		}
		return bonus;
	}

}
