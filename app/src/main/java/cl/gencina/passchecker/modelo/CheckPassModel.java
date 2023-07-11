package cl.gencina.passchecker.modelo;

//modelo tiene toda la logica

public class CheckPassModel {

    public static final int DEBIL = 0;
    public static final int MEDIA = 1;
    public static final int FUERTE = 2;


    public int validarPass(String pass){
        if(pass.length() < 5){
            return DEBIL;
        } else if(pass.equals(pass.toLowerCase())){
            return MEDIA;
        }else{
            return FUERTE;
        }
    }

}
