import fetchIntercept from 'fetch-intercept';



export class FetchInterceptor {
    unregister;
    static getToken;
    static router;

    constructor(session, router) {
        this.unregister = fetchIntercept.register(this);
        FetchInterceptor.getToken = () => session.getCurrentToken();
        FetchInterceptor.router = router;
    }

    request(url, options) {
        let token = FetchInterceptor.getToken();
        if (token == null) {
            return [url, options];
        } else if (options == null) {
            return [url, { headers: { Authorization: token }}]
        } else {
            let newOptions = { ...options };
            newOptions.headers = {
                ...options.headers,
                Authorization: token,
            }
            return [url, newOptions];
        }
    }

    response(response) {
        if (response.status >= 400 && response.status < 600) {
            FetchInterceptor.handleErrorInResponse(response);
        }
        return response;
    }

    static async handleErrorInResponse(response) {
        console.error(`FetchInterceptor response with error: ${response.status} - ${response.statusText}`);
        console.log(`FetchInterceptor current token: ${FetchInterceptor.getToken()}`);
        if (response.status == 401) {
            console.warn(`Authentication error for request: ${response.url}`);
            FetchInterceptor.router.push("/login");
        } else if (response.status != 406) {
            let errorMessage = `Request = ${response.request.method} ${response.request.url}`
                + `<br>Response status code = ${response.status}`
                + `<br>Response error text = ${response.errorText}`
            console.error(`Error message: ${errorMessage}`);
            FetchInterceptor.router.push({ name: 'ERROR', params: { message: errorMessage}});
        }
    }
}