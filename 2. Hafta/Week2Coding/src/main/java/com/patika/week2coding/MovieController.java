package com.patika.week2coding;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {


    @Getter
    @Setter
    Library l=new Library();

    @PostMapping("/CREATE")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie CREATE_MOVIE(){


        Movie o=  Movie.builder()
                        .name("Spiderman")
                        .genre(Genre.ACTION)
                        .releaseYear(2002)
                        .director("Sam RAIMI")
                        .cast(List.of(
                                Actor.builder()
                                        .nameSurname("Tomay Maguire")
                                        .build()
                                     )
                             )
                        .movieId(1001)
                        .point(7)
                        .build();

        Movie o2 = Movie.builder()
                        .name("Dont look up")
                        .genre(Genre.ACTION)
                        .releaseYear(2021)
                        .director("Adam McKay")
                        .cast(List.of(
                                Actor.builder()
                                        .nameSurname("Leonardo Di Caprio")
                                        .build()
                                        )
                                )
                        .movieId(1002)
                        .point(9)
                        .build();


        l.addfilem(o);
        l.addfilem(o2);


        return l.getFilmlist().get(1);


    }
    @GetMapping("/movie/{movieId}")
    public Movie GET_MOVIE_WITH_ID(@PathVariable Integer movieId){


        for (int i=0; i< l.getFilmlist().size(); i++)
            if (l.getFilmlist().get(i).getMovieId().equals(movieId))
                movieId =i;

        return l.getFilmlist().get(movieId);

    }

    @GetMapping("/allmovies")
    public ArrayList<Movie> GET_ALL_MOVIES(){

        return l.getFilmlist();
    }

    @DeleteMapping("delete/{movieId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Integer movieId){

        for (int i=0; i<l.getFilmlist().size();i++){
            if (l.getFilmlist().get(i).getMovieId().equals(movieId)){
                movieId = i;
            }
        }

        l.getFilmlist().remove(movieId);
    }

}
