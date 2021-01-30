import { put } from 'redux-saga/effects';

import axiosIns from '../../database/axios/axios-orders';
import * as actions from '../actions/index';

export function* initIngredientsSaga(action) {
    try {
        const response = yield axiosIns.get('/ingredients.json');
        yield put(actions.setIngredients(response.data));
    } catch (err) {
        yield put(actions.fetchIngredientsFailed())
    }
}