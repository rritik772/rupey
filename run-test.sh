#!/bin/bash

export $(xargs < .env-test)
mvn spring-boot:run