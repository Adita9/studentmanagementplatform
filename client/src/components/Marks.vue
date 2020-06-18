<template>
    <div class="outset">
        <router-view></router-view>

        <h1 align="left">Marks</h1>

        <b-button variant="light" block :squared="true" :pill="true" :pressed.sync="firstYear">First year</b-button>
        <div v-if="firstYear === true">
            <b-table striped hover :items="year1"></b-table>
        </div>

        <b-button block :squared="true" :pill="true" :pressed.sync="secondYear" variant="light">Second year
    </b-button>
        <div v-if="secondYear === true">
            <b-table block striped hover :items="year2"></b-table>
        </div>
        <b-button block :squared="true" :pill="true" :pressed.sync="thirdYear" variant="light">Third year</b-button>
        <div v-if="thirdYear === true">
            <b-table striped hover :items="year3"></b-table>
        </div>

        <!--<b-table striped hover :items="items"></b-table>-->
    </div>
</template>

<script>
    export default {
        name: "Marks",
        data() {
            return {
                year1: [
                    {class: 'Algorithms and programming languages', Mark: 7, Credits: 5},
                    {class: 'asd', Mark: 9, Credits: 6},
                    {class: 'POO', Mark: 4, Credits: 7},
                    {class: 'JAVA', Mark: 4, Credits: 8}
                ],

                year2: [
                    {class: 'SDDdddddddddddddddddddd', Mark: 7, Credits: 5},
                    {class: 'PAW', Mark: 9, Credits: 6},
                    {class: 'POO', Mark: 4, Credits: 7},
                    {class: 'JAVA', Mark: 4, Credits: 8}
                ],

                year3: [
                    {class: 'Materieeeeeeeeeeeeeeeeeee', Mark: 7, Credits: 5},
                    {class: 'Materie', Mark: 9, Credits: 6},
                    {class: 'MAterie', Mark: 4, Credits: 7},
                    {class: 'MAterie', Mark: 4, Credits: 8}
                ],
                firstYear: false,
                secondYear: false,
                thirdYear: false
            }
        }
    }
</script>

<style scoped>

    .border-aligned {
        border: black;
        border-left: 10px;
        alignment: left;
    }

    .outset {
        border-top: 2px;
        border-bottom: 0px;
        border-left: 0px;
        border-right: 0px;

    }
</style>