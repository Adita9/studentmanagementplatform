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

        </table>
        <div>
            <h1>My documents</h1>
            <b-table block striped hover :items="documents">
                <!--<template v-slot:cell(download)="">-->
                <!--&lt;!&ndash; `data.value` is the value after formatted by the Formatter &ndash;&gt;-->
                <!--<b-link :href="item.download">{{ item.download }}</b-link>-->
                <!--</template>-->
                <template v-slot:cell(download)="{ item, value }">
                    <b-link :href="value">Direct download</b-link>
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
                        download: 'http://localhost:9090/studentstorage/students/1/files/1'
                    },

                    {
                        File: 'tax_validation231',
                        type: '.png',
                        sent_to: ' secretariat ASE',
                        date: '20.03.2020',
                        accepted: true,
                        download: 'http://localhost:9090/studentstorage/students/1/files/1'
                    },
                ],
                email: '',
                student: Object,
                documents: []
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
                        fetch('http://localhost:8080/studentplatform/displayFiles/' + this.student.id, {
                            method: 'get'
                        })
                            .then((response) => {
                                return response.json()
                            })
                            .then((jsonData) => {
                                this.documents = jsonData
                            })

                    }
                )

        },
        methods: {
            onFileSelected(event) {
                this.selectedFile = event.target.files[0];
                this.email = document.getElementById("inline-form-input-name");
                console.log(this.email);
            },

            onUpload() {
                const fd = new FormData();
                fd.append('pdf', this.selectedFile, this.selectedFile.name);
                fd.append('email', 'asdasds');
                axios.post('http://localhost:8080/studentplatform/upload/', fd, {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        }
                    }
                )

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
                    .then((response) => {
                        return response.json()
                    })
                    .then((jsonData) => {
                        this.documents = jsonData
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