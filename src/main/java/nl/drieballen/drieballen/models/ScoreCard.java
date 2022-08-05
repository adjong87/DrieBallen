package nl.drieballen.drieballen.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class ScoreCard {

    public ScoreCard(String playerOneName, String playerTwoName, int aimScoreP1, int aimScoreP2) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.aimScoreP1 = aimScoreP1;
        this.aimScoreP2 = aimScoreP2;
    }

    public ScoreCard() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "scorecard_id")
    private Long id;

    private String playerOneName;

    private String playerTwoName;

    public int highestSerieP1;

    public int highestSerieP2;

    private int aimScoreP1;

    private int aimScoreP2;

    private int remainderP1;

    private int remainderP2;

    private double averageP1;

    private double averageP2;

    private int nrOfTurns;

    private LocalDate gespeeldOp = LocalDate.now();

    @JsonIgnore
    @OneToMany(mappedBy = "scoreCard", cascade = CascadeType.ALL)
    private Collection<PlayedGame> playedGames;

    private boolean filledIn;

    // ----- GETTERS ------------

    public Long getId() {
        return id;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public int getHighestSerieP1() {
        return highestSerieP1;
    }

    public int getHighestSerieP2() {
        return highestSerieP2;
    }

    public int getAimScoreP1() {
        return aimScoreP1;
    }

    public int getAimScoreP2() {
        return aimScoreP2;
    }

    public int getRemainderP1() {
        return remainderP1;
    }

    public int getRemainderP2() {
        return remainderP2;
    }

    public double getAverageP1() {
        return averageP1;
    }

    public double getAverageP2() {
        return averageP2;
    }

    public int getNrOfTurns() {
        return nrOfTurns;
    }

    public LocalDate getGespeeldOp() {
        return gespeeldOp;
    }

    public Collection<PlayedGame> getPlayedGames() {
        return playedGames;
    }

    public boolean isFilledIn() {
        return filledIn;
    }

    // ----- SETTERS ------------


    public void setId(Long id) {
        this.id = id;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public void setHighestSerieP1(int highestSerieP1) {
        this.highestSerieP1 = highestSerieP1;
    }

    public void setHighestSerieP2(int highestSerieP2) {
        this.highestSerieP2 = highestSerieP2;
    }

    public void setAimScoreP1(int aimScoreP1) {
        this.aimScoreP1 = aimScoreP1;
    }

    public void setAimScoreP2(int aimScoreP2) {
        this.aimScoreP2 = aimScoreP2;
    }

    public void setRemainderP1(int remainderP1) {
        this.remainderP1 = remainderP1;
    }

    public void setRemainderP2(int remainderP2) {
        this.remainderP2 = remainderP2;
    }

    public void setAverageP1(double averageP1) {
        this.averageP1 = averageP1;
    }

    public void setAverageP2(double averageP2) {
        this.averageP2 = averageP2;
    }

    public void setNrOfTurns(int nrOfTurns) {
        this.nrOfTurns = nrOfTurns;
    }

    public void setGespeeldOp(LocalDate gespeeldOp) {
        this.gespeeldOp = gespeeldOp;
    }

    public void setPlayedGames(Collection<PlayedGame> playedGames) {
        this.playedGames = playedGames;
    }

    public void addPlayedGame(PlayedGame playedGame){
        playedGames.add(playedGame);
    }

    public void setFilledIn(boolean filledIn) {
        this.filledIn = filledIn;
    }
}
