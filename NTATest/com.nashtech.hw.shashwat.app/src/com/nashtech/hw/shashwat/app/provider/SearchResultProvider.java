package com.nashtech.hw.shashwat.app.provider;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.nashtech.hw.shashwat.app.model.Tuple;
import com.nashtech.hw.shashwat.app.util.Util;

/**
 * The Class SearchResultProvider.
 * 
 * @author shashwat.anand
 */
public class SearchResultProvider {

	/**
	 * Search based on id.
	 *
	 * @param searchId the search id
	 * @return the list
	 */
	public List<Tuple> searchBasedOnId(final int searchId) {
		final Map<Integer, Tuple> inMemTuples = Util.getInstance().getInMemTuples();
		return inMemTuples.values().parallelStream().filter(t -> t.getId() == searchId).collect(Collectors.toList());
	}

	/**
	 * Search based on name.
	 *
	 * @param searchText the search text
	 * @return the list
	 */
	public List<Tuple> searchBasedOnName(final String searchText) {
		final Map<Integer, Tuple> inMemTuples = Util.getInstance().getInMemTuples();
		return inMemTuples.values().parallelStream().filter(t -> t.getName().equals(searchText)).collect(Collectors.toList());
	}
	
	/**
	 * Search based on pattern.
	 *
	 * @param searchText the search text
	 * @return the list
	 */
	public List<Tuple> searchBasedOnPattern(final String searchText) {
		final Map<Integer, Tuple> inMemTuples = Util.getInstance().getInMemTuples();
		return inMemTuples.values().parallelStream().filter(t -> t.getPattern().equals(searchText)).collect(Collectors.toList());
	}
	
	/**
	 * Search based on flag.
	 *
	 * @param searchFlag the search flag
	 * @return the list
	 */
	public List<Tuple> searchBasedOnFlag(final boolean searchFlag) {
		final Map<Integer, Tuple> inMemTuples = Util.getInstance().getInMemTuples();
		return inMemTuples.values().parallelStream().filter(t -> t.isFlag() == searchFlag).collect(Collectors.toList());
	}
}
