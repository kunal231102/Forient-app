# FORIENT - Forex Price Prediction App

## 📌 Overview
FORIENT is an Android application that predicts **forex prices** for the next day using a **machine learning model (LSTM)**. The app provides an intuitive interface for users to log in, access past forex data, and generate predictions. The predictions are powered by a **TensorFlow Lite LSTM model**, making real-time forex forecasting efficient and accessible.

## ✨ Features
- **User Authentication**: Secure **login and signup system** with SQLite database.
- **Forex Prediction**: Predict **tomorrow's forex price** using a deep learning model.
- **Machine Learning Model**: Implements a **Long Short-Term Memory (LSTM)** model converted to TensorFlow Lite.
- **Database Integration**: Stores user credentials securely in **SQLite**.
- **Progress Indicator**: Shows a loading animation while the model processes data.
- **Intuitive UI**: Clean and simple interface for easy navigation.

## 🏗 Tech Stack
- **Android Studio** (Java & XML)
- **SQLite** (User authentication & storage)
- **TensorFlow Lite** (Machine Learning model execution)
- **LSTM Model** (For time-series forex prediction)

## 📂 Folder Structure
```
Forient/
│-- app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/loginpage/
│   │   │   │   ├── MainActivity.java  # Login Page
│   │   │   │   ├── SignupActivity.java  # User Signup
│   │   │   │   ├── workspace.java  # Main Workspace
│   │   │   │   ├── usdclick.java  # Prediction Screen
│   │   │   │   ├── ForexPredictor.java  # ML Model Integration
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml  # Login UI
│   │   │   │   ├── activity_signup.xml  # Signup UI
│   │   │   │   ├── activity_workspace.xml  # Dashboard UI
│   │   │   ├── assets/
│   │   │   │   ├── forex_model.tflite  # Machine Learning Model
│   ├── AndroidManifest.xml  # App Configurations
```

## ⚡ How It Works
1. **User Signup/Login**: Users create an account and log in.
2. **Enter Forex Data**: The app fetches relevant forex data.
3. **Run Prediction**: The LSTM model predicts the next day's price.
4. **Display Results**: The predicted price is shown on the screen.

## 🔧 Setup & Installation
1. **Clone the Repository**:
   ```sh
   git clone https://github.com/your-repo/forient.git
   cd forient
   ```
2. **Open in Android Studio**
3. **Add Dependencies** (in `build.gradle`):
   ```gradle
   implementation 'org.tensorflow:tensorflow-lite:2.9.0'
   implementation 'org.tensorflow:tensorflow-lite-select-tf-ops:2.9.0'
   ```
4. **Ensure `forex_model.tflite` is in the `assets/` folder**
5. **Run the App** on an Android emulator or physical device.

## 🛠 Troubleshooting
- If the model does not load, ensure **TensorFlow Lite dependencies** are installed.
- If login fails, verify that the **SQLite database** is working correctly.
- Check **Logcat** in Android Studio for debugging errors.

## 🎯 Future Enhancements
- **Real-time forex data integration**
- **Graphical visualization of predictions**
- **Support for multiple currency pairs**

## 📜 License
This project is open-source and available under the **MIT License**.

---
🚀 **Developed by [Your Name/Team]** - Bringing AI-powered forex predictions to mobile! 🚀

