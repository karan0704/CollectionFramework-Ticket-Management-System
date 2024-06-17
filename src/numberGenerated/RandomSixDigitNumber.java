package numberGenerated;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomSixDigitNumber {
    private static final Set<Integer> generatedNumbers = new HashSet<>();
    private int sixDigitNumber;

    public RandomSixDigitNumber() {
        Random random = new Random();
        do {
            sixDigitNumber = 100000 + random.nextInt(900000);
        } while (generatedNumbers.contains(sixDigitNumber));
        generatedNumbers.add(sixDigitNumber);
    }

    public int getSixDigitNumber() {
        return sixDigitNumber;
    }

    public void setSixDigitNumber(int sixDigitNumber) {
        if (!generatedNumbers.contains(sixDigitNumber)) {
            this.sixDigitNumber = sixDigitNumber;
            generatedNumbers.add(sixDigitNumber);
        }
    }
}