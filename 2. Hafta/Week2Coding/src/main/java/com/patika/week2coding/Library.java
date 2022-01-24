package com.patika.week2coding;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Library {

    Movie movie;
    private ArrayList <Movie> filmlist = new ArrayList<>();
    Member member;
    private ArrayList<Member> memberList = new ArrayList<>();
    WatchList watchList;
    private ArrayList<WatchList> watchListArrayList = new ArrayList<>();

    public void addfilem(Movie m) {
        filmlist.add(m);
    }
}
