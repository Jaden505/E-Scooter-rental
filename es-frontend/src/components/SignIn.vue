<template>
    <div class="login-form">
        <h2>Sign In</h2>
        <form @submit.prevent="login">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" v-model="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" v-model="password" required>
            </div>
            <button type="submit">Sign In</button>
            <div class="error-message" v-if="errorMessage">{{errorMessage}}</div>
        </form>
    </div>
</template>

<script>
export default {
    name: "SignIn",

    inject: ["sessionService"],

    data() {
        return {
            email: "",
            password: "",
            errorMessage: "",
        };
    },

    methods: {
        async login() {
            const user = await this.sessionService.asyncSignIn(this.email, this.password);
            if (user &&  user.name){
                this.$router.push("/home");
            }
            else {
                this.errorMessage = "Incorrect credentials, use and email from @hva.nl"
            }
        },
    },
};
</script>

<style scoped>
.login-form {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #f5f5f5;
    border: 1px solid #ccc;
    border-radius: 4px;
}

h2 {
    margin-top: 0;
}

.form-group {
    margin-bottom: 10px;
}

label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

input[type="email"],
input[type="password"] {
    display: block;
    width: 100%;
    padding: 10px;
    font-size: 16px;
    border-radius: 4px;
    border: 1px solid #ccc;
}

button[type="submit"] {
    display: block;
    margin-top: 10px;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.error-message {
    margin-top: 10px;
    color: red;
}
</style>
