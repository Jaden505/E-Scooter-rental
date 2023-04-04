export class SessionSbService {
    BROWSER_STORAGE_ITEM_NAME;
    RESOURCES_URL;

    current_user = null;
    current_user_token = null;

    constructor(resourcesUrl, browserStorageItemName) {
        this.BROWSER_STORAGE_ITEM_NAME = browserStorageItemName;
        this.RESOURCES_URL = resourcesUrl;

        this.getToken()
    }

    getCurrentUserToken() {
        return this.current_user_token;
    }

    getCurrentUserName() {
        if (this.current_user) {
            return this.current_user.name
        }

        return "Visitor";
    }


    async asyncSignIn(email, password) {
        let response = await fetch(this.RESOURCES_URL + 'login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                password: password
            }),
            credentials: 'include',
        });

        if (response.ok) {
            let user = await response.json();
            this.saveToken(response.headers.get('Authorization'),
                user);
            return user;
        }
        else {
            console.log(response);
            return "Invalid credentials"
        }
    }

    saveToken(token, user) {
        this.current_user_token = token;
        this.current_user = user;

        const namedToken = {
            token,
            user
        };

        const namedTokenStr = JSON.stringify(namedToken);
        window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME, namedTokenStr);
        window.localStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME, namedTokenStr);
    }

    getToken() {
        if (this.current_user_token != null) return this.current_user_token;

        const namedTokenStr = window.sessionStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME) || window.localStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME);

        if (namedTokenStr != null) {
            const namedToken = JSON.parse(namedTokenStr);
            this.current_user_token = namedToken.token;
            this.current_user_token = namedToken.user;
        }

        return this.current_user_token;
    }


    signOut() {
        this.saveToken(null, null);
    }
}