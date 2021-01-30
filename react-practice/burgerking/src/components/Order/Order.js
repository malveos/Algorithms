import React from 'react';

import classes from './Order.css';

const order = props => {

    let ingredients = [];
    for (let ig in props.ingredients) {
        ingredients.push({ name: ig, amount: props.ingredients[ig] });
    }
    const igOutput = ingredients.map(ig => {
        return <span
            key={ig.name} >
            {ig.name} - {ig.amount}</span>
    })

    return (
        <div className={classes.Order}>
            <p>Ingredients: {igOutput}</p>
            <p>Price: <strong>Rs.{Number.parseFloat(props.price).toFixed(2)}</strong></p>
        </div>);
}

export default order;