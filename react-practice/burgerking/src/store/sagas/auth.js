import { put, delay, call } from 'redux-saga/effects';
import axios from 'axios';

import * as actions from '../actions/index';

export function* logoutSaga(action) {
    yield call([localStorage, 'removeItem'], "token"); //We can mock action
    //yield localStorage.removeItem('token');
    yield localStorage.removeItem('expirationDate');
    yield localStorage.removeItem('localId');
    yield put(actions.logoutSucceed());
}

export function* checkAuthTimeoutSaga(action) {
    yield delay(action.expirationTime * 1000);
    yield put(actions.logout());
}

export function* authUserSaga(action) {
    yield put(actions.authStart());
    const postData = {
        email: action.email,
        password: action.password,
        returnSecureToken: true
    }
    let url = 'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyCnepwOXIsCksdXCa6crB3LFP5_aUQG3P0';
    if (!action.isSignUp) {
        url = 'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyCnepwOXIsCksdXCa6crB3LFP5_aUQG3P0';
    }
    try {
        const response = yield axios.post(url, postData)
        yield localStorage.setItem('token', response.data.idToken);
        yield localStorage.setItem('localId', response.data.localId);
        yield localStorage.setItem('expirationDate', new Date(new Date().getTime() + response.data.expiresIn * 1000));
        yield put(actions.authSuccess(response.data.idToken, response.data.localId));
        yield put(actions.checkAuthTimeOut(response.data.expiresIn));
    } catch (err) {
        yield put(actions.authFail(err.response.data.error));
    }
}

export function* authCheckStateSaga(action) {
    const token = yield localStorage.getItem('token');
    if (!token) {
        yield put(actions.logout());
    } else {
        const expirationDate = yield new Date(localStorage.getItem('expirationDate'));
        if (expirationDate < new Date()) {
            yield put(actions.logout());
        } else {
            yield put(actions.authSuccess(token, localStorage.getItem('localId')));
            const timeSlot = yield expirationDate.getTime() - new Date().getTime();
            yield put(actions.checkAuthTimeOut(timeSlot/1000));
        }
    }
}