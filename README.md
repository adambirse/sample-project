# sample-project
[![Build Status](https://travis-ci.org/adambirse/sample-project.svg?branch=master)](https://travis-ci.org/adambirse/sample-project)

Sample getting started project for Gradle, Docker and Spring boot.  This project is intended to be a starter for ten for anyone looking to use the following technologies:

- Gradle
- Spring boot
- Docker

In addition it adds features to aid in the development of a production grade project, for example:

- Dependency checking
- Test coverage
- Support for flyway
- OWASP dependency check
- Rest documentation

## Architecture

This application consists of the following (deployed as docker containers):

- Eureka Discovery Service
- Spring boot admin console
- mysql database
- web server serving thymeleaf pages
- web service (Discovery client, REST)
- data service (Discovery client, REST)

## Gradle Integration

The following tasks have been added to gradle:

- _buildDocker_ Builds the docker file. See [Transmode](https://github.com/Transmode/gradle-docker) for full details.
- _prepareDocker_ Performs property substitution before running _buildDocker_
- _prepareComposeFile_ Performs property substitution on before running composeUp
- _prepareComposeDevFile_ Performs property substitution on before running composeUp
- jacocoTestReport Generates jacoco test coverage report.
- _dependencyUpdates_ Generates a report of dependencies to be updated. See [Gradle versions plugin](https://github.com/ben-manes/gradle-versions-plugin) for full details
- _composeUp_  and _composeDown_ provide docker compose integration.  See  [Docker compose plugin](https://github.com/avast/docker-compose-gradle-plugin)
- Flyway support provided by [Flyway plugin](https://flywaydb.org/documentation/gradle/)
- _dependencyCheck_ OWASP dependency checking provided by [Dependency Check](https://jeremylong.github.io/DependencyCheck/dependency-check-gradle/)
- _asciidoctor_ for generating rest documentation using spring-rest-docs.  See [Ascii Doctor](http://asciidoctor.org/docs/asciidoctor-gradle-plugin/) for details.

As this project evolves I aim to add the following:

- Unit and Integration testing
- Selenium testing
- Non java/spring applications
- Anything else that might be useful for those starting a new project.

Please feel free to get in touch and to make contributions.


