package funct.monad;

import static funct.types.Collections.*;

import java.util.List;

import junit.framework.TestCase;

public class ListTest extends TestCase {

	private List<Integer> list = List( 1, 2, 3, 4 );
	
	
	public void testMapBetweenTypes(){
				
		List<String> sList = on( list ).map( new funct.on1<Integer,String>(){ void def(){ yield( _ + "!" ); } } ).get();
		
		assertEquals( List( "1!", "2!", "3!", "4!" ), sList );
	}
	
	
	public void testMapChain(){
		
		funct.on2<Integer,Integer,Integer> mult = new funct.on2<Integer,Integer,Integer>(){ void def(){ yield( _1 * _2 ); } };
		 
		funct.on1<Integer, Integer> doubleIt = mult.apply_1( 2 );
		
		
		List<Integer> times6 = on( list ).map( mult.apply_1( 3 ) ).map( doubleIt ).get();
		
		assertEquals( List( 6, 12, 18, 24 ), times6 );
	}
	
	
	public void testMapFilterCombination(){
		
		funct.on1<Integer,Integer> square = new funct.on1<Integer,Integer>(){ void def(){ yield( _ * _ ); } };
		
		funct.on1<Integer,Integer> plusFive = new funct.on1<Integer,Integer>(){ void def(){ yield( _ + 5 ); } };
		
		funct.on1<Integer,Boolean> isGreaterTen = new funct.on1<Integer,Boolean>(){ void def(){ yield( _ > 10 ); } };
		
		
		List<Integer> filtered = on( list ).map( square ).map( plusFive ).filter( isGreaterTen ).get();
		
		assertEquals( List( 14, 21 ), filtered );
	}
}
