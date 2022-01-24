package com.patika.week2coding;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

    MovieController m = new MovieController();
    @PostMapping("/createmember")
    @ResponseStatus(HttpStatus.CREATED)
    public Member CREATE_MEMBER(){

        Member b=  Member.builder()
                        .nameSurname("Burak Dirlik")
                        .memberId(225)
                        .build();
        m.getL().getMemberList().add(b);
        return b;
    }

    @GetMapping("/getmembers")
    public ArrayList <Member> GET_MEMBERS(){
        return m.getL().getMemberList();
    }

    @GetMapping("/getmembers/{memberId}")
    public Member GET_MEMBERS(@PathVariable Integer memberId){

        for (Integer i=0; i< m.getL().getMemberList().size(); i++)
            if (m.getL().getMemberList().get(i).getMemberId().equals(memberId))
                memberId = i;
        return m.getL().getMemberList().get(memberId);

    }

    @PostMapping("/memberId/{memberId}/watchListName/{watchListName}")
    public String createWatchList(@PathVariable Integer memberId, @PathVariable String watchListName ){
        WatchList w = WatchList.builder()
                .name(watchListName)
                .watchListId( (int)(Math.random()*100000))
                .movieListToWatch(List.of(
                        Movie.builder()
                                .build()
                ))
                .build();
        m.getL().getWatchListArrayList().add(w);

        for (int i=0; i< m.getL().getMemberList().size(); i++){
            if (m.getL().getMemberList().get(i).getMemberId().equals(memberId)){
                m.getL().getMemberList().get(i).setWatchList(w); ;
            }
        }

        return "Member Id" + memberId  + " "+ w.toString();

    }

    @PostMapping("/addMovieToWatchList/{memberId}/{watchListId}/{movieId}")
    public String addMovieToWatchList(@PathVariable Integer memberId, @PathVariable Integer watchListId, @PathVariable Integer movieId){

        for (int i=0; i< m.getL().getMemberList().size(); i++){
            if (m.getL().getMemberList().get(i).getMemberId().equals(memberId)){
                memberId = i;
            }
        }
        Member givenmember = m.getL().getMemberList().get(memberId);


        for (int i=0; i< m.getL().getWatchListArrayList().size(); i++){
            if (m.getL().getWatchListArrayList().get(i).getWatchListId().equals(watchListId));
            watchListId = i;
        }
        WatchList givenwatchlist = m.getL().getWatchListArrayList().get(watchListId);


        for (int i=0; i< m.getL().getFilmlist().size(); i++){
            if (m.getL().getFilmlist().get(i).getMovieId().equals(movieId)){
                movieId = i;
            }
        }
        Movie givenmovie = m.getL().getFilmlist().get(movieId);

        givenmember.setWatchList(givenwatchlist);
        givenmember.getWatchList().getMovieListToWatch().add(givenmovie);

        return givenmember.getWatchList().getMovieListToWatch().toString();

    }

    @PostMapping("rateMovie/{memberid}/{movieid}/{point}")
    public void rateMovie(){

    }


}
