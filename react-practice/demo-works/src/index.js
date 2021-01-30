import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, NavLink, Switch } from 'react-router-dom';
import axios from 'axios';

import App from './containers/App';
import AppHttp from './http/AppHttp'
import registerServiceWorker from './registerServiceWorker';
import classes from './index.css'
import AppRedux from './redux/AppRedux';


axios.defaults.baseURL = 'https://jsonplaceholder.typicode.com';
axios.defaults.headers.common['Authorization'] = 'AUTH TOKEN';
axios.defaults.headers.post['Content-Type'] = 'application/json';

axios.interceptors.request.use(req => {
    // console.log(req);
    return req;
}, error => {
    console.log(error);
    return Promise.reject(error);
});

axios.interceptors.response.use(res => {
    // console.log(req);
    return res;
}, error => {
    console.log(error);
    return Promise.reject(error);
});











let render = <BrowserRouter basename="/">
    <div className={classes.Home}>
        <header>
            <nav>
                <ul>
                    <li><NavLink to="/person-manager"
                        activeStyle={Object.assign({},classes.active)}>Person Manager</NavLink></li>
                    <li><NavLink to="/http-app"
                        activeStyle={Object.assign({},classes.active)}>Http App Demo</NavLink></li>
                    <li><NavLink to="/redux"
                        activeStyle={Object.assign({},classes.active)}>Redux Demo</NavLink></li>
                </ul>
            </nav>
        </header>
        <Switch>
            <Route path="/person-manager" render={(props) => <App {...props} title='Person Manager' />} />
            <Route path="/http-app" component={AppHttp} />
            <Route path="/redux" component={AppRedux} />
        </Switch>
    </div>
</BrowserRouter >;

//ReactDOM.render(<App title='Person Manager'/>, document.getElementById('root'));
ReactDOM.render(render, document.getElementById('root'));
registerServiceWorker();