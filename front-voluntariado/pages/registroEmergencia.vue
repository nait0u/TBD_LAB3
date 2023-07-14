<template>
  <div>
    <header class="shadow-sm bg-#CA8F28">
      <title>VoluntaRed</title>
      <div>
        <a>
          <img
            src="https://i.ibb.co/yRyDcBf/Voluntared-fotor-20230618213813.png"
            alt="Voluntared-fotor-20230618213813"
            border="0"
          />
        </a>
        <div class="flex items-center gap-4">
          <NuxtLink to="/" class="cta-button">Inicio</NuxtLink>
          <NuxtLink to="/registroUsuario" class="cta-button">Registro Voluntario</NuxtLink>
          <NuxtLink to="/registroInstitucion" class="cta-button">Registro Institución</NuxtLink>
          <NuxtLink to="/login" class="cta-button">Login</NuxtLink>
          <NuxtLink to="/registroEmergencia" class="cta-button">Registro Emergencia</NuxtLink>
          <NuxtLink to="/vistaMapa" class="cta-button">Ver Mapa</NuxtLink>
          <NuxtLink to="/listaEmergencia" class="cta-button">Emergencias</NuxtLink>
        </div>
      </div>
    </header>
    <div class="container">
      <h1 class="text-center">Ingreso de Emergencia</h1>

      <form class="form">
        <div class="form-group">
          <label for="nombre">Nombre:</label>
          <input type="text" id="nombre" v-model="nombre" class="input-field">
        </div>

        <div class="form-group">
          <label for="descripcion">Descripción:</label>
          <textarea id="descripcion" v-model="descripcion" class="input-field"></textarea>
        </div>

        <div class="form-group">
          <label for="fecha">Fecha:</label>
          <input type="date" id="fecha" v-model="fecha" class="input-field">
        </div>

        <div class="form-group">
          <label for="reqs_grupales">Requisitos grupales:</label>
          <textarea id="reqs_grupales" v-model="reqs_grupales" class="input-field"></textarea>
        </div>

        <div class="form-group">
          <label for="reqs_individuales">Requisitos individuales:</label>
          <textarea id="reqs_individuales" v-model="reqs_individuales" class="input-field"></textarea>
        </div>

        <div class="form-group">
          <label for="longitude">Longitud:</label>
          <input type="number" id="longitude" v-model="longitude" class="input-field">
        </div>

        <div class="form-group">
          <label for="latitude">Latitud:</label>
          <input type="number" id="latitude" v-model="latitude" class="input-field">
        </div>

        <button v-on:click="submitForm" type="submit" class="cta-button2">Enviar</button>
      </form>

      <h1>Lista de Requisitos</h1>

      <form class="form">
        <div class="form-group">
          <label for="task">Habilidad:</label>
          <input type="text" id="task" v-model="newTask" class="input-field">
        </div>
        <button v-on:click="addTask" type="submit" class="cta-button2">Agregar Requisitos de Habilidades</button>
      </form>

      <div>
        <h2>Habilidades:</h2>
        <ul>
          <li v-for="(task, index) in tasks" :key="index">{{ task }}</li>
        </ul>
      </div>
    </div>
  </div>
</template>


<style>
/* Your existing styles here */
</style>

<script>
export default {
  data() {
    return {
      nombre: '',
      descripcion: '',
      fecha: '',
      reqs_grupales: '',
      reqs_individuales: '',
      longitude: 0,
      latitude: 0,
      newTask: '',
      tasks: []
    };
  },

  methods: {
    submitForm: async function() {
      try {
        let response = await this.$axios.post("/emergencia/create",
          {

            nombre: this.nombre,
            correo: this.correo,
            usuario: this.usuario,
            password: this.password,
            numero: this.numero

          });
      } catch (error) {
        console.log("error", error);
      }
    },

    addTask() {
      if (this.newTask !== '') {
        this.tasks.push(this.newTask);
        this.newTask = '';
      }
    }
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
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

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
.cta-button2 {
  display: inline-block;
  padding: 10px 18px;
  background-color: #FDB35A;
  color: #fff;
  font-size: 15px;
  text-decoration: none;
  border-radius: 4px;
}
.buttons-container {
  text-align: center;
}
.form-group {
  margin-bottom: 1em;
}
.input-field {
  font-size: 1.1em; /* Aumenta el tamaño de la fuente */
  padding: 0.5em; /* Ajusta el relleno para hacer el campo de entrada ligeramente más grande */
}

</style>
