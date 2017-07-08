package no.haakon.begynnelse;

import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public final class ListUtils<T extends Comparable<? super T>> {

	public List<T> toUnmodifiableList(Collection<T> collection) {
		List<T> list = new LinkedList<>(collection);
		Collections.sort(list);
		return Collections.unmodifiableList(list);
	}
	
}
