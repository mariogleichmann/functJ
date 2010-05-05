package funct;


public class on1<ARG1,RETURN> extends Function<RETURN> {

	protected ARG1 _ = null;
	
	public RETURN call( ARG1 arg ){
		
		_ = arg;
		
		eval();
		
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

}
