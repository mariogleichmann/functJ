package funct.types;

public class Tuple3<T1,T2,T3> extends Tuple2<T1,T2> implements Triple<T1,T2,T3>{
	
	public T3 _3 = null;

	public Tuple3(T1 o1, T2 o2, T3 o3 ){
		super( o1, o2 );
		_3 = o3;
	}

	public T3 _3() {
		return _3;
	}
}

