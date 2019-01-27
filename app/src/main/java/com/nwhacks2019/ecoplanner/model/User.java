package com.nwhacks2019.ecoplanner.model;
import java.util.HashSet;

public class User {
    private int id;
    private HashSet<Goal> goals;

    public User(int id){
        this.id = id;
    }

    public void setGoal(Goal g){
        this.goals.add(g);
    }

    public void cancelGoal(Goal g){
        this.goals.remove(g);
    }

    @Override
    public boolean equals(Object o){
        // null check
        if (o == null) {
            return false;
        }

        if (this == o){
            return true;
        }

        return (o instanceof User) && ((User) o).id == this.id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
