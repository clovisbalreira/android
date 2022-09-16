package com.example.comissao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Vendedor vendedor = new Vendedor();
    EditText nome, meta, valor;
    TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.nomeEditText);
        meta = findViewById(R.id.metaEditText);
        valor = findViewById(R.id.valorVendidoEditText);
        resposta = findViewById(R.id.respostaTextView);
    }

    public void calcular(View view) {
        if(nome.getText().toString().isEmpty() || meta.getText().toString().isEmpty() || valor.getText().toString().isEmpty()){
            Toast.makeText(this,"Preencha os campos",Toast.LENGTH_LONG);
        }else{
            vendedor.setNome(nome.getText().toString());
            vendedor.setMeta(Double.parseDouble(meta.getText().toString()));
            resposta.setText(vendedor.toString() + "\nValor vendido: R$ " + valor.getText().toString() + "\nComissão: R$ " + vendedor.calcularComissao(Double.parseDouble(valor.getText().toString())));
        }
    }
}