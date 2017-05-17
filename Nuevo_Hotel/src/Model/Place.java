
package Model;

public class Place {
    private int code;
    private byte level;;
    private String name;
    private String abreviate;
    private Place parent;

    public Place(int code, byte level, String name, String abreviate, Place parent) {
        this.code = code;
        this.level = level;
        this.name = name;
        this.abreviate = abreviate;
        this.parent = parent;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbreviate() {
        return abreviate;
    }

    public void setAbreviate(String abreviate) {
        this.abreviate = abreviate;
    }

    public Place getParent() {
        return parent;
    }

    public void setParent(Place parent) {
        this.parent = parent;
    }
    /**
     * gemera el codigo del lugar..
     * 1. 3 digitos pais
     * 2. 3 digitos depto
     * 3. digitos mun..3 digitos xnivel
     */
    
    public int getfullCode(){
        switch(level){
            case 1: return code;
            case 2: return parent.code*1000+code;
            case 3: return parent.parent.code*1000000+parent.code*1000+code;
            case 4: return parent.parent.parent.code*1000000000+parent.parent.code;
            default: return 0;
        }
    }
    public long getfullCodeMejorado(){
        long myCode=1;
        int pow=10;
        switch(level){
            case 1: myCode= code;
            case 2: myCode= parent.code*(pow*3)+code;
            case 3: myCode= parent.parent.code*(pow*6)+parent.code*(pow*3)+code;
            case 4: myCode= parent.parent.parent.code*(pow*9)+parent.parent.code;
            default: myCode= 0;
        }
        return myCode;
    }
    public long getFullCodeRepeticion(){
        long myCode=this.code;
        Place auxParent=this.parent;
        while(auxParent!=null){
            myCode=myCode+auxParent.code*(long)Math.pow(1000,this.level-auxParent.level);
        }
        return myCode;
    }
//    public long getfullCodeRecursive(byte level){
//        return code 
//    }
    
    
}
