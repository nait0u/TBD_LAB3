<template>
  <div>
    <header class="shadow-sm bg-#CA8F28">
      <title>Login | VoluntaRed</title>
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
    <div>
      <div class="container">
        <h1>Iniciar sesión</h1>
      <form @submit.prevent="login">
        <div class="form-group">
          <label for="correo">Correo electrónico:</label>
          <input type="email" id="correo" v-model="credentials.correo">
        </div>
        <div class="form-group">
          <label for="password">Contraseña:</label>
          <input type="password" id="password" v-model="credentials.password">
        </div>
        <button type="submit" class="cta-button2">Iniciar sesión</button>
      </form>
    </div>
    </div>
  </div>
</template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      credentials: {
        email: '',
        password: ''
      }
    };
  },
  methods: {
    login() {
      axios.post('/api/login', this.credentials)
        .then(response => {
          // Procesar la respuesta del servidor
          console.log(response.data);
        })
        .catch(error => {
          // Manejar errores de solicitud
          console.error(error);
        });
    }
  }
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
<script setup>
</script>
