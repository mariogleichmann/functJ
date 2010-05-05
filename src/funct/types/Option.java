package funct.types;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Option<T> implements Iterable<T>{

	@SuppressWarnings("unchecked")
	public static None<?> none = new None();
	
	public static <V> Some<V> some( V value ){
		return new Some<V>( value );
	}

	@SuppressWarnings("unchecked")
	public static <V> Option<V> option( V value ){
		return value != null ? new Some<V>( value ) : (Option<V>) none;
	}
	
	
	public abstract T get();
	
	public abstract T getOrElse( T elseValue );
	
	public abstract <V> Option<V> map( funct.on1<T,V> mapper );
	
	
	
	private static class None<T> extends Option<T> {

		public T getOrElse( T elseValue ){ return elseValue; }
		
		public T get(){ return null; }
		
		public Iterator<T> iterator() {
			return new ArrayList<T>().iterator();
		}
		
		@SuppressWarnings("unchecked")
		public <V> Option<V> map( funct.on1<T,V> mapper ){
			return (Option<V>) none;
		}
	}
	
	private static class Some<T> extends Option<T> {

		private T value;
		
		public Some( T value ){
			this.value = value;
		}
		
		public T get() {
			return value;
		}

		public T getOrElse(T elseValue) {
			return value;
		}

		
		@SuppressWarnings({ "unchecked", "serial" })
		public Iterator<T> iterator() {
			return new ArrayList(){{ add( value ); }}.iterator();
		}
		
		@SuppressWarnings("unchecked")
		public <V> Option<V> map( funct.on1<T,V> mapper ){
			
			V retVal = mapper.call( value );
			
			return retVal != null ? some( retVal ) : (Option<V>) none;
		}
	}
}

