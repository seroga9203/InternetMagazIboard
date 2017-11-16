package service;

import java.util.HashMap;

public class CreateControllerService {

    private String name;
    private String pic;
    private int price;
    private String about;

    private String ErrorName;
    private String ErrorPic;
    private String ErrorPrice;
    private String ErrorAbout;

    public HashMap< String, Integer> CheckFields(String name, String pic, int price, String about) {
        HashMap< String, Integer> hashMap = new HashMap<String, Integer>();
            if (name == null || name == "") {
                hashMap.put("Please enter name", 0);
            }
            if (pic == "" || pic == null) {
                hashMap.put("Please enter link of picture", 1);
            }
            if (price > 0) {
                hashMap.put("Please enter price", 2);
            }
            if (about == "" || about == null) {
                hashMap.put("Please enter about", 3);
            }
            return hashMap;
        }
    
}
