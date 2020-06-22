<template>
    <div class="outset">
        <router-view></router-view>

        <h1 align="center">Marks</h1>

        <b-button variant="light" block :squared="true" :pill="true" :pressed.sync="firstYear">First year</b-button>
        <div v-if="firstYear === true">
            First semester
            <b-table striped hover :items="year1sem1"></b-table>
            Second semester
            <b-table striped hover :items="year1sem2"></b-table>

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
                year1sem1: [
                    {class: 'ATP', Mark: 7, Credits: 5},
                    {class: 'BOC', Mark: 9, Credits: 6},
                    {class: 'POO', Mark: 6, Credits: 5},
                    {class: 'JAVA', Mark: 6, Credits: 6}
                ],

                year2: [
                    {class: 'SO', Mark: 7, Credits: 5},
                    {class: 'BCO', Mark: 9, Credits: 6},
                    {class: 'POO', Mark: 6, Credits: 5},
                    {class: 'JAVA', Mark: 6, Credits: 6}
                ],

                year1sem2: [
                    {class: 'SDD', Mark: 7, Credits: 5},
                    {class: 'PAW', Mark: 9, Credits: 6},
                    {class: 'Math', Mark: 7, Credits: 5},
                    {class: 'SO', Mark: 5, Credits: 6}
                ],

                year3: [
                    {class: '', Mark: 7, Credits: 5},
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
        background: #F8F8FF;
        font-family: "Roboto", "Segoe UI", "GeezaPro", "DejaVu Serif", "sans-serif", "-apple-system", "BlinkMacSystemFont";
    }
</style>