package crejo.fun;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieReview {
	
	private class Movie{
		
		ArrayList<String> genre = new ArrayList<>();
		int year;
		int avgrating;
		int totalreview;
		boolean critic;
		HashMap<String, Boolean> reviewed = new HashMap<>();
	}
	
	private HashMap<String, Integer> user;
	private HashMap<String, Movie> movies;
	private HashMap<Integer, Integer> avgYearScore;
	
	public MovieReview() {
		 user = new HashMap<>();
		movies = new HashMap<>();
		avgYearScore = new HashMap<>();
	}
	
	public void addUser(String uname) throws Exception{
		if(user.containsKey(uname)) {
			throw new Exception("User already exists");
		}
		user.put(uname, 0);
	}
	
	public void addMovie(String mname, ArrayList<String> genre, int year) throws Exception{
		
		if(movies.containsKey(mname)) {
			throw new Exception("Movie already exists");
		}
		Movie movie = new Movie();
	    movie.genre = genre;
		movie.year = year;
		movies.put(mname, movie);
	}
	
	public void addReview(String uname, String mname, int rating) throws Exception{
		
		if(!user.containsKey(uname)) {
			throw new Exception("Invalid User");
		}
		if(!movies.containsKey(mname)) {
			throw new Exception("Invalid Movie");
		}
		if(rating>10 || rating<1) {
			throw new Exception("Invalid Rating");
		}
		
		Movie movie = movies.get(mname);
		if(movie.reviewed.containsKey(uname)) {
			throw new Exception("Multiple reviwes not allowed.");
		}
		
		if(movie.year >= 2021) {
			throw new Exception("Movie yet to be released");
		}
		
		
		int value = user.get(uname);
		if(value>=3) {
			movie.critic = true;
		}
		if(movie.critic) {
			rating = rating*2;
		}
		int oldrating = (movie.avgrating*movie.totalreview);
		movie.totalreview++;
		movie.avgrating = (oldrating+rating)/movie.totalreview;
		value++;
		user.put(uname, value);
		movie.reviewed.put(uname, true);
	}
	
	public int avgMovieScore(String mname) throws Exception{
		if(!movies.containsKey(mname)) {
			throw new Exception("Movie does not exist");
		}
		Movie movie = movies.get(mname);
		return movie.avgrating;
	}
	
	public int avgYearScore(int year) throws Exception{
		
		if(year>2021) {
			throw new Exception("Invalid Year");
		}
		ArrayList<String> keys = new ArrayList<>(movies.keySet());
		int avgScore = 0;
		int counter = 0;
		for(String key: keys) {
			
			Movie movie = movies.get(key);
			if(movie.year == year) {
				counter++;
				avgScore = (avgScore + movie.avgrating);
			}
		}
		avgScore = avgScore/counter;
		return avgScore;
	}
	
	public void topMovies(int n, String genre) {
		ArrayList<String> list = this.listopMovies(n,genre);
		int counter =1;
		for(String li : list) {
			System.out.println(counter + ". " + li);
			counter++;
		}
	}
	
	private ArrayList<String> listopMovies(int n, String genre){
		
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<movies.size() && i<n; i++) {
			
			int max = Integer.MIN_VALUE;
			StringBuilder sb = new StringBuilder();
			ArrayList<String> keys = new ArrayList<String>(movies.keySet());
			for(String key : keys) {
				
				Movie movie = movies.get(key);
				if(!processed.containsKey(key)  && movie.genre.contains(genre) && movie.critic && max<movie.avgrating){
					max = movie.avgrating;
					sb.delete(0, sb.length());
					sb.append(key);
				}
				}
			if(sb.length()==0) {
				continue;
			}
			processed.put(sb.toString(), true);
			list.add(sb.toString());
		}
		return list;
	}
	
}
