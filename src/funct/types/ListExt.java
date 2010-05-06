package funct.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListExt<T> {

	private List<T> list;
	
	public ListExt( List<T> list ) {
		this.list = list;
	}

	public <V> ListExt<V> map( funct.on1<T,V> mapper ){
		
		List<V> mapped = new ArrayList<V>();
		
		for( T elem : list ) mapped.add( mapper.call( elem ) );
		
		return new ListExt<V>( mapped );
	}	
	
	
	public ListExt<T> filter( funct.on1<T,Boolean> filter ){
		
		List<T> filtered = new ArrayList<T>();
		
		for( T elem : list ){
			
			if( filter.call( elem ) ) filtered.add( elem );
		}
		
		return new ListExt<T>( filtered );
	}
	
	public List<T> get(){
		return list;
	}
}
