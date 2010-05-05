package funct.types;

import java.util.Collection;
import java.util.Map;

public class Collections {

	public static <T> CollectionExt<T> on( Collection<T> collection ){
		return new CollectionExt<T>( collection );
	}
	
	public static <K,V> MapExt<K,V> on( Map<K,V> map ){
		return new MapExt<K,V>( map );
	}
}
