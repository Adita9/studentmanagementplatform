<template>
    <div class="outset" id="schedule">
        <router-view>
        </router-view>
        <div>
            <iframe src="https://orar.sisc.ro/" width="1000" height="1000">
            </iframe>
        </div>

    </div>
</template>

<script>
    export default {
        name: "Schedule"
    }
</script>

<style scoped>
    .outset {
        border-top: 2px;
        border-bottom: 0px;
        border-left: 0px;
        border-right: 0px;

    }

</style>