<template class="back">
    <div class="back" id="app">
        <div v-if="student.status">
            <Header></Header>
            <router-view></router-view>
            <!--<Login></Login>-->
        </div>
        <div v-else>
            <Login></Login>
        </div>

    </div>
</template>

<script>
    import Header from './components/Header.vue'
    import Login from "./components/Login";

    export default {
        name: "App",
        components: {
            Login,
            Header
        },
        data() {
            return {
                myToggle: false,
                student: Object
            }
        },
        mounted: function () {

            fetch('http://localhost:8080/studentplatform/', {
                method: 'get'
            })
                .then((response) => {
                    return response.json()
                })
                .then((jsonData) => {
                    this.student = jsonData
                })
        }
    }


</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }

    #nav {
        padding: 30px;
    }

    #nav a {
        font-weight: bold;
        color: #2c3e50;
    }

    #nav a.router-link-exact-active {
        color: #42b983;
    }

    .align-data {
        resize: horizontal;
        width: 400px;
        box-sizing: content-box;
    }

    .button {
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }

    .outset {
        border-top: 2px;
        border-bottom: 0px;
        border-left: 0px;
        border-right: 0px;

    }

    .back {
        font-family: "Roboto", "Segoe UI", "GeezaPro", "DejaVu Serif", "sans-serif", "-apple-system", "BlinkMacSystemFont";

    }

</style>
