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

```
 
 ## Peticiones HTTP -Agenda

  - GET localhost:8080/sistema/agenda/listar

  ```
localhost:8080/sistema/agenda/listar

  ```
 -Petición que permite listar la agenda que introduce el Doctor Ramirez, esta indica el dia, y horas disponibles. 
     
```json
 
    {
        "id": "25",
        "dia": "Lunes",
        "fecha": "2023-02-02",
        "ini": "08:00:00",
        "fin": "11:30:00",
        "citas": [
            {
                "id": 0,
                "horario": {
                    "fecha": "2023-02-02",
                    "inicio": "08:00:00",
                    "finalizada": "08:30:00",
                    "dia": "THURSDAY"
                },
                "paciente": null,
                "disponible": true
            },

```

- POST localhost:8080/sistema/agenda/crear

  ```

   localhost:8080/sistema/agenda/crear

  ```
  
 - Petición que permite crear un horario para citas es decir, dia, fecha inicio de horario y final de horario disponible 
    para citas realizadas por el doctor. 
  
  ```json
 
    {
        "id": "45",
        "dia": "Jueves",
        "fecha": "2023-02-18",
        "ini": "08:00:00",
        "fin": "11:30:00"
        
    }

```


- PUT localhost:8080/sistema/agenda/actualizar/{idAgenda}"

  ```

  localhost:8080/sistema/agenda/actualizar/45

  ```
  
 - Petición que permite modificar un horario en la agenda
    
  
  ```json
 
    {
        "id": "45",
        "dia": "Jueves",
        "fecha": "2023-02-18",
        "ini": "08:00:00",
        "fin": "15:30:00"
        
    }

```

 ## Peticiones HTTP - Cita

- GET localhost:8080/sistema/agenda/listar/cita{idAgenda}


  ```
  
  localhost:8080/sistema/agenda/listar/cita/25
 

  ```
  
- Petición que permite lista las citas de una agenda del doctor (franja dias, hora comiento y fin de hora que atiende)y siendo citas que pueden 
  ser tomadas por el  paciente cuando este es null. 
 
  
  ```json
  
    {
        "id": 0,
        "horario": {
            "fecha": "2023-02-02",
            "inicio": "08:00:00",
            "finalizada": "08:30:00",
            "dia": "THURSDAY"
        },
        "paciente": null,
        "disponible": true
    },
    {
        "id": 1,
        "horario": {
            "fecha": "2023-02-02",
            "inicio": "08:30:00",
            "finalizada": "09:00:00",
            "dia": "THURSDAY"
        },
        "paciente": null,
        "disponible": true
    },
    {
        "id": 2,
        "horario": {
            "fecha": "2023-02-02",
            "inicio": "09:00:00",
            "finalizada": "09:30:00",
            "dia": "THURSDAY"
        },
        "paciente": null,
        "disponible": true
    },
    {
        "id": 3,
        "horario": {
            "fecha": "2023-02-02",
            "inicio": "09:30:00",
            "finalizada": "10:00:00",
            "dia": "THURSDAY"
        },
        "paciente": null,
        "disponible": true
     }
  
 ```
 
 
 - PUT localhost:8080/sistema/agenda/asignar/cita/{idAgenda}/{idCita}


  ```
  
  localhost:8080/sistema/agenda/asignar/cita/25/0

  ```
  
  
  -Endponit que permite al paciente registrado tomar por medio del id agenda una cita de los horarios disponibles. 
 
     
 ```json
 
    {
    "id": "25",
    "dia": "Lunes",
    "fecha": "2023-02-02",
    "ini": "08:00:00",
    "fin": "11:30:00",
    "citas": [
        {
            "id": 0,
            "horario": {
                "fecha": "2023-02-02",
                "inicio": "08:00:00",
                "finalizada": "08:30:00",
                "dia": "THURSDAY"
            },
            "paciente": {
                "id": "11",
                "nombre": "Maria",
                "apellido": "Toll",
                "telefono": "320547774",
                "edad": 50,
                "peso": 74.0,
                "estatura": 1.6,
                "sexo": "femenino",
                "fecha_ingreso": "10-01-2021",
                "historia": []
            },
            "disponible": false
        }
 
```

 - PUT /actdesactivar/cita/{idAgenda}/{idCita}/{accion} 

  ```
  localhost:8080/sistema/agenda/actdesactivar/cita/25/1/a

  ```
 -Este endpoint al doctor activar o desactivar una cita de la agenda en este caso medediante la acciín de colocar una a(activar) o no con otra letra 
     
```json
 {
    "id": 1,
    "horario": {
        "fecha": "2023-02-02",
        "inicio": "08:30:00",
        "finalizada": "09:00:00",
        "dia": "THURSDAY"
    },
    "paciente": null,
    "disponible": false
}
```



