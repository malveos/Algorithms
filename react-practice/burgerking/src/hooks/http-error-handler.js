import { useState, useEffect } from 'react';

export default httpClient => {
    const [err, setErr] = useState(null);

    const reqInterceptor = httpClient.interceptors.request.use(req => {
        setErr(null);
        return req;
    });
    const resInterceptor = httpClient.interceptors.response.use(res => res, err => {
        setErr(err)
    });

    useEffect(() => {
        return () => {
            httpClient.interceptors.request.eject(reqInterceptor);
            httpClient.interceptors.response.eject(resInterceptor);
        };
    }, []);

    const errorConfirmed = () => {
        setErr(null);
    }

    return [err, errorConfirmed];
}