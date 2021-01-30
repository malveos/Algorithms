import React from 'react'
import Aux from '../../../hoc/AuxFile/Auxile'
import Button from '../../UI/Button/Button'

const orderSummary = props => {

    let ingredientsSummary = Object.keys(props.ingredients)
        .map(ik => <li key={ik}><span style={{ textTransform: 'capitalize' }}>{ik}</span>: {props.ingredients[ik]}</li>);

    return <Aux>
        <h3>Your Order</h3>
        <p>A delicious burger with following ingredients</p>
        <ul>{ingredientsSummary}</ul>
        <p><strong>Total price: Rs.{props.totalprice.toFixed(2)}</strong></p>
        <p>Continue to Checkout?</p>
        <Button btnType="Danger" clicked={props.purchaseCanceled}>CANCEL</Button>
        <Button btnType="Success" clicked={props.purchaseContinued} >CONTINUE</Button>
    </Aux>
}

export default orderSummary;