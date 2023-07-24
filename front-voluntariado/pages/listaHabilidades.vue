<template>
    <body>
    <div>
      <header class="shadow-sm bg-#CA8F28">
        <title>Emergencias | VoluntaRed</title>
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
    </div>
    <div class="container">
      <title> VoluntaRed - Habilidades</title>
      <h1 class="text-center">Habilidades</h1>
  
      <div class="content-table">
        <table class="table table-bordered table-hover" style="center">
          <thead class="thead-dark">
            <tr>
              <th>Id</th>
              <th>Descripción</th>
              <th>Código</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="habilidad in habilidades" :key="habilidad.id_habilidad">
              <th>{{ habilidad.id_habilidad }}</th>
              <th>{{ habilidad.descripcion }}</th>
              <th>{{ habilidad.codigo }}</th>
            </tr>
          </tbody>
        </table>
      </div>

      <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
        crossorigin="anonymous"
      />
    </div>
    <footer class="container mx-auto p-4 flex justify-between border-t-2">
      <ul class="flex gap-4">
        <NuxtLink to="/" class="cta-button">Home</NuxtLink>
      </ul>
    </footer>
    </body>
  </template>
  


  
  <script>
  export default {
    data() {
      return {
        habilidades: [], // Lista de habilidades
      };
    },
  
    methods: {
      getHabilidades: async function () {
        try {
          // Realizar la llamada a la API para obtener la lista de habilidades
          let response = await this.$axios.get("/habilidades");
          this.habilidades = response.data;
          console.log(response);
        } catch (error) {
          console.log("Error", error);
        }
      },
    },
  
    created: function () {
      this.getHabilidades();
    },
  };
  </script>