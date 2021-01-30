import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';

import CheckOutSummary from '../../components/Order/CheckOutSummary/CheckOutSummary';
import ContactData from '../../containers/CheckOut/ContactData/ContactData';

const checkOut = props => {

    const onCheckoutCancelledHandler = () => {
        props.history.goBack();
    }

    const onCheckoutContinuedHandler = () => {
        props.history.replace('/checkout/contact-data');
    }


    let summary = <Redirect to="/" />;
    if (props.ingredients) {
        const purchaseRedirect = props.purchased ? <Redirect to="/" /> : null;
        summary = (<div>
            {purchaseRedirect}
            <CheckOutSummary
                ingredients={props.ingredients}
                onCheckoutCancelled={onCheckoutCancelledHandler}
                onCheckoutContinued={onCheckoutContinuedHandler} />
            <Route path={props.match.path + '/contact-data'} component={ContactData} />
        </div>)
        return summary;
    }
}

const mapStateToProps = state => {
    return {
        ingredients: state.burgerBuilder.ingredients,
        purchased: state.order.purchased
    };
};

export default connect(mapStateToProps)(checkOut);