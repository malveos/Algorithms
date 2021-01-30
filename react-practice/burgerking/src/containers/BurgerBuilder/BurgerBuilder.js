import React, { useState, useEffect, useCallback } from 'react';
import { useSelector, useDispatch } from 'react-redux';

import Aux from '../../hoc/AuxFile/Auxile';
import Burger from '../../components/Burger/Burger';
import BuildControls from '../../components/Burger/BuildControls/BuildControls';
import Modal from '../../components/UI/Modal/Modal';
import OrderSummary from '../../components/Burger/OrderSummary/OrderSummary';
import Spinner from '../../components/UI/Spinner/Spinner';
import WithErrorHandler from '../../hoc/WithErrorHandler/WithErrorHandler';
import axiosIns from '../../database/axios/axios-orders';
import * as actions from '../../store/actions/index';

const burgerBuilder = props => {

    const [purchasing, setPurchasing] = useState(false);

    const dispatch = useDispatch();
    const addIngredients = (igName) => dispatch(actions.addIngredient(igName));
    const removeIngredients = (igName) => dispatch(actions.removeIngredient(igName));
    const onInitIngredients = useCallback(() => dispatch(actions.initIngredients()), [dispatch]);
    const onInitPurchase = () => dispatch(actions.purchaseInit());
    const onSetAuthRedirectpath = (path) => dispatch(actions.setAuthRedirectPath(path));


    const ingredients = useSelector(state => state.burgerBuilder.ingredients);
    const totalprice = useSelector(state => state.burgerBuilder.totalprice);
    const error = useSelector(state => state.burgerBuilder.error);
    const isAuthenticated = useSelector(state => state.auth.token !== null);

    useEffect(() => {
        onInitIngredients();
    }, [onInitIngredients]);

    const purchaseHandler = () => {
        if (isAuthenticated) {
            setPurchasing(true);
        } else {
            onSetAuthRedirectpath('/checkout');
            props.history.push('/auth');
        }
    }

    const purchaseCancelHandler = () => {
        setPurchasing(false);
    }

    const purchaseContinueHandler = () => {
        onInitPurchase();
        props.history.push('/checkout');
        // const queryParam = [];
        // for (let i in props.ingredients) {
        //     queryParam.push(encodeURIComponent(i) + '=' + encodeURIComponent(props.ingredients[i]));
        // }
        // queryParam.push('price=' + props.totalprice);
        // props.history.push({
        //     pathname: '/checkout',
        //     search: '?' + queryParam.join('&')
        // });
    }

    const updatePurchasable = (igrn) => {
        const sum = Object.keys(igrn)
            .map(i => igrn[i])
            .reduce((arr, e) => arr + e, 0);
        return sum > 0.0;
    }

    const disableButtons = {
        ...ingredients
    };
    for (let k in disableButtons) {
        disableButtons[k] = disableButtons[k] <= 0;
    }
    let orderSum = null;
    let burger = error ? <p style={{ textAlign: 'center' }}>Ingredients can't be loaded...</p> : <Spinner />;
    if (ingredients) {
        burger = (<Aux>
            <Burger ingredients={ingredients} />
            <BuildControls
                totalprice={totalprice}
                removeClick={removeIngredients}
                addClick={addIngredients}
                isAuth={isAuthenticated}
                ordered={purchaseHandler}
                purchasable={updatePurchasable(ingredients)}
                disable={disableButtons} />
        </Aux>);
        orderSum = <OrderSummary
            ingredients={ingredients}
            purchaseCanceled={purchaseCancelHandler}
            purchaseContinued={purchaseContinueHandler}
            totalprice={totalprice} />;
    }

    return (
        <Aux>
            <Modal show={purchasing} modalClosed={purchaseCancelHandler}>
                {orderSum}
            </Modal>
            {burger}
        </Aux>
    );

}

// const mapStateToProps = state => {
//     return {
//         ingredients: state.burgerBuilder.ingredients,
//         totalprice: state.burgerBuilder.totalprice,
//         error: state.burgerBuilder.error,
//         isAuthenticated: state.auth.token !== null
//     };
// };

// const mapDispatchToProps = dispatch => {
//     return {
//         addIngredients: (igName) => dispatch(actions.addIngredient(igName)),
//         removeIngredients: (igName) => dispatch(actions.removeIngredient(igName)),
//         initIngredients: () => dispatch(actions.initIngredients()),
//         onInitPurchase: () => dispatch(actions.purchaseInit()),
//         onSetAuthRedirectpath: (path) => dispatch(actions.setAuthRedirectPath(path))
//     };
// };

//export default connect(mapStateToProps)(WithErrorHandler(burgerBuilder, axiosIns));
export default WithErrorHandler(burgerBuilder, axiosIns);