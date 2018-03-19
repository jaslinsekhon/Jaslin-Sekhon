package com.jsekhon;
import javax.jws.WebMethod;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RangeLimitTest implements  Serializable {
    private static List<RangeLimit> rangeLimitList = new ArrayList<RangeLimit>();
    public static void main(String[] args) {
        //Tested with all the conditions positive and negative
        RangeLimit first = new RangeLimit(94133, 94133);
        RangeLimit second = new RangeLimit(94200, 94299);
        RangeLimit third = new RangeLimit(94226, 94399);
        RangeLimit fourth = new RangeLimit(94199, 94400);
        RangeLimit fifth = new RangeLimit(1, 1000000);
        RangeDeterminationJaslinStrategy js = new RangeDeterminationJaslinStrategy();
        js.examineRange(first,rangeLimitList );
        js.examineRange(second,rangeLimitList );
        js.examineRange(third,rangeLimitList );
        js.examineRange(fourth,rangeLimitList );
      //  js.examineRange(fifth,rangeLimitList );
        // RangeLimitTest.examineRange(first);
       // RangeLimitTest.examineRange(second);
        //RangeLimitTest.examineRange(third);
        //RangeLimitTest.examineRange(fourth);
       // RangeLimitTest.examineRange(fifth);
        if (rangeLimitList.size() >= 1) {
            for (RangeLimit rangeLimit : rangeLimitList) {
                System.out.println(rangeLimit);
            }
        }
    }

}
