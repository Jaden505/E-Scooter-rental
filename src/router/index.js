import {createRouter, createWebHashHistory} from "vue-router";
import Welcome from "@/components/Welcome";
import overview31 from "@/components/scooters/Overview31";
import overview32 from "@/components/scooters/Overview32";

const routes = [
    {path : "/", component: Welcome},
    {path : "/home", component: Welcome},
    {path : "/scooters/overview31", component: overview31},
    {path : "/scooters/overview32", component: overview32}
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})