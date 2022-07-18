package nl.drieballen.drieballen.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreCardInputDto {
    public int highestSerieP1;
    public int highestSerieP2;
    private int remainderP1;
    private int remainderP2;
    private double averageP1;
    private double averageP2;
    private int nrOfTurns;
}

