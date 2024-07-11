package com.example.firstprojectbmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //variable declaration
        TextView txtResult;
        EditText edtweight,edtHeightft,edtHeightIn;
        Button btnCal;
        LinearLayout llmain;
        //initialisation
        edtweight = findViewById(R.id.edtWeight);
        edtHeightft = findViewById(R.id.edtHeightFt);
        edtHeightIn =findViewById(R.id.edtHeightIn);
        txtResult = findViewById(R.id.txtresult);
        btnCal= findViewById(R.id.btnCal);
        llmain= findViewById(R.id.llmain);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(edtweight.getText().toString());
                int hft=Integer.parseInt(edtHeightft.getText().toString());
                int hin=Integer.parseInt(edtHeightIn.getText().toString());
                int totalin=hft*12+hin;
                double totalcm= totalin*2.53;
                double  totalM=totalcm/100;
                double bmi= wt/(totalM*totalM);
                if(bmi>25){
                    txtResult.setText("You are Overweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if(bmi<18){
                    txtResult.setText("You are Underweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else{
                    txtResult.setText("You are healthy");
                    llmain.setBackgroundColor(getResources().getColor(R.color.green));
                }
                
            }
        });









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.llmain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}