package crejo.fun;

import java.util.ArrayList;

public class MovieClient {

	public static void main(String[] args) throws Exception {
		
		MovieReview mr = new MovieReview();
		
		
		// Add Movies
		ArrayList<String> dongenre = new ArrayList<String>();
		dongenre.add("Action");                               // add 1st movie
		dongenre.add("Comedy");
		mr.addMovie("Don",dongenre, 2006);
		
		ArrayList<String> tigergenre = new ArrayList<String>();
		tigergenre.add("Drama");                              // add 2nd movie
		mr.addMovie("Tiger",tigergenre, 2008);
		
		ArrayList<String> padgenre = new ArrayList<String>();
		padgenre.add("Comedy");                                 // so on..
		mr.addMovie("Padmaavat",padgenre, 2006);
		
		ArrayList<String> lbgenre = new ArrayList<String>();
		lbgenre.add("Drama");
		mr.addMovie("LunchBox",lbgenre, 2021);
		
		ArrayList<String> gurugenre = new ArrayList<String>();
		gurugenre.add("Drama");
		mr.addMovie("Guru",gurugenre, 2006);
		
		ArrayList<String> metgenre = new ArrayList<String>();
		metgenre.add("Romance");
		mr.addMovie("Metro",metgenre, 2006);
		
		// Add users
		
		mr.addUser("SRK");
		mr.addUser("Salman");
		mr.addUser("Deepika");
		
		
		// Add reviews
		
		mr.addReview("SRK", "Don", 2);
		mr.addReview("SRK", "Padmaavat", 8);
		mr.addReview("Salman", "Don", 5);
		mr.addReview("Deepika", "Don", 9);
		mr.addReview("Deepika", "Guru", 6);
	//	mr.addReview("SRK", "Don", 10);
	//	mr.addReview("Deepika", "LunchBox", 5);
		mr.addReview("SRK", "Metro", 7);
		mr.addReview("SRK", "Tiger", 5);
//		mr.addReview("SRK", "LunchBox", 6);
		mr.addReview("SRK", "Guru", 3);
		
//		System.out.println(mr.avgMovieScore("Don"));              // 5
//		System.out.println(mr.avgMovieScore("Padmaavat"));       // 8
//		System.out.println(mr.avgMovieScore("Guru"));             // 6
//		System.out.println(mr.avgMovieScore("Metro"));  // 14 (Srk rating = 7 *(2) because he is a critic)
//		
//		System.out.println(mr.avgYearScore(2006));   // 8
		
		mr.topMovies(5,"Drama");

	}

}
