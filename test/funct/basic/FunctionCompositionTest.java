package funct.basic;

import funct.on2;
import junit.framework.TestCase;

public class FunctionCompositionTest extends TestCase {

	
    public void testFunctionComposition(){
    	
    	funct.on1<Integer,Integer> succ = new funct.on1<Integer, Integer>(){ void def(){ yield( _ + 1 ); } };
    	
    	funct.on1<Integer,Integer> square = new funct.on1<Integer,Integer>(){ void def(){ yield( _ * _ ); } };
    	
    	
    	funct.on1<Integer, Integer> succOfSquare = square.andThen( succ );
    	
    	assertEquals( Integer.valueOf( 17 ), succOfSquare.call( 4 ) );
    }
    
    
    public void testMultipleFunctionComposition(){
    	
    	funct.on1<Integer,Integer> doubleIt = new funct.on1<Integer, Integer>(){ void def(){ yield( _ * 2 ); } };
    	
    	funct.on2<Integer,Integer,Integer> sum = new funct.on2<Integer,Integer,Integer>(){ void def(){ yield( _1 + _2 ); } };
    	
    	funct.on1<Integer,Integer> invertIt = new funct.on1<Integer, Integer>(){ void def(){ yield( _ * -1 ); } };
    	
    	
    	on2<Integer, Integer, Integer> inversionOfDoubledSum = sum.andThen( doubleIt ).andThen( invertIt );
    	
    	assertEquals( Integer.valueOf( -14 ), inversionOfDoubledSum.call( 2, 5 ) );
    }
}
