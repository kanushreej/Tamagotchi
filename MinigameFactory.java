package softwaredesign;

public class MinigameFactory {
    public Minigame getMinigame(String gamechoice){
        if(gamechoice == null){
            return null;
        }
        else if(gamechoice.equals("1")){
            return new RockPaperScissors();
        }
        return null;
    }
}
