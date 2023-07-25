<div align="center">
      <h1> <img src="https://th.bing.com/th/id/R.70c11b59c144e8d8af1a292274043105?rik=qsIhI%2f3hvZdFJQ&pid=ImgRaw&r=0" width="80px"><br/>Laboratorio 3 TDB </h1>
     </div>

# Voluntariado_grupo5

## Integrantes
- Ricardo Arancibia (Backend)
- Hernán Aravena (Backend)
- Bryan Salgado (Fronted)
- Constanza Palomo (Frontend)
- Semestre: 1-2023
- Fecha de entrega: 24/07/2023




# Tecnologías utilizadas🛠:
 ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Vue.js](https://img.shields.io/badge/vuejs-%2335495e.svg?style=for-the-badge&logo=vuedotjs&logoColor=%234FC08D) ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) ![MongoDb](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)
   

### Instrucciones de Instalación 💻:
Para poder ejecutar el proyecto se deben tener instaladas las siguientes herramientas:

    - Intellij v2023.1.4
    - Spring Boot v3.0.9 
    - Java 17
    - MongoDB v6.0.8
    - MongoDB Compass v1.39.0
    - Postman v10.16
    
Primeramente se debe clonar el repositorio proporcionado, dentro del cual se encontrarán las carpetas "voluntariado"(back-end) y "db mongo" donde en esta última se podrán encontrar los archivos en formato .JSON para poblar la base de datos del programa.

### Montar el back-end 🚀:

Antes de comenzar a levantar el proyecto, se debe tener en cuenta que se necesita tener MongoDB configurado en el puerto 27017,
que es el puerto por defecto.
1. Ejecute MongoDB Compass en su computador.
2. Teniendo ya MongoDB configurado, se debe crear una colección (de nombre a elección) y una base de datos llamada "bd_voluntariado", necesariamente se debe llamar de esta forma para que el backend se conecte con la base de datos.
3. Teniendo la base de datos creada, abra una shell de Mongo (consola) haciendo click en la parte inferior de MongoDB Compass, donde dice >_Mongosh y ejecute los siguientes comamdos: 
```
# Conectarse a base de datos 'admin'
test> use admin

# Crear superusuario llamado 'mongo' con contraseña 'mongo'
admin> db.createUser({user: "mongo", pwd: "mongo", roles: [ { role: "root", db: "admin" } ]})

# Conectarse a base de datos 'bd_voluntariado'
admin> use bd_voluntariado

# Crear usuario 'mongo' con contraseña 'mongo' para que quede asociado a la base de datos 'bd_voluntariado', con permisos de lectura y escritura
bd_voluntariado> db.createUser({user: "mongo", pwd: "mongo", roles: [ { role: "readWrite", db: "bd_voluntariado" } ]})

#Cerrar consola, haciendo click en >_Mongosh
```
4. Ahora entre a la base de datos bd_voluntariado y haga click en el botón verde ADD_DATA e importe los archivos .JSON "habilidad" y "voluntario". Con esto la base de datos ya estará poblada. 

5. El archivo "application.properties" que se encuentra en la ruta TBD_LAB3\voluntariado\src\main\resources\application.properties, ya viene con las credenciales necesarias para conectar el back-end a la base de datos.
6. Para mayor comodidad se recomienda abrir el proyecto de backend en IntelliJ (abrir la carpeta voluntariado TBD_LAB3\voluntariado), y ejecutar desde el idle con el boton run 'VoluntariadoApplication'
7. En caso de no tener IntelliJ o querer ocupar consola se deben ejecutar los siguientes comandos:
```
  -- mvn clean package
  -- java -jar target/voluntariado-0.0.1-SNAPSHOT.jar
```
Y de esta manera se despliega el back

### Probar el back-end a través de peticiones HTML por Postman 🚀:

1. Ejecute Postman en su computador.
2. Agregue una nueva petición con el botón add request y en la barra principal (a modo de ejemplo) seleccione GET y pegue el siguiente endpoint: 'localhost:3000/voluntario' luego haga click en el botón azul SEND para enviar la petición y deberían aparecerle todos los voluntarios que hay en la base de datos.
3. Puede revisar el resto de endpoints para probar el programa en la carpeta Services que se encuentra dentro del back-end, en cada uno de los servicios.
