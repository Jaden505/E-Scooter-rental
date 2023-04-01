export class SessionSbService {
    BROWSER_STORAGE_ITEM_NAME;
    RESOURCES_URL;

    constructor(resourcesUrl, browserStorageItemName) {
        this.BROWSER_STORAGE_ITEM_NAME = browserStorageItemName;
        this.RESOURCES_URL = resourcesUrl;
    }

    async asyncSignIn(email, password) {
        let response = await fetch(this.RESOURCES_URL + '/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                password: password
            }),
            credentials: 'include',
        })
        if (response.ok) {
            let user = await response.json();
            this.saveTokenIntoBrowserStorage(response.headers.get('Authorization'),
                user);
            return user;
        }
        else {
            console.log(response);
            return null;
        }
    }

    signOut() {
        // discards user details and the JWT authentication token from the service
        // and from the browser storage
        localStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME);
    }

    saveTokenIntoBrowserStorage(token) {
        localStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME, token);
    }

    getTokenFromBrowserStorage() {
        return localStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME);
    }
}