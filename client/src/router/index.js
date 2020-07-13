import Vue from 'vue'
import VueRouter from 'vue-router'
import App from '../App.vue'
import Schedule from '../components/Schedule.vue'
import Marks from "../components/Marks";
import Profile from "../components/Profile"
import Upload from "../components/Upload"
import Login from "../components/Login"
import Taxes from "../components/Taxes"


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'App',
        redirect: to => {



            console.log(status);
            if (to) {
                return {path: '/login'}
            }
        },

        component: App
    },
    {
        path: '/schedule',
        name: 'Schedule',
        component: Schedule
    },
    {
        path: '/marks',
        name: 'Marks',
        component: Marks
    },
    {
        path: '/profile',
        name: 'Profile',
        component: Profile
    },
    {
        path: '/upload',
        name: 'Upload',
        component: Upload
    }
    ,
    {
        path: '/login',
        name: 'Login',
        component: Login

    },

    {
        path: '/taxes',
        name: 'Taxes',
        component: Taxes

    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})


export default router
