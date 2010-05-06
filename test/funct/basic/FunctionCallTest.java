package funct.basic;

import funct.on2;
import junit.framework.TestCase;

public class FunctionCallTest extends TestCase {

	public void testCallConstantFunction(){
		
		funct.on0<Integer> seven = new funct.on0<Integer>(){ void def(){ yield( 7 ); } };
		
		for( int i=0; i < 5; i++ ) assertEquals( Integer.valueOf( 7 ), seven.call() );
	}
	
	
	public void testCallOnFunctionWithArityOne(){
		
		funct.on1<Integer,Integer> succ = new funct.on1<Integer, Integer>(){ void def(){ yield( _ + 1 ); } };
		
		assertEquals( Integer.valueOf( 1 ), succ.call( 0 ) );
		
		assertEquals( Integer.valueOf( 17 ), succ.call( 16 ) );
		
		assertEquals( Integer.valueOf( 111 ), succ.call( 110 ) );
	}
	
	
	public void testCallOnFunctionWithArityTwo(){
		
		funct.on2<Integer,String,String> concat = new funct.on2<Integer,String,String>(){ void def(){ 	
			
				String con = "";
				for( int i = 0; i < _1; i++ ) con = con + _2;	
				yield( con );
		} };
		
		assertEquals( "hohoho", concat.call( 3, "ho" ) );
	}
	
	
    public void testRecursiveCall(){
        
        funct.on1<Integer,Integer> fib = new funct.on1<Integer,Integer>(){ void def(){ yield( _ == 1 ? 1 : call( _ - 1 ) * _  ); } };

        assertEquals( Integer.valueOf( 120 ) , fib.call( 5 ) );
    }
    
}


