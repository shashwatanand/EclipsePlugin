package com.nashtech.hw.shashwat.app.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.nashtech.hw.shashwat.app.model.Tuple;
import com.nashtech.hw.shashwat.app.provider.SearchResultProvider;
import com.nashtech.hw.shashwat.app.util.*;

/**
 * The Class SearchTester.
 */
public class SearchTester {
	
	/**
	 * Setup.
	 */
	@BeforeClass
	public static void setup() {
		Map<Integer, Tuple> inMemTuples = Util.getInstance().getInMemTuples();
		inMemTuples.clear();
		/*1, "myPattern", src/patterns/Functional1.pat, false
		2, "myPattern", src/patterns/Functional2.pat, false
		3, "myPattern", src/patterns/Functional3.pat, false
		4, "myPattern", src/patterns/Functional4.pat, false
		5, "myPattern", src/patterns/Functional5.pat, false*/
		inMemTuples.put(1, new Tuple(1, "\"myPattern\"", "src/patterns/Functional1.pat", false));
		inMemTuples.put(2, new Tuple(2, "\"myPattern\"", "src/patterns/Functional2.pat", false));
		inMemTuples.put(3, new Tuple(3, "\"myPattern\"", "src/patterns/Functional3.pat", false));
		inMemTuples.put(4, new Tuple(4, "\"myPattern\"", "src/patterns/Functional4.pat", false));
		inMemTuples.put(5, new Tuple(5, "\"myPattern\"", "src/patterns/Functional5.pat", false));
	}
	
	/**
	 * Search pos id.
	 */
	@Test
	public void searchPosId() {
		SearchResultProvider provider = new SearchResultProvider();
		List<Tuple> result = provider.searchBasedOnId(1);
		assertFalse(result.isEmpty());
	}
	
	/**
	 * Search neg id.
	 */
	@Test
	public void searchNegId() {
		SearchResultProvider provider = new SearchResultProvider();
		List<Tuple> result = provider.searchBasedOnId(6);
		assertTrue(result.isEmpty());
	}
	
	/**
	 * Search pos name.
	 */
	@Test
	public void searchPosName() {
		SearchResultProvider provider = new SearchResultProvider();
		List<Tuple> result = provider.searchBasedOnName("\"myPattern\"");
		assertFalse(result.isEmpty());
	}
	
	/**
	 * Search neg name.
	 */
	@Test
	public void searchNegName() {
		SearchResultProvider provider = new SearchResultProvider();
		List<Tuple> result = provider.searchBasedOnName("myPattern");
		assertTrue(result.isEmpty());
	}
	
	/**
	 * Search pos pattern.
	 */
	@Test
	public void searchPosPattern() {
		SearchResultProvider provider = new SearchResultProvider();
		List<Tuple> result = provider.searchBasedOnPattern("src/patterns/Functional1.pat");
		assertFalse(result.isEmpty());
	}
	
	/**
	 * Search neg pattern.
	 */
	@Test
	public void searchNegPattern() {
		SearchResultProvider provider = new SearchResultProvider();
		List<Tuple> result = provider.searchBasedOnPattern("myPattern");
		assertTrue(result.isEmpty());
	}
	
	/**
	 * Search pos flag.
	 */
	@Test
	public void searchPosFlag() {
		SearchResultProvider provider = new SearchResultProvider();
		List<Tuple> result = provider.searchBasedOnFlag(false);
		assertFalse(result.isEmpty());
	}
	
	/**
	 * Search neg flag.
	 */
	@Test
	public void searchNegFlag() {
		SearchResultProvider provider = new SearchResultProvider();
		List<Tuple> result = provider.searchBasedOnFlag(true);
		assertTrue(result.isEmpty());
	}

}
