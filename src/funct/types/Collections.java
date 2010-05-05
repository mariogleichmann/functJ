package funct.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {

	public static <T> CollectionExt<T> on( Collection<T> collection ){
		return new CollectionExt<T>( collection );
	}
	
	public static <K,V> MapExt<K,V> on( Map<K,V> map ){
		return new MapExt<K,V>( map );
	}
	
	public static <T1> Tuple1<T1> o(T1 o1 ){
		return new Tuple1<T1>( o1 );
	}
	
	public static <T1,T2> Tuple2<T1,T2> o(T1 o1, T2 o2 ){
		return new Tuple2<T1,T2>( o1, o2 );
	}
	
	public static <T1,T2,T3> Tuple3<T1,T2,T3> o(T1 o1, T2 o2, T3 o3 ){
		return new Tuple3<T1,T2,T3>( o1, o2, o3 );
	}
	
	/**
	 * Ueberfuehrt die uebergebenen Tuple / Paare in eine Map
	 */
	public static <K,V> Map<K,V> Map( Tuple2<K,V>...tuples ){
		
		Map<K,V> map = new HashMap<K,V>();
		
		for( Tuple2<K,V> tuple : tuples ){
		
			map.put( tuple._1 , tuple._2 );
		}
		return map;
	}

	
	/**
	 * Ueberfuehrt die uebergebenen Elemente in eine Liste.
	 * 
	 * @param 	<T>
	 * 			Typ der uebergebenen Elemente
	 * 
	 * @param 	elements
	 * 			Elemente, welche in eine List ueberfuehrt werden sollen
	 */
	public static <T> List<T> List( T...elements ){
		List<T> list = new ArrayList<T>();
		for( T element : stripNull( elements ) ){
			list.add( element );
		}
		return list;
	}
	
	/**
	 * Ueberfuehrt die uebergebenen Elemente in ein Set.
	 * 
	 * @param 	<T>
	 * 			Typ der uebergebenen Elemente
	 * 
	 * @param 	elements
	 * 			Elemente, welche in eine List ueberfuehrt werden sollen
	 */
	public static <T> Set<T> Set( T...elements ){
		Set<T> set = new HashSet<T>();
		for( T element : stripNull( elements ) ){
			set.add( element );
		}
		return set;
	}
	
	/** Liefert eine neue Liste aller uebergebenen Elemente, welche NICHT null sind */
	private static <T> List<T> stripNull( T...elems ){
		
		List<T> stripped = new ArrayList<T>();
		
		for( int i=0; i<elems.length; i++ ){
			
			if( elems[i] != null ) stripped.add( elems[i] );
		}
		return stripped;
	}
}
