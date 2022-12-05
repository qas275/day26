package vttp2022.day26.day26.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
// import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TVShowRepo {

    public static final String C_TV_SHOWS = "tvshows";
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Document> findTVShowByLanguage(String language){
        
        //criteria filters
        Criteria c = Criteria.where("language").is(language);
        
        //further changes the results of everything in the filter
        Query q = Query.query(c);


        List<Document> res = mongoTemplate.find(q, Document.class, C_TV_SHOWS);
        
        return res;
    }

    public List<Document> findTVShowByRating(Float f, Integer y){
        Criteria c = Criteria.where("rating.average").gte(f).andOperator(
            Criteria.where("year").gte(y),
            Criteria.where("language").is("English")
            );
        Query q = Query.query(c);

        return mongoTemplate.find(q, Document.class, C_TV_SHOWS);
    }

    public List<String> findGenres(){
        List<String> genres = mongoTemplate.findDistinct(new Query(), "genres", C_TV_SHOWS, String.class);

        return genres;
    }

    public List<Document> findShowsByGenre(String genre){
        Criteria c = Criteria.where("genres").is(genre);
        Query q = Query.query(c).skip(0).limit(10);

        return mongoTemplate.find(q, Document.class, C_TV_SHOWS);
    }

}
