package com.automation.Objs.holidays;

public class Event {
    String title;
    String date;
    String notes;
    boolean bunting;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isBunting() {
        return bunting;
    }

    public void setBunting(boolean bunting) {
        this.bunting = bunting;
    }
}
