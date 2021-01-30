import { takeEvery } from 'redux-saga/effects';

import { logoutSaga, checkAuthTimeoutSaga, authUserSaga, authCheckStateSaga } from './auth';
import { initIngredientsSaga } from './burgerBuilder';
import { purchaseBurgerSaga, fetchOrdersSaga } from './order';
import * as actionTypes from '../actions/actionTypes';

export function* watchSagas() {
    // yield all([
    //     takeEvery(actionTypes.AUTH_INITIATE_LOGOUT, logoutSaga),// setup listener
    //     takeEvery(actionTypes.AUTH_CHECK_TIMEOUT, checkAuthTimeoutSaga),
    //     takeEvery(actionTypes.AUTH_USER_INITIATE, authUserSaga),
    //     takeEvery(actionTypes.AUTH_CHECKSTATE_INITIATE, authCheckStateSaga),

    //     takeEvery(actionTypes.INIT_INGREDIENTS, initIngredientsSaga),

    //     takeLatest(actionTypes.PURCHASE_BURGER, purchaseBurgerSaga),
    //     takeEvery(actionTypes.FETECH_ORDERS_INITIATE, fetchOrdersSaga)
    // ])
    yield takeEvery(actionTypes.AUTH_INITIATE_LOGOUT, logoutSaga);// setup listener
    yield takeEvery(actionTypes.AUTH_CHECK_TIMEOUT, checkAuthTimeoutSaga);
    yield takeEvery(actionTypes.AUTH_USER_INITIATE, authUserSaga);
    yield takeEvery(actionTypes.AUTH_CHECKSTATE_INITIATE, authCheckStateSaga);

    yield takeEvery(actionTypes.INIT_INGREDIENTS, initIngredientsSaga);

    yield takeEvery(actionTypes.PURCHASE_BURGER, purchaseBurgerSaga);
    yield takeEvery(actionTypes.FETECH_ORDERS_INITIATE, fetchOrdersSaga)
}