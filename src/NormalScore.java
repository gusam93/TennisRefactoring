

public class NormalScore extends Score {
	private final int maxNormalSCore = 3;
    private final String NormalLiteralScoreType[]= {"LOVE", "Fifteen", "Thirty", "Forty"};
    
	public NormalScore(Player player1, Player player2) {
		super(player1,player2);
	}

	@Override
	public String getLiteralScore(){
		int score1 = player1.getScore();
		int score2 = player2.getScore();		
		return 	NormalLiteralScoreType[score1] + "-" + NormalLiteralScoreType[score2];
	}

}
