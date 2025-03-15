package com.example.loginpage;

import android.content.Context;
import org.tensorflow.lite.Interpreter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ForexPredictor {
    private Interpreter interpreter;

    // Constructor to load the model
    public ForexPredictor(Context context) throws IOException {
        interpreter = new Interpreter(loadModelFile(context));
    }

    private MappedByteBuffer loadModelFile(Context context) throws IOException {
        File file = new File(context.getFilesDir(), "forex_model.tflite");
        FileInputStream fis = new FileInputStream(file);
        FileChannel fileChannel = fis.getChannel();
        long startOffset = 0;
        long declaredLength = file.length();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    // Method to predict next day price
    public float predict(float[] inputData) {
        float[][] outputData = new float[1][1]; // Model output
        ByteBuffer inputBuffer = ByteBuffer.allocateDirect(60 * 4); // 60 time steps, 4 bytes per float
        inputBuffer.order(ByteOrder.nativeOrder());

        for (float val : inputData) {
            inputBuffer.putFloat(val);
        }

        interpreter.run(inputBuffer, outputData);
        return outputData[0][0]; // Return predicted value
    }
}
