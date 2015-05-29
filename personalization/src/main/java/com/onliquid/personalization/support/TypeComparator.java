package com.onliquid.personalization.support;

import java.util.Comparator;


public class TypeComparator implements Comparator {

    private String mOrder;

    public TypeComparator(String s) {
        mOrder = s;
    }

    public int compare(Item item, Item item1) {
        if (item.getType().equals(mOrder)) {
            return -1;
        }
        return !item1.getType().equals(mOrder) ? 0 : 1;
    }

    public int compare(Object obj, Object obj1) {
        return compare((Item) obj, (Item) obj1);
    }
}
