# Experimental project with Android UI autotests configured by "Owner" library

## Stack:
- Appium (Java)
- Browserstack
- Selenium (Java)
- Gradle
- JUnit 5
- Owner

Run on emulator:
```
gradle clean test -DdeviceHost=emulator
```

Run on real device:
```
gradle clean test -DdeviceHost=real-device
```

Run on BrowserStack device:
```
gradle clean test -DdeviceHost=browserstack
```
