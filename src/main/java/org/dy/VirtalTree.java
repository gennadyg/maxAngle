package org.dy;


import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *  Object to deal with overlapping
 *
 */
public class VirtalTree extends Tree {

    final static Logger logger = Logger.getLogger( TreeCount.class );

    private double virtualAngle = 0;

    public VirtalTree( int x, int y  ) {

        super( x, y );


/*        BigDecimal angleToCenter = new BigDecimal( String.valueOf( super.getAngleToCenter() ));
        logger.info( "before ->> " + angleToCenter );
        BigDecimal result = angleToCenter.add( new BigDecimal("360"));
        logger.info( "big decimal after ->>" + result );
        BigDecimal ttt = new BigDecimal( result.toPlainString(), new MathContext(15, RoundingMode.FLOOR));*

        There is a bug here about presision in double numbers

        /
 */

        virtualAngle = super.getAngleToCenter() + 360;

        //virtualAngle = result.doubleValue();
        logger.info( "after ->>" + virtualAngle );
    }

    @Override
    public double getAngleToCenter() {

        return virtualAngle;
    }
}
