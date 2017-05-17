package Test;

import Persistence.FilePlace;
import Model.Place;

public class TestFilePlace {
    public static void main(String[] args) {
     Place place0=new Place(57,(byte)1,"Colombia","COL",null);
     Place place1 =new Place(001,(byte)3,"Tunja","TUN",null);
     Place place2=new Place(15,(byte)2,"Boyaca","BY",place0);
     place1.setParent(place2);
     Place place3 =new Place(002,(byte)3,"Duitama","DU",place0);
     
     FilePlace filePlace = new FilePlace("C:/Users/Mendez/Desktop/Programacion/Programacion II/Hotel-Nuevo/src/Doc/municipiosOrde.bin");
//     filePlace.open("rw");
//     filePlace.save(place0, 0);
//     filePlace.save(place1, 1);
//     filePlace.save(place2, 2);
//     filePlace.save(place3, 3);
//     filePlace.close();
//      //leer ...
//     //filePlace.sort();
     //filePlace.shell();
     filePlace.sortShell();
     filePlace.open("r");
     Place place;
     for (int i = 0; i < 2000; i++) {
        place = filePlace.load(i);
         System.out.println("Registro : "+i);
         System.out.println("Codigo : "+place.getCode());
         System.out.println("Nivel : "+place.getLevel());
         System.out.println("Nombre : "+place.getName());
         System.out.println("Abreviado : "+place.getAbreviate());
         System.out.println("Parent  : "+place.getParent());
         //System.out.println("codigo completo  : "+place.getfullCode());
     }
     filePlace.close();
    }
    
}
