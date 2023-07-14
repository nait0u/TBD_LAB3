<template>
  <button :class="['button', colorClass]">
    <slot></slot>
  </button>
</template>

<script>
export default {
  name: 'Button',
  props: {
    color: {
      type: String,
      required: true,
    },
  },
  computed: {
    colorClass() {
      return `button-${this.color}`;
    },
  },
};
</script>

<style scoped>
.button {
  border-radius: 9999px;
  padding: 0.75rem 1.5rem;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.button-ca8f28 {
  background-color: #CA8F28;
  color: #fff;
}

.button-0d748a {
  background-color: #0D748A;
  color: #fff;
}

.button-192d36 {
  background-color: #192D36;
  color: #fff;
}

.button-6ebdc4 {
  background-color: #6EBDC4;
  color: #fff;
}
</style>
