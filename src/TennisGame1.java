import static org.junit.Assume.assumeNoException;

public class TennisGame1 implements TennisGame {
	
	private final int Max_Normal_Score = 3;
    private boolean isEnd = false;
	private int scoreDiff;
	
    private Player player1;
    private Player player2;
    
    private Score normalCoreState;
    private Score tieScoreState;
    private Score advantageScoreState;
    private Score winScoreState;    
    private Score curScoreState;
    
    public TennisGame1(String player1Name, String player2Name) {
    	this.player1= new Player(player1Name);
    	this.player2= new Player(player2Name);
    	
    	this.normalCoreState = new NormalScore(player1, player2);
    	this.tieScoreState = new TieScore(player1, player2);
    	this.advantageScoreState=  new AdvantageScore(player1, player2);
    	this.winScoreState = new WinScore(player1, player2);
    	
    	this.curScoreState = tieScoreState;
    	this.scoreDiff = 0;
    }

   
    public void wonPoint(String playerName) {
    	Player wonPlayer = getPlayer(playerName);
    	wonPlayer.wonPoint();
    	updateScoreDiff();
    	changeScoreState();
    }
    
    public String getLiteralScore() {
        return curScoreState.getLiteralScore();
    }
    
    public void setEnd() {
    	isEnd = true;
    }
    public boolean isEnd() {
		return isEnd;
	}
    private void updateScoreDiff() {
    	scoreDiff = player1.getScore() - player2.getScore();
    }
    
    private Player getPlayer(String name){
    	if(player1.getName() == name) {
    		return player1;
    	}
    	
    	else if (player2.getName() ==name) {
    		return player2;
    	}
    	
    	throw new UnsupportedOperationException("Invalid player!");
    	
    }
    
    private boolean isTieScore() {
    	return (scoreDiff == 0);
    }
    
    private boolean isNormalScore() {
    	if(scoreDiff == 0) return false;
    	return player1.getScore()<= Max_Normal_Score && player2.getScore() <= Max_Normal_Score;
    }
    
    private boolean isAdvantageScore() {
    	if(player1.getScore() <= Max_Normal_Score && player2.getScore() < 4) return false;	
    	return Math.abs(scoreDiff) == 1;
    }
    
    
    public void setScoreState(Score scoreState) {
    	this.curScoreState = scoreState;
    }
    
    public void changeScoreState() {
    	if(isTieScore()) {
    		setScoreState(tieScoreState);
    	}
    	else if (isNormalScore()) {
    		setScoreState(normalCoreState);
    	}
    	
    	else if (isAdvantageScore()) {
    		setScoreState(advantageScoreState);
    	}
    	
    	else {
    		setScoreState(winScoreState);
    		setEnd();
    	}
    }
      
}
