package cl.gencina.passchecker.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import cl.gencina.passchecker.databinding.ActivityMainBinding;
import cl.gencina.passchecker.interfaces.CheckPassInterface;
import cl.gencina.passchecker.presentador.CheckPassPresenter;

public class MainActivity extends AppCompatActivity implements CheckPassInterface {
    private ActivityMainBinding binding;
    private CheckPassPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        presenter = new CheckPassPresenter(this);

        setContentView(binding.getRoot());

        binding.etvPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // cuando este cambiando
                presenter.checkPass(s.toString());
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //despues de haebr escrito
            }
            @Override
            public void afterTextChanged(Editable s) {
                //antes de escribir
            }
        });
    }

    @Override
    public void showPassHigh(){
        binding.tvResult.setText("Seguridad correcta");
        binding.tvColor.setBackgroundColor(Color.GREEN);
    }
    @Override
    public void showPassMedium(){
        binding.tvResult.setText("Seguridad aceptable");
        binding.tvColor.setBackgroundColor(Color.YELLOW);
    }
    @Override
    public void showPassLow(){
        binding.tvResult.setText("Seguridad débil");
        binding.tvColor.setBackgroundColor(Color.RED);
    }

    @Override
    public void showError() {
        binding.tvResult.setText("Error");
        binding.tvColor.setBackgroundColor(Color.WHITE);
    }

}