<div align="center">
      <h1> <img src="https://th.bing.com/th/id/R.70c11b59c144e8d8af1a292274043105?rik=qsIhI%2f3hvZdFJQ&pid=ImgRaw&r=0" width="80px"><br/>Laboratorio TDB </h1>
     </div>

# Voluntariado_grupo5

## Integrantes
- Ricardo Arancibia(Backend)
- Hernán Aravena (Backend)
- Bryan Salgado (Fronted)
- Constanza Palomo (Frontend)
- Semestre: 1-2023
- Fecha de entrega: 19/06/2023




# Tecnologías utilizadas🛠:
 ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Vue.js](https://img.shields.io/badge/vuejs-%2335495e.svg?style=for-the-badge&logo=vuedotjs&logoColor=%234FC08D) 
   

### Instrucciones de Instalación 💻:
Para poder ejecutar el proyecto se deben tener instaladas las siguientes herramientas:

    - Nodejs
    - Vue 2x
    - Nuxt 3
    - Postgres 12 o superior
    - Java 17
    - PgAdmin 4
    
Primeramente se debe clonar el repositorio proporcionado, dentro del cual se encontrarán las carpeta "voluntariado"(back-end), "front-voluntariado"(front-end) y "db" donde se podrán encontrar los scripts para crear y poblar la base de datos del programa.

### Montar el back-end 🚀:

Antes de comenzar a levantar el proyecto, se debe tener en cuenta que se necesita tener Postgres configurado en el puerto 5432,
que es el puerto por defecto, además de tener instalada la extensión de POSTGIS.
1. Teniendo ya Postgres configurado, se debe crear una base de datos llamada "bd_val", necesariamente se debe llamar de esta forma para que el backend se conecte con la base de datos.
2. Teniendo la base de datos creada se debe abrir una query y ejecutar la siguiente instrucción: 
```
"CREATE EXTENSION postgis;"
```
3. Luego en la misma query o en una distinta (como desee) ejecutar los comandos que se encuentran en los siguientes archivos de la carpeta "db" del proyecto, y siguiendo este orden:
    1. archivo "create_table.sql"
    2. archivo "create_triggers.sql"
    3. archivo "create_proc.sql"
    4. archivo "import.sql"
    5. archivo "division_regional.sql"

4. Configurar el archivo "application.properties" que se encuentra en la ruta Lab1\voluntariado\src\main\resources\application.properties, con las credenciales que correspondan
5. Para mayor comodidad se recomienda abrir el proyecto de backend en IntelliJ (abrir la carpeta voluntariado Lab1\voluntariado), y ejecutar desde el idle con el boton run 'VoluntariadoApplication'
6. En caso de no tener IntelliJ o querer ocupar consola se debe ejecutar los siguientes comandos:
```
  -- mvn clean package
  -- java -jar target/voluntariado-0.0.1-SNAPSHOT.jar
```
Y de esta manera se despliega el back
### Montar el front-end 🚀:

Para iniciar el front se debe abrir la carpeta "front-voluntariado" del proyecto clonado, luego se debe abrir una terminal en la carpeta y ejecutar el siguiente comando para instalar las dependencias:
```
npm install
```
En caso de que falte instalar alguna dependencia(como axios), se debe ejecutar el siguiente comando:
```
npm install <nombre_modulo> -> En este caso sería: npm install axios
```
Luego para poner en marcha el fronted se ejecuta el comando:
```
npm run dev
```
Finalmente, para acceder a la vista esta se encontrará en el puerto:
```
http://localhost:8080/
```

### Extra📌📌:
En caso de que la biblioteca leaflet genere algun problema ejecutar:
```
npm install leaflet-defaulticon-compatibility --save
```
Luego volver a ejecutar el comando para poner en marcha.
