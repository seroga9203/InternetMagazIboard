package service;

import dao.ItemDAO;
import entity.Item;
import org.springframework.web.servlet.ModelAndView;
import spring.SpringContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

public class MainControllerService {

    public ModelAndView controlMainService(HttpServletRequest req) {
        ItemDAO idao = (ItemDAO) SpringContextHolder.getContext().getBean("idao");
        TopItemListRandomizer listRandom = (TopItemListRandomizer) SpringContextHolder.getContext().getBean("randomlist");
        ModelAndView mw;
        List<Item> topItems = listRandom.getRandomTopItems();
        List<Item> items = idao.get();
        Collections.shuffle(items);
        mw = new ModelAndView("main", "displayitem", items);
        if (topItems != null) {
            mw.addObject("topItems", topItems);
        }
        return mw;
    }
}
