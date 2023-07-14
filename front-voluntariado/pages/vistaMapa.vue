<template>
  <div>
    <header class="shadow-sm bg-#CA8F28">
      <title>Ver Mapa | VoluntaRed </title>
      <nav class="container mx-auto p-4 flex justify-between items-center">
        <div>
          <a>
            <img
              src="https://i.ibb.co/yRyDcBf/Voluntared-fotor-20230618213813.png"
              alt="Voluntared-fotor-20230618213813"
              border="0"
            />
          </a>
        </div>

        <div class="flex items-center gap-4">
          <NuxtLink to="/" class="cta-button">Inicio</NuxtLink>
          <NuxtLink to="/registroUsuario" class="cta-button">Registro Voluntario</NuxtLink>
          <NuxtLink to="/registroInstitucion" class="cta-button">Registro Institución</NuxtLink>
          <NuxtLink to="/login" class="cta-button">Login</NuxtLink>
          <NuxtLink to="/registroEmergencia" class="cta-button">Registro Emergencia</NuxtLink>
          <NuxtLink to="/vistaMapa" class="cta-button">Ver Mapa</NuxtLink>
          <NuxtLink to="/listaEmergencia" class="cta-button">Emergencias</NuxtLink>
        </div>
      </nav>
    </header>
    <div class="container"><h1>Vista Mapa</h1></div>

    <div id="mapContainer">

    </div>
    <footer class="flex items-center gap-4">
      <ul class="flex gap-4">
        <NuxtLink to="/" class="cta-button">Home</NuxtLink>
      </ul>
    </footer>
  </div>
</template>

<script>
import "leaflet/dist/leaflet.css";
import * as L from "leaflet";
import axios from 'axios';
import 'leaflet-defaulticon-compatibility/dist/leaflet-defaulticon-compatibility.webpack.css'; // Re-uses images from ~leaflet package
import 'leaflet-defaulticon-compatibility';


export default {
  components: { },
  name: "LeafletMap",
  data() {
    return {
      map: null,
      tasks: []
    };
  },

  methods: {
    getData: async function () {
      try {
        const response = await axios.get("/tarea");
        this.tasks = response.data;

        console.log(response);
      } catch (error) {
        console.log("Error: ", error);
      }
    },
  },

  mounted: async function() {
    await this.getData();

    this.map = L.map("mapContainer").setView([-33.45694, -70.64827], 5);
    L.tileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png", {
      attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      maxZoom: 10
    }).addTo(this.map);

    var tareaMarker = L.icon({
      iconUrl: 'tarea.png',
      iconSize:     [38, 80], // size of the icon
      iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
      popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
    });

    var legend = L.control({position: "bottomright"});

    legend.onAdd = function(map) {
      var div = L.DomUtil.create("div", "legend");
      div.innerHTML += '<h4>Marcadores</h4>';
      div.innerHTML += '<i style="background: #0000FF"></i><span>Tarea</span><br>';

      return div;
    };

    legend.addTo(this.map);

    console.log(this.tasks);

    this.tasks.forEach(task => {
      var popupContent = "<hr>Nombre: </hr>" + task.nombre + "<hr>Descripción: </hr>" + task.descripcion
        + "<hr>Fecha: </hr>" + task.fecha + "<hr>Requerimientos: </hr>" + task.requerimientos + "<hr>Longitud: </hr>" + task.longitude
        + "<hr>Latitud: </hr>" + task.latitude + "<hr></hr>";

      L.marker([task.latitude, task.longitude], {icon: tareaMarker}).bindPopup(popupContent).openPopup().addTo(this.map);


    });
  },

  onBeforeUnmount() {
    if (this.map) {
      this.map.remove();
    }
  },
};
</script>

<style>
#mapContainer {
  margin: 50px;
  width: 90vw;
  height: 90vh;
}

.heading {
  margin: 0;
  padding: 0px;
  color:
    rgb(69, 69, 121);
}

.heading > h1 {
  padding: 20px;
  margin: 0;
}
.legend {
  padding: 6px 8px;
  font: 14px Arial, Helvetica, sans-serif;
  background: white;
  background: rgba(255, 255, 255, 0.8);
  /*box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);*/
  /*border-radius: 5px;*/
  line-height: 24px;
  color: #555;
}
.legend h4 {
  text-align: center;
  font-size: 16px;
  margin: 2px 12px 8px;
  color: #777;
}

.legend span {
  position: relative;
  bottom: 3px;
}

.legend i {
  width: 18px;
  height: 18px;
  float: left;
  margin: 0 8px 0 0;
  opacity: 0.7;
}

.legend i.circle {
  border-radius: 50%;
  width: 18px;
  height: 18px;
}
body {
  background-color: #FEE9E4;
  color: #2E5077;
  font-family: ui-rounded, sans-serif;
  margin: 0;
  padding: 0;
}
.container {
  max-width: 960px;
  margin: 0 auto;
  padding: 20px;
}
body2 {
  background-color: #CA8F28;
  color: #2E5077;
  font-family: ui-rounded, sans-serif;
  margin: 0;
  padding: 0;
}
.header2 {
  background-color: #87ACA3;
  padding: 10px;
  text-align: center;
}
header {
  background-color: #F47784;
  color: #2E5077;
  padding: 0px;
  text-align: center;
}
header img {
  max-width: 250px;
  height: auto;
}
.logo {
  margin-bottom: 10px;
}
.logo h1 {
  font-family: ui-rounded, sans-serif;
  font-size: 36px;
  color: #2E5077;
}
h1 {
  background-color: #FEE9E4;
  color: #2E5077;
  font-size: 36px;
  margin-bottom: 20px;
}
.content-table {
  background-color: #FEE9E4;
  color: #2E5077;
  border-collapse: collapse;
  width: 100%;
  margin-top: 20px;
}
.content-table th {
  background-color: #FEE9E4;
  color: #2E5077;
  padding: 10px;
  text-align: left;
}
.content-table td {
  border: 1px solid #FEE9E4;
  padding: 10px;
}
.hero-image {
  background-size: cover;
  background-position: center;
  height: 400px;
}
.hero-text {
  padding-top: 150px;
  text-align: center;
}
.hero-text h2 {
  font-size: 24px;
  color: #2E5077;
  margin-bottom: 20px;
}
.hero-text p {
  font-size: 24px;
  color: #2E5077;
  margin-bottom: 30px;
}
.cta-button {
  display: inline-block;
  padding: 12px 24px;
  background-color: #FDB35A;
  color: #fff;
  font-size: 20px;
  text-decoration: none;
  border-radius: 4px;
}
.buttons-container {
  text-align: center;
}
</style>
