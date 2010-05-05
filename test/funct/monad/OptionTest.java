package funct.monad;

import static funct.types.Collections.Map;
import static funct.types.Collections.o;
import static funct.types.Collections.on;

import java.util.Map;

import junit.framework.TestCase;

@SuppressWarnings("unchecked")
public class OptionTest extends TestCase {

	final Map<String,String> developers = Map( o( "Jan", "IAK" ),
											   o( "Jim", "KTT" ),
											   o( "Tom", "MIS" ) );
		
	final Map<String,String> projects =   Map( o( "IAK", "drabiCom" ),
											   o( "KTT", "uccConsult" ) );	
					
	final Map<String,String> customers =  Map( o( "uccConsult", "Frankfurt" ) );
	
		
		
	public void testSuccessfulMapStepping(){
		
		String jimsLocation =
			on( developers ).get( "Jim" )
							.map( new funct.on1<String,String>(){ void def(){ yield( projects.get( _ ) ); } } )
							.map( new funct.on1<String,String>(){ void def(){ yield( customers.get( _ ) ); } } )
							.getOrElse( "unknown" );
		
		assertEquals( "Frankfurt", jimsLocation );
	}
	
	
	public void testIncompleteMapStepping(){
		
		String tomsLocation =
			on( developers ).get( "Tom" )
							.map( new funct.on1<String,String>(){ void def(){ yield( projects.get( _ ) ); } } )
							.map( new funct.on1<String,String>(){ void def(){ yield( customers.get( _ ) ); } } )
							.getOrElse( "unknown" );
		
		assertEquals( "unknown", tomsLocation );
	}
}
