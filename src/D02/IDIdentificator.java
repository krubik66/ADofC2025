package D02;

import java.util.ArrayList;
import java.util.Arrays;

public class IDIdentificator {
    private long sumOfId;
    private final ArrayList<String> ranges;
    private final boolean searchAll;

    public IDIdentificator(String input, boolean searchAll) {
        this.sumOfId = 0;
        this.ranges = new ArrayList<>();
        this.ranges.addAll(Arrays.stream(input.split(",")).toList());
        this.searchAll = searchAll;
        findTheWrongOnes();
    }

    private void findTheWrongOnes() {
        for(int i = 0; i < ranges.size(); i++) {
            sumOfId += checkTheRange(ranges.get(i));
        }
    }

    private long checkTheRange(String range) {
        String[] splitted = range.split("-");
        long toReturn = 0;
        for(long i = Long.parseLong(splitted[0]); i <= Long.parseLong(splitted[1]); i++) {
            if(searchAll) {
                toReturn += checkAllRepeats(i);
            } else {
                toReturn += checkTheNumber(i);
            }
        }
        return toReturn;
    }

    private long checkTheNumber(long singleNumber) {
        String convertedToText = singleNumber + "";
        int length = convertedToText.length();
        if(length % 2 == 0 && convertedToText.substring(0, length/2).endsWith(convertedToText.substring(length/2, length))) {
//            System.out.println(singleNumber);
            return singleNumber;
        } else {
            return 0;
        }
    }

    private long checkAllRepeats(long singleNumber) {
        String convertedToText = singleNumber + "";
        int length = convertedToText.length();

        for (int i = 1; i <= length/2; i++) {
            String fragment = convertedToText.substring(0, i);
            if (convertedToText.split(fragment).length == 0) {
                System.out.println(singleNumber);
                return singleNumber;
            }
        }

        return 0;
    }

    public long getSumOfId() {
        return sumOfId;
    }
}
