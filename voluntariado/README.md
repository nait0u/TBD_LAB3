# TBD-GRUPO-5-backend
Instrucciones para desplegar el backend
- Antes de comenzar a levantar el proyecto, se debe tener en cuenta que se necesita tener Postgres configurado en el puerto 5432, 
    que es el puerto por defecto, ademas de tener instala la extencion de POSTGIS.
- Teniendo ya Postgres configurado, se debe crear una base de datos llamada "bd_val", necesariamente se debe llamar de esta forma para que el backend se conecte con la base de datos.
- Teniendo la base de datos creada se debe abrir una query y ejecutar la siguiente instruccion: "CREATE EXTENSION postgis;"
- Luego en la misma query o en una distinta (como desee) ejecutar los comandos que se encuentran en los siguientes archivos y siguiendo este orden 
    1. archivo "create_table.sql"
    2. archivo "create_triggers.sql"
    3. archivo "create_proc.sql"
    4. archivo "import.sql"
    5. archivo "division_regional.sql"

- Configurar el archivo "aplication.properties" que se encuentra en la ruta Lab1\voluntariado\src\main\resources\application.properties, con las credenciales que correspondan
- Para mayor comodidad se recomienda abrir el proyecto de backend en InteliJ (abrir la carpeta voluntariado Lab1\voluntariado), y ejecutar desde el idle con el boton run 'VoluntariadoApplication'
- En caso de no tener intelij o querer ocupar consola se debe ejecutar los siguientes comandos: 
 -- mvn clean package
 -- java -jar target/voluntariado-0.0.1-SNAPSHOT.jar

Y de esta manera se despliega el back



