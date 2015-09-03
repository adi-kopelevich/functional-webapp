package sample.design.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kopelevi on 03/09/2015.
 */
public class NameContainer implements Iterator{

    private int index;

    List<String> nameContanier = new ArrayList<String>();

    public NameContainer(String ... names) {
        for(String name : names){
            this.nameContanier.add(name);
        }
    }

    @Override
    public boolean hasNext() {
        if(index < nameContanier.size()){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return nameContanier.get(index++);
    }
}
