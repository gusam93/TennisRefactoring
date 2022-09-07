
public class TieScore extends Score {
	
	private final int duecePoint = 3;
    private final String TieLiteralScoreType[]= {"Love-All", "Fifteen-All", "Thirty-All"};
    
	public TieScore(Player player1, Player player2) {
		super(player1, player2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getLiteralScore() {
		int score = player1.getScore();
		
		if(score >= duecePoint) {
			return "Deuce";
		}
		
		return TieLiteralScoreType[score];
	}

}
