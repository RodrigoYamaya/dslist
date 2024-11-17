package com.RodriSolution.dslist.projections;

public interface GameMinProjection {
    long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}