package com.example.associacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Horoscopo horoscopo;
    EditText nome, dia, mes, ano;
    TextView resposta, hoje;
    SimpleDateFormat diaFormatado = new SimpleDateFormat("dd");
    String diaAgora = diaFormatado.format(new Date());
    SimpleDateFormat mesFormatado = new SimpleDateFormat("MM");
    String mesAgora = mesFormatado.format(new Date());
    SimpleDateFormat anoFormatado = new SimpleDateFormat("yyyy");
    String anoAgora = anoFormatado.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.edtNome);
        dia = findViewById(R.id.edtDia);
        mes = findViewById(R.id.edtMes);
        ano = findViewById(R.id.edtAno);
        resposta = findViewById(R.id.txtResposta);
        hoje = findViewById(R.id.txtHoje);
        horoscopo = new Horoscopo();
        hoje.setText(diaAgora + " / " + mesAgora + " / " + anoAgora);
    }

    public void verificarCampo(EditText campo){
        if(campo.getText().toString().isEmpty()){
            campo.setError("Campo vazio");
        }
    }

    public void mostrarSigno(View view) {
        if(nome.getText().toString().isEmpty() || dia.getText().toString().isEmpty() || mes.getText().toString().isEmpty() || ano.getText().toString().isEmpty()){
            verificarCampo(nome);
            verificarCampo(dia);
            verificarCampo(mes);
            verificarCampo(ano);
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }else{
            horoscopo.getDataAtual().setDia(Byte.parseByte(diaAgora));
            horoscopo.getDataAtual().setMes(Byte.parseByte(mesAgora));
            horoscopo.getDataAtual().setAno(Integer.parseInt(anoAgora));
            horoscopo.getPessoa().setNome(nome.getText().toString());
            horoscopo.getPessoa().getDataNascimento().setDia(Byte.parseByte(dia.getText().toString()));
            horoscopo.getPessoa().getDataNascimento().setMes(Byte.parseByte(mes.getText().toString()));
            horoscopo.getPessoa().getDataNascimento().setAno(Integer.parseInt(ano.getText().toString()));
            resposta.setText(horoscopo.toString());
        }
    }
}