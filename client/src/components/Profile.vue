<template>
    <div>
        <div >
            <b-card>
                <b-card-text>
                    <a id="profile"></a>
                    <img src="https://scontent-frt3-1.xx.fbcdn.net/v/t1.15752-9/101204796_3098610436852247_6965571067230289920_n.jpg?_nc_cat=108&_nc_sid=b96e70&_nc_oc=AQkd4_HI1mDsGW3FL4rLzHB476Qjk11n1a4aGFujDzv6y6udiSkItfHfmxp2IezZXFY&_nc_ht=scontent-frt3-1.xx&oh=57032758299be90a536d9825cdd0a933&oe=5EFB8281"
                         width="200" height="200" align="left">
                    <h1 align="left" class="">{{personalInfo.name}}</h1>
                    <table>
                        <td>
                            <tr><p class="align-data" align="left"> Date of birth: {{personalInfo.dateOfBirth}}</p></tr>
                            <tr><p class="align-data" align="left"> Place of birth: {{personalInfo.placeOfBirth}}</p>
                            </tr>
                            <tr><p class="align-data" align="left"> Email: {{personalInfo.email}}</p></tr>
                            <tr><p class="align-data" align="left"> Phone number: {{personalInfo.phoneNumber}}</p></tr>
                            <tr><p class="align-data" align="left"> Address: {{personalInfo.address}}</p>
                            </tr>
                            <tr><p class=" align-data" align="left"> Wallet: {{personalInfo.wallet}}
                                RON</p></tr>
                        </td>
                        <td>
                            <tr><p class="align-data" align="left"> Specialization:
                                {{schoolInformation.collageYear[0].specialization}}
                            </p></tr>
                            <tr><p class="align-data" align="left"> Year: {{schoolInformation.collageYear[0].year}}</p>
                            </tr>
                            <tr><p class="align-data" align="left"> Semester:
                                {{schoolInformation.collageYear[0].semester}}</p></tr>
                            <tr><p class="align-data" align="left"> Learning form:
                                {{schoolInformation.collageYear[0].learningForm}}</p></tr>
                            <tr><p class="align-data" align="left"> State:
                                {{schoolInformation.collageYear[0].state}}</p>
                            </tr>
                        </td>
                    </table>
                </b-card-text>
            </b-card>


            <h1 align="left" class="align-profile">Marks</h1>
        </div>
    </div>
</template>

<script>
    export default {
        props: {
            personalInfo: Object,
            schoolInformation: []
        },
        name: "Profile"
    }
</script>

<style scoped>
    .border-aligned {
        border: black;
        border-left: 10px;
    }

    .align-profile {
        margin-left: 200px;
    }

    .align-data {
        resize: horizontal;
        width: 400px;
        box-sizing: content-box;
    }

</style>