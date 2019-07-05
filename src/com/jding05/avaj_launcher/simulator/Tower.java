package com.jding05.avaj_launcher.simulator;

import com.jding05.avaj_launcher.aircraft.Flyable;
import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if (observers.contains(flyable)) {
            return ;
        }
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        if (!observers.contains(flayable)) {
            return ;
        }
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditons();
        }
    }
}
