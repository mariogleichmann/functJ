package funct;

import java.lang.reflect.Method;

public class Function<RETURN>{
		
		protected RETURN retVal = null;
		
		protected Throwable throwable = null;

		public void yield( RETURN retVal ){
			this.retVal = retVal;
		}
		
		public void throwing( Throwable throwable ){
			this.throwable = throwable;
		}

		public void eval(){
			
			retVal = null;
			throwable = null;
			
			try {
				Method method = getClass().getDeclaredMethod( "def" );

				method.setAccessible( true );

				method.invoke( this );
			}
			catch (Exception e) {
				throw new RuntimeException( e );
			}
			
			if( throwable != null && throwable instanceof RuntimeException ) throw (RuntimeException) throwable;
			
			if( throwable != null ) throw new RuntimeException( throwable );
		}
		

}
