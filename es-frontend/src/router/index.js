import {createRouter, createWebHashHistory} from "vue-router";
import Welcome from "@/components/Welcome";
import SignIn from "@/components/SignIn.vue";
import overview31 from "@/components/scooters/Overview31";
import overview32 from "@/components/scooters/Overview32";
import overview33 from "@/components/scooters/Overview33";
import overview34 from "@/components/scooters/Overview34";
import overview37 from "@/components/scooters/Overview37";
import detail32 from "@/components/scooters/Detail32";
import detail34 from "@/components/scooters/Detail34";
import detail37 from "@/components/scooters/Detail37";
import unknownroute from "@/components/UnknownRoute"

const routes = [
    {path : "/", component: Welcome},
    {path : "/home", component: Welcome},
    {path : "/sign-in", component: SignIn},
    {path : "/scooters/overview31", component: overview31},
    {path : "/scooters/overview32", component: overview32},
    {path : "/scooters/overview33", component: overview33, children: [{path: ":id", component: detail32}]},
    {path : "/scooters/overview34", component: overview34, children: [{path: ":id", component: detail34}]},
    {path : "/scooters/overview37", component: overview37, children: [{path: ":id", component: detail37}]},
    {path: '/:catchAll(.*)*', name: "UnknownRoute", component: unknownroute,},
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})