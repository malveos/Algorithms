import * as actionTypes from './actionTypes';

export const authStart = () => {
    return {
        type: actionTypes.AUTH_START
    };
};

export const authSuccess = (token, userId) => {
    return {
        type: actionTypes.AUTH_SUCCESS,
        idToken: token,
        userId: userId
    };
};

export const authFail = (error) => {
    return {
        type: actionTypes.AUTH_FAIL,
        error: error
    };
};

export const auth = (email, password, isSignUp) => {
    return {
        type: actionTypes.AUTH_USER_INITIATE,
        email: email,
        password: password,
        isSignUp: isSignUp
    };
};

export const authCheckState = () => {
    return {
       type: actionTypes.AUTH_CHECKSTATE_INITIATE
    }
}

export const setAuthRedirectPath = (path) => {
    return {
        type: actionTypes.SET_PATH_REDIRECT,
        path: path
    };
};

export const logout = () => {
    return {
        type: actionTypes.AUTH_INITIATE_LOGOUT
    }
};

export const logoutSucceed = () => {
    return {
        type: actionTypes.AUTH_LOGOUT
    }
};

export const checkAuthTimeOut = (expirationTime) => {
    return {
        type: actionTypes.AUTH_CHECK_TIMEOUT,
        expirationTime: expirationTime
    };
};