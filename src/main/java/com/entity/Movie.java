package com.entity;

/**
* @author Administrator
* @date 2019��8��22��
* @version 1.0
*/
public class Movie {   //����һ����Ӱ��
    private Integer id;//��Ӱ���

    private String name;//��Ӱ����

    private Double score;//��Ӱ����

    private String dorector;//����

    private String actor;//����

    private String type;//����

    private String area;//����/����

    private String language;//����

    private Integer duration;//ʱ��

    private String plot;//����

    private String showtime;//��ӳʱ��
    
    private String img;//ͼƬ·��
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDorector() {
        return dorector;
    }

    public void setDorector(String dorector) {
        this.dorector = dorector == null ? null : dorector.trim();
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor == null ? null : actor.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot == null ? null : plot.trim();
    }
    
    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime == null ? null : showtime.trim();
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}