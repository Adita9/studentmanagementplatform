import Vue from 'vue'
import VueRouter from 'vue-router'
import App from '../App.vue'
import Schedule from '../components/Schedule.vue'
import Marks from "../components/Marks";
import Profile from "../components/Profile"
import Upload from "../components/Upload"


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'App',
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
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
