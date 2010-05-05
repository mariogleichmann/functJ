package funct.basic;

import junit.framework.TestCase;

public class CurryingTest extends TestCase {

	public void testCurryingAddition(){
		
		funct.on2<Integer,Integer,Integer> add = new funct.on2<Integer,Integer,Integer>(){ void def(){ yield( _1 + _2 ); } };
		
		funct.on1<Integer, Integer> succ = add.apply_1( 1 );
		
		
		assertEquals( Integer.valueOf( 1 ), succ.call( 0 ) );
		
		assertEquals( Integer.valueOf( 17 ), succ.call( 16 ) );
		
		assertEquals( Integer.valueOf( 111 ), succ.call( 110 ) );
	}
	
	
	public void testCurryingMultiplication(){
		
		funct.on2<Integer,Integer,Integer> mult = new funct.on2<Integer,Integer,Integer>(){ void def(){ yield( _1 * _2 ); } };
		
		funct.on1<Integer, Integer> triple = mult.apply_1( 3 );
		
		
		assertEquals( Integer.valueOf( 0 ), triple.call( 0 ) );
		
		assertEquals( Integer.valueOf( 3 ), triple.call( 1 ) );
		
		assertEquals( Integer.valueOf( 36 ), triple.call( 12 ) );
	}
}
