
#### REST API for an ExchangeRate Application

There is an application that provides the user with
a set of functions for obtaining information about
exchange rates, as well as additional functions for this.

## Install application:
- Clone application to your directory:
  `git clone https://github.com/sssectumsempra/currency-rate-processor.git`

- Build project: `mvn clean install`

## Prerequisite:
- JDK 17 or higher
- Maven 4.0.0 or higher
- Flyway 11.1.0 or lower
- H2 last dependency version
- Jackson-databind / J-d jsr310 as well 2.18.2
- Jackson-databind-nullable 0.2.6
- Mapstruct / Mapstruct-processor 1.6.3

[//]: # (- MySQL 8.3.0 or lower)
[//]: # (- Docker 27.3.1)

## Program main functional:

### ExchangeRateController methods:
- Get rate list
- Get rate by cc(currency code)