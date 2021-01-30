import * as actionTypes from './actionTypes';

export const saveResult = result => {
    return {
        type: actionTypes.STORE_RESULT,
        result: result
    }
}

export const storeResult = (result) => {
    return (dispatch, getState) => {
        setTimeout(() => {
            const oldC = getState().ctr.counter;
            console.log('[result.js] old counter - ', oldC);
            dispatch(saveResult(result));
        }, 2000);
    }

}
export const deleteResult = (removeID) => {
    return {
        type: actionTypes.DELETE_RESULT,
        removeID: removeID
    }
}