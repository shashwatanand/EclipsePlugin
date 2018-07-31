package de.shashwat.eg.xviewer.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFilter implements FilenameFilter {
	protected Matcher matcher;

	public MatchFilter(String pattern) {
		this.matcher = Pattern.compile(pattern).matcher("");
	}

	@Override
	public boolean accept(File dir, String fileName) {
		matcher.reset(fileName);
		return matcher.matches();
	}
}
