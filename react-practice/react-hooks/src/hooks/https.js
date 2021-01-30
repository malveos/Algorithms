import { useReducer, useCallback } from 'react';

const httpREducer = (httpState, action) => {
    switch (action.type) {
        case 'SEND':
            return { isLoading: true, err: null, data: null, isSuccess: false };
        case 'SUCCESS':
            return { ...httpState, isLoading: false, data: action.responseData, isSuccess: true };
        case 'FAIL':
            return { ...httpState, err: action.errorMessage, isSuccess:false }
        case 'CLEAR':
            return { ...httpState, err: null };
        default:
            throw new Error('no option reach here');
    }
}

const useHttp = () => {
    const [httpState, dispatchHttp] = useReducer(httpREducer,
        {
            isLoading: false,
            err: null,
            data: null,
            isSuccess: false
        });

    const sendRequest = useCallback((url, method, body) => {
        dispatchHttp({ type: 'SEND' });
        fetch(url, {
            method: method,
            body: body,
            headers: { 'Content-Type': 'application/json' }
        }).then(response => response.data)
            .then(response => {
                dispatchHttp({ type: 'SUCCESS', responseData: response });
            }).catch(error => {
                dispatchHttp({ type: 'FAIL', errorMessage: 'Something went wrong!!'})
            });
    }, []);

    return {
        isLoading: httpState.isLoading,
        err: httpState.err,
        data: httpState.data,
        sendRequest: sendRequest,
        isSuccess: httpState.isSuccess
    };
};

export default useHttp;