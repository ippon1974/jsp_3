package ru.airconcept.service;

import ru.airconcept.model.ModelCart;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    // Список для хранения CarItem (элемент корзины)
    private List<ModelCart> list = new ArrayList<ModelCart> ();

    public List<ModelCart> list() {
        return list;
    }

    public void add(ModelCart modelCart) {
        this.list.add(modelCart);
    }

    public void remove(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                break;
            }
        }
    }







}
