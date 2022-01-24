package com.patika.week2coding;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder

public class Movie {

    private String name;
    private Genre genre;
    private Integer releaseYear;
    private String director;
    private List<Actor> cast;
    private  Integer movieId;
    private Integer point;


}
