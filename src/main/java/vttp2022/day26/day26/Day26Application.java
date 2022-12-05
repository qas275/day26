package vttp2022.day26.day26;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp2022.day26.day26.repositories.TVShowRepo;

@SpringBootApplication
public class Day26Application {


	// @Autowired
	// private TVShowRepo tvRepo;

	// @Override
	// public void run(String... args){
	// 	List<Document> res = tvRepo.findTVShowByLanguage("English");
	// 	for(Document d: res){
	// 		Document ratingDoc = d.get("rating", Document.class);
	// 		System.out.printf("Name: %s \n Summary: %s\n rating: %s\n", d.getString("name"), d.getString("summary"), ratingDoc.get("rating.average"));
	// 		// System.out.printf("Name: %s \n Summary: %s\n rating: %s\n", d.getString("name"), d.getString("summary"), ratingDoc.get("rating.average",Double.class)); //this will cast the rating as a double from a object
			
	// 	}
	// 	System.exit(0);
	// }

	public static void main(String[] args) {
		SpringApplication.run(Day26Application.class, args);
	}

}
