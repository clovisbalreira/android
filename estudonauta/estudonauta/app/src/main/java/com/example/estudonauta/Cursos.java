package com.example.estudonauta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Cursos extends AppCompatActivity {

    Intent nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
    }

    public void clickCursosVoltar(View view) {
        finish();
    }

    public void clickCurAndroid(View view) {
        nav = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.estudonauta.com/"));
        startActivity(nav);
    }

    public void clickCurKotlin(View view) {
        nav = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.estudonauta.com/"));
        startActivity(nav);
    }

    public void clickCurC(View view) {
        nav = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.estudonauta.com/"));
        startActivity(nav);
    }

    public void clickCurCSharp(View view) {
        nav = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.estudonauta.com/"));
        startActivity(nav);
    }

    public void clickCurPhp(View view) {
        nav = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.estudonauta.com/"));
        startActivity(nav);
    }

    public void clickCurPortugol(View view) {
        nav = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.estudonauta.com/"));
        startActivity(nav);
    }

    public void clickCurCursoVideo(View view) {
        nav = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.estudonauta.com/"));
        startActivity(nav);
    }
}