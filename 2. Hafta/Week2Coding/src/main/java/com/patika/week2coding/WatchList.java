package com.patika.week2coding;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class WatchList {
    private Integer watchListId;
    private String name;
    private List<Movie> movieListToWatch;

}
