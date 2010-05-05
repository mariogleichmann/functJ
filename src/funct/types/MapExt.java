package funct.types;

import java.util.Map;
import static funct.types.Option.*;

public class MapExt<K,V> {

	private Map<K,V> map = null;
	
	public MapExt( Map<K,V> map ){
		this.map = map;
	}
	
	@SuppressWarnings("unchecked")
	public Option<V> get( K key ){
		
		V retVal = map.get( key );
		
		return retVal != null ? some( retVal ) : (Option<V>) none;
	}
}
