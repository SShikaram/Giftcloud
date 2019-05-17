#!/bin/bash

# execute from base directory with ./test-runner/run.sh
mvn -U -f test-runner/pom.xml -fae integration-test "$@" -Dlog.location=./test-runner/ -DgridUrl=$SELENIUM_GRID_URL
