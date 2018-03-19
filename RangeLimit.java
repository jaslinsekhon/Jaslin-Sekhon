package com.jsekhon;
import java.io.Serializable;

public class RangeLimit implements Serializable {

    private static final long serialversionUID = 129348938L; // For serialization
    private static RangeLimit rangeInstance = null;
    //Used Encapsulation getters and setters for all private variables.
    private int lowerRange;
    private int upperRange;

    RangeLimit(int lowerRange, int upperRange) {
        this.lowerRange = lowerRange;
        this.upperRange = upperRange;
    }

    public int getLowerRange() {
        return lowerRange;
    }
    public void setLowerRange(int lowerRange) {
        this.lowerRange = lowerRange;
    }
    public int getUpperRange() {
        return upperRange;
    }

    public void setUpperRange(int upperRange) {
        this.upperRange = upperRange;
    }
    @Override
    public String toString() {
        return String.format("['%d','%d']", lowerRange, upperRange);
    }
    @Override
    public boolean equals(Object another) {
        boolean result = false;
        if (another instanceof RangeLimit) {
            RangeLimit that = (RangeLimit) another;
            result = (this.getLowerRange() == that.getLowerRange() && this.getUpperRange() == that.getUpperRange());
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + lowerRange;
        result = 31 * result + upperRange;
        return result;
    }
}

