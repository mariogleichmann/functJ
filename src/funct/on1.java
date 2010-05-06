package funct;


public class on1<ARG1,RETURN> extends Function<RETURN> {

	protected ARG1 _ = null;
	
	public RETURN call( ARG1 arg ){
		
		ARG1 tmp = _;
		
		_ = arg;
		
		eval();
		
		_ = tmp;
		
		return retVal;
	}
	
	
	public funct.on0<RETURN> apply( final ARG1 arg1 ){
		
		final funct.on1<ARG1,RETURN> toCall = this;
		
		return new funct.on0<RETURN>(){
			
			public RETURN call(){
				return toCall.call( arg1 );
			}
		};
	}
	
	public <Y> funct.on1<ARG1,Y> andThen( final funct.on1<RETURN,Y> next ){
		
		final funct.on1<ARG1,RETURN> thisFunct = this;
		
		return new funct.on1<ARG1,Y>(){
			
			void def(){
				
				RETURN retVal = thisFunct.call( _ );
				yield( next.call( retVal ) );
			}
		};
	}

}
