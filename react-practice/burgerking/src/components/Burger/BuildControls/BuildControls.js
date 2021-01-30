import React from 'react'
import classes from './BuildControls.css'
import BuildControl from './BuildControl/BuildControl'

const controls = [
    { label: 'Salad', type: 'salad' },
    { label: 'Meat', type: 'meat' },
    { label: 'Bacon', type: 'bacon' },
    { label: 'Cheese', type: 'cheese' }
];

const buildControls = props => {
    return <div className={classes.BuildControls}>
        <p>Current Price:<strong>Rs.{props.totalprice.toFixed(2)}</strong></p>
        {controls.map(ctrl => {
            return <BuildControl key={ctrl.label} label={ctrl.label}
                removeClick={() => props.removeClick(ctrl.type)}
                addClick={() => props.addClick(ctrl.type)}
                disable={props.disable[ctrl.type]} />;
        })}
        <button
            onClick={props.ordered}
            disabled={!props.purchasable}
            className={classes.OrderButton}>{props.isAuth?'ORDER NOW':'SIGNUP TO ORDER'}</button>
    </div>;
}

export default buildControls;