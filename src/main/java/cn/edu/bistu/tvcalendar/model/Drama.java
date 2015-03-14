package cn.edu.bistu.tvcalendar.model;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2015/3/14.
 */
public class Drama {
    private double updatatime;
    private int current;
    private int hadwatch;
    private Bitmap poster;
    private String director;
    private String[] roles;
    private String name;
    private Boolean iswatchthisdrama;
    private Boolean isfavorite = false;

    public Drama(String name , int hadwatch, int current, String director, String[] roles,Boolean isfavorite) {
        this.isfavorite = isfavorite;
        this.name = name;
        this.director = director;
        this.hadwatch = hadwatch;
        this.current = current;
        this.roles = roles;
    }

    public void setUpdatatime(double updatatime) {
        this.updatatime = updatatime;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setHadwatch(int hadwatch) {
        this.hadwatch = hadwatch;
    }

    public void setPoster(Bitmap poster) {
        this.poster = poster;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIswatchthisdrama(Boolean iswatchthisdrama) {
        this.iswatchthisdrama = iswatchthisdrama;
    }

    public void setIsfavorite(Boolean isfavorite) {
        this.isfavorite = isfavorite;
    }

    public Boolean getIsfavorite() {

        return isfavorite;
    }

    public double getUpdatatime() {
        return updatatime;
    }

    public int getCurrent() {
        return current;
    }

    public int getHadwatch() {
        return hadwatch;
    }

    public Bitmap getPoster() {
        return poster;
    }

    public String getDirector() {
        return director;
    }

    public String[] getRoles() {
        return roles;
    }

    public String getName() {
        return name;
    }

    public Boolean getIswatchthisdrama() {
        return iswatchthisdrama;
    }
}
