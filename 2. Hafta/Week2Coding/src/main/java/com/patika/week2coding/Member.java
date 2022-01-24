package com.patika.week2coding;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Member {
    private String nameSurname;
    private Integer memberId;
    private WatchList watchList;
}
