#!/bin/bash

docker run \
    --name rupey \
    -e MYSQL_ROOT_PASSWORD=890076 \
    -e MYSQL_USER=rupey \
    -e MYSQL_PASSWORD=7788990012 \
    -e MYSQL_DATABASE=rupey \
    -p 3306:3306 \
    -d mysql:latest