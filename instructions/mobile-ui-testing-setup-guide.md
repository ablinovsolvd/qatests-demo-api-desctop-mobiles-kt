# Mobile UI Testing Setup Guide (Android)

Detailed step-by-step instructions for installing and configuring Appium Server, Appium Inspector, Node.js, Android Studio, and launching your own Android app (.apk) in the emulator.

---

## 1. Install Node.js (Required for Appium CLI)

Appium runs as a Node.js application.
- Download Node.js here: [https://nodejs.org/en/download/](https://nodejs.org/en/download/)
- Choose the LTS version for your OS (Windows/macOS/Linux) and install it.
- To verify, open a terminal and run:
  ```bash
  node -v
  ```
  Should output the version (e.g., v18.17.1).

---

## 2. Install Appium Server (CLI Version)

You’ll need at least Appium 2.x (your preferred version: **2.12.1**).

- In the terminal, run:
  ```bash
  npm install -g appium
  ```
- To check the installed version:
  ```bash
  appium --version
  ```
  Output should be: **2.12.1**

- To start the server, simply run:
  ```bash
  appium
  ```
- By default, Appium will run on `http://localhost:4723`

**Docs:**
- [Appium CLI Getting Started Guide](https://appium.io/docs/en/quickstart/quickstart/)

---

## 3. Install Appium Inspector

Appium Inspector is a desktop application that connects to Appium and helps you inspect and locate elements in your app.

- Download the latest version here:  
  [https://github.com/appium/appium-inspector/releases](https://github.com/appium/appium-inspector/releases)
- Your reference version: **App Version: 2024.9.1**

- Install it as a regular app (follow platform instructions).
- Launch Appium Inspector and configure it to connect to your running Appium Server at `http://localhost:4723`.

**Docs:**
- [Appium Inspector Documentation](https://docs.appium.io/docs/en/inspector/overview/)

---

## 4. Install Android Studio and Create an Emulator

Android Studio is needed for emulator creation and .apk installation.

- Download Android Studio here:  
  [https://developer.android.com/studio](https://developer.android.com/studio)
- Install for your OS (Windows/macOS/Linux).

### Create an Emulator:

1. Open Android Studio.
2. Go to `Tools` → `Device Manager` (or `AVD Manager`).
3. Click "Create Device" and select a model (e.g., Pixel 9).
4. Download and install a system image (API level, e.g., 15, or recommended).
5. Finish and launch your virtual device (emulator).

---

## 5. Installing Your APK on the Emulator

Assuming you already have the `.apk` file for your Android app.

**Method A — Drag & Drop:**

- When the emulator is running, simply drag the `.apk` file from your desktop and drop it onto the emulator window.
- The app should install automatically.

**Method B — Using Terminal (adb):**

1. Locate your Android SDK `platform-tools` directory (`adb` is here).
2. In your terminal, run:
   ```bash
   adb install /path/to/your/app.apk
   ```
   Replace `/path/to/your/app.apk` with the actual path.

---

## 6. Connect Appium Inspector to Your Emulator/App

- Start Appium Server (from step 2).
- Open Appium Inspector, enter your desired capabilities. Example:

```json
{
  "platformName": "Android",
  "appium:platformVersion": "15",
  "appium:deviceName": "Pixel 9",
  "appium:automationName": "UIAutomator2",
  "appium:appPackage": "com.swaglabsmobileapp",
  "appium:appActivity": "com.swaglabsmobileapp.SplashActivity",
  "appium:noReset": true
}
```
- Replace `deviceName`, `platformVersion`, etc. with your emulator's settings and `.apk` details.
- Click "Start Session" in Inspector.

---

## 7. Troubleshooting Notes

- **Appium does not start?**  
  Make sure Node.js and appium are installed and up to date. Restart terminal after `npm install`.
- **Emulator does not appear in Appium Inspector?**  
  Ensure the emulator is running and unlocked before starting the Inspector session.
- **Cannot install APK?**  
  Check that your emulator is running Google Play (for some apps), or use adb to install.
- **Appium Inspector fails to start session?**  
  Verify Appium Server is running at `localhost:4723` and your desired capabilities match your app/emulator.

---

## Recommended Version Recap

- **Appium Server:** 2.12.1
- **Appium Inspector:** 2024.9.1
- **Android Studio:** Latest recommended version

---

By following this guide, you’ll have a working local environment for Android UI automation with Appium, Inspector, and your custom app. Ready to start writing tests!

---
