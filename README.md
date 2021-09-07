# INDY Tests
This small project contains several simple tests for Indy blog page.

# Run tests:
### To run tests locally use next command:
```bash
gradle clean test
```

### To run tests remotely use next command:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

### To run tests and view the report use Jenkins:
#### Go to link below:
<a target="_blank" href="https://jenkins.autotests.cloud/job/INDY%20Tests/">INDY Tests Jenkins job</a>
#### Select "build with parameters" option and click "build" button:
![Jenkins](https://github.com/sheet-code-101/selenide-lesson-12/blob/master/Jenkins.png)

### After test run next report generates:
![Allure report](https://github.com/sheet-code-101/selenide-lesson-12/blob/master/Allure%20report.png)

### Also there will be a report in Telegram:
![Telegram report](https://github.com/sheet-code-101/selenide-lesson-12/blob/master/Telegram%20report.png)

### Selenoid preview
![Selenoid](https://github.com/sheet-code-101/selenide-lesson-12/blob/master/Selenoid.gif)
