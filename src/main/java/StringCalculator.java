import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        // Check if a custom delimiter is specified
        String delimiter = ",";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        // Split numbers using delimiter or newline
        String[] nums = numbers.split("[,\n" + delimiter + "]");

        // Sum up the numbers and handle negatives
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String num : nums) {
            int n = Integer.parseInt(num);
            if (n < 0) {
                negatives.add(n);
            } else if (n <= 1000) {
                sum += n;
            }
        }

        // Throw exception if negatives found
        if (!negatives.isEmpty()) {
            StringBuilder message = new StringBuilder("Negative numbers not allowed: ");
            for (int i = 0; i < negatives.size(); i++) {
                message.append(negatives.get(i));
                if (i < negatives.size() - 1) {
                    message.append(",");
                }
            }
            throw new IllegalArgumentException(message.toString());
        }

        return sum;
    }
}