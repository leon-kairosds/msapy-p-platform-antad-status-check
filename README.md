# msadp-d-deposit-account-detail

## Instrucciones de consumo
Realizar la petición al servicio

## Description
Este microservicio se encarga de lo siguiente:

1.Retornar el saldo, el estatus actual de la cuenta y su cuenta CLABE del cliente.

 /api/private/v1/serv/antad/checking/account/retrieve

2.Retornar el numero de tarjeta a quien se le realiza el abono.

 /api/private/v1/serv/antad/numcar/account/retrieve

### Versioning
Microservicio B-0.0.1-01

#### Important changes

#### Last modification date:
30/08/2023 by LFCM

#### 1.Retornar el saldo, el estatus actual de la cuenta y su cuenta CLABE del cliente.
### Endpoint
> /api/private/v1/serv/antad/checking/account/retrieve POST

#### 2.Retornar el numero de tarjeta a quien se le realiza el abono.
### Endpoint
> /api/private/v1/serv/antad/numcar/account/retrieve POST

### Precondiciones


## Built With
* Maven
* Spring
* SpringBoot
* Spring Tools Suite
* Lombok


### Prerequisites
Se necesita tener instalado:
		
- Contar con VPN de coppel 
 - Java 1.8  		
 - Maven 		
 - Spring Tools Suite
 - lombok
 - Mongo

## Deployment

    mvn spring boot:run  en Local 
	mvn jkube4:deploy -Popenshift 
O desde Spring Tools Suite click derecho sobre el proyecto -> Run As -> Spring Boot App


### Running JUnit tests

 - Desde pring Tools Suite click derecho sobre el proyecto  > Run As >
   JUnit Test. 
 
 mvn clean package site sonar:sonar -Pdevelopment_reporting 

 Esto ejecuta todas las pruebas unitarias del proyectos y genera los reportes en el site y el sonar.
 

### Reporting

Genera el reporte de check-style html y lo guarda en el site.

#### site

Se divide en dos partes:

 1. Informacion del proyecto.

	- Proporciona una descripción general de los diversos documentos y enlaces que forman parte de la información general de este proyecto.
	
2. Reportes de proyecto
	
	- Brindan un panoramageneral de varios reportes que son generados automaticamente por Maven.
	
EL site es generado  dentro de la ca: target > site > index.html
	

	$ mvn clean install site


#### Sonar
Sonar es una plataforma de código abierto utilizada por los equipos de desarrollo para gestionar la calidad del código fuente.

mvn clean package site sonar:sonar -Pdevelopment_reporting

En las últimas líneas de la salida de consola hay un enlace, cópielo y péguelo en cualquier navegador web para ver el informe.
