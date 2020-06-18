<template>
    <div>
        <table class="mega-style">
            <td>
                <div class="mega-style" align="center">
                    <b-button v-b-toggle="'collapse-a'">Bachelor degree thesis request form</b-button>
                    <!--<input @submit="validateFile" type="file" @change="onFileSelected"/>-->
                    <!--<button @click="validateFile">Upload</button>-->
                    <b-collapse id="collapse-a" class="mt-2">
                        <b-input
                                id="inline-form-input-name"
                                class="mb-2 mr-sm-2 mb-sm-0 mega-style3"
                                type="email"
                                label="Coordinator`s email"
                                required
                                placeholder="Enter coordinator`s email"></b-input>

                        <b-form-file @submit="validateFile" @change="onFileSelected"
                                     v-model="file"
                                     :state="Boolean(file)"
                                     placeholder="Choose a file or drop it here..."
                                     drop-placeholder="Drop file here...">

                        </b-form-file>
                        <!--<button @click="validateFile">Upload</button>-->
                        <div class="mega-style2">
                            <b-button @submit="validateFile" @click="validateFile" block :squared="true" :pill="true"
                                      :pressed.sync="secondYear"
                                      variant="light">Upload
                            </b-button>
                        </div>
                    </b-collapse>
                </div>
            </td>
            <td>
                <div class="mega-style" align="center">
                    <b-button v-b-toggle="'collapse-b'">Secretariat request</b-button>
                    <!--<input @submit="validateFile" type="file" @change="onFileSelected"/>-->
                    <!--<button @click="validateFile">Upload</button>-->
                    <b-collapse id="collapse-b" class="mt-2">
                        <b-form-file @submit="validateFile" @change="onFileSelected"
                                     v-model="file"
                                     :state="Boolean(file)"
                                     placeholder="Choose a file or drop it here..."
                                     drop-placeholder="Drop file here...">

                        </b-form-file>
                        <!--<button @click="validateFile">Upload</button>-->
                        <div class="mega-style2">
                            <b-button @submit="validateFile" @click="validateFile" block :squared="true" :pill="true"
                                      :pressed.sync="secondYear"
                                      variant="light">Upload
                            </b-button>
                        </div>
                    </b-collapse>
                </div>
            </td>
        </table>
        <div>
            <h1>My documents</h1>
            <table>
                <td>
                    <p class="mega-table">File Name</p>
                </td>
                <td><p class="mega-table">Sent to</p></td>
                <td><p class="mega-table">Date</p></td>
                <td><p class="mega-table">Download</p></td>

            </table>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        name: "Upload",
        data() {
            return {
                selectedFile: null,
                validExtention: '.pdf',
                mydocuuments: [],
                email: '',
                student: Object
            }
        }, mounted: function () {

            fetch('http://localhost:8080/studentplatform/', {
                method: 'get'
            })
                .then((response) => {
                    return response.json()
                })
                .then((jsonData) => {
                    this.student = jsonData
                })
        },
        methods: {
            onFileSelected(event) {
                this.selectedFile = event.target.files[0]
            },

            onUpload() {
                const fd = new FormData();
                fd.append('pdf', this.selectedFile, this.selectedFile.name);
                axios.post('http://localhost:8080/studentplatform/upload/', fd)
                    .then(res => {
                        console.log(res);
                    })
            },
            validateFile() {
                var ext = this.selectedFile.name.substr(this.selectedFile.name.lastIndexOf('.'));
                console.log(ext);
                if (!(ext === this.validExtention
                )) {
                    alert("Please introduce a .pdf file!");
                } else {
                    this.onUpload();
                }
            },
            getFiles() {
                axios.get('http://localhost:8080/studentplatform/files/', this.student.id)
                    .then(res => {
                        console.log(res);
                    })
            }
        }
    }
</script>

<style scoped>
    .mega-style {
        width: 100%;
        padding-top: 20px;
    }

    .mega-style2 {
        width: 100px;
        alignment: center;
    }

    .mega-style3 {
        alignment: center;
    }

    .mega-table {
        margin-right: 200px;
        margin-left: 100px;
        font-size: x-large;
    }


</style>