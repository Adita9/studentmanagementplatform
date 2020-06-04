<template>
    <div>
        <h1>Upload file</h1>
        <input type="file" @change="onFileSelected"/>
        <button @click="onUpload">Upload</button>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        name: "Upload"
        ,
        data() {
            return {
                selectedFile: null
            }
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
            }
        }

    }
</script>

<style scoped>

</style>