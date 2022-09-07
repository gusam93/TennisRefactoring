
public class AdvantageScore extends Score {

	public AdvantageScore(Player player1, Player player2) {
		super(player1, player2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getLiteralScore() {
		int score1 = player1.getScore();
		int score2 = player2.getScore();
		
		if(score1 > score2) {
			return "Advantage player1";
		}
		return "Advantage player2";
	}

}
