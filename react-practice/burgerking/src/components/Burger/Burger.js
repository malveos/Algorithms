import React from 'react'
import {withRouter} from 'react-router-dom';

import classes from './Burger.css'
import BurgerIngredient from './BurgerIngredient/BurgerIngredient'

const Burger = props => {
    let ingredientsCreated = Object.keys(props.ingredients)
        .map(igKey=>{
            return ([...Array(props.ingredients[igKey])]
            .map((_,i)=>{
               return <BurgerIngredient key={igKey + i} type={igKey}/>
            }));
        }).reduce((arr, el)=> arr.concat(el), []);

    if(ingredientsCreated.length === 0){
        ingredientsCreated = <p>Add Ingredients</p>;
    }
    return (
        <div className={classes.Burger}>
            <BurgerIngredient type="bread-top"/>
            {ingredientsCreated}
            <BurgerIngredient type="bread-bottom"/>
        </div>
    );
}

export default withRouter(Burger);