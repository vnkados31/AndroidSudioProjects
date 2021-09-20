package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int pointsA=0;
    int pointsB=0;
    int faula=0;
    int faulb=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void freethrowA(View view) {
        pointsA=pointsA+1;
         displayForTeamA(pointsA);
    }

    public void twopointerA(View view) {
        pointsA=pointsA+2;
         displayForTeamA(pointsA);
    }

    public void threepointerA(View view) {
        pointsA=pointsA+3;
        displayForTeamA(pointsA);
    }
    public void freethrowB(View view) {
        pointsB=pointsB+1;
        displayForTeamB(pointsB);
    }

    public void twopointerB(View view) {
        pointsB=pointsB+2;
        displayForTeamB(pointsB);
    }

    public void threepointerB(View view) {
        pointsB=pointsB+3;
        displayForTeamB(pointsB);
    }
    public void ResetAB(View view) {
        pointsA=0;
        pointsB=0;
        faula=0;
        faulb=0;
        displayForTeamA(pointsA);
        displayForTeamB(pointsB);
        displayForfaulA(faula);
        displayForfaulB(faulb);
    }

    public void faulA(View view) {
        faula=faula+1;
        displayForfaulA(faula);
    }

    public void faulB(View view) {
        faulb=faulb+1;
        displayForfaulB(faulb);
    }

    public void undoA(View view) {
        pointsA=pointsA-1;
        displayForTeamA(pointsA);
    }

    public void undoB(View view) {
        pointsB=pointsB-1;
        displayForTeamB(pointsB);
    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayForTeamA(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.points_text_viewA);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayForTeamB(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.points_text_viewB);
        quantityTextView.setText("" + number);
    }

    private void displayForfaulA(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.faula);
        quantityTextView.setText("" + number);
    }

    private void displayForfaulB(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.faulb);
        quantityTextView.setText("" + number);
    }
}