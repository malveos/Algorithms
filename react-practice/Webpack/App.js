import React, {Component} from 'react';
import {Link, Router} from 'react-router-dom';

import Users from './src/containers/Users';
import asyncComponent from './src/hoc/asyncComponent';

const asyncPizza = asyncComponent(()=> {
    return import('./src/containers/Pizza');
})
class App extends Component {
	render() {
		return (
			<div>
                <div>
                    <Link to="/">Users</Link>
                    <Link to="/pizza">Pizza</Link>
                </div>
                <div>
                    <Router path="/" exact component={Users} />
                    <Router path="/pizza" exact component={asyncPizza} />
                </div>
			</div>
		);
	}
};

export default App;