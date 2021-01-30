import React, { useEffect } from 'react';
import { connect } from 'react-redux';

import Order from '../../components/Order/Order';
import Spinner from '../../components/UI/Spinner/Spinner';
import axiosIns from '../../database/axios/axios-orders';
import WithErrorHandler from '../../hoc/WithErrorHandler/WithErrorHandler';
import * as orderActions from '../../store/actions/index';

const orders = props => {

    const { token, userId, ordersFetch } = props;
    useEffect(() => {
        ordersFetch(token, userId);
    }, [token, userId, ordersFetch]);

    let orders = <Spinner />;
    if (!props.loading) {
        orders = props.ordersLoaded.map(order => {
            return <Order
                key={order.id}
                ingredients={order.ingredients}
                price={order.price} />;
        });
    }
    return orders;

}

const mapStatesToProps = state => {
    return {
        ordersLoaded: state.order.orders,
        loading: state.order.loading,
        token: state.auth.token,
        userId: state.auth.userId
    };
};

const mapDispatchToProps = dispatch => {
    return {
        ordersFetch: (token, userId) => dispatch(orderActions.fetchOrders(token, userId))
    };
};

export default connect(mapStatesToProps, mapDispatchToProps)(WithErrorHandler(orders, axiosIns));