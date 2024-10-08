package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.model.StudyCafeLockerPasses;
import cleancode.studycafe.tobe.model.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.StudyCafeSeatPassType;
import cleancode.studycafe.tobe.model.StudyCafeSeatPasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudyCafeFileHandler {

    private static final String STUDY_CAFE_RESOURCE_PATH = "src/main/resources/cleancode/studycafe/";
    private static final String PASS_LIST_CSV_FILE_NAME = "pass-list.csv";
    private static final String LOCKER_CSV_FILE_NAME = "locker.csv";
    private static final String CSV_DELIMITER = ",";

    public StudyCafeSeatPasses readStudyCafePasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(STUDY_CAFE_RESOURCE_PATH + PASS_LIST_CSV_FILE_NAME));
            List<StudyCafeSeatPass> studyCafeSeatPasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(CSV_DELIMITER);
                StudyCafeSeatPassType studyCafeSeatPassType = StudyCafeSeatPassType.valueOf(values[0]);
                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);
                double discountRate = Double.parseDouble(values[3]);

                StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(studyCafeSeatPassType, duration, price, discountRate);
                studyCafeSeatPasses.add(studyCafeSeatPass);
            }

            return StudyCafeSeatPasses.of(studyCafeSeatPasses);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    public StudyCafeLockerPasses readLockerPasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(STUDY_CAFE_RESOURCE_PATH + LOCKER_CSV_FILE_NAME));

            return StudyCafeLockerPasses.from(lines);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

}
