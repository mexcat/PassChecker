package cl.gencina.passchecker.presentador;


import cl.gencina.passchecker.interfaces.CheckPassInterface;
import cl.gencina.passchecker.modelo.CheckPassModel;

public class CheckPassPresenter {
    private CheckPassModel modelo;
    private CheckPassInterface interfaced;

    public CheckPassPresenter(CheckPassInterface interfaced) {
        this.interfaced = interfaced;
        modelo = new CheckPassModel();
    }


    public void checkPass(String pass){
        int nivel = modelo.validarPass(pass);

        switch(nivel){
            case CheckPassModel.DEBIL :
                this.interfaced.showPassLow();
                break;
            case CheckPassModel.MEDIA:
                this.interfaced.showPassMedium();
                break;
            case CheckPassModel.FUERTE:
                this.interfaced.showPassHigh();
                break;
            default:
                this.interfaced.showError();
                break;
        }

    }
}
