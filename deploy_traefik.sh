#!/bin/bash

mvn install && docker-compose build && docker stack rm api-enderecos && docker stack deploy -c docker-compose.yml api-enderecos
