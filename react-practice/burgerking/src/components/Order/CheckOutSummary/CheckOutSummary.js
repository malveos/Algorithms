import React from 'react';

import Burger from '../../Burger/Burger';
import Button from '../../UI/Button/Button';
import classes from './CheckOutSummary.css'

const checkOutSummary = props => {
    return (
        <div className={classes.CheckOutSummary}>
            <h1>Hope it will taste well!</h1>
            <div style={{ width: '100%', height: '400px', margin: 'auto', padding: '10px' }}>
                <Burger ingredients={props.ingredients} />
            </div>
            <Button btnType="Danger" clicked={props.onCheckoutCancelled}>CANCEL</Button>
            <Button btnType="Success" clicked={props.onCheckoutContinued}>CONTINUE</Button>
        </div>
    );
}

export default checkOutSummary;