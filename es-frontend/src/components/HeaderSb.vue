<template>
    <div id="holder">
        <h1 style="    display: inline-block;">E-scooters Amsterdam</h1>
        <br>
        <h3>Welcome {{user_name}}</h3>
        <h3 id="day" ref="day">Today is </h3>
        <h3 id="sub-header">The easiest way to explore Amsterdam!</h3>

        <img src="../assets/images/E-scooter-icon1.jpeg" id="header-icon1" class="icons">
        <img src="../assets/images/Green-energy-icon.jpeg" id="header-icon2" class="icons">
        <hr>
    </div>
</template>

<script>
export default {
    name: "HeaderComp",
    mounted() {
        this.displayDay();
    },
    inject: ["sessionService"],

    computed: {
        user_name() {
            return this.sessionService.getCurrentUserName();
        }
    },

    methods: {
        displayDay() {
            const day = this.$refs.day;

            let current_day = new Date().toLocaleDateString("en-us", {weekday: 'long'});
            let current_date = new Date().toISOString().slice(0, 10);

            day.innerHTML += current_day + ", " + current_date;
        }
    }
}
</script>

<style scoped>
#holder {
    background-image: url("../assets/images/lime-green-background.png");
}

.icons {
    width: 15%;
    min-height: 15%;
    position: absolute;
    top: 62px;
    filter: drop-shadow(0px 3px 3px grey);
}

#header-icon1 {
    left: 0px;
}

#header-icon2 {
    right: 0px;
}

#sub-header {
    float: right;
    padding-right: 35%;
}

hr {
    margin-top: 135px;
    visibility: hidden;
}

/* Responsive layout - Changes header icons above each other */
@media screen and (max-width: 900px) {
    .icons {
        position: static;
        margin: auto;
        width: 150px;
        height: 150px;
        padding: 10px;
    }
}
</style>