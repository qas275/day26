package vttp2022.day26.model;

import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Show {
    
    private String name;
    private String summary;
    private String image;
    private String rating;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    public static List<Show> createShow(List<Document> rs){
        List<Show> shows = new LinkedList<>();
        for (Document d: rs){
            Show show = new Show();
            String name = d.getString("name");
            String summary = d.getString("summary");
            Document im = d.get("image", Document.class);
            String image = im.getString("original");
            Document ra = d.get("rating",Document.class);
            String rating = ra.get("average").toString();
            System.out.printf("NAME: %s, SUMMARY: %s,IMAGE: %s,RATING %s\n\n\n", name, summary, image,rating);
            show.setName(name);
            show.setSummary(summary);
            show.setImage(image);
            show.setRating(rating);
            
            shows.add(show);
        }

        return shows;
    }

    public JsonObject toJSON(){
        return Json.createObjectBuilder().add("name", getName()).add("summary", getSummary()).add("image", getImage()).add("rating", getRating()).build();
    }

}
