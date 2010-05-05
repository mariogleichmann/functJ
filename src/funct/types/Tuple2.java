package funct.types;

public class Tuple2<T1,T2> extends Tuple1<T1> implements Pair<T1,T2>{
	
	public T2 _2 = null;

	public Tuple2(T1 o1, T2 o2 ){
		super( o1 );
		_2 = o2;
	}

	public T1 _1() {
		return _1;
	}

	public T2 _2() {
		return _2;
	}
}
