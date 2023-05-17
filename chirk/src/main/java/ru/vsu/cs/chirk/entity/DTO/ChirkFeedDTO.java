package ru.vsu.cs.chirk.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vsu.cs.chirk.entity.Reaction;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class ChirkFeedDTO {

    private long chirkId;
    private String text;
    private LocalDateTime createdDate;
    private String userFirstname;
    private String userLastname;
    private int userIconId;
    private int countLike;
    private int countDislike;
    private Reaction reaction;

    @Override
    public String toString() {
        return "ChirkFeedDTO{" +
                "chirkId=" + chirkId +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                ", userFirstname='" + userFirstname + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userIconId=" + userIconId +
                ", countLike=" + countLike +
                ", countDislike=" + countDislike +
                ", reaction=" + reaction +
                '}';
    }
}
