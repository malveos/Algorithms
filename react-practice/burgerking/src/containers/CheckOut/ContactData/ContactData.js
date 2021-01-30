import React, { useState } from "react";
import axiosIns from '../../../database/axios/axios-orders';
import { connect } from "react-redux";

import Button from '../../../components/UI/Button/Button';
import Spinner from '../../../components/UI/Spinner/Spinner';
import Input from '../../../components/UI/Input/Input';
import classes from './ContactData.css';
import WithErrorHandler from '../../../hoc/WithErrorHandler/WithErrorHandler';
import * as orderActions from '../../../store/actions/index';
import { updateObject, checkValidity } from '../../../shared/utility';

const contactData = props => {
    const [orderForm, setOrderForm] = useState({
        name: {
            elementType: 'input',
            elementConfig: {
                type: 'text',
                placeholder: 'Your Name'
            },
            value: '',
            validation: {
                required: true
            },
            valid: false,
            touched: false
        },
        zip: {
            elementType: 'input',
            elementConfig: {
                type: 'text',
                placeholder: 'ZIP Code'
            },
            value: '',
            validation: {
                required: true,
                minLength: 6,
                maxLength: 6
            },
            valid: false,
            touched: false

        },
        email: {
            elementType: 'input',
            elementConfig: {
                type: 'text',
                placeholder: 'Your Email'
            },
            value: '',
            validation: {
                required: true
            },
            valid: false,
            touched: false
        },
        country: {
            elementType: 'input',
            elementConfig: {
                type: 'text',
                placeholder: 'Your Country'
            },
            value: '',
            validation: {
                required: true
            },
            valid: false,
            touched: false
        },
        deliveryMethod: {
            elementType: 'select',
            elementConfig: {
                options: [{
                    value: 'fastest',
                    displayValue: 'Fastest'
                },
                {
                    value: 'cheapest',
                    displayValue: 'Cheapest'
                }]
            },
            value: 'cheapest',
            validation: {},
            valid: true
        }
    });
    const [formIsValid, setformIsValid] = useState(false);

    const orderHandler = (event) => {
        event.preventDefault();
        const formData = {};
        for (let i in orderForm) {
            formData[i] = orderForm[i].value;
        }
        const orderData = {
            ingredients: props.ingredients,
            price: props.price,
            customer: formData,
            userId: props.userId
        };
        props.onBurgerOrder(orderData, props.token);
    }

    const inputChangehandler = (event, inputIdentifier) => {
        const updatedElem = updateObject(orderForm[inputIdentifier], {
            value: event.target.value,
            valid: checkValidity(event.target.value, orderForm[inputIdentifier].validation),
            touched: true
        });
        const updatedForm = updateObject(orderForm, {
            [inputIdentifier]: updatedElem
        });

        let formIsValid = true;
        for (let i in updatedForm) {
            formIsValid = formIsValid && updatedForm[i].valid;
        }
        setOrderForm(updatedForm);
        setformIsValid(formIsValid);
    }

    let formArray = [];
    for (let key in orderForm) {
        formArray.push({
            id: key,
            config: orderForm[key]
        });
    }

    let form = (
        <form onSubmit={orderHandler}>
            {formArray.map(e => {
                return <Input
                    key={e.id}
                    elementType={e.config.elementType}
                    elementConfig={e.config.elementConfig}
                    value={e.config.value}
                    invalid={!e.config.valid}
                    shouldValidate={e.config.validation}
                    touched={e.config.touched}
                    changed={(event) => inputChangehandler(event, e.id)} />
            })}
            <Button btnType="Success" disabled={!formIsValid}>ORDER</Button>
        </form>
    );
    if (props.loading) {
        form = <Spinner />;
    }
    return (
        <div className={classes.ContactData}>
            <h4>Enter your contact data..</h4>
            {form}
        </div>
    );
}

const mapStatesToProps = state => {
    return {
        ingredients: state.burgerBuilder.ingredients,
        price: state.burgerBuilder.totalprice,
        loading: state.order.loading,
        token: state.auth.token,
        userId: state.auth.userId
    };
};

const mapDispatchToProps = dispatch => {
    return {
        onBurgerOrder: (orderData, token) => dispatch(orderActions.purchaseBurger(orderData, token))
    };
};


export default connect(mapStatesToProps, mapDispatchToProps)(WithErrorHandler(contactData, axiosIns));