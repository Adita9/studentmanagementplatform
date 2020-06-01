<template>
    <div>
        <b-navbar toggleable="sm" type="light" variant="light">
            <b-navbar-toggle target="nav-text-collapse"></b-navbar-toggle>

            <b-navbar-brand active-class="margin-nav">
                <img src="https://upload.wikimedia.org/wikipedia/en/thumb/7/74/Logo_ASE_Bucharest.png/250px-Logo_ASE_Bucharest.png"
                     width="100" height="70">
            </b-navbar-brand>


            <b-collapse id="nav-text-collapse" is-nav>
                <b-navbar-brand href="#profile">
                    <img src="https://img.icons8.com/ios/50/000000/user-menu-male.png" width="30" height="30"
                         alt="Profile">
                    <div class="navcolor">Profile</div>
                </b-navbar-brand>

                <b-navbar-brand href="#">
                    <img src="https://img.icons8.com/ios/50/000000/report-card.png" width="30" height="30"
                         alt="Marks">
                    <div class="navcolor">Marks</div>
                </b-navbar-brand>

                <b-navbar-brand href="#">
                    <img src="https://img.icons8.com/ios/50/000000/wallet.png" width="30" height="30"
                         alt="Taxes">
                    <div class="navcolor">Taxes</div>
                </b-navbar-brand>

                <b-navbar-brand href="#">
                    <router-link to="/schedule">
                        <img src="https://img.icons8.com/ios/50/000000/overtime.png" width="30" height="30"
                             alt="Schedule">
                        <div class="navcolor">Schedule</div>
                    </router-link>
                </b-navbar-brand>

                <b-navbar-brand href="#">
                    <img src="https://img.icons8.com/ios/50/000000/upload-document.png" width="30" height="30"
                         alt="Upload documents">
                    <div class="navcolor">Documents</div>
                </b-navbar-brand>


            </b-collapse>


            <b-nav-item-dropdown right>
                <!-- Using 'button-content' slot -->
                <template v-slot:button-content>
                    <em>Adrian Neagoe</em>
                </template>
                <b-dropdown-item href="#">Profile</b-dropdown-item>
                <b-dropdown-item href="#">Sign Out</b-dropdown-item>
            </b-nav-item-dropdown>
        </b-navbar>
    </div>
</template>


<script>

    export default {
        name: "Header",
        components: {}
    }
</script>

<style scoped>
    .navcolor {
        color: black;
        font-size: 12px;
    }

    .navbar-brand {
        margin-left: 10px !important;
        margin-right: 10px;
    }

</style>