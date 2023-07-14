<template>
    <l-map style="height: 400px" :zoom="zoom" :center="center">
      <l-tile-layer :url="tileLayerUrl"></l-tile-layer>
    </l-map>
  </template>
  
  <script>
  import { LMap, LTileLayer } from "vue2-leaflet";
  import "leaflet/dist/leaflet.css";
  
  export default {
    components: {
      LMap,
      LTileLayer,
    },
    data() {
      return {
        center: [51.505, -0.09],
        zoom: 13,
        tileLayerUrl: "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
      };
    },
  };
  </script>
  