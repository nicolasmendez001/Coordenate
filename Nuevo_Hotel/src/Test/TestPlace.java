/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Model.Place;


public class TestPlace {
    
    public static void main(String[] args) {
     Place place0=new Place(57,(byte)1,"Colombia","COL",null);
     Place place1 =new Place(001,(byte)3,"Tunja","TUN",null);
     Place place2=new Place(15,(byte)2,"Boyaca","BY",place0);
     place1.setParent(place2);
        System.out.println(place0.getfullCode());
        System.out.println(place1.getfullCode());
        System.out.println(place2.getfullCode());
             }
}
