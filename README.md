# Sistema de Registro de Alumnos y Calificaciones 

Aplicacion RESTfull desarrollada en java 17 con Spring Boot. Permite registar alumnos. asignar calificaciones por materia y consultar los datos de manera sencilla a travez de endpoint bien definidos 

## Tecnologias utilizadas

- Java 17
- Spring Boot 3.5.4
- Spring Web
- Spring Data JPA
- H2 Database (en memoria)
- Maven
- Swagger UI
- Lombok
  

## Requisitos previos
- java 17
- Maven
- Git

## Como ejecutar el programa
- Clona el proyecto
- git clone https://github.com/tu-usuario/tu-repo.git
- cd tu-repo
- mvn spring-boot:run

## La aplicacion s eejecutara en :
-  http://localhost:9001

## Swagger API Documentacion
 # Accede a la documentacion y prueba los endpoint desde:
- http://localhost:9001/swagger-ui.html
- http://localhost:9001/swagger-ui/index.html

# Endpoint disponibles

Metodo        Endpoint          Descripcion
GET           /api/alumnos      Listar todos los alumnos
POST         /api/alumnos       Registra un nuevo alumno

# Calificaciones 

Metodo           Endpoint                Descripcion
GET              /api/calificaciones     Listar todas las calificaciones
POST             /api/calificaciones     Registrar calificaciones por materia
PUT              /api/calificaciones     Actualizar calificaciones por ID 
DELETE          /api/calificaciones      Eliminar calificaciones por ID

# Ejemplos para Postman
# ALUMNOS

## POST /api/alumnos
{
"nombre": "Juan",
"apellidoPaterno": "Perez",
"apellidoMaterno": "Gomez",
"materia": "Matematicas"
}

## GET Listar Alumnos

http://localhost:9001/api/alumnos

# CALIFICACIONES

## POST /api/calificaciones 
{
"alumnoId": 1,
"materia": "matematicas",
"nota": 6.5
}

## GET Listar Calificaciones

http://localhost:9001/api/calificaciones

## PUT Actulaizar una nota   
{
  "alumnoId": 1,
  "materia": "matematicas",
  "nota": 4.0
}

## DELETE Eliminar Calificacion 

http://localhost:9001/api/calificaciones/1

# Base de datos
Usa H2 en memoria
http://localhost:9001/h2-console
JDBC URL: jdbc:h2:mem:alumnosdb
usuario: sa
contraseña: dejarlo vacio

# Autor  
Desarrollador Java Spring Boot  
Juan Carlos Inostroza.  

## Nota técnica

  Debido a inconvenientes con el entorno de desarrollo(en mi IDE), se presentaron errores en tiempo de ejecucion al utilizar las anotaciones de Lombok
(@Getter, @Setter, @NoArgsConstructor, etc), a pesar de tener la dependencia correctamente configurada en pom.xml.
Por este motivo, se optó por generar manualmente los constructores, metodos getters y setters en las clases correspondientes para asegurar el correcto
funcionamiento de la aplicacion.
Esta decisión no afecta a la funcionalidad del proyecto y se mantuvo la dependencia de Lombok en caso de que el entorno sea configurado correctamente en futuras ejecuciones.
Ademas espero que esta deción no afecte negativamente en mi evaluacion, ya que responde a un ajuste puntual que garantiza la estabilidad del proyecto, manteniendo buenas practicas y separacion de capas en el diseño general.
Gracias.    
