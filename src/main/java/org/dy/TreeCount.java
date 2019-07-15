package org.dy;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeCount {

    final static Logger logger = Logger.getLogger( TreeCount.class );

    /**
     * In order to deal with 'overlapping' values in circle of points - { 350, 351, 5, 10 },
     * going to add a virtual points with angle + 360 value, so instead of array above,
     * will be array - { 350, 351, 365, 370, 5, 10 },
     *
     * @param forest - array of Tree object
     * @param alpha - angle to count maximum of objects
     */
    public List<Tree> setupForest( List<Tree> forest, double alpha ) throws Exception {

        List<Tree> expandedForest = new ArrayList<>();
        try{

            logger.info("Forest before sorting");
            forest.forEach( c -> logger.info( c.getAngleToCenter() ));

            expandedForest.addAll( forest );

            for( Tree current : forest ){

                if( current.getAngleToCenter() < alpha ){

                    Tree virtualTree = new VirtalTree( current.getX(), current.getY() );
                    logger.info( current.getAngleToCenter() );
                    logger.info("Adding virtual node with angle - " + virtualTree.getAngleToCenter() );
                     expandedForest.add( virtualTree );
                }
            }
            Collections.sort( expandedForest );
            logger.info("Forest after sorting");

            expandedForest.forEach( c -> logger.info( c.getAngleToCenter() ));

        }catch( Exception ex ){

            logger.error("Failed to make innitial setup");
            throw new Exception("Failed to build points data structure");
        }
        return expandedForest;

    }
    /** Alghorithm is to find maximum angle with object by using sliding window.
     * if angle between current element and sliding window start ( rangeStartTreeIndex ) more than alpha,
     * remove elements from the start of sliding window
     *
     *
     * @param alpha - angle to find maximum number of trees
     * @param forest - data structure that contains all trees
     *
     * @return maximum number of trees
     *
     *
    * */
    public int countTrees( double alpha, List<Tree> forest ) {

        int maxNumOfTrees = 0;
        int curNumOfTrees = 2;

        if( forest.size() <= 1 ){

            return forest.size();
        }
        try{
            List<Tree> expandedForest = setupForest( forest, alpha );

            // sliding window
            double currentRange = expandedForest.get( 1 ).getAngleToCenter() - expandedForest.get( 0 ).getAngleToCenter();;
            int rangeStartTreeIndex = 0;

            for ( int i = 2; i < expandedForest.size(); i++) {

                // Update maxNumOfTrees if it becomes greater than curNumOfTrees
                if ( currentRange <= alpha )
                    maxNumOfTrees = Math.max( maxNumOfTrees, curNumOfTrees );

                // If curr_sum becomes greater than
                // sum subtract starting elements of array
                while( ( expandedForest.get( i ).getAngleToCenter() - expandedForest.get( rangeStartTreeIndex ).getAngleToCenter() > alpha )
                        &&
                        rangeStartTreeIndex < ( i - 1 )) {
                    currentRange -= expandedForest.get( rangeStartTreeIndex ).getAngleToCenter();
                    rangeStartTreeIndex++;
                }

                // Add elements to curr_sum
                currentRange = expandedForest.get( i ).getAngleToCenter() - expandedForest.get( rangeStartTreeIndex ).getAngleToCenter();
                curNumOfTrees = i - rangeStartTreeIndex + 1;
                logger.info("Current range is ["+ currentRange + "] curNumOfTrees[" + curNumOfTrees + "]" );

            }

            // Adding an extra check for last subarray
            if ( currentRange <= alpha )
                maxNumOfTrees = Math.max( maxNumOfTrees, curNumOfTrees );


        }catch( Exception ex ){

            logger.error("Failed to count trees", ex );
        }
        return maxNumOfTrees;
    }

    public static void main( String[] args ){

        ArrayList<Tree> forest = new ArrayList<Tree>();
/*        forest.add(new Tree(10, 30));
        forest.add(new Tree(11, 31));
        forest.add(new Tree(12, 32));
        forest.add(new Tree(13, 33));
        forest.add(new Tree(50, 2));

        forest.add(new Tree(50, 1));
        forest.add(new Tree(50, 0));
        forest.add(new Tree(50, -1));
        forest.add(new Tree(50, -2));
        forest.add(new Tree(-50, 20));
        forest.add(new Tree(-50, -20));*/

        forest.add(new Tree(10, 30));
        forest.add(new Tree(50, 2));
        forest.add(new Tree(50, 1));
        forest.add(new Tree(50, 0));
        forest.add(new Tree(50, -1));
        forest.add(new Tree(50, -2));
        forest.add(new Tree(-50, 20));
        forest.add(new Tree(-50, -20));

        double alpha = 360;

        int count = new TreeCount().countTrees( alpha, forest );
    }
}

