
package Persistence;

import Model.Place;

public class DAOPlace {
    public static final int RECORD_NULL = -1;
    public static final int RECORD_SIZE=37;
    public static final int NAME_LENGHT=20;
    public static final int ABREVIATE_LENGHT=4;
    private int code;   // 4
    private byte level;// 1
    private byte[] name; //20
    private byte[] abreviate; //4
    private long codeParent; //8
    
    public DAOPlace(){}

    public DAOPlace(int code, byte level, String name, String abreviate, Place parent) {
        this.code = code;
        this.level = level;
        this.name=this.stringToArray(name,NAME_LENGHT);
        this.abreviate=this.stringToArray(abreviate,ABREVIATE_LENGHT);
        this.codeParent = (parent==null)?RECORD_NULL:parent.getfullCode();
    }
    
    public DAOPlace(Place place) {
        this.code =place.getCode();
        this.level =place.getLevel();
        this.name=this.stringToArray(place.getName(),NAME_LENGHT);
        this.abreviate=this.stringToArray(place.getAbreviate(),ABREVIATE_LENGHT);
        this.codeParent = (place.getParent()==null)?RECORD_NULL:place.getParent().getfullCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public long getCodeParent() {
        return codeParent;
    }

    public void setCodeParent(long codeParent) {
        this.codeParent = codeParent;
    }
    
    public void setName(String name){
        this.name =this.stringToArray(name, NAME_LENGHT);
    }

    public void setAbreviate(String abreviate){
        this.abreviate=this.stringToArray(abreviate,ABREVIATE_LENGHT);
    }    
    
    public byte[] stringToArray(String string,int size){
        byte[] array=new byte[size];
        for (int i = 0; i <Math.min(string.length(),size) ; i++) {
            array[i]= (byte)string.charAt(i);
        }
        return array;
    }
    
    private String arrayToString(byte[] array,int size){
        String string="";
        for (int i = 0; i < size; i++) {
            string+= (char)array[i];
        }
        return string;
    }

    public String getStringName(){ 
        return arrayToString(this.name, NAME_LENGHT);
    }

    public String getStringAbreviate(){
        return arrayToString(this.abreviate,ABREVIATE_LENGHT);
    }
    
    public byte[] getName(){ 
       return this.name;
    }

    public byte[] getAbreviate(){
        return this.abreviate;
    }
    
   public void setName(byte[] name) {
	   this.name = name;
   }
   
   public void setAbreviate(byte[] name) {
	   this.abreviate = name;
   }

    public DAOPlace PlaceToBin(Place place){
        return null;// new DAOPlace(place.getCode(), place.getLevel(),place.getName(), place.getAbreviate(), codeParent);
    }
    
    public Place BintoPlace(){
        return new Place(this.code, this.level, this.getStringName(), this.getStringAbreviate(), null);
    }

}
