package funct;


public class on2<ARG1,ARG2,RETURN> extends Function<RETURN> {

	protected ARG1 _1;
	protected ARG2 _2;
	
	
	public RETURN call( ARG1 arg1, ARG2 arg2 ){
		
		ARG1 tmp1 = _1;
		ARG2 tmp2 = _2;
		
		_1 = arg1;
		_2 = arg2;
		
		eval();
		
		_1 = tmp1;
		_2 = tmp2;
		
		return retVal;
	}


	public funct.on1<ARG2,RETURN> apply_1( final ARG1 arg1 ) {
		
		final funct.on2<ARG1,ARG2,RETURN> toCall = this;
		
		return new funct.on1<ARG2,RETURN>(){
			
			public RETURN call( ARG2 arg2 ){
				return toCall.call( arg1, arg2 );
			}
		};
	}


	public funct.on1<ARG1,RETURN> apply_2( final ARG2 arg2 ) {
		
		final funct.on2<ARG1,ARG2,RETURN> toCall = this;
		
		return new funct.on1<ARG1,RETURN>(){
			
			public RETURN call( ARG1 arg1 ){
				return toCall.call( arg1, arg2 );
			}
		};
	}
	
	public <Y> funct.on2<ARG1,ARG2,Y> andThen( final funct.on1<RETURN,Y> next ){
		
		final funct.on2<ARG1,ARG2,RETURN> thisFunct = this;
		
		return new funct.on2<ARG1,ARG2,Y>(){
			
			void def(){
				
				RETURN retVal = thisFunct.call( _1, _2 );
				yield( next.call( retVal ) );
			}
		};
	}
}
