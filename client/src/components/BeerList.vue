

<template>
    <div class="beer-list">
        <h1>Beer List</h1>
        <div v-for="beer in beers">
            {{ beer.name }}
        </div>
    </div>
</template>

<script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';
    import axios from 'axios';

    export interface Beer {
        id: number;
        name: string;
        giphyUrl: string;
    }

    @Component
    export default class BeerList extends Vue {
        public beers: Beer[] = [];

        private async created() {
            const response = await axios.get('/');
            this.beers = await response.data;
        }
    }
</script>

