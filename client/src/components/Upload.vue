<template>
    <div>
        <h1>Upload file</h1>
        <div>
            <input @submit="validateFile" type="file" @change="onFileSelected"/>
            <button @click="validateFile">Upload</button>

            <div>
                <button @click="getFiles">Afiseaza cererile</button>
               {{student.documentsReferences[0].name}}
<!---->
            </div>

        </div>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        name: "Upload"
        ,
        data() {
            return {
                selectedFile: null,
                validExtention: '.pdf',
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

    }
</script>

<style scoped>

</style>