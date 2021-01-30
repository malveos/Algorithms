import * as actionTypes from '../actions/actionTypes';
import { updateObject } from '../../shared/utility';

const initialState = {
    ingredients: null,
    totalprice: 40,
    error: false,
    burgerBuilding: false
};

const INGREDIENT_COST = {
    salad: 10,
    cheese: 18,
    meat: 35,
    bacon: 28
};

const addIngredient = (state, action) => {
    return updateObject(state, {
        burgerBuilding: true,
        totalprice: state.totalprice + INGREDIENT_COST[action.ingredientName],
        ingredients: {
            ...state.ingredients,
            [action.ingredientName]: state.ingredients[action.ingredientName] + 1
        }
    });
};

const removeIngredient = (state, action) => {
    return updateObject(state, {
        burgerBuilding: true,
        totalprice: state.totalprice - INGREDIENT_COST[action.ingredientName],
        ingredients: {
            ...state.ingredients,
            [action.ingredientName]: state.ingredients[action.ingredientName] - 1
        }
    });
};

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case actionTypes.ADD_INGREDIENT:
            return addIngredient(state, action);
        case actionTypes.REMOVE_INGREDIENT:
            return removeIngredient(state, action);
        case actionTypes.SET_INGREDIENTS:
            return updateObject(state, { ingredients: action.ingredients, error: false, totalprice: 40, burgerBuilding: false });
        case actionTypes.FETCH_INGREDIENTS_FAILED:
            return updateObject(state, { error: true });
        default:
            return state;
    }
}

export default reducer;