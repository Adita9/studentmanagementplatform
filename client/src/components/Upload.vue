<template>
    <div style="overflow-x:auto;">
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
                        <div class=""></div>
                        <b-form-input class="mega-style4" placeholder="Short summery" list="input-list" id="input-with-list"></b-form-input>
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
            <b-table block striped hover :items="mydocuuments">
                <template v-slot:cell(download)="data">
                    <!-- `data.value` is the value after formatted by the Formatter -->
                    <a :href="'https://localhost:9090/studentstorage/students/1/files/1'">Direct download</a>
                </template>
            </b-table>
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
                mydocuuments: [
                    {
                        File: 'bachelorDegreeRequestV21',
                        type: '.pdf',
                        sent_to: ' catalin.boja@ie.ase.ro',
                        date: '22.10.2019',
                        accepted: true,
                        download:  'https://localhost:9090/studentstorage/students/1/files/1'
                    },
                    {
                        File: 'tax_validation231',
                        type: '.png',
                        sent_to: ' secretariat ASE',
                        date: '20.03.2020',
                        accepted: true,
                        download:  'https://localhost:9090/studentstorage/students/1/files/1'
                    }
                ],
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
    .mega-style4 {
        height: 200px;
    }

    .mega-table {
        margin-right: 200px;
        margin-left: 100px;
        font-size: x-large;
    }


</style>