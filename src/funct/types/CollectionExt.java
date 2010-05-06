package funct.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionExt<T> {

	protected Collection<T> collection = null;
	
	
	public CollectionExt(Collection<T> collection ) {
		this.collection = collection;
	}


	public <V> CollectionExt<V> map( funct.on1<T,V> mapper ){
		
		List<V> mapped = new ArrayList<V>();
		
		for( T elem : collection ) mapped.add( mapper.call( elem ) );
		
		return new CollectionExt<V>( mapped );
	}	
	
	
	public CollectionExt<T> filter( funct.on1<T,Boolean> filter ){
		
		List<T> filtered = new ArrayList<T>();
		
		for( T elem : collection ){
			
			if( filter.call( elem ) ) filtered.add( elem );
		}
		
		return new CollectionExt<T>( filtered );
	}
	
	public boolean exist( funct.on1<T,Boolean> predicate ){
		
		for( T elem : collection ){
			
			if( predicate.call( elem ) ) return true;
		}
		return false;
	}
	
	public boolean all( funct.on1<T,Boolean> predicate ){
		
		for( T elem : collection ){
			
			if( !predicate.call( elem ) ) return false;
		}
		return true;
	}
	
	public Collection<T> get(){
		return collection;
	}
}
