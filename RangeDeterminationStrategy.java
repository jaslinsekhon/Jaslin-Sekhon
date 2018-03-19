package com.jsekhon;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jsekhon
 * Date: 3/15/18
 * Time: 12:18 PM
 * To change this template use File | Settings | File Templates.
 */
interface  RangeDeterminationStrategy {
   void  examineRange(RangeLimit nextRange, List rangeLimitList);
}
