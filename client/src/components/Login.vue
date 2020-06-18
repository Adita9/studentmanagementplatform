<template>
    <div class="mega-style">
        <div>
            <img src="https://upload.wikimedia.org/wikipedia/en/thumb/7/74/Logo_ASE_Bucharest.png/250px-Logo_ASE_Bucharest.png"
                 width="400" height="300">
        </div>
        <div>
            <b-form  @submit.stop.prevent>
                <label  for="feedback-user">User ID</label>
                <b-input v-model="userId" :state="validation" id="feedback-user"></b-input>
                <b-form-invalid-feedback :state="validation">
                    Your user ID must be 5-12 characters long.
                </b-form-invalid-feedback>
                <b-form-valid-feedback :state="validation">
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
            <b-button block :squared="true" :pill="true" :pressed.sync="secondYear" variant="light">Login
            </b-button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Login"
    }
</script>

<style scoped>
.mega-style{
    width: 70%;
    alignment: center;
    padding-top: 200px;
    padding-left: 30%;
    align-content: center;
}
.mega-style2{
    padding-top: 2%;
}

</style>