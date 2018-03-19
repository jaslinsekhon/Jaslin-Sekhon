package com.jsekhon;

import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * User: jsekhon
 * Date: 3/15/18
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class RangeDeterminationJaslinStrategy implements RangeDeterminationStrategy, Serializable{

    public final  synchronized void examineRange(RangeLimit nextRange, List rangeLimitList ) {
        if (rangeLimitList.size() < 1)
            //if list is empty add the first range to the list
            rangeLimitList.add(nextRange);
        else {
            //Iterate over the existing ranges and see if they are added or removed
            //Iterator design pattern//
            //Collections interface framework extends Iterator
            ListIterator<RangeLimit> itr = rangeLimitList.listIterator();
            boolean flag = true;
            while (itr.hasNext()) {
                RangeLimit rangeLimit = itr.next();
                // existing rangelimit within the new rangelimit , so delete the old rangeLimit and flag new rangeLimit
                //  [100, 200]                       [50, 300]
                if (rangeLimit.getLowerRange() > nextRange.getLowerRange() && rangeLimit.getUpperRange() < nextRange.getUpperRange()) {
                    itr.remove();
                    flag = true;
                }
                //new rangeLimit within existing rangeLimit, no need to add
                //  [50. 100]             [25, 150]
                else if (rangeLimit.getLowerRange() <= nextRange.getLowerRange() && rangeLimit.getUpperRange() >= nextRange.getUpperRange()) {
                    flag = false;
                }
                //ranges do not overlap add it
                // [25, 60] , [75, 90]
                else if (rangeLimit.getLowerRange() > nextRange.getUpperRange() || rangeLimit.getUpperRange() < nextRange.getLowerRange()) {
                    flag = true;
                }
                //RangeLimit overlaps so update the new range and delete the existing range
                // [25, 60] [15, 45] —> [15, 60]         or [25, 50] [35, 70] —> becomes [25, 70]
                else {
                    if (rangeLimit.getUpperRange() > nextRange.getUpperRange())
                        nextRange.setUpperRange(rangeLimit.getUpperRange());
                    if (rangeLimit.getLowerRange() < nextRange.getLowerRange())
                        nextRange.setLowerRange(rangeLimit.getLowerRange());
                    itr.remove();
                    flag = true;
                }
            }
            if (flag)
                rangeLimitList.add(nextRange);
        }
    }
}
