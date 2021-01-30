import React from 'react';

import classes from './PizzaImage.css';
import PizzaImage from '../../assets/pizza.jpg';

const pizzaImage = (props) => {
	<div className={classes.pizzaImage}>
		<img src={PizzaImage} className={classes.Pizza}/>
	</div>
};

export default pizzaImage;