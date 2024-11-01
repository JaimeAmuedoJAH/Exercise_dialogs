package com.jah.practica_dialog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btnEnglish, btnSpanish, btnFrench, btnPortuguese, btnStart;
    String[] arrRate, arrVariables;
    int[] selectedRb;
    boolean[] selectedCb;
    String str;
    AlertDialog.Builder dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initComponents();

        btnEnglish.setOnClickListener(view -> languageSelected(1));
        btnSpanish.setOnClickListener(view -> languageSelected(2));
        btnFrench.setOnClickListener(view -> languageSelected(3));
        btnPortuguese.setOnClickListener(view -> languageSelected(4));
        
        btnStart.setOnClickListener(view -> createDialogStart());
    }

    private void createDialogStart() {
        dialog = new AlertDialog.Builder(this);
        
        dialog.setCancelable(false)
                .setIcon(R.drawable.baseline_engineering_24)
                .setTitle(R.string.dialog_button_start_title)
                .setMessage(getString(R.string.dialog_button_start_message) + str)
                .setNegativeButton(R.string.dialog_button_start_negative, null)
                .setPositiveButton(R.string.dialog_button_start_positive, (dialogInterface, i) -> createSecondDialog())
                .create()
                .show();
    }

    private void createSecondDialog() {
        LinearLayout ly = new LinearLayout(this);
        ly.setOrientation(LinearLayout.VERTICAL);
        ly.setPadding(300, 15, 0, 0);
        TextView string = new TextView(this);
        string.setText(getString(R.string.second_dialog_string) + " = " + " ''" + "Text" + "''");
        TextView integer = new TextView(this);
        integer.setText(getString(R.string.second_dialog_int) + " = " + "3");
        TextView bolean = new TextView(this);
        bolean.setText(getString(R.string.second_dialog_boolean) + " = " + "true");
        
        ly.addView(string);
        ly.addView(integer);
        ly.addView(bolean);
        dialog = new AlertDialog.Builder(this);
        
        dialog.setCancelable(false)
                .setIcon(R.drawable.baseline_engineering_24)
                .setTitle(R.string.second_dialog_title)
                .setView(ly)
                .setPositiveButton(R.string._dialog_positive, (dialogInterface, i) -> createThirdDialog())
                .create()
                .show();
    }

    private void createThirdDialog() {
        dialog = new AlertDialog.Builder(this);

        dialog.setCancelable(false)
                .setIcon(R.drawable.baseline_question_mark_24)
                .setTitle(R.string.third_dialog_title)
                .setSingleChoiceItems(arrVariables, selectedRb[0], (dialogInterface, which) ->
                        selectedRb[0] = which)
                .setPositiveButton(R.string._dialog_positive, (dialogInterface, i) -> createFourthDialog())
                .create()
                .show();
    }

    private void createFourthDialog() {
        dialog = new AlertDialog.Builder(this);

        dialog.setCancelable(false)
                .setIcon(R.drawable.baseline_lightbulb_24)
                .setTitle(R.string.fourth_dialog_title)
                .setMessage(getString(R.string.fourth_dialog_message))
                .setPositiveButton(R.string._dialog_positive, (dialogInterface, i) -> createFifthDialog())
                .create()
                .show();
    }

    private void createFifthDialog() {
        dialog = new AlertDialog.Builder(this);

        dialog.setCancelable(false)
                .setIcon(R.drawable.baseline_child_care_24)
                .setTitle(R.string.fifth_dialog_title)
                .setMultiChoiceItems(arrRate, selectedCb, null)
                .setPositiveButton(R.string._dialog_positive, (dialogInterface, i) -> createSixthDialog())
                .create()
                .show();
    }

    private void createSixthDialog() {
        dialog = new AlertDialog.Builder(this);

        dialog.setCancelable(false)
                .setIcon(R.drawable.baseline_thumb_up_24)
                .setTitle(R.string.sixth_dialog_title)
                .setMessage(R.string.sixth_dialog_message)
                .setPositiveButton(R.string.sixth_dialog_positive, null)
                .create()
                .show();
    }

    private void languageSelected(int selected) {
        if(selected == 1){
            str = " English";
        }else if(selected == 2){
            str = " Español";
        }else if(selected == 3){
            str = " FRANÇAIS";
        }else{
            str = " PORTUGUÊS";
        }
        
    }

    private void initComponents() {
        btnEnglish = findViewById(R.id.btnEnglish);
        btnSpanish = findViewById(R.id.btnSpanish);
        btnFrench = findViewById(R.id.btnFrench);
        btnPortuguese = findViewById(R.id.btnPortuguese);
        btnStart = findViewById(R.id.btnStart);
        arrVariables= getResources().getStringArray(R.array.third_dialog_options);
        arrRate = new String[]{getString(R.string.fifth_dialog_option1), getString(R.string.fifth_dialog_option2), getString(R.string.fifth_dialog_option3)};
        selectedCb = new boolean[3];
        Arrays.fill(selectedCb, false);
        selectedRb = new int[]{-1};
    }
}
