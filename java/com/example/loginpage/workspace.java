package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class workspace extends AppCompatActivity {

    Button USDButton;
    Button EURButton;
    Button JPYButton;
    Button CADButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_workspace);

        USDButton= findViewById(R.id.USDButton);
        EURButton= findViewById(R.id.EURButton);
        JPYButton= findViewById(R.id.JPYButton);
        CADButton= findViewById(R.id.CADButton);

        USDButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(workspace.this, "Analysing...", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(workspace.this, usdclick.class);
                startActivity(intent);
            }
        });

    }
}