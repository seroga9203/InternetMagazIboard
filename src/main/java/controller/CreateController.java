package controller;

import dao.ItemDAO;
import entity.Item;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import objectEntity.UserObject;
import service.CreateControllerService;

@Controller
public class CreateController {

    @RequestMapping("/create.html")
    public ModelAndView create(HttpServletRequest req) {

        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        UserObject uo = new UserObject(login);
//получаем даннык юзера вызовом конструктора класса-обертки

        String name = req.getParameter("name");
        String pic = req.getParameter("pic");
        String cat = req.getParameter("cat");
        String city = uo.getCity(); //получаем город залогиненого юзера
        String phone = uo.getPhone();//получаем тел залогиненого юзера
        String about = req.getParameter("about");
        int price = 0;//инициализируем прайс 

        CreateControllerService ccs = new CreateControllerService();
//        if (name != null && pic != null && about != null) {
            HashMap< String, Integer> hashMap = ccs.CheckFields(name, pic, price, about);
//        }

        try {
            price = Integer.parseInt(req.getParameter("price")); //получаем цену, при этом приобразовывая ее в число
        } catch (NumberFormatException e) {
            System.out.println("Поле прайса введено не число");

        }
        if (name != null
                && city != null
                && phone != null
                && pic != null
                && cat != null
                && about != null) {

            ItemDAO itemDAO = (ItemDAO) spring.SpringContextHolder.getContext().getBean("idao");
            Item createNewItem = new Item(new Random().nextInt(),
                    name, pic, cat, price, about,
                    new Date(), city, phone,
                    (String) session.getAttribute("login"), 0);

            itemDAO.addItem(createNewItem);

            return new ModelAndView("item", "displayitem", createNewItem);

        }

        req.setAttribute("map", hashMap);
        return new ModelAndView("create");
    }
}
