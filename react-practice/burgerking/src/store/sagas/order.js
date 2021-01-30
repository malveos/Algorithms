import { put } from 'redux-saga/effects';

import axiosIns from '../../database/axios/axios-orders';
import * as actions from '../actions/index';

export function* purchaseBurgerSaga(action) {
    yield put(actions.purchaseBurgerStart());
    try {
        const response = yield axiosIns.post('/orders.json?auth=' + action.token, action.orderData)
        yield put(actions.purchaseBurgerSuccess(response.data.name, action.orderData));
    } catch (error) {
        yield put(actions.purchaseBurgerFail(error));
    }
}

export function* fetchOrdersSaga(action) {
    yield put(actions.fetchOrderStart());
    const queryparams = yield '?auth=' + action.token + '&orderBy="userId"&equalTo="' + action.userId + '"';
    try {
        const response = yield axiosIns.get('/orders.json' + queryparams);
        let arr = [];
        for (let key in response.data) {
            arr.push({
                ...response.data[key],
                id: key
            });
        }
        yield put(actions.fetchOrderSuccess(arr));
    } catch (err) {
        yield put(actions.fetchOrderFail(err))
    }
} 