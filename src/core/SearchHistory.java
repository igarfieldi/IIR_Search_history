package core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchHistory {
	private ArrayList<QuerySearch> history;
	
	public SearchHistory() {
		// TODO: load history from file or smth.
		history = new ArrayList<QuerySearch>();
	}
	
	public SearchHistory(String fileName) {
		// TODO: load history from file or smth.
		history = new ArrayList<QuerySearch>();
	}
	
	public void saveHistory(String fileName) {
		// TODO: store the search history in some way...
	}
	
	/**
	 * Adds an element to the search history.
	 * It is assumed that this search has occurred after the latest historie'd search.
	 * @param search Search to append
	 */
	public void addEntry(QuerySearch search) {
		history.add(search);
	}
	
	/**
	 * Returns up to the n most recent searches in the history.
	 * @param maxAmount number of desired searches
	 * @return List of most recent searches
	 */
	public List<QuerySearch> getRecentSearches(int maxAmount) {
		if(history.isEmpty())
			return history;
		maxAmount = Math.min(maxAmount, history.size());
		return history.subList(history.size() - maxAmount, history.size());
	}
	
	/**
	 * Returns the entire search history ordered by date.
	 * @return List of searches
	 */
	public List<QuerySearch> getHistoryDateOrdered() {
		return this.getHistoryDateOrdered(null, null);
	}
	
	/**
	 * Returns a subset of the history ordered by date.
	 * @param begin Earliest date to include in result
	 * @param end Latest date to include in result
	 * @return List of searches within date range
	 */
	public List<QuerySearch> getHistoryDateOrdered(Date begin, Date end) {
		// If we don't have a history yet or no limitations on the date, we're done
		if((begin == null) && (end == null))
			return history;
		if(history.size() == 0)
			return history;

		int beginIndex = -1;
		int endIndex = -1;
		
		// If only one date is missing, the other one will be set to the first/latest possible date
		if(begin == null) {
			begin = new Date(0);
			beginIndex = 0;
		}
		if(end == null) {
			end = new Date(System.currentTimeMillis());
			endIndex = history.size() - 1;
		}
		
		// Determine the indices of the history by iterating through the list
		// and finding the first entries violating the date constraints
		for(int i = 0; (i < history.size()) && (beginIndex < 0) && (endIndex < 0); i++) {
			if(beginIndex < 0) {
				if(!history.get(i).getTimestamp().before(begin))
					beginIndex = i;
			}
			if(endIndex < 0) {
				if(history.get(i).getTimestamp().after(end))
					endIndex = i-1;
			}
		}
		
		// TODO: is this needed/correct? E.g. if the end index wasn't set because everything was earlier?
		if(beginIndex < 0)
			beginIndex = 0;
		
		if(endIndex < 0)
			endIndex = history.size() - 1;
		
		return history.subList(beginIndex, endIndex);
	}
}