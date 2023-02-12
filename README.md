# sistema_consultorio
Api-consultorio Medico 
Api-consultorio Medico 

## Sobre proyecto

-El doctor Ramiro Fernandez nos contactó porque quiere adquirir un sistema para la administración de las historias médicas y el manejo de citas de sus pacientes
## Diseño de la lógica de sistema para administración de citas y pacientes:
1-	Se procedió a crear un diagrama de Entidad-Relación para identificar las clases que se desarrollarían en el programa, luego en UML se escribieron los posibles atributos y métodos principales, que arrojo la clase abstracta Usuario para paciente y doctor.
2-	 Se diseñaron los endpoints de las clases, Paciente, agenda, consulta/ historial ya que el historial es una lista de consultas en nuestra lógica.
En este sentido, se tiene una lista de pacientes, consultas (estas contienen los datos que generan la historia de ese paciente como motivo de consulta cantidad de consultas previas, fecha de registro del paciente, tratamiento y diagnóstico. 
El doctor maneja su agenda, en este caso se ejecuta una agenda (lista donde se encuentra el día, la hora que esté disponible ejemplo: lunes, 8:00 am a 11:30. Así, esa franja horaria en la agenda permite agendar una cita a un paciente, siendo que si está disponible se paciente seria null.



<h3 align="center">Spring Boot API RESTful</h3>

## Local Installation

- run the application  

 ```

- (available at: [localhost:8080](http://localhost:8080))

  ```
## Peticiones HTTP -PACIENTE

  - GET localhost:8080/sistema/paciente/listar 

  ```
  localhost:8080/sistema/paciente/listar

  ```
 -Este endpoint permite recibir la lista de pacientes registrados, con sus respectiva lista 
     de consultas, que se traduce en su historia médica. 
     
```json
 {
        "id": "10",
        "nombre": "Pedro",
        "apellido": "Castillo",
        "telefono": "31158777",
        "edad": 32,
        "peso": 78.0,
        "estatura": 1.79,
        "sexo": "masculino",
        "fecha_ingreso": "21-11-2020",
        "historia": [
            {
                "id": "01",
                "numeroConsultas": "01",
                "fechaRegistro": "18-11-2020",
                "fechaModificacion": "11-02.2023",
                "motivoDeConsulta": "Control cronico",
                "tramiento": "cero estres y caobohidratos",
                "diagnostico": "diabetes tipo 2"
            },
```

 - POST localhost:8080/sistema/paciente/crear

  ```
  localhost:8080/sistema/paciente/crear

  ```
 -La petición que realiza este endpoint es crear y agreagr a las lista un nuevo registro de paciente, el cual aparece sin historia. 
     
 ```json
{
        "id": "20",
        "nombre": "Alejandra",
        "apellido": "Miranda",
        "telefono": "31155555",
        "edad": 19,
        "peso": 63.0,
        "estatura": 1.61,
        "sexo": "femenino",
        "fecha_ingreso": "12-02-2023"
    }
```

 - PUT localhost:8080/sistema/paciente/actualizar/{pacienteId}

  ```
  localhost:8080/sistema/paciente/actualizar/13

  ```
 -Endponit que permite actualizar un ovarios campo del paciente. 
     
 ```json
 {
        "id": "13",
        "nombre": "Juan",
        "apellido": "Lima",
        "telefono": "999999997",
        "edad": 40,
        "peso": 85.0,
        "estatura": 1.89,
        "sexo": "masculino",
        "fecha_ingreso": "02-10-2021"
    }
```
- Delete localhost:8080/sistema/paciente/eliminar/{id}

  ```
  localhost:8080/sistema/paciente/eliminar/14

  ```
 -Endponit que permite eliminar registro de lista de pacientes. 
     
## Peticiones HTTP -Historial

  - GET localhost:8080/sistema/paciente/listar/historial/{idPaciente} 

  ```
 localhost:8080/sistema/paciente/listar/historial/10

  ```
 -Petición que permite visualizar mediante el id de paciente la lista de consultas que ha realziado, es decir su historial. 
     
```json
 [
    {
        "id": "01",
        "numeroConsultas": "01",
        "fechaRegistro": "18-11-2020",
        "fechaModificacion": "11-02.2023",
        "motivoDeConsulta": "Control cronico",
        "tramiento": "cero estres y caobohidratos",
        "diagnostico": "diabetes tipo 2"
    },
    {
        "id": "04",
        "numeroConsultas": "10",
        "fechaRegistro": "20-05-2018",
        "fechaModificacion": "01-02.2023",
        "motivoDeConsulta": "mareos y dolor de cabeza",
        "tramiento": "se remite a examen neurologico",
        "diagnostico": "Laberintitis"
    }
]
```
 
