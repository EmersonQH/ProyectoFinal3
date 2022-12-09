package com.example.proyectofinal1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyectofinal1.View.CallFragment;

import java.util.ArrayList;
import java.util.List;


public class BarFragment extends Fragment {
    
    Button btnLogin,btnRegistro;
    EditText etUserName, etPassword;
    CallFragment callFragment;
    private DBHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bar,container,false);
        dbHelper =new DBHelper(getContext());
        dbHelper.OpenDB();

        List<String> horizontal = new ArrayList<String>();
        horizontal.add("Enero");
        horizontal.add("Febrero");
        horizontal.add("Marzo");
        horizontal.add("Abril");
        horizontal.add("Mayo");
        horizontal.add("Junio");
        horizontal.add("Julio");

        List<Integer> vertical = new ArrayList<Integer>();
        vertical.add(60);
        vertical.add(20);
        vertical.add(65);
        vertical.add(40);
        vertical.add(55);
        vertical.add(30);
        vertical.add(5);

        ViewBarChart grafico = view.findViewById(R.id.grafico);
        grafico.setDatos(horizontal,vertical);

        return  view;
    }
    public void setCallFragment (CallFragment callFragment){
        this.callFragment = callFragment;
    }

    public Boolean validateEmail(){
        String value = etUserName.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(value.isEmpty()){
            etUserName.setError("Rellene el campo vacio");
            return false;
        }else if(!value.matches(emailPattern)) {
            etUserName.setError("Correo electronico invalido");
            return false;
        }else{
            etUserName.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String value = etPassword.getText().toString();
        String passwordPattern = "^"+
                "(?=.*[a-zA-Z0-9])" +   //cualquier caracter
                "(?=\\s+$)" +           //sin espacios en blanco
                ".{4,}" +               //mas de 4 caracteres
                "$";

        if(value.isEmpty()){
            etPassword.setError("Rellene el campo vacio");
            return false;
        }
        //else if(!value.matches(passwordPattern)) {
          //  etPassword.setError("contraseña invalido");
            //etPassword.requestFocus();
            //return false;
        //}
        else{
            etPassword.setError(null);
            return true;
        }
    }

}