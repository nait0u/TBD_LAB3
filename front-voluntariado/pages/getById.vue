<template>
  <div class="container">
    <title> TBD laboratorio 1 - Vista detallada emergencia</title>
    <h1>Información emergencia</h1>
    <div class="center">
      <h5>Asunto:</h5>
      <p>{{ emergencia.asunto }}</p>
      <h5>Fecha de registro:</h5>
      <p>{{ emergencia.fecha }}</p>
      <h5>Descripción:</h5>
      <p>{{ emergencia.descripcion }}</p>
      <h5>Dirección:</h5>
      <p>{{ emergencia.direccion }}</p>
      <h5>Estado:</h5>
      <p v-if="emergencia.activa"> Activa </p>
      <p v-else> No activa </p>
      <h5>Tareas relacionadas a la emergencia:</h5>
      <div class="center-table" v-if="tareas.length != 0">
        <table class="table table-bordered table-hover">
          <thead class="thead-dark">
          <tr>
            <th>ID</th>
            <th>Tarea</th>
            <!--<th>Completada</th>-->
          </tr>
          </thead>
          <tbody>
          <tr v-for="tarea in tareas" v-bind:key="tarea.id_tarea">
            <td>{{ tarea.id_tarea }}</td>
            <td>{{ tarea.asunto_tarea }}</td>
            <!--<td>{{ estado }}</td>--> <!-- Esto seria para cada estado en estados -->
          </tr>
          </tbody>
        </table>
      </div>
      <div class="center-table" v-else>
        <p>No existen tareas relacionadas con esta emergencia</p>
      </div>
      <router-link to="/emergencies"
      ><button id="back_btn">Volver</button></router-link
      >
    </div>

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
      crossorigin="anonymous"
    />
  </div>
</template>

<script>

export default {
  data() {
    return {
      param: {},
      emergencia: {},
      tareas: {},
      estados: {}
    };
  },
  mounted() {
    this.param = this.$route.params.id_emergencia;
  },
  methods: {
    getData: async function () {
      try {
        let id_emergencia = this.$route.params.id;
        let response = await this.$axios.get("/getById-id/" + id_emergencia, {
          params: {
            id_emergencia: id_emergencia,
          },
        });

        this.emergencia = response.data;
        //console.log("datos: " + this.emergencia);

        let tareas_response = await this.$axios.get(
          "/getTareasByIdEmergencia/" + id_emergencia, {
            params:
              {
                id_emergencia: id_emergencia
              }});
        this.tareas = tareas_response.data;
        console.log("tarea: " + this.tareas);


        let estados_response = await this.$axios.get(
          "/getEstadoBytarea", {
            params:
              {
                tareas: this.tareas
              }});

        this.estados = estados_response.data;
        console.log("estados: " + this.estados);


      } catch (error) {
        console.log("error", error.response.data);
      }
    },
  },

  created: function () {
    this.getData();
  },
};
</script>

<style>
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
