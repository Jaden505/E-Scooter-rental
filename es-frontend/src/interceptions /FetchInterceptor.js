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
            // TODO combine existing headers with new Authorization header
            newOptions.headers = {
                ...options.headers,
                Authorization: token,
            }
            // console.log("FetchInterceptor request: ", url, newOptions);
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
        console.log("FetchInterceptor response with error: ", response);
        console.log("FetchInterceptor current token: ", FetchInterceptor.getToken())
        if (response.status == 401) {
            console.log("Authentication error")
            FetchInterceptor.router.push("/login");   // vue-router
        } else if (response.status != 406) {
            let errorMessage = `Request = ${response.request.method} ${response.request.url}`
                + `<br>Response status code = ${response.status}`
                + `<br>Response error text = ${response.errorText}`
            console.log("error")
            FetchInterceptor.router.push({ name: 'ERROR', params: { message: errorMessage}});  // vue-router
        }
    }
}