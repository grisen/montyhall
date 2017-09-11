package entities;

public class Game {

    private Round round = null;

    private int stayWins =0;
    private int switchWins =0;

    public void play() {
        round = new Round();

        //Initially, Player picks a box to be opened.
        Box pickedBox = userPicksFirstBox();

        //After that, Host opens a box (that is empty), but not the one Player just selected.
        Box hostBox = hostOpensEmptyBox(pickedBox.getId());

        //Now, Payer chooses the last box, but not the one the Host just opened (it is already open).
        Box finalBox = userOpensFinalBox(hostBox.getId());

        countResult(pickedBox, finalBox);
    }

    protected void countResult(Box pickedBox, Box finalBox) {
        if (pickedBox.equals(finalBox) && finalBox.isWin()) {
            stayWins++;
        } else if (!pickedBox.equals(finalBox) && !finalBox.isWin()) {
            stayWins++;
        } else {
            switchWins++;
        }
    }

    protected Box userOpensFinalBox(int openedByHost) {
        return round.playerOpenBox(openedByHost);
    }

    protected Box hostOpensEmptyBox(int playerPicksThisBox) {
        return round.hostOpenBox(playerPicksThisBox);
    }

    protected Box userPicksFirstBox() {
        return round.pickRandomBox();
    }

    protected void getRound() {
        if( round == null) {
            round = new Round();
        }
    }

    public int getStayWins() {
        return stayWins;
    }

    public void setStayWins(int stayWins) {
        this.stayWins = stayWins;
    }

    public int getSwitchWins() {
        return switchWins;
    }

    public void setSwitchWins(int switchWins) {
        this.switchWins = switchWins;
    }
}
