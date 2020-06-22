<template>
    <div class="back">
        <div style="overflow-x:auto;">
            <b-card class="back">
                <b-card-text>
                    <a id="profile"></a>
                    <img  class="align-profile" src="https://icons.iconarchive.com/icons/paomedia/small-n-flat/512/user-male-icon.png"
                         width="180" height="200" align="left">
                    <h1 align="left" class="">{{student.personalInfo.name}}</h1>
                    <table>
                        <td>
                            <tr><p class="align-data" align="left"> Date of birth:
                                {{student.personalInfo.dateOfBirth}}</p></tr>
                            <tr><p class="align-data" align="left"> Place of birth:
                                {{student.personalInfo.placeOfBirth}}</p>
                            </tr>
                            <tr><p class="align-data" align="left"> Email: {{student.personalInfo.email}}</p></tr>
                            <tr><p class="align-data" align="left"> Phone number:
                                {{student.personalInfo.phoneNumber}}</p></tr>
                            <tr><p class="align-data" align="left"> Address: {{student.personalInfo.address}}</p>
                            </tr>
                            <tr><p class=" align-data" align="left"> Wallet: {{student.personalInfo.wallet}}
                                RON</p></tr>
                        </td>
                        <td>
                            <tr><p class="align-data" align="left"> Specialization:
                                {{student.schoolInformation.collageYear[0].specialization}}
                            </p></tr>
                            <tr><p class="align-data" align="left"> Year:
                                {{student.schoolInformation.collageYear[0].year}}</p>
                            </tr>
                            <tr><p class="align-data" align="left"> Semester:
                                {{student.schoolInformation.collageYear[0].semester}}</p></tr>
                            <tr><p class="align-data" align="left"> Learning form:
                                {{student.schoolInformation.collageYear[0].learningForm}}</p></tr>
                            <tr><p class="align-data" align="left"> State:
                                {{student.schoolInformation.collageYear[0].state}}</p>
                            </tr>
                        </td>
                    </table>
                </b-card-text>
            </b-card>

        </div>
        <div>
            <Marks></Marks>
        </div>
    </div>

</template>

<script>

    import Marks from "./Marks";

    export default {
        name: "Profile",
        components: {Marks},
        data() {
            return {
                student: Object
            }
        }
        , mounted: function () {

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

<style scoped>
    .border-aligned {
        border: black;
        border-left: 10px;
    }

    .align-profile {
        margin-right: 10px;
    }

    .align-data {
        resize: horizontal;
        width: 400px;
        box-sizing: content-box;
    }

    .back {
        background: #F8F8FF;
        width: 100%;
        height: 100%;
    }


</style>