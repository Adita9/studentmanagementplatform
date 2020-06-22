<template>
    <div>
        <b-navbar small toggleable="sm" type="light" variant="light">
            <b-navbar-toggle target="nav-text-collapse"></b-navbar-toggle>

            <b-navbar-brand active-class="margin-nav">
                <img src="https://upload.wikimedia.org/wikipedia/en/thumb/7/74/Logo_ASE_Bucharest.png/250px-Logo_ASE_Bucharest.png"
                     width="100" height="70">
            </b-navbar-brand>


            <b-collapse id="nav-text-collapse" is-nav>
                <div class="navbar-brand">
                    <b-navbar-brand href="#">
                        <router-link to="/profile">
                            <img src="https://img.icons8.com/ios/50/000000/user-menu-male.png" width="30" height="30"
                                 alt="Profile">
                            <div class="navcolor">Profile</div>
                        </router-link>
                    </b-navbar-brand>
                </div>

                <div class="navbar-brand">
                    <b-navbar-brand href="#">
                        <router-link to="/marks">
                            <img src="https://img.icons8.com/ios/50/000000/report-card.png" width="30" height="30"
                                 alt="Marks">
                            <div class="navcolor">Marks</div>
                        </router-link>
                    </b-navbar-brand>
                </div>

                <div class="navbar-brand">
                    <b-navbar-brand href="#">
                        <router-link to="/taxes">
                            <img src="https://img.icons8.com/ios/50/000000/wallet.png" width="30" height="30"
                                 alt="Taxes">
                            <div class="navcolor">Taxes</div>
                        </router-link>
                    </b-navbar-brand>
                </div>

                <div class="navbar-brand">
                    <b-navbar-brand href="#">
                        <router-link to="/schedule">
                            <img src="https://img.icons8.com/ios/50/000000/overtime.png" width="30" height="30"
                                 alt="Schedule">
                            <div class="navcolor">Schedule</div>
                        </router-link>
                    </b-navbar-brand>
                </div>

                <div class="navbar-brand">
                    <b-navbar-brand href="#">
                        <router-link to="/upload">
                            <img src="https://img.icons8.com/ios/50/000000/upload-document.png" width="30" height="30"
                                 alt="Upload documents">
                            <div class="navcolor">Documents</div>
                        </router-link>
                    </b-navbar-brand>
                </div>

            </b-collapse>


            <b-nav-item-dropdown right>
                <!-- Using 'button-content' slot -->
                <template v-slot:button-content>
                    <em>Adrian Neagoe</em>
                </template>
                <b-dropdown-item href="#">
                    <router-link to="/profile">
                        Profile
                    </router-link>
                </b-dropdown-item>
                <b-dropdown-item href="#">
                    <router-link to="/login">
                        Sign Out
                    </router-link>
                </b-dropdown-item>
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
        margin-left: 20px !important;
        margin-right: 20px;
    }

    .navigation-top {
        position: fixed; /* Set the navbar to fixed position */
        top: 0; /* Position the navbar at the top of the page */
        width: 100%; /* Full width */
    }


</style>