<template>
    <div class="mega-style">
        <div>
            <img src="https://upload.wikimedia.org/wikipedia/en/thumb/7/74/Logo_ASE_Bucharest.png/250px-Logo_ASE_Bucharest.png"
                 width="400" height="300">
        </div>
        <h1 class="mega-style2">Webstudent 2.0</h1>
        <div>
            <b-form @submit.stop.prevent>
                <label for="feedback-user">User ID</label>
                <b-input id="feedback-user"></b-input>
                <b-form-invalid-feedback >
                    Your user ID must be 5-12 characters long.
                </b-form-invalid-feedback>
                <b-form-valid-feedback>
                    Looks Good.
                </b-form-valid-feedback>
            </b-form>
        </div>
        <div>
            <b-form @submit.stop.prevent>
                <label for="text-password">Password</label>
                <b-input type="password" id="text-password" aria-describedby="password-help-block"></b-input>
            </b-form>
        </div>
        <div class="mega-style2">
            <router-link to="/profile">
                <b-button block :squared="true" @click="getStatus" :pill="true" variant="light">
                    Login
                </b-button>
            </router-link>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        name: "Login",
        data() {
            return {
                status: false
            }
        },
        methods: {
            getStatus() {
                console.log("asdsadsadasdsaddaa");
                axios.get('http://localhost:8080/studentplatform/status/1')
                    .then(res => {
                        console.log(res);
                    })
            }
        }
    }
</script>

<style scoped>
    .mega-style {
        width: 70%;
        alignment: center;
        padding-top: 200px;
        padding-left: 30%;
        align-content: center;
    }

    .mega-style2 {
        padding-top: 2%;
        font-family: "Roboto", "Segoe UI", "GeezaPro", "DejaVu Serif", "sans-serif", "-apple-system", "BlinkMacSystemFont";

    }

</style>