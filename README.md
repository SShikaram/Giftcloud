# MostafDemo
This is seed project to start on-boarding new projects into MOSTAF

If you want to execute the project on your local machine run the next command

```
mvn -U clean test-compile failsafe:integration-test  -DenableSplunkForwarder=false -Dlog.location=./ -DmostestRootLogLevel=trace -DenableBfmReporting=false -Dtest.client=chrome -Denvironment=staging -Dtest.suite=smoke
```

# Parameters

* **test.suite=[name]**
  - This parameter specifies what suite will be executed. Your suite should be located on testng folder under test/resource folder

* **environment=[staging,production]**
  - This parameter specifies what configuration should be loaded. We have the file environment.properties. This file is in the folder config.staging or config.production.

* **test.client=[chrome,firefox]**
  - This parameter specifies what browser should be used to execute tests

* **test.device=[android,iphone] OPTIONAL**
  - This parameter specifies if the touch version should be used. If this parameter is not present then tests are executed on web desktop.

* **gridUrl=[http://selenium-grid1-dev.snc1:4444/wd/hub] OPTIONAL**
  - This parameter specifies if tests should be executed on grid. If this parameter is not present then tests are executed on local.

* **enableSplunkForwarder=false**
  - This enables splunk logging

* **log.location=./**
  - This set log path

* **mostestRootLogLevel=trace**
  - This parameter sets log level

* **enableBfmReporting=false**
  - This parameter enabled bfm reporting


# Code Fomatting
We follow jtier standard: https://pages.github.groupondev.com/jtier/jtier-docs/components/codestyle.html
