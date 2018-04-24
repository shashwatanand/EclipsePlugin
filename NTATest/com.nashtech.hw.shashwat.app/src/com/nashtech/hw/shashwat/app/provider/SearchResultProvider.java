package com.nashtech.hw.shashwat.app.provider;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.nashtech.hw.shashwat.app.model.Tuple;
import com.nashtech.hw.shashwat.app.util.Util;

/**
 * The Class SearchResultProvider.
 * 
 * @author shashwat.anand
 */
public class SearchResultProvider {
	
	/** The in mem tuples. */
	private Map<Integer, Tuple> inMemTuples;

	/**
	 * Instantiates a new search result provider.
	 */
	public SearchResultProvider() {
		this.inMemTuples = Util.getInstance().getInMemTuples();
	}
	
	/**
	 * Use parallel stream.
	 *
	 * @return true, if successful
	 */
	boolean useParallelStream() {
		int cores = Runtime.getRuntime().availableProcessors();
		if (cores > 1 && this.inMemTuples.size() > 1000) {
			return true;
		}
		return false;
	}

	/**
	 * Search based on id.
	 *
	 * @param searchId the search id
	 * @return the list
	 */
	public List<Tuple> searchBasedOnId(final int searchId) {
		final Predicate<Tuple> predicate = t -> t.getId() == searchId;
		return execute(predicate);
	}

	/**
	 * Search based on name.
	 *
	 * @param searchText the search text
	 * @return the list
	 */
	public List<Tuple> searchBasedOnName(final String searchText) {
		final Predicate<Tuple> predicate = t -> t.getName().equals(searchText);
		return execute(predicate);
	}
	
	/**
	 * Search based on pattern.
	 *
	 * @param searchText the search text
	 * @return the list
	 */
	public List<Tuple> searchBasedOnPattern(final String searchText) {
		final Predicate<Tuple> predicate = t -> t.getPattern().equals(searchText);
		return execute(predicate);
	}
	
	/**
	 * Search based on flag.
	 *
	 * @param searchFlag the search flag
	 * @return the list
	 */
	public List<Tuple> searchBasedOnFlag(final boolean searchFlag) {
		final Predicate<Tuple> predicate = t -> t.isFlag() == searchFlag;
		return execute(predicate);
	}
	
	/**
	 * Execute.
	 *
	 * @param predicate the predicate
	 * @return the list
	 */
	private List<Tuple> execute(Predicate<Tuple> predicate) {
		if (useParallelStream()) {
			return inMemTuples.values().parallelStream().filter(predicate).collect(Collectors.toList());
		}
		return inMemTuples.values().stream().filter(predicate).collect(Collectors.toList());
	}
}
