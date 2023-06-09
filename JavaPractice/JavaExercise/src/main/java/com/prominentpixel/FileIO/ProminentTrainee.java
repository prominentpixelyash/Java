package com.prominentpixel.FileIO;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public class ProminentTrainee {

    int TraineeId;

    String TraineeName;

    String TraineeAddress;

    LocalDate TraineeDOB;

    LocalDate TraineeJoiningDate;

    int TraineeAge;

    public ProminentTrainee() {
    }

    public ProminentTrainee(int traineeId, String traineeName, String traineeAddress, LocalDate traineeDOB, LocalDate traineeJoiningDate, int traineeAge) {
        TraineeId = traineeId;
        TraineeName = traineeName;
        TraineeAddress = traineeAddress;
        TraineeDOB = traineeDOB;
        TraineeJoiningDate = traineeJoiningDate;
        TraineeAge = traineeAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProminentTrainee that = (ProminentTrainee) o;
        return TraineeId == that.TraineeId && Objects.equals(TraineeName, that.TraineeName) && Objects.equals(TraineeAddress, that.TraineeAddress) && Objects.equals(TraineeDOB, that.TraineeDOB) && Objects.equals(TraineeJoiningDate, that.TraineeJoiningDate) && Objects.equals(TraineeAge, that.TraineeAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TraineeId, TraineeName, TraineeAddress, TraineeDOB, TraineeJoiningDate, TraineeAge);
    }

    @Override
    public String toString() {
        return "ProminentTrainee{" +
                "TraineeId=" + TraineeId +
                ", TraineeName='" + TraineeName + '\'' +
                ", TraineeAddress='" + TraineeAddress + '\'' +
                ", TraineeDOB=" + TraineeDOB +
                ", TraineeJoiningDate=" + TraineeJoiningDate +
                ", TraineeAge=" + TraineeAge +
                '}';
    }
}
