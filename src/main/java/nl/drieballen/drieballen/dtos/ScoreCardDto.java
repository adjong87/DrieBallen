package nl.drieballen.drieballen.dtos;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ScoreCardDto {

    private Long Id;
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
    private LocalDate gespeeldOp;
}
