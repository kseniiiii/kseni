package com.company;
import java.util.ArrayList;

public class Insurance extends Obligation {
    private final ArrayList<Obligation> list = new ArrayList<>();
    public ArrayList<Obligation> getList() {
        return list;
    }
}
