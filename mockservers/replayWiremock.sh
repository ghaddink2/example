#!/bin/bash

java -jar wiremock-standalone-2.6.0.jar --port 9080 --https-port 8443 --proxy-all="https://api.openaq.org/"
