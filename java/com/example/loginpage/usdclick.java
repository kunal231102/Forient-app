package com.example.loginpage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;

public class usdclick extends AppCompatActivity {
    private ForexPredictor forexPredictor;
    private TextView predictionTextView;
    private Button predictButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_usdclick);

        predictionTextView = findViewById(R.id.predictionText);
        predictButton = findViewById(R.id.predictButton);
        progressBar = findViewById(R.id.progressBar);

        // Ensure ProgressBar is hidden initially
        progressBar.setVisibility(View.GONE);

        predictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE); // Show loading indicator
                predictButton.setEnabled(false); // Disable button during prediction

                predictButton.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (forexPredictor != null) {
                            float[] inputData = new float[60]; // Replace with real past 60 days' prices
                            float predictedPrice = forexPredictor.predict(inputData);
                            predictionTextView.setText("Predicted Price: ₹" + predictedPrice);
                        } else {
                            predictionTextView.setText("Prediction failed. Model is unavailable.");
                        }

                        progressBar.setVisibility(View.GONE); // Hide ProgressBar after prediction
                        predictButton.setEnabled(true); // Re-enable button
                    }
                }, 2000); // Simulated delay of 2 seconds
                if (forexPredictor == null) {
                    predictionTextView.setText("Model is not loaded. Try restarting the app.");
                    return;
                }

            }
        });
        try {
            forexPredictor = new ForexPredictor(this);
        } catch (IOException e) {
            e.printStackTrace();
            forexPredictor = null;
            predictionTextView.setText("Error loading model");
            return;
        }
    }
}