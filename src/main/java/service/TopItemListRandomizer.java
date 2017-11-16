package service;

import dao.ItemDAO;
import entity.Item;
import spring.SpringContextHolder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TopItemListRandomizer {

    public List<Item> getRandomTopItems() {
        ItemDAO idao = (ItemDAO) SpringContextHolder.getContext().getBean("idao");
        List<Item> list = idao.getItemByIsTop();
        List<Item> topList = null;

        if (list != null) {
            topList = new LinkedList<>(list);
            Collections.shuffle(topList,new Random());
        }
        List<Item> out = new LinkedList<>();
        for(int i = 0; i < 3; i++){
            if(topList.size()>i){
                out.add(topList.get(i));
            }else{
                break;
            }
        }

        return out;
    }

    public List<Item> getRandomTopItemsByNameAndCat(String name, String cat) {
        ItemDAO idao = (ItemDAO) SpringContextHolder.getContext().getBean("idao");
        List<Item> list = idao.getItemByCategoryAndNameAndTop(name, cat);
        List<Item> topList = null;

        if (list != null) {
            topList = new LinkedList<>(list);
            Collections.shuffle(topList,new Random());
        }
        List<Item> out = new LinkedList<>();
        for(int i = 0; i < 3; i++){
            if(topList.size()>i){
                out.add(topList.get(i));
            }else{
                break;
            }
        }

        return out;
    }
    public List<Item> getRandomTopItemsByCat(String cat) {
        ItemDAO idao = (ItemDAO) SpringContextHolder.getContext().getBean("idao");
        List<Item> list = idao.getItemByCategoryAndTop(cat);
        List<Item> topList = null;

        if (list != null) {
            topList = new LinkedList<>(list);
            Collections.shuffle(topList,new Random());
        }
        List<Item> out = new LinkedList<>();
        for(int i = 0; i < 3; i++){
            if(topList.size()>i){
                out.add(topList.get(i));
            }else{
                break;
            }
        }

        return out;
    }

    public List<Item> getRandomTopItemsByName(String name) {
        ItemDAO idao = (ItemDAO) SpringContextHolder.getContext().getBean("idao");
        List<Item> list = idao.getItemByNameAndTop(name);
        List<Item> topList = null;

        if (list != null) {
            topList = new LinkedList<>(list);
            Collections.shuffle(topList,new Random());
        }
        List<Item> out = new LinkedList<>();
        for(int i = 0; i < 3; i++){
            if(topList.size()>i){
                out.add(topList.get(i));
            }else{
                break;
            }
        }

        return out;
    }
}
