import * as actionTypes from './actionTypes';

// Action Creator
export const increment = () => {
    return {
        type: actionTypes.INCREMENT
    }
}

export const decrement = () => {
    return {
        type: actionTypes.DECREMENT
    }
}
export const add = (val) => {
    return {
        type: actionTypes.ADD,
        val: val
    }
}
export const subtract = (val) => {
    return {
        type: actionTypes.SUBSTRACT,
        val: val
    }
}