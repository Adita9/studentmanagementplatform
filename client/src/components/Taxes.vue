<template>
    <div>
        <h1>Taxes</h1>
        <b-table block striped hover :items="taxes"></b-table>
    </div>
</template>

<script>
    export default {
        name: "Taxes",
        data() {
            return {
                taxes: [
                    {type: 'Arrer', price: 75, Description: 'POO', Year: 1, Semester: 2},
                    {type: 'Tuition', price: 2000, Description: 'Tuition tax', Year: 1, Semester: 2},
                    {type: 'Arrer', price: 75, Description: 'SDD', Year: 2, Semester: 2},
                    {type: 'Tuition', price: 2000, Description: 'Tuition tax', Year: 2, Semester: 1},
                    {type: 'Arrer', price: 75, Description: 'BCO', Year: 2, Semester: 2},
                    {type: 'General tax', price: 900, Description: 'Bachelor degree thesis exam', Year: 3, Semester: 2},
                    {type: 'General Tax', price: 50, Description: ' Anti- plagiarism', Year: 3, Semester: 2},
                ]
            }

        }
    }
</script>

<style scoped>

</style>